 package com.happy.controller.front;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpUserEducationEntity;
import com.happy.entity.HpUserExpEntity;
import com.happy.entity.HpUserIntentionEntity;
import com.happy.entity.HpUserResumeEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.message.MessageService;
import com.happy.service.position.PositionService;
import com.happy.service.position.data.GroupDataMsg;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.user.UserService;
import com.happy.service.user.data.UpImgMsg;
import com.happy.service.user.data.UserResumeDataMsg;
import com.happy.service.user.data.UserSimpleDataMsg;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;
import com.happy.util.wxUtil.WxAppParamsEnum;
import com.happy.util.wxUtil.WxModelConst;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="前台用户中心API集合",tags="前台用户中心API集合")
@RestController
@RequestMapping("frontUser")
public class UserCenterController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserCenterController.class);
    
    @Resource
    private UserService userService;
    @Resource
    private PositionService positionService;
    @Resource
    private MessageService messageService;
    
    /**
    *
    * @TODO:     我的页面进入后获取个人信息
    */
   @ApiOperation(value="我的页面进入后获取个人信息",notes="我的页面进入后获取个人信息")
   @ApiImplicitParams({
       @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=true),
   })
   @GetMapping(value="centerInfo")
    public UserSimpleDataMsg wxUserInfo(HttpServletRequest request) {
       
       // TODO 是否需要验证用户
        String oid = request.getHeader("oid");
        String sid = request.getHeader("sid");
        
        logger.info("resume 参数日志：oid=={},sid=={}",oid,sid);
        
        return this.userService.getUserCenterDate(oid, sid);
    }
   
   /**
    *
    * @TODO:     我的页面进入后获取个人信息
    */
   @ApiOperation(value="用户认证信息提交",notes="用户认证信息提交,图片先上传获取连接")
   @ApiImplicitParams({
       @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="realName",value="用户真实姓名",dataType="String",paramType="query",required=true),
       @ApiImplicitParam(name="idNum",value="用户身份证号",dataType="String",paramType="query",required=true),
       @ApiImplicitParam(name="idFrontPic",value="身份证正面图片地址",dataType="String",paramType="query",required=true),
       @ApiImplicitParam(name="idBackPic",value="身份证反面图片地址",dataType="String",paramType="query",required=true),
       @ApiImplicitParam(name="idPersonPic",value="身份证手持图片地址",dataType="String",paramType="query",required=true),
       @ApiImplicitParam(name="formId",value="消图推送必须formId",dataType="String",paramType="query",required=true),
   })
   @PostMapping(value="approve")
   public BaseMsg approve(HttpServletRequest request) {
       
       // TODO 是否需要验证用户
       String sid = request.getHeader("sid");
       String oid = request.getHeader("oid");
       String realName = request.getParameter("realName");
       String idNum = request.getParameter("idNum");
       String idFrontPic = request.getParameter("idFrontPic");
       String idBackPic = request.getParameter("idBackPic");
       String idPersonPic = request.getParameter("idPersonPic");
       String formId = request.getParameter("formId");
       
       logger.info("resume 参数日志：sid=={},realName=={},idNum=={},idFrontPic=={},idBackPic=={},idPersonPic=={},formId=={}",
           sid,realName,idNum,idFrontPic,idBackPic,idPersonPic,formId);
       BaseMsg msg = this.userService.updateUserIdApply(sid, realName, idNum, idFrontPic, idBackPic, idPersonPic);
       this.userService.updateBoundFormId(oid, formId);
       return msg;
   }
   
   /**
    *
    * @TODO:     我的简历基本信息
    */
   @ApiOperation(value="用户简历基本信息添加、修改：第一次创建简历、简历基本信息编辑",
       notes="用户简历基本信息添加、修改：第一次创建简历、简历基本信息编辑，hpUserResumeId存在编辑、否新增")
   @PostMapping(value="resumeBase")
   public BaseMsg resumeBase(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid,
       @RequestBody HpUserResumeEntity data) {
       
       logger.info("frontUser.resumeBase 参数===data=={},",JSONObject.toJSONString(data));
       
       return this.userService.insertOrUpUserResumeBase(sid, data);
   }
   
   /**
    *
    * @TODO:     我的简历信息获取
    */
   @ApiOperation(value="用户简历：用户简历详情信息",notes="用户简历：用户简历详情信息")
   @GetMapping(value="resume")
   public UserResumeDataMsg resume(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid) {
       
       logger.info("resume 参数日志：oid=={},sid=={}",oid,sid);
       return this.userService.getUserResume(sid);
   }
   
   /**
    *
    * @TODO:     我的用户求职意向编辑、新增
    */
   @ApiOperation(value="用户简历：用户求职意向编辑、新增",notes="用户简历：用户求职意向编辑、新增")
   @PostMapping(value="resumeIntent")
   public BaseMsg resumeIntent(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid,
       @RequestBody HpUserIntentionEntity data) {
       
       logger.info("resumeIntent 参数日志：sid=={},data=={}",sid,JSONObject.toJSONString(data));
       
       return this.userService.insertOrUpUserIntent(sid,data);
   }
   /**
    *
    * @TODO:     用户教育背景编辑、新增
    */
   @ApiOperation(value="用户简历：用户教育背景编辑、新增",notes="用户简历：用户教育背景编辑、新增")
   @PostMapping(value="resumeEdu")
   public BaseMsg resumeEdu(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid,
       @RequestBody HpUserEducationEntity data) {
       
       return this.userService.insertOrUpUserEdu(sid, data);
   }
   /**
    *
    * @TODO:     用户工作经验编辑、新增
    */
   @ApiOperation(value="用户简历：用户工作经验编辑、新增",notes="用户简历：用户工作经验编辑、新增")
   @PostMapping(value="resumeExp")
   public BaseMsg resumeExp(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid,
       @RequestBody HpUserExpEntity data) {
       
       logger.info("resumeExp 参数日志：sid=={},data=={}",sid,JSONObject.toJSONString(data));
       
       return this.userService.insertOrUpUserExp(sid, data);
   }
   
   /**
    *
    * @TODO:     岗位申请：用户申请职位或者发起拼团
    */
   @ApiOperation(value="岗位申请：用户申请职位或者发起拼团",notes="岗位申请：用户申请职位或者发起拼团")
   @ApiImplicitParams({
       @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="hpPositionId",value="岗位ID",dataType="long",paramType="query",required=true),
       @ApiImplicitParam(name="formId",value="消息推送formID",dataType="String",paramType="query",required=true),
   })
   @PostMapping(value="positionApply")
   public GroupDataMsg positionApply(HttpServletRequest request) {
       
       String sid = request.getHeader("sid");
       String oid = request.getHeader("oid");
       Long hpPositionId = (Long)Util.typeChange(request.getParameter("hpPositionId"), Long.class);
       String formId = request.getParameter("formId");
       logger.info("positionApply 参数日志：sid=={},hpPositionId=={},formId=={}",sid,hpPositionId,formId);
       GroupDataMsg msg = this.positionService.insertUserPositionApply(sid, hpPositionId);
       this.userService.updateBoundFormId(oid, formId);
       return msg;
   }
   
   /**
    *
    * @TODO:     岗位申请：用户申请参与职位拼团
    */
   @ApiOperation(value="岗位申请：用户申请参与职位拼团",notes="岗位申请：用户申请参与职位拼团")
   @ApiImplicitParams({
       @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="hpPositionGroupId",value="岗位拼团ID",dataType="long",paramType="query",required=true),
       @ApiImplicitParam(name="formId",value="消息推送formID",dataType="String",paramType="query",required=true),
   })
   @PostMapping(value="groupApply")
   public GroupDataMsg groupApply(HttpServletRequest request) {
       
       String sid = request.getHeader("sid");
       String oid = request.getHeader("oid");
       String formId = request.getParameter("formId");
       Long hpPositionGroupId = (Long)Util.typeChange(request.getParameter("hpPositionGroupId"), Long.class);
       logger.info("positionApply 参数日志：sid=={},hpPositionGroupId=={},formId=={}",sid,hpPositionGroupId,formId);
       GroupDataMsg msg = this.positionService.insertUserGroupApply(sid, hpPositionGroupId);
       this.userService.updateBoundFormId(oid, formId);
       try {
           this.messageService.sendPositionMsg(oid, hpPositionGroupId);
       } catch (Exception e) {
            logger.error("拼团成功消息推送异常===",e);
       }
       return msg;
   }
   
   /**
    *
    * @TODO:     用户岗位申请列表
    */
   @ApiOperation(value="用户中心：我的岗位申请列表",notes="用户中心：我的岗位申请列表")
   @ApiImplicitParams({
       @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=true),
       @ApiImplicitParam(name="groupOn",value="是否是拼团岗位",dataType="int",paramType="query",required=false),
       @ApiImplicitParam(name="currentPage",value="当前分页",dataType="int",paramType="query",required=true),
       @ApiImplicitParam(name="showCount",value="单页展示记录数",dataType="int",paramType="query",required=true),
   })
   @PostMapping(value="positionList")
   public PositionListMsg positionList(HttpServletRequest request) {
       
       String sid = request.getHeader("sid");
       Integer groupOn = (Integer)Util.typeChange(request.getParameter("groupOn"), Integer.class);
       Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
       currentPage = currentPage==null||currentPage<=0?1:currentPage;
       Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
       showCount = showCount==null||showCount<=0?10:showCount;
       logger.info("positionApply 参数日志：sid=={},groupOn=={},currentPage=={},showCount=={}",sid,groupOn,currentPage,showCount);
       
       return this.positionService.getPostionlistPage(sid, null, null, null, null, null, null, null, groupOn, currentPage, showCount);
   }
   
   /**
    *
    * @TODO:     小程序二维码生成
    */
   @ApiOperation(value="用户分享二维码：二维码生成",notes="二维码生成接口B")
   @PostMapping(value="shareQrCodeA")
   public UpImgMsg shareQrCodeA(
       @RequestHeader(name="oid",defaultValue="微信登录凭证",required=true) String oid,
       @RequestHeader(name="sid",defaultValue="用户登录凭证",required=true) String sid,
       @RequestHeader(name="targetUrl",defaultValue="需要生产二维码的页面访问地址,根路径前不要填加 /",required=true) String targetUrl
       ) {
       
       logger.info("positionApply 参数日志：sid=={},oid=={},targetUrl=={}",sid,oid,targetUrl);
       
       
       UpImgMsg msg = Util.getWXAQRCode(WxModelConst.getAppAccessToken(WxAppParamsEnum.PARAMS_APPLETS_JOB, false), 
           targetUrl, Const.HP_QRCODE_IMAGE_WIDTH);
       
       return msg;
   }
   /**
    *
    * @TODO:     小程序二维码生成
    */
   @ApiOperation(value="用户分享二维码：二维码生成",notes="二维码生成接口B")
   @PostMapping(value="shareQrCodeB")
   public UpImgMsg shareQrCodeB(
       @RequestHeader(name="oid",defaultValue="微信登录凭证",required=true) String oid,
       @RequestHeader(name="sid",defaultValue="用户登录凭证",required=true) String sid,
       @RequestHeader(name="targetUrl",defaultValue="需要生产二维码的页面访问地址,根路径前不要填加 /",required=true) String targetUrl
       ) {
       
       logger.info("positionApply 参数日志：sid=={},oid=={},targetUrl=={}",sid,oid,targetUrl);
       
       
       UpImgMsg msg = Util.getWXACode(WxModelConst.getAppAccessToken(WxAppParamsEnum.PARAMS_APPLETS_JOB, false), 
           targetUrl, Const.HP_QRCODE_IMAGE_WIDTH);
       
       return msg;
   }
   /**
    *
    * @TODO:     小程序二维码生成
    */
   @ApiOperation(value="用户分享二维码：二维码生成",notes="二维码生成接口C")
   @PostMapping(value="shareQrCodeC")
   public UpImgMsg shareQrCodeC(
       @RequestHeader(name="oid",defaultValue="微信登录凭证",required=true) String oid,
       @RequestHeader(name="sid",defaultValue="用户登录凭证",required=true) String sid,
       @RequestHeader(name="scene",defaultValue="最大32个可见字符，只支持数字，大小写英文以及部分特殊字符",required=true) String scene,
       @RequestHeader(name="page",defaultValue="必须是已经发布的小程序存在的页面（否则报错），根路径前不要填加斜杠,不能携带参数（参数请放在scene字段里）",required=true) String page
       ) {
       
       logger.info("positionApply 参数日志：sid=={},oid=={},scene,page=={}",sid,oid,scene,page);
       
       
       UpImgMsg msg = Util.getWXACodeUnlimit(WxModelConst.getAppAccessToken(WxAppParamsEnum.PARAMS_APPLETS_JOB, false),scene, 
           page, Const.HP_QRCODE_IMAGE_WIDTH);
       
       return msg;
   }
   
   
}
