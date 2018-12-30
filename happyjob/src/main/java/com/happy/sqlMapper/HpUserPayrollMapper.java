package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserPayrollEntity;

@Repository("hpUserPayrollMapper")
public interface HpUserPayrollMapper{

	void insert(HpUserPayrollEntity hpUserPayroll);

	HpUserPayrollEntity selectByPK(long hpUserPayrollId);

	void updateByPK(HpUserPayrollEntity hpUserPayroll);

	void deleteByPK(long hpUserPayrollId);

	List< HpUserPayrollEntity> selectAll();

	List< HpUserPayrollEntity> selectAllIsUse();

}
