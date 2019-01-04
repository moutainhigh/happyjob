 package com.happy.service.salary;

import com.happy.service.salary.data.SalarySimpleListMsg;

public interface SalaryService {
	
	
	/**
	   *
	   * @TODO:     分页获取工资信息
	   */ 
   SalarySimpleListMsg getSalaryListPage(String workNum,String payName,String payIdNum,
		   String payComName,Integer payTime,Integer currentPage,Integer showCount);
  
}
