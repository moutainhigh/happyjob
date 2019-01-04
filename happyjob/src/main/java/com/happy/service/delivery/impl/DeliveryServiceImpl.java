package com.happy.service.delivery.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.service.delivery.DeliveryService;
import com.happy.service.delivery.data.DeliveryData;
import com.happy.service.delivery.data.DeliveryListMsg;
import com.happy.service.delivery.data.DeliverySearch;
import com.happy.service.salary.impl.SalaryServiceImpl;
import com.happy.sqlExMapper.HpPositionRefUserExMapper;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	private static final Logger logger = LoggerFactory.getLogger(SalaryServiceImpl.class);
	   
	@Autowired
	private HpPositionRefUserExMapper hpPositionRefUserExMapper ;
	
	@Override
	public DeliveryListMsg getDeliverylistPage(String userName, String comName, String posName, Long startTime,
			Long endTime, String realName, Integer gender, String contactStat,Integer currentPage, Integer showCount) {
		
		DeliveryListMsg msg = new DeliveryListMsg();
		DeliverySearch page = new DeliverySearch();
        
		currentPage = currentPage==null || currentPage<1?1:currentPage;
        showCount = showCount==null||showCount<1?10:showCount;
        
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
        
        page.setUserName(userName);
        page.setComName(comName);
        page.setPosName(posName);
        page.setStartTime(startTime);
        page.setEndTime(endTime);
        page.setRealName(realName);
        page.setGender(gender);

        page.setContactStat(contactStat);
        
        List<DeliveryData> list = this.hpPositionRefUserExMapper.getDeliverylistPage(page);
        msg.setList(list);
        msg.setPage(page);
        return msg;
	}

}
