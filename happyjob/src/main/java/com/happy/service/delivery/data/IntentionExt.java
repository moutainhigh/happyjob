package com.happy.service.delivery.data;

import com.happy.entity.HpUserIntentionEntity;

import io.swagger.annotations.ApiModelProperty;

public class IntentionExt extends HpUserIntentionEntity{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name="lowerNum",value="最低工资")
	private Integer lowerNum; 
	
	@ApiModelProperty(name="hightNum",value="最高工资")
	private Integer hightNum;

	public Integer getLowerNum() {
		return lowerNum;
	}

	public void setLowerNum(Integer lowerNum) {
		this.lowerNum = lowerNum;
	}

	public Integer getHightNum() {
		return hightNum;
	}

	public void setHightNum(Integer hightNum) {
		this.hightNum = hightNum;
	}

	@Override
	public String toString() {
		return "IntentionExt [lowerNum=" + lowerNum + ", hightNum=" + hightNum + "]";
	} 
	
	
}
