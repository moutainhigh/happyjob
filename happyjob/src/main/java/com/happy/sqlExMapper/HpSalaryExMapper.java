package com.happy.sqlExMapper;

import java.util.List;

import com.happy.entity.HpUserPayrollEntity;
import com.happy.service.salary.data.SalaryManageSearch;

public interface HpSalaryExMapper {

	 /*
	  *  管理端  分页查询工资 
	  */
	 List<HpUserPayrollEntity> getSalarylistPage(SalaryManageSearch page);
	 
	 /**
	  * 获取
	  * @param hpUserPayrollEntity
	  * @return
	  */
	 List<HpUserPayrollEntity> getPayroll(HpUserPayrollEntity hpUserPayrollEntity);
}
