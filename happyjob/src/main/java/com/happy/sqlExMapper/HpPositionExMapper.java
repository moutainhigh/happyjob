package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.entity.HpPositionEntity;
import com.happy.service.position.data.GroupData;
import com.happy.service.position.data.GroupSearch;
import com.happy.service.position.data.PositionData;
import com.happy.service.position.data.PositionDetail;
import com.happy.service.position.data.PositionSearch;

@Repository("hpPositionExMapper")
public interface HpPositionExMapper{

    List<PositionData> getFrontPoslistPage(PositionSearch page);
    
    PositionData getFrontPosByKey(@Param("hpPositionId") Long hpPositionId,@Param("sid") String sid);
    /**
     *
     * @TODO:     普通申请数量
     */
    int getPosNumBySearch(PositionSearch page);
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
    /**
     *
     * @TODO:     获取拼团当前参与人数
     */
    int getGroupPartNum(@Param("hpPositionGroupId") Long hpPositionGroupId);
    /**
    *
    * @TODO:     后台：职位列表查询
    */
    List<PositionData> getBackPoslistPage(PositionSearch page);
    /**
    *
    * @TODO:     后台：岗位详细信息：编辑
    */
    PositionDetail getPosDetailByKey(@Param("hpPositionId") Long hpPositionId);
    /**
    *
    * @TODO:     后台：删除岗位福利关联关系
    */
    void deleteGroupWelfare(@Param("hpPositionId") Long hpPositionId);
    /**
     *
     * @TODO:     后台：新增岗位福利关联关系
     */
    void insertGroupWelfare(@Param("hpPositionId") Long hpPositionId,@Param("list")List<Long> idArr);
    /**
    *
    * @TODO:     后台：获取岗位要求ID
    */
    Long getPositionRequireId(@Param("hpPositionId") Long hpPositionId);
    /**
     *
     * @TODO:     消息推送：获取岗位名称
     */
    String getPosNameByGroupKey(@Param("hpPositionGroupId") Long hpPositionGroupId);
}

