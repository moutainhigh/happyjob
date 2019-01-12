package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpPositionRefUser对象",description="")
public class HpPositionRefUserEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司职位招聘拼团参与表ID
	@ApiModelProperty(name="hpPositionRefUserId",value="公司职位招聘拼团参与表ID")
	private java.lang.Long hpPositionRefUserId;
	//公司职位招聘拼团表ID
	@ApiModelProperty(name="hpPositionGroupId",value="公司职位招聘拼团表ID")
	private java.lang.Long hpPositionGroupId;
	//公司招聘岗位表id
	@ApiModelProperty(name="hpPositionId",value="公司招聘岗位表id")
	private java.lang.Long hpPositionId;
	//申请人id
	@ApiModelProperty(name="hpUserId",value="申请人id")
	private java.lang.Long hpUserId;
	//是否是发起人
	@ApiModelProperty(name="leaderOn",value="是否是发起人")
	private java.lang.Integer leaderOn;
	//申请时间
	@ApiModelProperty(name="partTime",value="申请时间")
	private java.lang.Long partTime;
	//申请类型（1、普通申请，2、拼团申请）
	@ApiModelProperty(name="partType",value="申请类型（1、普通申请，2、拼团申请）")
	private java.lang.Integer partType;
	//是否入职
	@ApiModelProperty(name="workOn",value="是否入职")
	private java.lang.Integer workOn;
	//入职时间
	@ApiModelProperty(name="workTime",value="入职时间")
	private java.lang.Long workTime;
	//操作联系人名称
	@ApiModelProperty(name="optionPerson",value="操作联系人名称")
	private String optionPerson;
	//操作联系时间
	@ApiModelProperty(name="optionTime",value="操作联系时间")
	private java.lang.Long optionTime;

	public java.lang.Long getHpPositionRefUserId() {
		return hpPositionRefUserId;
	}


	public void setHpPositionRefUserId(java.lang.Long hpPositionRefUserId) {
		this.hpPositionRefUserId = hpPositionRefUserId;
	}


	public java.lang.Long getHpPositionGroupId() {
		return hpPositionGroupId;
	}


	public void setHpPositionGroupId(java.lang.Long hpPositionGroupId) {
		this.hpPositionGroupId = hpPositionGroupId;
	}


	public java.lang.Long getHpPositionId() {
		return hpPositionId;
	}


	public void setHpPositionId(java.lang.Long hpPositionId) {
		this.hpPositionId = hpPositionId;
	}


	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
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


	public java.lang.Integer getPartType() {
		return partType;
	}


	public void setPartType(java.lang.Integer partType) {
		this.partType = partType;
	}


	public java.lang.Integer getWorkOn() {
		return workOn;
	}


	public void setWorkOn(java.lang.Integer workOn) {
		this.workOn = workOn;
	}


	public java.lang.Long getWorkTime() {
		return workTime;
	}


	public void setWorkTime(java.lang.Long workTime) {
		this.workTime = workTime;
	}


	public String getOptionPerson() {
		return optionPerson;
	}


	public void setOptionPerson(String optionPerson) {
		this.optionPerson = optionPerson;
	}


	public java.lang.Long getOptionTime() {
		return optionTime;
	}


	public void setOptionTime(java.lang.Long optionTime) {
		this.optionTime = optionTime;
	}

}