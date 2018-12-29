package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 地址省份表
 */
@ApiModel(value="HappyAreaProvince对象",description="地址省份表")
public class HappyAreaProvinceEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//省ID
	@ApiModelProperty(name="hpProvinceId",value="省ID",dataType="java.lang.Long")
	private java.lang.Long hpProvinceId;
	//省唯一标识
	@ApiModelProperty(name="provinceCode",value="省唯一标识",dataType="String")
	private String provinceCode;
	//省名称
	@ApiModelProperty(name="provinceName",value="省名称",dataType="String")
	private String provinceName;

	public java.lang.Long getHpProvinceId() {
		return hpProvinceId;
	}


	public void setHpProvinceId(java.lang.Long hpProvinceId) {
		this.hpProvinceId = hpProvinceId;
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