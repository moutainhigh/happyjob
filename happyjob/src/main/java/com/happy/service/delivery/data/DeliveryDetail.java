package com.happy.service.delivery.data;

import java.util.List;

import com.happy.entity.HpUserExpEntity;
import com.happy.entity.HpUserIntentionEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModelProperty;

public class DeliveryDetail extends BaseMsg{

	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name="experienceList",value="工作经历")
    private List<HpUserExpEntity> experienceList;
	
	@ApiModelProperty(name="educationList",value="教育经历")
    private List<HpUserEducationExt> educationList;
	
	@ApiModelProperty(name="intentionList",value="求职意向")
    private List<IntentionExt> intentionList;

	public List<HpUserExpEntity> getExperienceList() {
		return experienceList;
	}

	public void setExperienceList(List<HpUserExpEntity> experienceList) {
		this.experienceList = experienceList;
	}

	public List<HpUserEducationExt> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<HpUserEducationExt> educationList) {
		this.educationList = educationList;
	}

	public List<IntentionExt> getIntentionList() {
		return intentionList;
	}

	public void setIntentionList(List<IntentionExt> intentionList) {
		this.intentionList = intentionList;
	}


	
	
	
}
