package com.happy.service.apply;

import com.happy.plugin.BaseMsg;
import com.happy.service.apply.data.ApplyListMsg;

public interface ApplyService {

	ApplyListMsg getApplylistPage(Integer currentPage,Integer showCount,String name ,String comName,String contactNum );
	
	 BaseMsg companyApplyDel(Long hpCompanyApplyId);
	 
	 BaseMsg addComtact(Long hpCompanyApplyId,String optionPerson,Long optionTime);
}
