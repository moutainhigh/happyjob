package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionSalaryEntity;

@Repository("hpPositionSalaryMapper")
public interface HpPositionSalaryMapper{

	void insert(HpPositionSalaryEntity hpPositionSalary);

	HpPositionSalaryEntity selectByPK(long hpPositionSalaryId);

	void updateByPK(HpPositionSalaryEntity hpPositionSalary);

	void deleteByPK(long hpPositionSalaryId);

	List< HpPositionSalaryEntity> selectAll();

	List< HpPositionSalaryEntity> selectAllIsUse();

}
