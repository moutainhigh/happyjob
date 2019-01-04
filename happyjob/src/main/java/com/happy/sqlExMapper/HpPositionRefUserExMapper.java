package com.happy.sqlExMapper;

import java.util.List;

import com.happy.service.delivery.data.DeliveryData;
import com.happy.service.delivery.data.DeliverySearch;

public interface HpPositionRefUserExMapper {

	/**
	 * 投递查询
	 * @param page
	 * @return
	 */
	List<DeliveryData> getDeliverylistPage(DeliverySearch page);
}
