package com.happy.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.service.delivery.DeliveryService;
import com.happy.service.delivery.data.DeliveryListMsg;
import com.happy.service.salary.SalaryService;
import com.happy.service.salary.data.SalarySimpleListMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台广告管理相关请求API",tags="后台广告管理相关请求API")
@RestController
@RequestMapping("backDelivery")
public class DeliveryManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(DeliveryManageController.class);
    
    @Resource
    private DeliveryService deliveryService;
    
    /**
     * @TODO:     用户列表查询
     */
    @ApiOperation(value="投递列表查询",notes="投递列表查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name="userName",value="用户名，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="comName",value="公司名称，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="posName",value="职位名称，模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="startTime",value="开始时间",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="endTime",value="结束时间",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="realName",value="姓名 模糊查询",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="gender",value="性别",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="contactStat",value="联系状态",dataType="String",paramType="query",required=false),
    })
    @GetMapping(value="deliveryList")
    public DeliveryListMsg deliveryList(HttpServletRequest request){
    	
        String userName = request.getParameter("userName");
        String comName = request.getParameter("comName");
        String posName = request.getParameter("posName");
        Long startTime = (Long)Util.typeChange(request.getParameter("startTime"), Long.class);
        Long endTime = (Long)Util.typeChange(request.getParameter("endTime"), Long.class);
        String realName = request.getParameter("realName");
        Integer gender = (Integer)Util.typeChange(request.getParameter("gender"), Integer.class);
        String contactStat = request.getParameter("contactStat");
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
       
        logger.info("backUser.deliveryList 请求参数：userName={},comName={},posName={},"
            + "startTime={},endTime={},realName={},gender={},contactStat={},currentPage={},showCount={}",
        	userName,comName,posName,startTime,endTime,realName,gender,contactStat,currentPage,showCount);
        DeliveryListMsg ss = this.deliveryService.getDeliverylistPage(userName,comName,posName,startTime,endTime,realName,gender,contactStat,currentPage,showCount);
        return ss ;
    }
}
