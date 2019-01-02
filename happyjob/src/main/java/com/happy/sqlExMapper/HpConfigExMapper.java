package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpEducationEntity;

@Repository("hpConfigExMapper")
public interface HpConfigExMapper{
    /**
     * @TODO:     描述一下这个方法是干什么的
     */
	List<HpEducationEntity> getUseEduList(@Param("useOn") Integer useOn);
}
