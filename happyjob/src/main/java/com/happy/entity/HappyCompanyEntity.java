package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 企业信息表
 */
@ApiModel(value="HappyCompany对象",description="企业信息表")
public class HappyCompanyEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//企业id
	@ApiModelProperty(name="happyCompanyId",value="企业id",dataType="java.lang.Long")
	private java.lang.Long happyCompanyId;
	//公司行业类型表id
	@ApiModelProperty(name="happCompanyTypeId",value="公司行业类型表id",dataType="java.lang.Long")
	private java.lang.Long happCompanyTypeId;
	//公司规模表id
	@ApiModelProperty(name="happyCompanyScaleId",value="公司规模表id",dataType="java.lang.Long")
	private java.lang.Long happyCompanyScaleId;
	//公司名称
	@ApiModelProperty(name="comName",value="公司名称",dataType="String")
	private String comName;
	//公司性质
	@ApiModelProperty(name="comType",value="公司性质",dataType="java.lang.Integer")
	private java.lang.Integer comType;

	public java.lang.Long getHappyCompanyId() {
		return happyCompanyId;
	}


	public void setHappyCompanyId(java.lang.Long happyCompanyId) {
		this.happyCompanyId = happyCompanyId;
	}


	public java.lang.Long getHappCompanyTypeId() {
		return happCompanyTypeId;
	}


	public void setHappCompanyTypeId(java.lang.Long happCompanyTypeId) {
		this.happCompanyTypeId = happCompanyTypeId;
	}


	public java.lang.Long getHappyCompanyScaleId() {
		return happyCompanyScaleId;
	}


	public void setHappyCompanyScaleId(java.lang.Long happyCompanyScaleId) {
		this.happyCompanyScaleId = happyCompanyScaleId;
	}


	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public java.lang.Integer getComType() {
		return comType;
	}


	public void setComType(java.lang.Integer comType) {
		this.comType = comType;
	}

}