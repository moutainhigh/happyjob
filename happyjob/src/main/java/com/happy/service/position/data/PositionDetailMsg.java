 package com.happy.service.position.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PositionDetailMsg",description="招聘岗位详情返回信息封装类")
public class PositionDetailMsg extends BaseMsg {
    
    @ApiModelProperty(name="data",value="招聘岗位信息封装类")
    private PositionDetail data;

    public PositionDetail getData() {
        return data;
    }

    public void setData(PositionDetail data) {
        this.data = data;
    }
    
}
