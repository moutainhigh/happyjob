package com.happy.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.UserService;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;

/**
 * 
 * 类名称：登录过滤，权限验证 类描述：
 * 
 */
@Component
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    
	private static final Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if ((handler instanceof HandlerMethod)&& (AnnotationUtils.getAnnotation(((HandlerMethod) handler).getBeanType(),Controller.class) != null)) {
		    
		    String path = request.getServletPath();
			path = Util.isEmpty(path)?"/":path.toLowerCase();
			String sid = request.getHeader("sid");
			String oid = request.getHeader("oid");
			int isUser = 0;
			int isOther = 0;
			BaseMsg msg = null;
			if (path.matches(Const.INTERCEPTOR_PATH_FRONT_REGEX)) { // 前端需要拦截的请求
			    if(path.matches(Const.INTERCEPTOR_PATH_FRONT_USER_REGEX)) { // 用户拦截
			        isUser = 1;
			        isOther = 1;
			    }
			    msg = this.userService.confirmUser(sid, oid, isUser, isOther);
			    if(msg.getErrorCode() == 0) {
			        return true;
			    }
			} else if(path.matches(Const.INTERCEPTOR_PATH_BACK_REGEX)){ // 商城前端请求拦截
			    
			    msg = this.userService.confirmUser(sid, null, 1, 0);
			    
			}else {
			    return true;
			}
			if(msg != null) {
			    PrintWriter pw = response.getWriter();
			    pw.write(JSONObject.toJSONString(pw));
			    pw.flush();
			    pw.close();
			    return false;
			}
		}
//		response.sendRedirect(request.getContextPath()+ Const.LOGIN);
//		return false;
		return true;

	}
}
