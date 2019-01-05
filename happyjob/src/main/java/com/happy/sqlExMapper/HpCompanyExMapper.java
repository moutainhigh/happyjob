package com.happy.sqlExMapper;

import java.util.List;

import com.happy.plugin.Page;
import com.happy.service.company.data.HpCompanyExt;

public interface HpCompanyExMapper {

	List<HpCompanyExt> getCompanyListPage(Page page);
	
}
