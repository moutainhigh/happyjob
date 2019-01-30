package com.happy.controller.back;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.plugin.BaseMsg;
import com.happy.service.banner.BannerService;
import com.happy.service.banner.data.BannerListMsg;
import com.happy.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="后台广告管理相关请求API",tags="后台广告管理相关请求API")
@RestController
@RequestMapping("backAdvertisement")
public class AdvertisementManageController {
	
	    private static final Logger logger = LoggerFactory.getLogger(AdvertisementManageController.class);
	    @Resource
	    private BannerService bannerService;
	    
	    /**
	     *      广告列表查询
	     */
	    @ApiOperation(value="广告列表查询",notes="广告列表查询")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="currentPage",value="当前页",dataType="int",paramType="query",required=false),
	        @ApiImplicitParam(name="showCount",value="单页展示记录数",dataType="int",paramType="query",required=false),
	    })
	    @GetMapping(value="advertisementList")
	    public BannerListMsg advertisementList(HttpServletRequest request){
	        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
	        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
	        logger.info("backAdvertisement.advertisementList 请求参数：currentPage={},showCount={}",currentPage,showCount);
	        BannerListMsg result = this.bannerService.getBannerlistPage( currentPage, showCount);
	        return  result;
	    }
	    
	    /**
	     * 广告开启/关闭
	     */
	    @ApiOperation(value="是否开启广告",notes="是否开启广告")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="hpAdvBannerId",value="广告id",dataType="Long",paramType="query",required=false),
	        @ApiImplicitParam(name="useOn",value="是否开启，1：开启；0：关闭",dataType="int",paramType="query",required=false),
	    })
	    @PostMapping(value="advertisementUseOn")
	    public BaseMsg advertisementUseOn(HttpServletRequest request){
	        Long hpAdvBannerId = (Long)Util.typeChange(request.getParameter("hpAdvBannerId"), Long.class);
	        Integer useOn = (Integer)Util.typeChange(request.getParameter("useOn"), Integer.class);
	        logger.info("backAdvertisement.advertisementUseOn 请求参数：hpAdvBannerId={},useOn={}",hpAdvBannerId,useOn);
	        return this.bannerService.updateUseOn(hpAdvBannerId,useOn);
	    }
	    
	    /**
	     * 删除
	     */
	    @ApiOperation(value="删除广告",notes="删除广告")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="hpAdvBannerId",value="广告id",dataType="Long",paramType="query",required=false),
	    })
	    @PostMapping(value="deleteAdvertisement")
	    public BaseMsg deleteAdvertisement(HttpServletRequest request){
	        Long hpAdvBannerId = (Long)Util.typeChange(request.getParameter("hpAdvBannerId"), Long.class);
	        logger.info("backAdvertisement.deleteAdvertisement 请求参数：hpAdvBannerId={}",hpAdvBannerId);
	        BaseMsg ss = this.bannerService.deleteAdvertisement(hpAdvBannerId);
	        return ss;
	    }
	    
	    /**
	     * 添加
	     */
	    @ApiOperation(value="添加广告",notes="添加广告")
	    @ApiImplicitParams({
	        @ApiImplicitParam(name="title",value="标题",dataType="String",paramType="query",required=false),
	        @ApiImplicitParam(name="posType",value="广告位类型（1、首页轮播）",dataType="Integer",paramType="query",required=false),
	        @ApiImplicitParam(name="picUrl",value="图片url",dataType="String",paramType="query",required=false),
	        @ApiImplicitParam(name="targetUrl",value="图片详情链接url",dataType="String",paramType="query",required=false),
	        @ApiImplicitParam(name="endTime",value="结束时间",dataType="Long",paramType="query",required=false),
	        @ApiImplicitParam(name="sort",value="排序",dataType="Long",paramType="query",required=false),
	    })
	    @PostMapping(value="saveAdvertisement")
	    public BaseMsg saveAdvertisement(HttpServletRequest request){
	    	String title = request.getParameter("title");
	    	Integer posType = (Integer)Util.typeChange(request.getParameter("posType"), Integer.class);
	    	String type = request.getParameter("type");
	    	String picUrl = request.getParameter("picUrl");
	    	String targetUrl = request.getParameter("targetUrl");
	    	
	        Long endTime = (Long)Util.typeChange(request.getParameter("endTime"), Long.class);
	        Long sort = (Long)Util.typeChange(request.getParameter("sort"), Long.class);
	        logger.info("backAdvertisement.saveAdvertisement 请求参数：title={},location={},type={},sort={},picUrl={},endTime={},targetUrl={}",title
	        		,posType,type,sort,picUrl,endTime,targetUrl);
	        
	        BaseMsg ss = this.bannerService.saveAdvertisement(title,posType,sort,picUrl,targetUrl,endTime);
	        return ss;
	    }
	    
	    /**
	     * 广告修改
	     */
	    @ApiOperation(value="修改广告",notes="修改广告")
	    @ApiImplicitParams({
	    	@ApiImplicitParam(name="hpAdvBannerId",value="广告id",dataType="Long",paramType="query",required=false),
	        @ApiImplicitParam(name="title",value="标题",dataType="String",paramType="query",required=false),
	        @ApiImplicitParam(name="posType",value="广告位类型（1、首页轮播）",dataType="Integer",paramType="query",required=false),
	        @ApiImplicitParam(name="picUrl",value="图片url",dataType="String",paramType="query",required=false),
	        @ApiImplicitParam(name="targetUrl",value="图片详情链接url",dataType="String",paramType="query",required=false),
	        @ApiImplicitParam(name="endTime",value="结束时间",dataType="Long",paramType="query",required=false),
	        @ApiImplicitParam(name="sortNum",value="排序",dataType="Long",paramType="query",required=false),
	    })
	    @PostMapping(value="updateAdvertisement")
	    public BaseMsg updateAdvertisement(HttpServletRequest request){
	    	
	        Long hpAdvBannerId = (Long)Util.typeChange(request.getParameter("hpAdvBannerId"), Long.class);
	        String title = request.getParameter("title");
	    	String picUrl = request.getParameter("picUrl");
	    	String targetUrl = request.getParameter("targetUrl");
	    	Integer posType = (Integer)Util.typeChange(request.getParameter("posType"), Integer.class);
	        Long endTime = (Long)Util.typeChange(request.getParameter("endTime"), Long.class);
	        Long sortNum = (Long)Util.typeChange(request.getParameter("sortNum"), Long.class);
	        
	        logger.info("backAdvertisement.saveAdvertisement 请求参数：hpAdvBannerId={},title={},location={},sort={},picUrl={},endTime={},targetUrl={}",hpAdvBannerId,title
	        		,posType,sortNum,picUrl,endTime,targetUrl);
	        
	        BaseMsg ss = this.bannerService.updateAdvertisement(hpAdvBannerId,title,posType,sortNum,picUrl,targetUrl,endTime);
	        return ss;
	    }
	    
	   
}
