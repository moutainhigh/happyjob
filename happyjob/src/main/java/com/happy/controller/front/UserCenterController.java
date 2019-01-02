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
import com.happy.service.user.UserService;
import com.happy.service.user.data.UserResumeDataMsg;

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
    public BaseMsg wxUserInfo(HttpServletRequest request) {
       
       // TODO 是否需要验证用户
        String oid = request.getHeader("oid");
        String sid = request.getHeader("sid");
        
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
   })
   @PostMapping(value="approve")
   public BaseMsg approve(HttpServletRequest request) {
       
       // TODO 是否需要验证用户
       String sid = request.getHeader("sid");
       String realName = request.getParameter("realName");
       String idNum = request.getParameter("idNum");
       String idFrontPic = request.getParameter("idFrontPic");
       String idBackPic = request.getParameter("idBackPic");
       String idPersonPic = request.getParameter("idPersonPic");
       
       return this.userService.updateUserIdApply(sid, realName, idNum, idFrontPic, idBackPic, idPersonPic);
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
   @ApiOperation(value="用户简历详情信息",notes="用户简历详情信息")
   @GetMapping(value="resume")
   public UserResumeDataMsg resume(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid) {
       
       return this.userService.getUserResume(sid);
   }
   
   /**
    *
    * @TODO:     我的用户求职意向编辑、新增
    */
   @ApiOperation(value="用户求职意向编辑、新增",notes="用户求职意向编辑、新增")
   @PostMapping(value="resumeIntent")
   public BaseMsg resumeIntent(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid,
       @RequestBody HpUserIntentionEntity data) {
       
       return this.userService.insertOrUpUserIntent(sid,data);
   }
   /**
    *
    * @TODO:     用户教育背景编辑、新增
    */
   @ApiOperation(value="用户教育背景编辑、新增",notes="用户教育背景编辑、新增")
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
   @ApiOperation(value="用户工作经验编辑、新增",notes="用户工作经验编辑、新增")
   @PostMapping(value="resumeExp")
   public BaseMsg resumeExp(@RequestHeader(value="oid",required=true) String oid,
       @RequestHeader(value="sid",required=true) String sid,
       @RequestBody HpUserExpEntity data) {
       
       return this.userService.insertOrUpUserExp(sid, data);
   }
   
   
}
