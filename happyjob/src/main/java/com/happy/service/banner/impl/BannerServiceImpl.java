 package com.happy.service.banner.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpAdvBannerEntity;
import com.happy.entity.HpUserEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.banner.BannerService;
import com.happy.service.banner.data.BannerDataMsg;
import com.happy.service.banner.data.BannerListMsg;
import com.happy.service.banner.data.BannerSearch;
import com.happy.sqlExMapper.HpAdvBannerExMapper;
import com.happy.sqlMapper.HpAdvBannerMapper;
import com.happy.util.Util;

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
        adv.setUseOn(useOn == 1?0:1);
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
        adv.setDelOn(0);
        this.hpAdvBannerMapper.updateByPK(adv);
		return msg;
	}



}
