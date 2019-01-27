package com.happy.sqlExMapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.happy.entity.HpCompanyApplyEntity;
import com.happy.service.apply.data.ApplySearch;

@Repository("HpCompanyApplyExMapper")
public interface HpCompanyApplyExMapper {

	List<HpCompanyApplyEntity> getCompanyApplylistPage(ApplySearch page);
	
}
