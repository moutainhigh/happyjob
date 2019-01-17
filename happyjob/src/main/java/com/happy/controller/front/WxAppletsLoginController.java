 package com.happy.controller.front;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.happy.controller.base.BaseController;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.UserService;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherLoginMsg;
import com.happy.service.user.data.UpImgData;
import com.happy.service.user.data.UpImgMsg;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;
import com.happy.util.wxUtil.WxAppParamsEnum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 *
 *  @TODO: 微信小程序登录相关请求API
 */
@Api(value="微信小程序登录相关请求API",tags="微信小程序登录相关请求API")
@RestController
@RequestMapping("wxAppletsLogin")
public class WxAppletsLoginController {
    
    private static final Logger logger = LoggerFactory.getLogger(WxAppletsLoginController.class);
    
    
    @Resource
    private UserService userService;
    
    
    /**
     * @TODO:     微信小程序投票活动，使用code获取openID、unionID信息
     */
    @ApiOperation(value="投票活动小程序，根据微信CODE获取微信用户信息",notes="投票活动小程序，根据微信CODE获取微信用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name="code",value="微信登录CODE",dataType="String",paramType="query",required=true),
        @ApiImplicitParam(name="storeToken",value="门店识别码（扫门店二维码进入，带上该参数）",dataType="String",paramType="query",required=false),
    })
    @PostMapping(value="wxVoteLogin")
    public OtherLoginMsg wxVoteLogin(HttpServletRequest request){
        OtherLoginMsg msg = new OtherLoginMsg();
        OtherLoginData data = new OtherLoginData();
        //微信端登录code值
        String code = request.getParameter("code");
        String storeToken = request.getParameter("storeToken");
        
        logger.info("wxVoteLogin 参数信息：code=={},storeToken=={}",code,storeToken);
        
        JSONObject wxJson = this.userService.getSessionKeyAndOropenid(code, WxAppParamsEnum.PARAMS_APPLETS_JOB.getAppId(), WxAppParamsEnum.PARAMS_APPLETS_JOB.getAppSecret());
        if(Util.isEmpty(wxJson)) { // 未获取到微信信息
            msg.setErrorCode(1);
            msg.setMessage("未获取到用户微信信息");
            return msg;
        }
        String openid = wxJson.getString("openid");
        String unionid = wxJson.getString("unionid");
        String sessionKey = wxJson.getString("session_key");
        if(Util.isEmpty(openid)) {
            msg.setErrorCode(1);
            msg.setMessage("未获取到openid");
            return msg;
        }
//        if(Util.isEmpty(unionid)) {
//            msg.setErrorCode(1);
//            msg.setMessage("未获取到unionid");
//            return msg;
//        }
        if(Util.isEmpty(sessionKey)) {
            msg.setErrorCode(1);
            msg.setMessage("未获取到sessionKey");
            return msg;
        }
        
        data = this.userService.insertWxLogin(openid, unionid,storeToken);
        data.setSessionKey(sessionKey);
        msg.setData(data);
        return msg;
    }
    /**
    *
    * @TODO:     商城小程序单张图片上传接口
    * @CreateTime:  2018年12月27日下午5:43:41 
    * @CreateAuthor: chenwei
    * @param request
    * @return
    */
   @ApiOperation(value="单张图片上传接口",notes="单张图片上传接口,文件流形式上传,文件参数名file")
   @ApiImplicitParams({
       @ApiImplicitParam(name="oid",value="用户微信登录凭证",dataType="String",paramType="header",required=false),
       @ApiImplicitParam(name="code",value="上传类型：user、用户图片上传，company、公司图片上传，position、岗位图片上传，banner、轮播图片上传",dataType="String",paramType="query",required=true),
       @ApiImplicitParam(name="file",value="图片文件流",dataType="form提交",paramType="query",required=true),
   })
   
   @PostMapping(value = "/imgUpOne")
   public UpImgMsg mallImgUpOne(HttpServletRequest request) {
       UpImgMsg msg=new UpImgMsg();
       String oid = request.getHeader("oid");
       String code = request.getParameter("code");
       logger.info("OrderPayController.WxMallPrePay params==oid={},",oid);
       
       MultipartHttpServletRequest multiRequest = BaseController.getMultiReq(request);
       if(multiRequest == null) {
           msg.setErrorCode(1);
           msg.setMessage("上传文件为空");
           return msg;
       }
       MultipartFile file_member = multiRequest.getFile("file");
       String leftPath  = null;
       String fileRegex = null;
       long maxSize = 0;
       if("user".equals(code)) {
           leftPath = Const.HP_UP_IMG_USER_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else if("company".equals(code)) {
           leftPath = Const.HP_UP_IMG_COM_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else if("position".equals(code)) {
           leftPath = Const.HP_UP_IMG_POS_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else if("banner".equals(code)) {
           leftPath = Const.HP_UP_IMG_BANNER_PATH;
           fileRegex = Const.HP_UP_IMG_FORMAT;
       }else {
           msg.setErrorCode(1);
           msg.setMessage("上传类型不符");
           return msg;
       }
       JSONObject json = BaseController.UploadFiles(file_member, leftPath, fileRegex, maxSize, 0);
       msg.setErrorCode(json.getIntValue(Const.RESUTL_MESSAGE_ERRORCODE));
       msg.setMessage(json.getString(Const.RESUTL_MESSAGE_MESSAGE));
       UpImgData data = new UpImgData();
       data.setImgUrl(json.getString(Const.RESUTL_MESSAGE_UP_IMG_URL));
       msg.setData(data);
       return msg;
   }
    
   /**
   *
   * @TODO:     提交信息指定专属方案
   */
  @ApiOperation(value="提交信息指定专属方案",notes="提交信息指定专属方案")
  @ApiImplicitParams({
      @ApiImplicitParam(name="name",value="姓名",dataType="String",paramType="query",required=true),
      @ApiImplicitParam(name="comName",value="公司名称",dataType="String",paramType="query",required=true),
      @ApiImplicitParam(name="contactNo",value="联系方式",dataType="String",paramType="query",required=true),
      @ApiImplicitParam(name="position",value="职务",dataType="String",paramType="query",required=true),
  })
  @PostMapping(value="comApply")
  public BaseMsg comApply(HttpServletRequest request) {
      
      String name = request.getParameter("name");
      String comName = request.getParameter("comName");
      String contactNo = request.getParameter("contactNo");
      String position = request.getParameter("position");
      return this.userService.insertCompanyApply(name, comName, contactNo, position);
  }
  
  /**
  *
  * @TODO:     小程序解密用户敏感数据
  * @CreateTime:  2018年12月4日下午3:05:24 
  * @CreateAuthor: chenwei
  * @param request
  * @return
  */
 @ApiOperation(value="解密数据：小程序解密用户敏感数据",notes="小程序解密用户敏感数据")
 @ApiImplicitParams({
     @ApiImplicitParam(name="encryptedData",value="消息",paramType="query",required = true,dataType="String"),
     @ApiImplicitParam(name="iv",value="向量",paramType="query",required = true,dataType="String"),
     @ApiImplicitParam(name="sessionKey",value="那个ID",paramType="query",required = true,dataType="String"),
 })
 @PostMapping(value="decodeUserInfo")
 public JSONObject decodeUserInfo(HttpServletRequest request) {
     JSONObject json = new JSONObject();
     String encryptedData = request.getParameter("encryptedData");
     String iv = request.getParameter("iv");
     String sessionKey = request.getParameter("sessionKey");
     try {
        encryptedData = URLDecoder.decode(encryptedData, Const.CODE_TYPE_STR);
        iv = URLDecoder.decode(iv, Const.CODE_TYPE_STR);
        sessionKey = URLDecoder.decode(sessionKey, Const.CODE_TYPE_STR);
    } catch (UnsupportedEncodingException e1) {
         logger.error("解码异常===");
    }
//     encryptedData.replace("+", " ");
     encryptedData.replace(" ", "+");
     iv.replace(" ", "+");
     sessionKey.replace(" ", "+");
     System.out.println(encryptedData);
     System.out.println(iv);
     System.out.println(sessionKey);
    
  // 被加密的数据
     byte[] dataByte = Base64.decodeBase64(encryptedData);
     // 加密秘钥
     byte[] keyByte = Base64.decodeBase64(sessionKey);
     // 偏移量
     byte[] ivByte = Base64.decodeBase64(iv);
     try {
         // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
         int base = 16;
         if (keyByte.length % base != 0) {
             int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
             byte[] temp = new byte[groups * base];
             Arrays.fill(temp, (byte) 0);
             System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
             keyByte = temp;
         }
         // 初始化
         Security.addProvider(new BouncyCastleProvider());
         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
         SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
         AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
         parameters.init(new IvParameterSpec(ivByte));
         cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
         byte[] resultByte = cipher.doFinal(dataByte);
         if (null != resultByte && resultByte.length > 0) {
             String result = new String(resultByte, "UTF-8");
             JSONObject resultJson = JSONObject.parseObject(result);
             json.put("data", resultJson);
             if(resultJson.getIntValue("errcode") != 0) {
                 json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
             }else {
                 json.put(Const.RESUTL_MESSAGE_ERRORCODE, 0);
             }
             return json;
         }
     }catch (NoSuchProviderException e) {
         logger.error("here is exception", e);
     } catch (UnsupportedEncodingException e) {
         logger.error("here is exception", e);
     } catch (NoSuchAlgorithmException e) {
         logger.error("here is exception", e);
     } catch (NoSuchPaddingException e) {
         logger.error("here is exception", e);
     } catch (InvalidKeyException e) {
         logger.error("here is exception", e);
     } catch (InvalidAlgorithmParameterException e) {
         logger.error("here is exception", e);
     } catch (InvalidParameterSpecException e) {
         logger.error("here is exception", e);
     } catch (IllegalBlockSizeException e) {
         logger.error("here is exception", e);
     } catch (BadPaddingException e) {
         logger.error("here is exception", e);
     }
     return null;

     
 }
}
