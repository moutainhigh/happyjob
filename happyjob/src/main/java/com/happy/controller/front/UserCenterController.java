 package com.happy.controller.front;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.plugin.BaseMsg;
import com.happy.service.user.UserService;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="前台用户中心API集合",tags="前台用户中心API集合")
@RestController
@RequestMapping("frontUser")
public class UserCenterController {
    
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
   
   
}
