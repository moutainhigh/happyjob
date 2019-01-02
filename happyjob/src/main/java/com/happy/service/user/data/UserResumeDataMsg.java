package com.happy.service.user.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserResumeDataMsg对象",description="用户简历返回信息封装类")
public class UserResumeDataMsg extends BaseMsg {
    
    @ApiModelProperty(name="data",value="用户简历对象")
    private UserResumeData data;

    public UserResumeData getData() {
        return data;
    }

    public void setData(UserResumeData data) {
        this.data = data;
    }
    
}
