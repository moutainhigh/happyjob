package com.happy.service.apply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpCompanyApplyEntity;
import com.happy.entity.HpPositionRefUserEntity;
import com.happy.entity.HpUserEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.apply.ApplyService;
import com.happy.service.apply.data.ApplyListMsg;
import com.happy.service.apply.data.ApplySearch;
import com.happy.sqlExMapper.HpCompanyApplyExMapper;
import com.happy.sqlMapper.HpCompanyApplyMapper;



@Service
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private HpCompanyApplyExMapper hpCompanyApplyExMapper ;
	
	@Autowired
	private HpCompanyApplyMapper hpCompanyApplyMapper ;
	
	@Override
	public ApplyListMsg getApplylistPage(Integer currentPage,Integer showCount,String name ,
	    String comName,String contactNum,Long startTime,Long endTime,Integer contactOn ){
		
		ApplyListMsg msg = new ApplyListMsg();
		ApplySearch page = new ApplySearch();
		page.setName(name);
		page.setComName(comName);
		page.setContactNum(contactNum);
		page.setStartTime(startTime);
		page.setEndTime(endTime);
		page.setContactOn(contactOn);
		
		currentPage = currentPage==null || currentPage<1?1:currentPage;
        showCount = showCount==null||showCount<1?10:showCount;
        
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
		
        List<HpCompanyApplyEntity> list = this.hpCompanyApplyExMapper.getCompanyApplylistPage(page);
	    msg.setList(list);
	    msg.setPage(page);
	    return msg;
	}


	@Override
	public BaseMsg companyApplyDel(Long hpCompanyApplyId) {
		BaseMsg msg = new BaseMsg();
        if(hpCompanyApplyId == null) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：hpCompanyApplyId");
            return msg;
        }
        HpCompanyApplyEntity adv = new HpCompanyApplyEntity();
        adv.setHpCompanyApplyId(hpCompanyApplyId);
        adv.setDelOn(1);
        this.hpCompanyApplyMapper.updateByPK(adv);
		return msg;
	}


	@Override
	public BaseMsg addComtact(Long hpCompanyApplyId, String optionPerson, Long optionTime) {
		BaseMsg msg = new BaseMsg();
		//更新
		if(hpCompanyApplyId != null &&  hpCompanyApplyId !=0 ) {
			HpCompanyApplyEntity apply = new HpCompanyApplyEntity();
			apply.setHpCompanyApplyId(hpCompanyApplyId);
			apply.setOptionPerson(optionPerson);
			apply.setOptionTime(optionTime);
			apply.setContactOn(1);
			hpCompanyApplyMapper.updateByPK(apply);
		}else {
			msg.setErrorCode(1);
			msg.setMessage("参数有误：hpCompanyApplyId");
			return msg;
		}
		msg.setErrorCode(0);
		msg.setMessage("操作成功");
		return msg;
	}
	
	



}
