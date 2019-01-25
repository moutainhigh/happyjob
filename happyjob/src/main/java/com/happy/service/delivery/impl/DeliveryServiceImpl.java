package com.happy.service.delivery.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpPositionRefUserEntity;
import com.happy.entity.HpUserEntity;
import com.happy.entity.HpUserExpEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.delivery.DeliveryService;
import com.happy.service.delivery.data.DeliveryData;
import com.happy.service.delivery.data.DeliveryDetail;
import com.happy.service.delivery.data.DeliveryListMsg;
import com.happy.service.delivery.data.DeliverySearch;
import com.happy.service.delivery.data.HpUserEducationExt;
import com.happy.service.delivery.data.IntentionExt;
import com.happy.service.salary.data.LoginUserMsg;
import com.happy.service.salary.impl.SalaryServiceImpl;
import com.happy.sqlExMapper.HpDeliveryMapper;
import com.happy.sqlMapper.HpPositionRefUserMapper;
import com.happy.sqlMapper.HpUserMapper;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	private static final Logger logger = LoggerFactory.getLogger(SalaryServiceImpl.class);
	   
	@Autowired
	private HpDeliveryMapper hpDeliveryMapper ;
	
	@Autowired
	private HpPositionRefUserMapper hpPositionRefUserMapper;
	
	@Autowired
	private HpUserMapper hpUserMapper ;
	
	@Override
	public DeliveryListMsg getDeliverylistPage(String comName, String posName, Long startTime,
			Long endTime, String realName, Integer gender, String contactStat,Integer currentPage, Integer showCount) {
		
		DeliveryListMsg msg = new DeliveryListMsg();
		DeliverySearch page = new DeliverySearch();
        
		currentPage = currentPage==null || currentPage<1?1:currentPage;
        showCount = showCount==null||showCount<1?10:showCount;
        
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
        
        page.setComName(comName);
        page.setPosName(posName);
        page.setStartTime(startTime);
        page.setEndTime(endTime);
        page.setRealName(realName);
        page.setGender(gender);

        page.setContactStat(contactStat);
        
        List<DeliveryData> list = this.hpDeliveryMapper.getDeliverylistPage(page);
        msg.setList(list);
        msg.setPage(page);
        return msg;
	}

	@Override
	public DeliveryDetail deliveryQueryByUserId(Long hpUserId) {
		DeliveryDetail deliveryDetail = new DeliveryDetail();
		if(hpUserId == null ) {
			deliveryDetail.setErrorCode(1);
			deliveryDetail.setMessage("传递参数有误");
			return deliveryDetail;
		}
		List<HpUserExpEntity> experienceList = this.hpDeliveryMapper.getExperienceByUserId(hpUserId);
	    List<HpUserEducationExt> educationList =  this.hpDeliveryMapper.getEducationByUserId(hpUserId);
	    List<IntentionExt> intentionList = this.hpDeliveryMapper.getIntentionByUserId(hpUserId);
	    
	    deliveryDetail.setExperienceList(experienceList);
	    deliveryDetail.setEducationList(educationList);
	    deliveryDetail.setIntentionList(intentionList);
	    
		return deliveryDetail;
	}

	@Override
	public BaseMsg addComtact(Long hpPositionRefUserId,String comtPerson,Long comTime ,Integer workOn,Long hpCompanyId,Long hpUserId) {
		BaseMsg msg = new BaseMsg();
		//更新
		if(hpPositionRefUserId != null &&  hpPositionRefUserId !=0 ) {
			HpPositionRefUserEntity positionRefUserEntity = new HpPositionRefUserEntity();
			positionRefUserEntity.setHpPositionRefUserId(hpPositionRefUserId);
			positionRefUserEntity.setOptionPerson(comtPerson);
			positionRefUserEntity.setOptionTime(comTime);
			if(workOn != null && workOn.equals(1)) {
				positionRefUserEntity.setWorkOn(workOn); //入职
			}
			hpPositionRefUserMapper.updateByPK(positionRefUserEntity);
			
			if(hpUserId != null && hpCompanyId != null &&  !hpUserId.equals(0) && !hpPositionRefUserId.equals(0)) {
				HpUserEntity hpUser = new HpUserEntity();
				hpUser.setHpUserId(hpUserId);
				hpUser.setHpCompanyId(hpCompanyId);
				hpUserMapper.updateByPK(hpUser);
			}
		}else {
			msg.setErrorCode(1);
			msg.setMessage("参数有误：hpPositionRefUserId");
			return msg;
		}
		msg.setErrorCode(0);
		msg.setMessage("操作成功");
		return msg;
	}
	
	@Override
	public LoginUserMsg getLoginUserInfo(String userToken) {
		LoginUserMsg msg = new LoginUserMsg();
		LoginUserMsg loginUserMsg = hpDeliveryMapper.getLoginUser(userToken);
		//更新
		if(loginUserMsg == null) {
			msg.setErrorCode(1);
			msg.setMessage("获取不到该登陆人信息");
		}
		loginUserMsg.setComTime(Util.dateFormat(new Date(),Const.DATE_FORMAT_STR_2));
		msg.setErrorCode(0);
		msg.setMessage("操作成功");
		return loginUserMsg;
	}
}
