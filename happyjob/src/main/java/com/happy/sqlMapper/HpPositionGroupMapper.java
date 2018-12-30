package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionGroupEntity;

@Repository("hpPositionGroupMapper")
public interface HpPositionGroupMapper{

	void insert(HpPositionGroupEntity hpPositionGroup);

	HpPositionGroupEntity selectByPK(long hpPositionGroupId);

	void updateByPK(HpPositionGroupEntity hpPositionGroup);

	void deleteByPK(long hpPositionGroupId);

	List< HpPositionGroupEntity> selectAll();

	List< HpPositionGroupEntity> selectAllIsUse();

}
