 package com.happy.service.user.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserDataMsg对象",description="员工信息表")
public class UserSimpleDataMsg extends BaseMsg {
    
    @ApiModelProperty(name="data",value="员工信息封装类")
    private UserSimpleData data;

    public UserSimpleData getData() {
        return data;
    }

    public void setData(UserSimpleData data) {
        this.data = data;
    }
    
}
