package com.happy.sqlExMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.happy.plugin.Page;
import com.happy.service.company.data.HpCompanyExt;

@Repository("HpCompanyExMapper")
public interface HpCompanyExMapper {

	List<HpCompanyExt> getCompanylistPage(Page page);
	
}
