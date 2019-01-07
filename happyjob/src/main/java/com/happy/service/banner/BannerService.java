 package com.happy.service.banner;

import com.happy.plugin.BaseMsg;
import com.happy.service.banner.data.BannerDataMsg;
import com.happy.service.banner.data.BannerListMsg;

public interface BannerService {
     
     /**
      * 
      * @TODO:   分页获取轮播图列表
      */
    BannerListMsg getBannerList(Integer useOn,Integer delOn,Integer state,int isPage,Integer currentPage,Integer showCount);
     
    /**
     * 
     * @TODO:   获取轮播图详情
     */
    BannerDataMsg getBanner(Long hpBannerId);
    
    /**
     * 开启 /关闭
     */
    BaseMsg updateUseOn(Long hpBannerId,Integer useOn);
    
    /**
     * 删除广告
     */
    BaseMsg deleteAdvertisement(Long hpBannerId);
    
    
    /**
     * 修改广告
     */
    BaseMsg updateAdvertisement(Long hpAdvBannerId ,String title,String location,String type,Long sort,String picUrl,String targetUrl,Long endTime);

    
    /**
     * 添加广告
     * @param title
     * @param location
     * @param type
     * @param sort
     * @param picUrl
     * @param targetUrl
     * @param endTime
     * @return
     */
    BaseMsg saveAdvertisement(String title,String location,String type,Long sort,String picUrl,String targetUrl,Long endTime);
}
