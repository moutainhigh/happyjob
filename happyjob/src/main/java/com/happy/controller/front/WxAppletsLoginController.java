 package com.happy.controller.front;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.happy.util.pubConst.WxAppletsConst;

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
        
        JSONObject wxJson = this.userService.getSessionKeyAndOropenid(code, WxAppletsConst.XCX_JOB_APPID, WxAppletsConst.XCX_JOB_SECRET);
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
        if(Util.isEmpty(unionid)) {
            msg.setErrorCode(1);
            msg.setMessage("未获取到unionid");
            return msg;
        }
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
  
}
