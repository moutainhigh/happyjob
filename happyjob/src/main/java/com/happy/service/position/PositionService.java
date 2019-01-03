 package com.happy.service.position;

import com.happy.service.position.data.GroupDataMsg;
import com.happy.service.position.data.GroupListMsg;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;

public interface PositionService {
     
     /**
      * 
      * @TODO:   分页获取招聘列表
      */
    PositionListMsg getPostionlistPage(String oid,String keyWord,String cityName,Integer posNature,Integer retOn,
         Integer hotOn,Integer welfareOn,Integer urgentOn,Integer groupOn,Integer currentPage,Integer showCount);
     
    /**
     * 
     * @TODO:   获取招聘岗位详情
     */
    PositionMsg getPostion(String sid,String oid,Long hpPositionId);
    
    /**
     * 
     * @TODO:   分页获取招聘岗位拼团列表
     */
   GroupListMsg getGrouplistPage(String sid,Long hpPositionId,int isPage,Integer currentPage,Integer showCount);
    
   /**
    * 
    * @TODO:   获取招聘岗位拼团详情
    */
   GroupDataMsg getGroupDetail(String sid,Long hpPositionGroupId);
   /**
    * 
    * @TODO:   用户申请职位或者发起拼团
    */
   GroupDataMsg insertUserPostionApply(String sid,Long hpPositionId);
}
