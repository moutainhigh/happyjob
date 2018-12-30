package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司职位招聘拼团参与表
 */
@ApiModel(value="HpPositionGroupUser对象",description="公司职位招聘拼团参与表")
public class HpPositionGroupUserEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司职位招聘拼团参与表ID
	@ApiModelProperty(name="hpPositionGroupUserId",value="公司职位招聘拼团参与表ID",dataType="java.lang.Long")
	private java.lang.Long hpPositionGroupUserId;
	//公司职位招聘拼团表ID
	@ApiModelProperty(name="hpPositionGroupId",value="公司职位招聘拼团表ID",dataType="java.lang.Long")
	private java.lang.Long hpPositionGroupId;
	//是否是发起人
	@ApiModelProperty(name="leaderOn",value="是否是发起人",dataType="java.lang.Integer")
	private java.lang.Integer leaderOn;
	//参与时间
	@ApiModelProperty(name="partTime",value="参与时间",dataType="java.lang.Long")
	private java.lang.Long partTime;

	public java.lang.Long getHpPositionGroupUserId() {
		return hpPositionGroupUserId;
	}


	public void setHpPositionGroupUserId(java.lang.Long hpPositionGroupUserId) {
		this.hpPositionGroupUserId = hpPositionGroupUserId;
	}


	public java.lang.Long getHpPositionGroupId() {
		return hpPositionGroupId;
	}


	public void setHpPositionGroupId(java.lang.Long hpPositionGroupId) {
		this.hpPositionGroupId = hpPositionGroupId;
	}


	public java.lang.Integer getLeaderOn() {
		return leaderOn;
	}


	public void setLeaderOn(java.lang.Integer leaderOn) {
		this.leaderOn = leaderOn;
	}


	public java.lang.Long getPartTime() {
		return partTime;
	}


	public void setPartTime(java.lang.Long partTime) {
		this.partTime = partTime;
	}

}