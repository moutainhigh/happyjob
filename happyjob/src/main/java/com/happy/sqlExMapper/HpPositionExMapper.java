package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.entity.HpPositionEntity;
import com.happy.service.position.data.GroupData;
import com.happy.service.position.data.GroupSearch;
import com.happy.service.position.data.PositionData;
import com.happy.service.position.data.PositionSearch;

@Repository("hpPositionExMapper")
public interface HpPositionExMapper{

    List<PositionData> getFrontPoslistPage(PositionSearch page);
    
    PositionData getFrontPosByKey(@Param("hpPositionId") Long hpPositionId);
    /**
     *
     * @TODO:     普通申请数量
     */
    int getPosNumBySearch(PositionSearch search);
    /**
     *
     * @TODO:     拼团申请数量
     */
    int getGroupPosNumBySearch(PositionSearch page);
    
    /**
     *
     * @TODO:     获取岗位下正在进行的拼团列表
     */
    List<GroupData> getGroupListBySearch(GroupSearch page);
    /**
     *
     * @TODO:     获取岗位下正在进行的拼团列表数量
     */
    int getGroupNumBySearch(GroupSearch page);
    /**
     *
     * @TODO:     获取岗位拼团详情
     */
    GroupData getGroupDetail(@Param("sid") String sid,@Param("hpPositionGroupId") Long hpPositionGroupId,@Param("curTime")Long curTime);
    /**
    *
    * @TODO:     获取岗位详情指定字段，仅用作判断
    */
    HpPositionEntity getSimplePosByKey(@Param("hpPositionId") Long hpPositionId);
}

