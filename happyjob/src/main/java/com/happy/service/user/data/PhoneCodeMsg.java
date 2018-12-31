 package com.happy.service.user.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PhoneCodeMsg",description="手机验证码发送接口返回信息类")
public class PhoneCodeMsg extends BaseMsg {
    
    @ApiModelProperty(name="data",value="手机验证码封装类")
    private PhoneCodeData data;

    public PhoneCodeData getData() {
        return data;
    }

    public void setData(PhoneCodeData data) {
        this.data = data;
    }
    
}
