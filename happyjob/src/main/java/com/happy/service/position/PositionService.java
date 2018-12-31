 package com.happy.service.position;

import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;

public interface PositionService {
     
     /**
      * 
      * @TODO:   分页获取招聘列表
      */
    PositionListMsg getPostionlistPage(String cityName,Integer posNature,Integer retOn,
         Integer hotOn,Integer welfareOn,Integer currentPage,Integer showCount);
     
    /**
     * 
     * @TODO:   获取招聘岗位详情
     */
    PositionMsg getPostion(String sid,String oid,Long hpPositionId);
    
    
}
