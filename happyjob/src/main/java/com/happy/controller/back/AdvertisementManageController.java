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
import io.swagger.annotations.ApiOperation;

@Api(value="后台广告管理相关请求API",tags="后台广告管理相关请求API")
@RestController
@RequestMapping("backAdvertisement")
public class AdvertisementManageController {
	
	    private static final Logger logger = LoggerFactory.getLogger(AdvertisementManageController.class);
	    @Resource
	    private BannerService bannerService;
	    
	    /**
	     * @TODO:     用户列表查询
	     */
	    @ApiOperation(value="广告列表查询",notes="广告列表查询")
	    @GetMapping(value="advertisementList")
	    public BannerListMsg userList(HttpServletRequest request){
	        logger.info("AdvertiseManageController class  userList method");
	        Integer currentPage = (Integer)Util.typeChange(request.getParameter("currentPage"), Integer.class);
	        Integer showCount = (Integer)Util.typeChange(request.getParameter("showCount"), Integer.class);
	       
	        BannerListMsg result = this.bannerService.getBannerList(null, 1, null, 1, currentPage, showCount);
	        return  result;
	    }
	    
	    /**
	     * 广告开启/关闭
	     */
	    @ApiOperation(value="是否开启广告",notes="是否开启广告")
	    @PostMapping(value="advertisementUseOn")
	    public BaseMsg advertisementUseOn(HttpServletRequest request){
	        Long hpAdvBannerId = (Long)Util.typeChange(request.getParameter("hpAdvBannerId"), Long.class);
	        Integer useOn = (Integer)Util.typeChange(request.getParameter("useOn"), Integer.class);
	        
	        logger.info("backAdvertisement.advertisementUseOn 请求参数：hpAdvBannerId={},useOn={}",hpAdvBannerId,useOn);
	        return this.bannerService.updateUseOn(hpAdvBannerId,useOn);
	    }
	    
	    /**
	     * 广告开启/关闭
	     */
	    @ApiOperation(value="是否开启广告",notes="是否开启广告")
	    @PostMapping(value="deleteAdvertisement")
	    public BaseMsg deleteAdvertisement(HttpServletRequest request){
	        Long hpAdvBannerId = (Long)Util.typeChange(request.getParameter("hpAdvBannerId"), Long.class);
	        logger.info("backAdvertisement.deleteAdvertisement 请求参数：hpAdvBannerId={}",hpAdvBannerId);
	        BaseMsg ss = this.bannerService.deleteAdvertisement(hpAdvBannerId);
	        return ss;
	    }
	    
}
