package com.happy.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.plugin.BaseMsg;
import com.happy.service.config.ConfigService;
import com.happy.service.config.data.AreaListMsg;
import com.happy.service.config.data.EduListMsg;
import com.happy.service.config.data.SalaryListMsg;
import com.happy.service.config.data.WelfareListMsg;
import com.happy.service.config.impl.ConfigServiceImpl;
import com.happy.service.position.PositionService;
import com.happy.service.position.data.PositionDetail;
import com.happy.service.position.data.PositionDetailMsg;
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
    @Resource
    private ConfigService configService;
    
    /**
     * @TODO:     招聘列表
     */
    @ApiOperation(value="招聘：招聘列表",notes="招聘列表")
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
    @ApiOperation(value="招聘：招聘岗位设置热门状态",notes="招聘岗位设置热门状态")
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
    
    /**
     * @TODO:     招聘详情获取
     */
    @ApiOperation(value="招聘：招聘详情获取",notes="招聘详情获取")
    @ApiImplicitParams({
        @ApiImplicitParam(name="hpPositionId",value="职位Id",dataType="long",paramType="query",required=true),
    })
    @GetMapping(value="position")
    public PositionDetailMsg position(HttpServletRequest request){
        
        Long hpPositionId = (Long)Util.typeChange(request.getParameter("hpPositionId"), Long.class);
        
        logger.info("position---参数信息----hpPositionId=={}",hpPositionId);
        
        return this.positionService.getPostionDetail(hpPositionId);
    }
    
    /**
     * @TODO:     招聘详情获取
     */
    @ApiOperation(value="招聘：招聘详情页新增、更新",notes="招聘详情新增、更新")
    @PostMapping(value="position")
    public BaseMsg position(@RequestBody(required=true) PositionDetail data){
        
        logger.info("position---参数信息----hpPositionId=={}","");
        
        return this.positionService.insertOrUpPosition(data);
    }
    
    
    /**
     * @TODO:     招聘详情获取
     */
    @ApiOperation(value="测试：招聘福利",notes="招聘福利")
    @ApiImplicitParams({
        @ApiImplicitParam(name="hpPositionId",value="职位Id",dataType="long",paramType="query",required=true),
        @ApiImplicitParam(name="welfareIds",value="职位Id",dataType="long",paramType="query",required=true),
    })
    @PostMapping(value="positionWelfare")
    public BaseMsg positionWelfare(HttpServletRequest request){
        
        Long hpPositionId = (Long)Util.typeChange(request.getParameter("hpPositionId"), Long.class);
        String welfareIds = request.getParameter("welfareIds");
        
        logger.info("position---参数信息----hpPositionId=={},welfareIds=={}",hpPositionId,welfareIds);
        
        return this.positionService.insertOrUpPositionTest(hpPositionId, welfareIds);
    }
    
    /**
     * @TODO:     招聘福利选项获取
     */
    @ApiOperation(value="配置：招聘福利选项",notes="招聘福利选项")
    @GetMapping(value="positionWelfare")
    public WelfareListMsg positionWelfare(){
        
        return this.configService.getPositionWelfare();
    }
    
    /**
     * @TODO:     招聘薪资选项获取
     */
    @ApiOperation(value="配置：招聘薪资选项",notes="招聘薪资选项")
    @GetMapping(value="positionSalary")
    public SalaryListMsg positionSalary(){
        
        return this.configService.getSalaryList();
    }
    
    /**
     * @TODO:     学历选项获取
     */
    @ApiOperation(value="配置：招聘学历选项",notes="招聘学历选项")
    @GetMapping(value="eduList")
    public EduListMsg eduList(){
        
        return this.configService.getEduList(1);
    }
    
    /**
     * @TODO:     职位行业类型选项获取
     */
    @ApiOperation(value="配置：职位行业类型选项",notes="职位行业类型选项")
    @GetMapping(value="posTypeList")
    public EduListMsg posTypeList(){
        
        return this.configService.getEduList(1);
    }
    
    /**
     * @TODO:     区域选项获取
     */
    @ApiOperation(value="配置：区域选项",notes="区域选项")
    @ApiImplicitParams({
        @ApiImplicitParam(name="provinceId",value="省Id",dataType="long",paramType="query",required=false),
        @ApiImplicitParam(name="cityId",value="市Id",dataType="long",paramType="query",required=false),
    })
    @GetMapping(value="area")
    public AreaListMsg area(HttpServletRequest request){
        Long provinceId = (Long)Util.typeChange(request.getParameter("provinceId"), Long.class);
        Long cityId = (Long)Util.typeChange(request.getParameter("cityId"), Long.class);
        
        logger.info("area---参数信息----provinceId=={},cityId=={}",provinceId,cityId);
        int areaCode = ConfigServiceImpl.AREA_CODE_0;
        Long areaId = null;
        if(provinceId !=null) {
            areaId = provinceId;
            areaCode = ConfigServiceImpl.AREA_CODE_1;
        }else if(cityId !=null) {
            areaId = cityId;
            areaCode = ConfigServiceImpl.AREA_CODE_2;
        }
        
        return this.configService.getAreaList(areaCode, areaId);
    }
    
    
    
}
