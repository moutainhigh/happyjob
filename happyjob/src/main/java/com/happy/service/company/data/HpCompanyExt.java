package com.happy.service.company.data;

import com.happy.entity.HpCompanyEntity;

import io.swagger.annotations.ApiModelProperty;

public class HpCompanyExt extends HpCompanyEntity{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name="typeName",value="所属行业")
    private String typeName;
    @ApiModelProperty(name="lowerNum",value="下限")
    private Integer lowerNum;
    @ApiModelProperty(name="hightNum",value="上限")
    private Integer hightNum;
    
    @ApiModelProperty(name="countryName",value="区名")
    private String countyName;
    @ApiModelProperty(name="cityName",value="市名")
    private String cityName;
    @ApiModelProperty(name="provinceName",value="省名")
    private String provinceName;
    
    @ApiModelProperty(name="cityId",value="市")
    private Long cityId;
    @ApiModelProperty(name="provinceId",value="省")
    private Long provinceId;
    
    
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	public String getCountyName() {
		return countyName;
	}
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getLowerNum() {
		return lowerNum;
	}
	public void setLowerNum(Integer lowerNum) {
		this.lowerNum = lowerNum;
	}
	public Integer getHightNum() {
		return hightNum;
	}
	public void setHightNum(Integer hightNum) {
		this.hightNum = hightNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}
