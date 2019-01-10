 package com.happy.service.banner.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpAdvBannerEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.banner.BannerService;
import com.happy.service.banner.data.BannerDataMsg;
import com.happy.service.banner.data.BannerListMsg;
import com.happy.service.banner.data.BannerSearch;
import com.happy.service.company.data.CompanyListMsg;
import com.happy.service.company.data.CompanySearch;
import com.happy.service.company.data.HpCompanyExt;
import com.happy.sqlExMapper.HpAdvBannerExMapper;
import com.happy.sqlMapper.HpAdvBannerMapper;
import com.happy.util.Util;
import com.happy.util.pubConst.EnumConst;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private HpAdvBannerExMapper hpAdvBannerExMapper;
    @Autowired
    private HpAdvBannerMapper hpAdvBannerMapper;

    @Override
    public BannerListMsg getBannerList(Integer useOn, Integer delOn, Integer state, int isPage, Integer currentPage,
        Integer showCount) {
        BannerListMsg msg = new BannerListMsg();
        BannerSearch page = new BannerSearch();
        page.setDelOn(delOn);
        if(state != null ) {
            page.setState(state);
            page.setCurTime(Util.getDateSecond(Util.getCurrentDate()));
        }
        page.setUseOn(useOn);
        if(isPage == 1) {
            currentPage = currentPage==null?1:currentPage;
            showCount = showCount==null?10:showCount;
            page.setIsPage(isPage);
            page.setCurrentPage(currentPage);
            page.setShowCount(showCount);
            int totalCount = this.hpAdvBannerExMapper.getBannerNumBySearch(page);
            page.setTotalResult(totalCount);
            msg.setPage(page);
        }
        List<HpAdvBannerEntity> bannerList = this.hpAdvBannerExMapper.getBannerListBySearch(page);
        msg.setList(bannerList);
        return msg;
    }

    @Override
    public BannerDataMsg getBanner(Long hpBannerId) {
        BannerDataMsg msg = new BannerDataMsg();
        HpAdvBannerEntity banner = this.hpAdvBannerMapper.selectByPK(hpBannerId);
        msg.setData(banner);
        return msg;
    }

	@Override
	public BaseMsg updateUseOn(Long hpAdvBannerId,Integer useOn) {
		BaseMsg msg = new BaseMsg();
        if(hpAdvBannerId == null) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：hpAdvBannerId");
            return msg;
        }
        if(useOn == null ) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：useOn");
            return msg;
        }
        
        HpAdvBannerEntity adv = new HpAdvBannerEntity();
        adv.setHpAdvBannerId(hpAdvBannerId);
        adv.setUseOn(useOn == EnumConst.advertisementUseOn.UseOnYse.getKey()?EnumConst.advertisementUseOn.UseOnNo.getKey():EnumConst.advertisementUseOn.UseOnYse.getKey());
	    this.hpAdvBannerMapper.updateByPK(adv);
        return msg;
	}

	@Override
	public BaseMsg deleteAdvertisement(Long hpAdvBannerId) {
		BaseMsg msg = new BaseMsg();
        if(hpAdvBannerId == null) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：hpAdvBannerId");
            return msg;
        }
        HpAdvBannerEntity adv = new HpAdvBannerEntity();
        adv.setHpAdvBannerId(hpAdvBannerId);
        adv.setDelOn(EnumConst.advertisementDelOn.DelOnYse.getKey());
        this.hpAdvBannerMapper.updateByPK(adv);
		return msg;
	}

	@Override
	public BaseMsg saveAdvertisement(String title, Integer posType, String type, Long sort, String picUrl,String targetUrl,
			Long endTime) {
		BaseMsg msg = new BaseMsg();
        if(sort == null || sort ==0) {
            msg.setErrorCode(1);
            msg.setMessage("参数格式错误：排序");
            return msg;
        }
        HpAdvBannerEntity hpAdvBanner = new HpAdvBannerEntity();
        hpAdvBanner.setTitle(title);
        hpAdvBanner.setSortNum(sort);
        hpAdvBanner.setPicUrl(picUrl);
        hpAdvBanner.setTargetUrl(targetUrl);
        hpAdvBanner.setPosType(posType);
        hpAdvBanner.setDelOn(EnumConst.advertisementDelOn.DelOnNo.getKey());   
        hpAdvBanner.setUseOn(EnumConst.advertisementUseOn.UseOnNo.getKey());   //关闭状态
        hpAdvBanner.setEndTime(endTime);
        this.hpAdvBannerMapper.insert(hpAdvBanner);
        if(hpAdvBanner.getHpAdvBannerId() == null) {
            msg.setErrorCode(1);
            msg.setMessage("添加失败，稍后再试");
        }
        return msg;
	}

	@Override
	public BaseMsg updateAdvertisement(Long hpAdvBannerId, String title, Integer posType, String type, Long sortNum,
			String picUrl, String targetUrl, Long endTime) {
		BaseMsg msg = new BaseMsg();
        if(hpAdvBannerId == null || hpAdvBannerId ==0) {
            msg.setErrorCode(1);
            msg.setMessage("参数格式错误：hpAdvBannerId");
            return msg;
        }
        HpAdvBannerEntity hpAdvBanner = new HpAdvBannerEntity();
        hpAdvBanner.setHpAdvBannerId(hpAdvBannerId);
        hpAdvBanner.setTitle(title);
        hpAdvBanner.setSortNum(sortNum);
        if(picUrl != null && picUrl != "") {
        	hpAdvBanner.setPicUrl(picUrl);
        }
        
        hpAdvBanner.setPicUrl(targetUrl);
        hpAdvBanner.setEndTime(endTime);
        this.hpAdvBannerMapper.updateByPK(hpAdvBanner);
        
        return msg;
	}

	
	@Override
	public BannerListMsg getBannerlistPage(Integer currentPage, Integer showCount) {
		BannerListMsg msg = new BannerListMsg();
		BannerSearch page = new BannerSearch();
		currentPage = currentPage==null || currentPage<1?1:currentPage;
        showCount = showCount==null||showCount<1?10:showCount;
        
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
        page.setDelOn(EnumConst.advertisementDelOn.DelOnNo.getKey());
        List<HpAdvBannerEntity> list = this.hpAdvBannerExMapper.getBannerlistPage(page);
        msg.setList(list);
        msg.setPage(page);
		return msg;
	}


}
