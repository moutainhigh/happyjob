package com.happy.sqlExMapper;

import java.util.List;

import com.happy.entity.HpUserExpEntity;
import com.happy.entity.HpUserIntentionEntity;
import com.happy.service.delivery.data.DeliveryData;
import com.happy.service.delivery.data.DeliveryDetail;
import com.happy.service.delivery.data.DeliverySearch;
import com.happy.service.delivery.data.HpUserEducationExt;
import com.happy.service.salary.data.LoginUserMsg;

public interface HpDeliveryMapper {

	/**
	 * 投递查询
	 * @param page
	 * @return
	 */
	List<DeliveryData> getDeliverylistPage(DeliverySearch page);
	
	List<HpUserExpEntity> getExperienceByUserId(Long hpUserId );
	
	List<HpUserEducationExt> getEducationByUserId(Long hpUserId);
	
	List<HpUserIntentionEntity> getIntentionByUserId( Long hpUserId);
	
	DeliveryDetail deliveryQueryUser(Long hpUserId);
	
	LoginUserMsg getLoginUser(String userToken);
}
