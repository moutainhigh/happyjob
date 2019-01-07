package com.happy.service.company;

import com.happy.plugin.BaseMsg;
import com.happy.service.company.data.CompanyListMsg;

public interface CompanyService {

	 CompanyListMsg companyListPage(String comName,Long startTime,Long endTime,Integer currentPage, Integer showCount);
	 
	 BaseMsg companyAuth(Long companyId ,Integer approveState);
	 
	 BaseMsg newCompany(String comName,Long companyTypeId,Long companyScaleId,String comDesc,
			 Long countyId,String addrDetail,String comtPerson,String comPhone,String comEmail);
}
