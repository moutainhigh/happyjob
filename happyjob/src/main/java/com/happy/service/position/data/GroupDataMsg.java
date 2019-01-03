 package com.happy.service.position.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GroupDataMsg",description="招聘岗位拼团详情返回信息封装类")
public class GroupDataMsg extends BaseMsg {
    
    @ApiModelProperty(name="data",value="招聘岗位信息封装类")
    private GroupData data;

    public GroupData getData() {
        return data;
    }

    public void setData(GroupData data) {
        this.data = data;
    }
    
}
