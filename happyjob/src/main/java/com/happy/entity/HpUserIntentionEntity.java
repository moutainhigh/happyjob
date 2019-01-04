package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpUserIntention对象",description="")
public class HpUserIntentionEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//求职者求职意向表id
	@ApiModelProperty(name="hpUserIntentionId",value="求职者求职意向表id")
	private java.lang.Long hpUserIntentionId;
	//公司招聘岗位月薪表ID（0、表示面议）
	@ApiModelProperty(name="hpPositionSalaryId",value="公司招聘岗位月薪表ID（0、表示面议）")
	private java.lang.Long hpPositionSalaryId;
	//期望地点
	@ApiModelProperty(name="workArea",value="期望地点")
	private String workArea;
	//求职者简历表ID
	@ApiModelProperty(name="hpUserResumeId",value="求职者简历表ID")
	private java.lang.Long hpUserResumeId;
	//期望行业
	@ApiModelProperty(name="posType",value="期望行业")
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


	public String getWorkArea() {
		return workArea;
	}


	public void setWorkArea(String workArea) {
		this.workArea = workArea;
	}


	public java.lang.Long getHpUserResumeId() {
		return hpUserResumeId;
	}


	public void setHpUserResumeId(java.lang.Long hpUserResumeId) {
		this.hpUserResumeId = hpUserResumeId;
	}


	public String getPosType() {
		return posType;
	}


	public void setPosType(String posType) {
		this.posType = posType;
	}

}