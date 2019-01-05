package com.happy.service.company;

import com.happy.service.company.data.CompanyListMsg;

public interface CompanyService {

	 CompanyListMsg companyListPage(String comName,Long startTime,Long endTime,Integer currentPage, Integer showCount);
}
