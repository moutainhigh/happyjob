package com.happy.service.config.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="AreaData",description="地区信息公共封装类")
public class AreaData {

    @ApiModelProperty(name="areaId",value="地区ID")
    private Long areaId;
    
    @ApiModelProperty(name="areaName",value="地区名称")
    private String areaName;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    
}
