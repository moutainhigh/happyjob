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

	@Override
	public BaseMsg newCompany(String comName, Long companyTypeId, Long companyScaleId, String comDesc, Long countyId,
			String addrDetail, String comtPerson, String comPhone, String comEmail) {
		BaseMsg msg = new BaseMsg();
        if(comName == null || comName == "") {
            msg.setErrorCode(1);
            msg.setMessage("公司名称必填");
            return msg;
        }
        if(comDesc == null || comDesc == "") {
            msg.setErrorCode(1);
            msg.setMessage("公司描述必填");
            return msg;
        }
        if(companyScaleId == null || companyScaleId == 0) {
            msg.setErrorCode(1);
            msg.setMessage("公司规模必填");
            return msg;
        }
        if(countyId == null || countyId == 0) {
            msg.setErrorCode(1);
            msg.setMessage("公司位置必填");
            return msg;
        }
        if(addrDetail == null || addrDetail == "") {
        	msg.setErrorCode(1);
        	msg.setMessage("公司详细地址必填");
        	return msg;
        }
        if(comtPerson == null || comtPerson == "") {
        	msg.setErrorCode(1);
        	msg.setMessage("联系人必填");
        	return msg;
        }
        if(comPhone == null || comPhone =="") {
        	msg.setErrorCode(1);
        	msg.setMessage("联系电话必填");
        	return msg;
        }
        
        HpCompanyEntity company = new HpCompanyEntity();
        company.setComName(comName);
        company.setHpCompanyTypeId(companyTypeId);
        company.setHpCompanyScaleId(companyScaleId);
        company.setComDesc(comDesc);
        company.setCountyId(countyId);
        company.setAddrDetail(addrDetail);
        company.setComtPerson(comtPerson);
        company.setComPhone(comPhone);
        company.setComEmail(comEmail);
        company.setApproveState(0); //未认证
        this.hpCompanyMapper.insert(company);
		return msg;
	}

	@Override
	public BaseMsg updateCompany(Long companyId, String comName, Long companyTypeId, Long companyScaleId,
			String comDesc, Long countyId, String addrDetail, String comtPerson, String comPhone, String comEmail) {
		BaseMsg msg = new BaseMsg();
        if(companyId == null || companyId == 0) {
            msg.setErrorCode(1);
            msg.setMessage("参数有问题："+companyId);
            return msg;
        }
        
        HpCompanyEntity company = new HpCompanyEntity();
        company.setComName(comName);
        company.setHpCompanyTypeId(companyTypeId);
        company.setHpCompanyScaleId(companyScaleId);
        company.setComDesc(comDesc);
        company.setCountyId(countyId);
        company.setAddrDetail(addrDetail);
        company.setComtPerson(comtPerson);
        company.setComPhone(comPhone);
        company.setComEmail(comEmail);
        this.hpCompanyMapper.updateByPK(company);
		return msg;
	}

}
