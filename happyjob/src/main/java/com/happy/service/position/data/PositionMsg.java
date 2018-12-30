 package com.happy.service.position.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PositionMsg",description="招聘岗位详情返回信息封装类")
public class PositionMsg extends BaseMsg {
    
    @ApiModelProperty(name="data",value="招聘岗位信息封装类")
    private PositionData data;

    public PositionData getData() {
        return data;
    }

    public void setData(PositionData data) {
        this.data = data;
    }
    
}
