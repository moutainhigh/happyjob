 package com.happy.service.config.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="LocationDataMsg对象",description="地址经纬编码返回信息类")
public class LocationDataMsg extends BaseMsg {

    @ApiModelProperty(name="data",value="地址编码")
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
