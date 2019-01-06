package com.happy.service.company.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpCompanyEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.company.CompanyService;
import com.happy.service.company.data.CompanyListMsg;
import com.happy.service.company.data.CompanySearch;
import com.happy.service.company.data.HpCompanyExt;
import com.happy.sqlExMapper.HpCompanyExMapper;
import com.happy.sqlMapper.HpCompanyMapper;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private HpCompanyExMapper hpCompanyExMapper ;
	
	@Autowired
	private HpCompanyMapper hpCompanyMapper ;
	
	@Override
	public CompanyListMsg companyListPage(String comName, Long startTime, Long endTime,Integer currentPage, Integer showCount) {
		CompanyListMsg msg = new CompanyListMsg();
		CompanySearch page = new CompanySearch();
		
		currentPage = currentPage==null || currentPage<1?1:currentPage;
        showCount = showCount==null||showCount<1?10:showCount;
        
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
		page.setComName(comName);
		page.setStartTime(startTime);
		page.setEndTime(endTime);
		
		List<HpCompanyExt> list = this.hpCompanyExMapper.getCompanyListPage(page);
        msg.setList(list);
        msg.setPage(page);
		return msg;
	}

	@Override
	public BaseMsg companyAuth(Long companyId,Integer approveState) {
		BaseMsg msg = new BaseMsg();
        if(companyId == null) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：companyId");
            return msg;
        }
        HpCompanyEntity adv = new HpCompanyExt();
        adv.setHpCompanyId(companyId);
        adv.setApproveState(approveState);
        this.hpCompanyMapper.updateByPK(adv);
		return msg;
		
	}

}
