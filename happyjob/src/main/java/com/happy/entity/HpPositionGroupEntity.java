package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司职位招聘拼团表
 */
@ApiModel(value="HpPositionGroup对象",description="公司职位招聘拼团表")
public class HpPositionGroupEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司职位招聘拼团表ID
	@ApiModelProperty(name="hpPositionGroupId",value="公司职位招聘拼团表ID",dataType="java.lang.Long")
	private java.lang.Long hpPositionGroupId;
	//公司招聘岗位表id
	@ApiModelProperty(name="hpPositionId",value="公司招聘岗位表id",dataType="java.lang.Long")
	private java.lang.Long hpPositionId;
	//拼团开始时间
	@ApiModelProperty(name="startTime",value="拼团开始时间",dataType="java.lang.Long")
	private java.lang.Long startTime;
	//拼团结束时间
	@ApiModelProperty(name="endTime",value="拼团结束时间",dataType="java.lang.Long")
	private java.lang.Long endTime;
	//拼团状态（0、未成团，1、已成团）
	@ApiModelProperty(name="groupState",value="拼团状态（0、未成团，1、已成团）",dataType="java.lang.Integer")
	private java.lang.Integer groupState;

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


	public java.lang.Long getStartTime() {
		return startTime;
	}


	public void setStartTime(java.lang.Long startTime) {
		this.startTime = startTime;
	}


	public java.lang.Long getEndTime() {
		return endTime;
	}


	public void setEndTime(java.lang.Long endTime) {
		this.endTime = endTime;
	}


	public java.lang.Integer getGroupState() {
		return groupState;
	}


	public void setGroupState(java.lang.Integer groupState) {
		this.groupState = groupState;
	}

}