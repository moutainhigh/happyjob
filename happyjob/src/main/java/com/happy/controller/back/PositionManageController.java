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

import com.happy.plugin.BaseMsg;
import com.happy.service.position.PositionService;
import com.happy.service.position.data.PositionListMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台招聘接口集",tags="后台招聘接口集")
@RestController
@RequestMapping("backPosition")
public class PositionManageController {

    private static final Logger logger = LoggerFactory.getLogger(PositionManageController.class);
    
    @Resource
    private PositionService positionService;
    
    /**
     * @TODO:     招聘列表
     */
    @ApiOperation(value="招聘列表",notes="招聘列表")
    @ApiImplicitParams({
        @ApiImplicitParam(name="posName",value="职位名称",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="comName",value="公司名称",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="startTime",value="发布开始时间（s）",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="endTime",value="发布结束时间（s）",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="posState",value="招聘状态：1、招聘中，4、已过期，其他全部",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="currentPage",value="当前页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页展示记录数",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="positionList")
    public PositionListMsg positionList(HttpServletRequest request,HttpServletResponse response){
        
       String posName = request.getParameter("posName");
       String comName = request.getParameter("comName");
       Long startTime = (Long)Util.typeChange(request.getParameter("startTime"), Long.class);
       Long endTime = (Long)Util.typeChange(request.getParameter("endTime"), Long.class);
       Integer posState = (Integer)Util.typeChange(request.getParameter("posState"), Integer.class);
       Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
       currentPage = currentPage==null?1:currentPage;
       Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
       showCount = showCount==null?10:showCount;
       
       logger.info("positionList---参数信息----posName=={},comName=={},startTime=={},endTime=={},posState=={},currentPage=={},showCount=={}",
           posName,comName,startTime,endTime,posState,currentPage,showCount);
       
       return this.positionService.getBackPostionlistPage(posName, comName, startTime, endTime, posState, currentPage, showCount);
    }
    /**
     * @TODO:     招聘列表
     */
    @ApiOperation(value="招聘岗位设置热门状态",notes="招聘岗位设置热门状态")
    @ApiImplicitParams({
        @ApiImplicitParam(name="hpPositionId",value="职位Id",dataType="long",paramType="query",required=true),
        @ApiImplicitParam(name="hotOn",value="是否热门：0、取消热门，1、设置热门",dataType="String",paramType="query",required=false),
    })
    @PostMapping(value="positionHotOn")
    public BaseMsg positionHotOn(HttpServletRequest request){
        
        Long hpPositionId = (Long)Util.typeChange(request.getParameter("hpPositionId"), Long.class);
        Integer hotOn = (Integer)Util.typeChange(request.getParameter("hotOn"), Integer.class);
        
        logger.info("positionHotOn---参数信息----hpPositionId=={},hotOn=={}",
            hpPositionId,hotOn);
        
        return this.positionService.updatePositionHotOn(hpPositionId, hotOn);
    }
    
    
}
