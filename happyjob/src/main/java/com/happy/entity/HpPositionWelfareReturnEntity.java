package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司福利入职返现时间表
 */
@ApiModel(value="HpPositionWelfareReturn对象",description="公司福利入职返现时间表")
public class HpPositionWelfareReturnEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司福利入职返现时间表
	@ApiModelProperty(name="hpPositionWelfareReturnId",value="公司福利入职返现时间表",dataType="java.lang.Long")
	private java.lang.Long hpPositionWelfareReturnId;
	//所少天后返现
	@ApiModelProperty(name="dayNum",value="所少天后返现",dataType="java.lang.Integer")
	private java.lang.Integer dayNum;

	public java.lang.Long getHpPositionWelfareReturnId() {
		return hpPositionWelfareReturnId;
	}


	public void setHpPositionWelfareReturnId(java.lang.Long hpPositionWelfareReturnId) {
		this.hpPositionWelfareReturnId = hpPositionWelfareReturnId;
	}


	public java.lang.Integer getDayNum() {
		return dayNum;
	}


	public void setDayNum(java.lang.Integer dayNum) {
		this.dayNum = dayNum;
	}

}