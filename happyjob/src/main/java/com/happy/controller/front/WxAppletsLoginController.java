 package com.happy.controller.front;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.happy.service.user.UserService;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherLoginMsg;
import com.happy.util.Util;
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
    })
    @GetMapping(value="wxVoteLogin")
    public OtherLoginMsg wxVoteLogin(HttpServletRequest request){
        OtherLoginMsg msg = new OtherLoginMsg();
        OtherLoginData data = new OtherLoginData();
        //微信端登录code值
        String code = request.getParameter("code");
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
        
        data = this.userService.insertWxLogin(openid, unionid);
        data.setSessionKey(sessionKey);
        msg.setData(data);
        return msg;
    }
    
    
    
}
