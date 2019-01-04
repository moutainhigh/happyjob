package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpAreaCounty对象",description="")
public class HpAreaCountyEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//区ID
	@ApiModelProperty(name="countyId",value="区ID")
	private java.lang.Long countyId;
	//市ID
	@ApiModelProperty(name="cityId",value="市ID")
	private java.lang.Long cityId;
	//区唯一标识
	@ApiModelProperty(name="countryCode",value="区唯一标识")
	private String countryCode;
	//区名称
	@ApiModelProperty(name="countyName",value="区名称")
	private String countyName;

	public java.lang.Long getCountyId() {
		return countyId;
	}


	public void setCountyId(java.lang.Long countyId) {
		this.countyId = countyId;
	}


	public java.lang.Long getCityId() {
		return cityId;
	}


	public void setCityId(java.lang.Long cityId) {
		this.cityId = cityId;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public String getCountyName() {
		return countyName;
	}


	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

}