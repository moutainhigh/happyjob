package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 求职者工作经验表
 */
@ApiModel(value="HpUserExp对象",description="求职者工作经验表")
public class HpUserExpEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//求职者工作经验表
	@ApiModelProperty(name="hpUserExpId",value="求职者工作经验表")
	private java.lang.Long hpUserExpId;
	//用户简历表id
	@ApiModelProperty(name="hpUserResumeId",value="用户简历表id")
	private java.lang.Long hpUserResumeId;
	//公司名称
	@ApiModelProperty(name="comName",value="公司名称")
	private String comName;
	//工作职位
	@ApiModelProperty(name="posType",value="工作职位")
	private String posType;
	//入职时间
	@ApiModelProperty(name="startTime",value="入职时间")
	private java.lang.Long startTime;
	//离职时间
	@ApiModelProperty(name="endTime",value="离职时间")
	private java.lang.Long endTime;

	public java.lang.Long getHpUserExpId() {
		return hpUserExpId;
	}


	public void setHpUserExpId(java.lang.Long hpUserExpId) {
		this.hpUserExpId = hpUserExpId;
	}


	public java.lang.Long getHpUserResumeId() {
		return hpUserResumeId;
	}


	public void setHpUserResumeId(java.lang.Long hpUserResumeId) {
		this.hpUserResumeId = hpUserResumeId;
	}


	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public String getPosType() {
		return posType;
	}


	public void setPosType(String posType) {
		this.posType = posType;
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