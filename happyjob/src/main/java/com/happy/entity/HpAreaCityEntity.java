package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 地址城市表
 */
@ApiModel(value="HpAreaCity对象",description="地址城市表")
public class HpAreaCityEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//市ID
	@ApiModelProperty(name="cityId",value="市ID",dataType="java.lang.Long")
	private java.lang.Long cityId;
	//省ID
	@ApiModelProperty(name="provinceId",value="省ID",dataType="java.lang.Long")
	private java.lang.Long provinceId;
	//省唯一标识
	@ApiModelProperty(name="cityCode",value="省唯一标识",dataType="String")
	private String cityCode;
	//市名称
	@ApiModelProperty(name="cityName",value="市名称",dataType="String")
	private String cityName;

	public java.lang.Long getCityId() {
		return cityId;
	}


	public void setCityId(java.lang.Long cityId) {
		this.cityId = cityId;
	}


	public java.lang.Long getProvinceId() {
		return provinceId;
	}


	public void setProvinceId(java.lang.Long provinceId) {
		this.provinceId = provinceId;
	}


	public String getCityCode() {
		return cityCode;
	}


	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}