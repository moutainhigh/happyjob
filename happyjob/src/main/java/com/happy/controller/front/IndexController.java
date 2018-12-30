 package com.happy.controller.front;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.service.position.PositionService;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="首页相关请求API",tags="首页相关请求API")
@RestController
@RequestMapping("frontIndex")
 public class IndexController {

    @Resource
    private PositionService positionService;
    
    /**
     * @TODO:     岗位列表分页获取
     */
    @ApiOperation(value="首页岗位列表分页获取",notes="首页岗位列表分页获取")
    @ApiImplicitParams({
        @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
        @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=false),
        @ApiImplicitParam(name="cityName",value="城市名称",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="posNature",value="职位性质（1、实习，2、兼职，3、全职）",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="retOn",value="是否入职返现",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="hotOn",value="是否热门",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="welfareOn",value="是否福利岗位",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="currentPage",value="当前分页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页展示记录数",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="position")
    public PositionListMsg position(HttpServletRequest request){
        String oid = request.getHeader("oid");
        String sid = request.getHeader("sid");
        String cityName = request.getParameter("cityName");
        Integer posNature = (Integer)Util.typeChange(request.getParameter("posNature"), Integer.class);
        Integer retOn = (Integer)Util.typeChange(request.getParameter("retOn"), Integer.class);
        Integer hotOn = (Integer)Util.typeChange(request.getParameter("hotOn"), Integer.class);
        Integer welfareOn = (Integer)Util.typeChange(request.getParameter("welfareOn"), Integer.class);
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        currentPage = currentPage==null||currentPage<=0?1:currentPage;
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
        showCount = showCount==null||showCount<=0?1:showCount;
        
        return this.positionService.getPostionlistPage(cityName, posNature, retOn, hotOn, welfareOn, currentPage, showCount);
    }
    
    /**
     * @TODO:     首页招聘岗位详情页
     */
    @ApiOperation(value="首页招聘岗位详情页",notes="首页招聘岗位详情页")
    @ApiImplicitParams({
        @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
        @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=false),
        @ApiImplicitParam(name="hpPositionId",value="招聘岗位ID",dataType="long",paramType="query",required=true),
        
    })
    @GetMapping(value="positionDetail")
    public PositionMsg positionDetail(HttpServletRequest request){
        String oid = request.getHeader("oid");
        String sid = request.getHeader("sid");
        Long hpPositionId = (Long)Util.typeChange(request.getParameter("hpPositionId"), Long.class);
        
        
        return this.positionService.getPostion(sid, oid, hpPositionId);
    }
    
    
}
