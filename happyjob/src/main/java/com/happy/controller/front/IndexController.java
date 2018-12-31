 package com.happy.controller.front;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.service.banner.BannerService;
import com.happy.service.banner.data.BannerListMsg;
import com.happy.service.position.PositionService;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;
import com.happy.service.user.UserService;
import com.happy.service.user.data.UserSerachListMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="前台首页相关请求API",tags="前台首页相关请求API")
@RestController
@RequestMapping("frontIndex")
 public class IndexController {

    @Resource
    private PositionService positionService;
    @Resource
    private BannerService bannerService;
    @Resource
    private UserService userService;
    
    /**
     * @TODO:     岗位列表分页获取
     */
    @ApiOperation(value="首页岗位列表分页获取",notes="首页岗位列表分页获取")
    @ApiImplicitParams({
        @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
        @ApiImplicitParam(name="sid",value="用户登录凭证",dataType="String",paramType="header",required=false),
        @ApiImplicitParam(name="cityName",value="城市名称",dataType="String",paramType="query",required=false),
        @ApiImplicitParam(name="keyWord",value="关键字，模糊匹配公司名称、职位名称",dataType="String",paramType="query",required=false),
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
        String keyWord = request.getParameter("keyWord");
        Integer posNature = (Integer)Util.typeChange(request.getParameter("posNature"), Integer.class);
        Integer retOn = (Integer)Util.typeChange(request.getParameter("retOn"), Integer.class);
        Integer hotOn = (Integer)Util.typeChange(request.getParameter("hotOn"), Integer.class);
        Integer welfareOn = (Integer)Util.typeChange(request.getParameter("welfareOn"), Integer.class);
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        currentPage = currentPage==null||currentPage<=0?1:currentPage;
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
        showCount = showCount==null||showCount<=0?1:showCount;
        
        if(!Util.isEmpty(keyWord)) { // 添加搜索记录
            this.userService.insertUserSearch(oid, keyWord);
        }
        
        return this.positionService.getPostionlistPage(oid,keyWord,cityName, posNature, retOn, hotOn, welfareOn, currentPage, showCount);
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
    
    /**
     * @TODO:     首页轮播图
     */
    @ApiOperation(value="首页轮播图列表获取",notes="首页轮播图列表获取")
    @ApiImplicitParams({
        @ApiImplicitParam(name="useOn",value="是否开启",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="delOn",value="是否删除",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="state",value="广告时效，1、有效，2、过期，其他全部",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="isPage",value="是否分页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="currentPage",value="分页当前页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页展示数",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="banner")
    public BannerListMsg banner(HttpServletRequest request){
        Integer useOn = (Integer)Util.typeChange(request.getParameter("useOn"), Integer.class);
        Integer delOn = (Integer)Util.typeChange(request.getParameter("delOn"), Integer.class);
        Integer state = (Integer)Util.typeChange(request.getParameter("state"), Integer.class);
        Integer isPage = (Integer)Util.typeChange(request.getParameter("isPage"), Integer.class);
        isPage = isPage==null || isPage!=1 ?0:isPage;
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
        
        
        return this.bannerService.getBannerList(useOn, delOn, state, isPage, currentPage, showCount);
    }
    /**
     * @TODO:     搜索记录查询
     */
    @ApiOperation(value="搜索记录查询",notes="搜索记录查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name="oid",value="微信登录凭证",dataType="String",paramType="header",required=true),
        @ApiImplicitParam(name="delOn",value="是否删除",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="isPage",value="是否分页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="currentPage",value="分页当前页",dataType="int",paramType="query",required=false),
        @ApiImplicitParam(name="showCount",value="单页展示数",dataType="int",paramType="query",required=false),
    })
    @GetMapping(value="searchHistory")
    public UserSerachListMsg searchHistory(HttpServletRequest request){
        String oid = request.getHeader("oid");
        Integer delOn = (Integer)Util.typeChange(request.getParameter("delOn"), Integer.class);
        Integer isPage = (Integer)Util.typeChange(request.getParameter("isPage"), Integer.class);
        isPage = isPage==null || isPage!=1 ?0:isPage;
        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
        
        
        return this.userService.getUserSearchList(oid, delOn, isPage, currentPage, showCount);
    }
    
    
    
    
}
