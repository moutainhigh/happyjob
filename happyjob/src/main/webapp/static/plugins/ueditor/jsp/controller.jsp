<%@page import="org.slf4j.LoggerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter,org.slf4j.Logger,com.happy.util.ServiceConfig"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

final Logger logger = LoggerFactory.getLogger(ServiceConfig.class);
    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");

	String str = new ActionEnter( request, ServiceConfig.getUeditorRootPath() ).exec();
	
    logger.info("str ==== {}", str);

	out.write( str );
	
%>