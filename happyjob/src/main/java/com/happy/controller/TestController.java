 package com.happy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.happy.plugin.BaseMsg;
import com.happy.service.message.MessageService;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="testController",tags="测试接口集")
@RestController
@RequestMapping(value="/testController")
public class TestController {
    
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @Resource
    MessageService messageService;
     
    @ApiOperation(value="swagger返回测试接口",notes="swagger返回测试接口")
    @GetMapping(value = "/{id}/msgTest")
    public BaseMsg msgTest(@PathVariable("id") Long id) {
        BaseMsg msg = new BaseMsg();
        
        logger.info("id===={}",id);
        
        return msg;
    }
    
    
    @ApiOperation(value="swaggerBUG返回测试接口",notes="swaggerBUG返回测试接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name="id",value="参数ID",dataType="long",paramType="query",required=false)
    })
    @GetMapping(value = "/bugTest")
    public BaseMsg bugTest(HttpServletRequest request) {
        BaseMsg msg = new BaseMsg();
        String idStr = request.getParameter("id");
        Long id = Long.valueOf(idStr);
        logger.info("id===={}",id);
        
        return msg;
    }
    
    /**
     * @TODO:     微信公众号模板消息推送接口
     * @CreateTime:  2018年12月29日下午5:01:09 
     * @CreateAuthor: chenwei
     */
    @ApiOperation(value = "微信公众号模板消息推送接口",notes="微信公众号模板消息推送接口操作类型，1、愚公坊公众号，2、微信商城小程序，3、投票活动小程序")
    @PostMapping(value = "/wxModel")
    public BaseMsg wxModel(@RequestHeader(value="option",required=true) int option,
        @RequestBody JSONObject data) {
        logger.info("这里是微信公众号模板消息推送接口===========");
        String content = data.toString();
        return messageService.pushWxMsg(content);
    }
    /**
     * -查询所有微信公众好下面的推送模板
     * Description:  
     * @author jiangchao1  
     * @date 2019年1月2日  
     * @version 1.0
     */
    @ApiOperation(value = "获得所有微信推送消息模板",notes="获得所有微信推送消息模板")
    @ApiImplicitParams({
        @ApiImplicitParam(name="currentPage",value="分页当前页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页数据量",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value = "/getAllWxTemplateIds")
    public BaseMsg getAllWxTemplateIds(HttpServletRequest request){
        
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        currentPage = currentPage==null || currentPage<0?null:currentPage;
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
        showCount = showCount==null || showCount<1?null:showCount;
         
        return messageService.getAllWxTemplateIds(currentPage,showCount);
    }
}
