package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.service.position.data.PositionData;
import com.happy.service.position.data.PositionSearch;

@Repository("hpPositionExMapper")
public interface HpPositionExMapper{

    List<PositionData> getFrontPoslistPage(PositionSearch search);
    
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
    int getGroupPosNumBySearch(PositionSearch search);
}
