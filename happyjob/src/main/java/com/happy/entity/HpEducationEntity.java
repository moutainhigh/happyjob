package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 学历选项表
 */
@ApiModel(value="HpEducation对象",description="学历选项表")
public class HpEducationEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//学历选项表ID
	@ApiModelProperty(name="hpEducationId",value="学历选项表ID",dataType="java.lang.Long")
	private java.lang.Long hpEducationId;
	//学历名称
	@ApiModelProperty(name="eduName",value="学历名称",dataType="String")
	private String eduName;
	//是否启用
	@ApiModelProperty(name="useOn",value="是否启用",dataType="java.lang.Integer")
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