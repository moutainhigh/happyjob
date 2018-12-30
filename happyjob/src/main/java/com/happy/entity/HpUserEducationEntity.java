package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 求职者教育背景表
 */
@ApiModel(value="HpUserEducation对象",description="求职者教育背景表")
public class HpUserEducationEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//求职者教育背景表ID
	@ApiModelProperty(name="hpUserEducationId",value="求职者教育背景表ID",dataType="java.lang.Long")
	private java.lang.Long hpUserEducationId;
	//活动背景图id
	@ApiModelProperty(name="hpUserId",value="活动背景图id",dataType="java.lang.Long")
	private java.lang.Long hpUserId;
	//学历选项表ID
	@ApiModelProperty(name="hpEducationId",value="学历选项表ID",dataType="java.lang.Long")
	private java.lang.Long hpEducationId;
	//学校名称
	@ApiModelProperty(name="schName",value="学校名称",dataType="String")
	private String schName;
	//入学时间
	@ApiModelProperty(name="startTime",value="入学时间",dataType="java.lang.Long")
	private java.lang.Long startTime;
	//毕业时间
	@ApiModelProperty(name="endTime",value="毕业时间",dataType="java.lang.Long")
	private java.lang.Long endTime;

	public java.lang.Long getHpUserEducationId() {
		return hpUserEducationId;
	}


	public void setHpUserEducationId(java.lang.Long hpUserEducationId) {
		this.hpUserEducationId = hpUserEducationId;
	}


	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	public java.lang.Long getHpEducationId() {
		return hpEducationId;
	}


	public void setHpEducationId(java.lang.Long hpEducationId) {
		this.hpEducationId = hpEducationId;
	}


	public String getSchName() {
		return schName;
	}


	public void setSchName(String schName) {
		this.schName = schName;
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

}