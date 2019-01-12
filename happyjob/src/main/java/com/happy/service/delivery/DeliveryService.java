package com.happy.service.delivery;

import com.happy.plugin.BaseMsg;
import com.happy.service.delivery.data.DeliveryDetail;
import com.happy.service.delivery.data.DeliveryListMsg;
import com.happy.service.salary.data.LoginUserMsg;


public interface DeliveryService {

	/**
     * 
     * @TODO:   分页获取投递列表
     */
	DeliveryListMsg getDeliverylistPage(String userName,String comName, String posName,
			Long startTime, Long endTime,String realName, Integer gender,String contactStat,Integer currentPage,Integer showCount);
    
	
	DeliveryDetail deliveryQueryByUserId(Long hpUserId);
	
	BaseMsg addComtact(Long hpPositionRefUserId,String comtPerson,Long comTime);
	
	LoginUserMsg getLoginUserInfo(String userToken);
	
}
