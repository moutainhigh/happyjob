package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司行业类型表
 */
@ApiModel(value="HappyCompanyType对象",description="公司行业类型表")
public class HappyCompanyTypeEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司行业类型表id
	@ApiModelProperty(name="happCompanyTypeId",value="公司行业类型表id",dataType="java.lang.Long")
	private java.lang.Long happCompanyTypeId;
	//公司名称
	@ApiModelProperty(name="typeName",value="公司名称",dataType="String")
	private String typeName;
	//是否启用
	@ApiModelProperty(name="useOn",value="是否启用",dataType="java.lang.Integer")
	private java.lang.Integer useOn;

	public java.lang.Long getHappCompanyTypeId() {
		return happCompanyTypeId;
	}


	public void setHappCompanyTypeId(java.lang.Long happCompanyTypeId) {
		this.happCompanyTypeId = happCompanyTypeId;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public java.lang.Integer getUseOn() {
		return useOn;
	}


	public void setUseOn(java.lang.Integer useOn) {
		this.useOn = useOn;
	}

}