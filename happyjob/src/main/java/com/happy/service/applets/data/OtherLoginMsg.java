 package com.happy.service.applets.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="OtherLoginMsg",description="第三方登录成功后信息返回类")
public class OtherLoginMsg extends BaseMsg {
    
    @ApiModelProperty(name="data",value="登录信息封装类")
    private OtherLoginData data;

    public OtherLoginData getData() {
        return data;
    }

    public void setData(OtherLoginData data) {
        this.data = data;
    }
    
}
