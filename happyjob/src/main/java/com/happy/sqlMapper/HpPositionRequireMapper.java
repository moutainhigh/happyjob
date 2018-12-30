package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionRequireEntity;

@Repository("hpPositionRequireMapper")
public interface HpPositionRequireMapper{

	void insert(HpPositionRequireEntity hpPositionRequire);

	HpPositionRequireEntity selectByPK(long hpPositionRequireId);

	void updateByPK(HpPositionRequireEntity hpPositionRequire);

	void deleteByPK(long hpPositionRequireId);

	List< HpPositionRequireEntity> selectAll();

	List< HpPositionRequireEntity> selectAllIsUse();

}
