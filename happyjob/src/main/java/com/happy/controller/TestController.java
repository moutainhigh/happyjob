 package com.happy.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="testController",tags="测试接口集")
@RestController
@RequestMapping(value="/testController")
public class TestController {
    
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
     
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
    
    
}
