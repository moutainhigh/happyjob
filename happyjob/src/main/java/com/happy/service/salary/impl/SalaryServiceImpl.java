package com.happy.service.salary.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpUserPayrollEntity;
import com.happy.service.salary.SalaryService;
import com.happy.service.salary.data.SalaryManageSearch;
import com.happy.service.salary.data.SalarySimpleListMsg;
import com.happy.sqlExMapper.HpSalaryExMapper;

@Service
public class SalaryServiceImpl implements SalaryService { 

	private static final Logger logger = LoggerFactory.getLogger(SalaryServiceImpl.class);
	   
	@Autowired
	private HpSalaryExMapper hpSalaryExMapper;
	
	@Override
	public SalarySimpleListMsg getSalaryListPage(String workNum, String payName, String payIdNum, String payComName,
			Integer payTime,Integer currentPage,Integer showCount) {
		SalarySimpleListMsg msg = new SalarySimpleListMsg();
		SalaryManageSearch page = new SalaryManageSearch();
        
		currentPage = currentPage==null || currentPage<1?1:currentPage;
        showCount = showCount==null||showCount<1?10:showCount;
        
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
        page.setWorkNum(workNum);
        page.setPayName(payName);
        page.setPayIdNum(payIdNum);
        page.setPayComName(payComName);
        page.setPayTime(payTime);
        
        List<HpUserPayrollEntity> list = this.hpSalaryExMapper.getSalarylistPage(page);
        msg.setList(list);
        msg.setPage(page);
        return msg;
	}
}
