 package com.happy.service.banner;

import com.happy.service.banner.data.BannerDataMsg;
import com.happy.service.banner.data.BannerListMsg;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;

public interface BannerService {
     
     /**
      * 
      * @TODO:   分页获取招聘列表
      */
    BannerListMsg getBannerList(Integer useOn,Integer delOn,Integer state,int isPage,Integer currentPage,Integer showCount);
     
    /**
     * 
     * @TODO:   获取招聘岗位详情
     */
    BannerDataMsg getBanner(Long hpBannerId);
    
    
}
