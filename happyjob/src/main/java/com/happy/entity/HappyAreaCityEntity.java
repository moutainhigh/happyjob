package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 地址城市表
 */
@ApiModel(value="HappyAreaCity对象",description="地址城市表")
public class HappyAreaCityEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//市ID
	@ApiModelProperty(name="hpCityId",value="市ID",dataType="java.lang.Long")
	private java.lang.Long hpCityId;
	//省ID
	@ApiModelProperty(name="hpProvinceId",value="省ID",dataType="java.lang.Long")
	private java.lang.Long hpProvinceId;
	//省唯一标识
	@ApiModelProperty(name="cityCode",value="省唯一标识",dataType="String")
	private String cityCode;
	//市名称
	@ApiModelProperty(name="cityName",value="市名称",dataType="String")
	private String cityName;

	public java.lang.Long getHpCityId() {
		return hpCityId;
	}


	public void setHpCityId(java.lang.Long hpCityId) {
		this.hpCityId = hpCityId;
	}


	public java.lang.Long getHpProvinceId() {
		return hpProvinceId;
	}


	public void setHpProvinceId(java.lang.Long hpProvinceId) {
		this.hpProvinceId = hpProvinceId;
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