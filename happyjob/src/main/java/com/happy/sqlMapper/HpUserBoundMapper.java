package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserBoundEntity;

@Repository("hpUserBoundMapper")
public interface HpUserBoundMapper{

	void insert(HpUserBoundEntity hpUserBound);

	HpUserBoundEntity selectByPK(long hpUserBoundId);

	void updateByPK(HpUserBoundEntity hpUserBound);

	void deleteByPK(long hpUserBoundId);

	List< HpUserBoundEntity> selectAll();

	List< HpUserBoundEntity> selectAllIsUse();

}
