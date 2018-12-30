package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionTypeEntity;

@Repository("hpPositionTypeMapper")
public interface HpPositionTypeMapper{

	void insert(HpPositionTypeEntity hpPositionType);

	HpPositionTypeEntity selectByPK(long hpPositionTypeId);

	void updateByPK(HpPositionTypeEntity hpPositionType);

	void deleteByPK(long hpPositionTypeId);

	List< HpPositionTypeEntity> selectAll();

	List< HpPositionTypeEntity> selectAllIsUse();

}
