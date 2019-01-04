package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpEducation对象",description="")
public class HpEducationEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//学历选项表ID
	@ApiModelProperty(name="hpEducationId",value="学历选项表ID")
	private java.lang.Long hpEducationId;
	//学历名称
	@ApiModelProperty(name="eduName",value="学历名称")
	private String eduName;
	//是否启用
	@ApiModelProperty(name="useOn",value="是否启用")
	private java.lang.Integer useOn;

	public java.lang.Long getHpEducationId() {
		return hpEducationId;
	}


	public void setHpEducationId(java.lang.Long hpEducationId) {
		this.hpEducationId = hpEducationId;
	}


	public String getEduName() {
		return eduName;
	}


	public void setEduName(String eduName) {
		this.eduName = eduName;
	}


	public java.lang.Integer getUseOn() {
		return useOn;
	}


	public void setUseOn(java.lang.Integer useOn) {
		this.useOn = useOn;
	}

}