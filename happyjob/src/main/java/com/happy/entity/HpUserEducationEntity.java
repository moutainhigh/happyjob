package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpUserEducation对象",description="")
public class HpUserEducationEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//用户简历表id
	@ApiModelProperty(name="hpUserEducationId",value="用户简历表id")
	private java.lang.Long hpUserEducationId;
	//求职者简历表id
	@ApiModelProperty(name="hpUserResumeId",value="求职者简历表id")
	private java.lang.Long hpUserResumeId;
	//学历选项表ID
	@ApiModelProperty(name="hpEducationId",value="学历选项表ID")
	private java.lang.Long hpEducationId;
	//学校名称
	@ApiModelProperty(name="schName",value="学校名称")
	private String schName;
	//入学时间
	@ApiModelProperty(name="startTime",value="入学时间")
	private java.lang.Long startTime;
	//毕业时间
	@ApiModelProperty(name="endTime",value="毕业时间")
	private java.lang.Long endTime;

	public java.lang.Long getHpUserEducationId() {
		return hpUserEducationId;
	}


	public void setHpUserEducationId(java.lang.Long hpUserEducationId) {
		this.hpUserEducationId = hpUserEducationId;
	}


	public java.lang.Long getHpUserResumeId() {
		return hpUserResumeId;
	}


	public void setHpUserResumeId(java.lang.Long hpUserResumeId) {
		this.hpUserResumeId = hpUserResumeId;
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