 package com.happy.service.position;

import com.happy.plugin.BaseMsg;
import com.happy.service.position.data.GroupDataMsg;
import com.happy.service.position.data.GroupListMsg;
import com.happy.service.position.data.PositionDetail;
import com.happy.service.position.data.PositionDetailMsg;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;

public interface PositionService {
     
     /**
      * 
      * @TODO:   分页获取招聘列表
      */
    PositionListMsg getPostionlistPage(String sid,String keyWord,String cityName,Integer posNature,Integer retOn,
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
   GroupDataMsg insertUserPositionApply(String sid,Long hpPositionId);
   /**
    * 
    * @TODO:   用户申请参与拼团
    */
   GroupDataMsg insertUserGroupApply(String sid,Long hpPositionGroupId);
   /**
    * 
    * @TODO:   后台：招聘列表
    */
   PositionListMsg getBackPostionlistPage(String posName,String comName,Long startTime,Long endTime,
       Integer posState,Integer currentPage,Integer showCount);
   /**
    * 
    * @TODO:   后台：招聘设置热门状态
    */
   BaseMsg updatePositionHotOn(Long hpPositionId,Integer hotOn);
   
   /**
    * @TODO:   删除
    */
   
   BaseMsg positionDel(Long hpPositionId);
   
   /**
    * 
    * @TODO:   获取招聘岗位详情
    */
   PositionDetailMsg getPostionDetail(Long hpPositionId);
   /**
    *
    * @TODO:   招聘新增、更新
    */
   BaseMsg insertOrUpPosition(PositionDetail data);
//   BaseMsg insertOrUpPositionTest(Long hpPositionId,String ids);
}
