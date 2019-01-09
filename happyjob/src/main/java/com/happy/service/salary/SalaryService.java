 package com.happy.service.salary;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.happy.entity.HpUserPayrollEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.salary.data.SalarySimpleListMsg;

public interface SalaryService {
	
	
	/**
	   *
	   * @TODO:     分页获取工资信息
	   */ 
   SalarySimpleListMsg getSalaryListPage(String workNum,String payName,String payIdNum,
		   String payComName,Integer payTime,Integer currentPage,Integer showCount);
  
   
   List<HpUserPayrollEntity> getPayroll(HpUserPayrollEntity hpUserPayrollEntity);
   
   BaseMsg importSalary(MultipartFile file);
}
