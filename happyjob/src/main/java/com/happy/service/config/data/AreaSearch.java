 package com.happy.service.config.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="AreaSearch",description="地区信息查询封装类")
public class AreaSearch extends Page {
    
    @ApiModelProperty(name="provinceId",value="省ID")
    private Long provinceId;
    @ApiModelProperty(name="cityId",value="市ID")
    private Long cityId;
    @ApiModelProperty(name="countyId",value="区ID")
    private Long countyId;
    public Long getProvinceId() {
        return provinceId;
    }
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    public Long getCountyId() {
        return countyId;
    }
    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }
    
    
}
