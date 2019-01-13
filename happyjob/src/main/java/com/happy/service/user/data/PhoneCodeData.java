 package com.happy.service.user.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PhoneCodeData",description="手机验证码信息类")
public class PhoneCodeData {
    
    @ApiModelProperty(name="msgCode",value="手机验证码")
    private String msgCode;
    @ApiModelProperty(name="sessionId",value="sessionId")
    private String sessionId;

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
