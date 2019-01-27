package com.happy.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baidu.ueditor.ActionEnter;
import com.happy.controller.base.BaseController;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.UserService;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherLoginMsg;
import com.happy.service.user.data.OtherUserData;
import com.happy.util.ServiceConfig;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台:用户登录接口集",tags="后台用户登录接口集")
@RestController
@RequestMapping("login")
public class LoginController {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Resource
    private UserService userService;

    /**
     * @TODO:     后台用户登录接口
     */
    @ApiOperation(value="登录：后台用户登录接口",notes="后台用户登录接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name="userName",value="登录用户名",dataType="String",paramType="query",required=true),
        @ApiImplicitParam(name="password",value="登录密码",dataType="String",paramType="query",required=true),
        @ApiImplicitParam(name="validCode",value="登录验证码",dataType="String",paramType="query",required=true),
    })
    @PostMapping(value="login")
    public OtherLoginMsg login(HttpServletRequest request,HttpServletResponse response){
        
       String userName = request.getParameter("userName");
       String password = request.getParameter("password");
       String validCode = request.getParameter("validCode");
       String ip = Util.getIpAddress(request);
       
       logger.info("login---参数信息----userName=={},userName=={},validCode=={}",
            userName,password,validCode);
       OtherUserData result = this.userService.checkUserLogin(userName, password, validCode);
       OtherLoginMsg msg = new OtherLoginMsg();
       if(result.getErrorCode() != 0) {
           msg.setErrorCode(result.getErrorCode());
           msg.setMessage(result.getMessage());
           return msg;
       }
       String sid = result.getUserToken();
       BaseController.addCookie(response, Const.COOKIE_ATTR_NAME_SID, sid, Const.COOKIE_MAX_AGE_USER);
       this.userService.UpdateUserLogin(result.getHpUserId(), ip); // 更新登录信息
       OtherLoginData data = new OtherLoginData();
       data.setUserName(userName);
       data.setHeaderPic(result.getHeaderPic());
       msg.setData(data);
       return msg;
    }
    
    /**
     * @TODO:     后台用户登录注销接口
     */
    @ApiOperation(value="登录：后台用户登录注销接口",notes="后台用户登录注销接口")
    @GetMapping(value="loginOut")
    public BaseMsg login(HttpServletResponse response){
        
        logger.info("loginOut---管理员注销登录");
        BaseController.removeCookieByName(response, Const.COOKIE_ATTR_NAME_SID);
        return new BaseMsg();
    }
    
    /**
     * @TODO:     ueditor数据接口
     */
    @RequestMapping(value="ueditor")
    public String ueditor(HttpServletRequest request){
        
        
        String str = new ActionEnter(request, ServiceConfig.getUeditorRootPath() ).exec();
        
        return str;
    }
}
