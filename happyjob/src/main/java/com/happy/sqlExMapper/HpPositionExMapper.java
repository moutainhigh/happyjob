package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.service.position.data.PositionData;
import com.happy.service.position.data.PositionSearch;

@Repository("hpPositionExMapper")
public interface HpPositionExMapper{

    List<PositionData> getFrontPosBySearch(PositionSearch search);
    
    PositionData getFrontPosByKey(@Param("hpPositionId") Long hpPositionId);
    
    int getFrontUserPosNum(@Param("hpPositionId") Long hpPositionId,@Param("sid") String sid,@Param("curTime") long curTime);
}
