package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionEntity;

@Repository("hpPositionMapper")
public interface HpPositionMapper{

	void insert(HpPositionEntity hpPosition);

	HpPositionEntity selectByPK(long hpPositionId);

	void updateByPK(HpPositionEntity hpPosition);

	void deleteByPK(long hpPositionId);

	List< HpPositionEntity> selectAll();

	List< HpPositionEntity> selectAllIsUse();

}
