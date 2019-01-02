 package com.happy.service.banner;

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
    
    
}
