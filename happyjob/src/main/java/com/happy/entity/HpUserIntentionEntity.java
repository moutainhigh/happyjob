package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 求职者求职意向表
 */
@ApiModel(value="HpUserIntention对象",description="求职者求职意向表")
public class HpUserIntentionEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//求职者求职意向表id
	@ApiModelProperty(name="hpUserIntentionId",value="求职者求职意向表id",dataType="java.lang.Long")
	private java.lang.Long hpUserIntentionId;
	//公司招聘岗位月薪表ID（0、表示面议）
	@ApiModelProperty(name="hpPositionSalaryId",value="公司招聘岗位月薪表ID（0、表示面议）",dataType="java.lang.Long")
	private java.lang.Long hpPositionSalaryId;
	//区ID
	@ApiModelProperty(name="countyId",value="区ID",dataType="java.lang.Long")
	private java.lang.Long countyId;
	//活动背景图id
	@ApiModelProperty(name="hpUserId",value="活动背景图id",dataType="java.lang.Long")
	private java.lang.Long hpUserId;
	//期望行业
	@ApiModelProperty(name="posType",value="期望行业",dataType="String")
	private String posType;

	public java.lang.Long getHpUserIntentionId() {
		return hpUserIntentionId;
	}


	public void setHpUserIntentionId(java.lang.Long hpUserIntentionId) {
		this.hpUserIntentionId = hpUserIntentionId;
	}


	public java.lang.Long getHpPositionSalaryId() {
		return hpPositionSalaryId;
	}


	public void setHpPositionSalaryId(java.lang.Long hpPositionSalaryId) {
		this.hpPositionSalaryId = hpPositionSalaryId;
	}


	public java.lang.Long getCountyId() {
		return countyId;
	}


	public void setCountyId(java.lang.Long countyId) {
		this.countyId = countyId;
	}


	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	public String getPosType() {
		return posType;
	}


	public void setPosType(String posType) {
		this.posType = posType;
	}

}