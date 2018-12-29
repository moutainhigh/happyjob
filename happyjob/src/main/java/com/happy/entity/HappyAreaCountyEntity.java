package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 地址地区表
 */
@ApiModel(value="HappyAreaCounty对象",description="地址地区表")
public class HappyAreaCountyEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//区ID
	@ApiModelProperty(name="hpCountyId",value="区ID",dataType="java.lang.Long")
	private java.lang.Long hpCountyId;
	//市ID
	@ApiModelProperty(name="hpCityId",value="市ID",dataType="java.lang.Long")
	private java.lang.Long hpCityId;
	//区唯一标识
	@ApiModelProperty(name="countryCode",value="区唯一标识",dataType="String")
	private String countryCode;
	//区名称
	@ApiModelProperty(name="countyName",value="区名称",dataType="String")
	private String countyName;

	public java.lang.Long getHpCountyId() {
		return hpCountyId;
	}


	public void setHpCountyId(java.lang.Long hpCountyId) {
		this.hpCountyId = hpCountyId;
	}


	public java.lang.Long getHpCityId() {
		return hpCityId;
	}


	public void setHpCityId(java.lang.Long hpCityId) {
		this.hpCityId = hpCityId;
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