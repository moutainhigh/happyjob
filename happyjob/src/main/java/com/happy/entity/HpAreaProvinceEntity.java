package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpAreaProvince对象",description="")
public class HpAreaProvinceEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//省ID
	@ApiModelProperty(name="provinceId",value="省ID")
	private java.lang.Long provinceId;
	//省唯一标识
	@ApiModelProperty(name="provinceCode",value="省唯一标识")
	private String provinceCode;
	//省名称
	@ApiModelProperty(name="provinceName",value="省名称")
	private String provinceName;

	public java.lang.Long getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(java.lang.Long provinceId) {
		this.provinceId = provinceId;
	}


	public String getProvinceCode() {
		return provinceCode;
	}


	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}


	public String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}