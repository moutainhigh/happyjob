 package com.happy.service.user.data;

import io.swagger.annotations.ApiModelProperty;

public class OtherLoginData {

    
    @ApiModelProperty(name="oid",value="第三方登录通行证")
    private String oid;
    
    @ApiModelProperty(name="sid",value="商城用户通行证")
    private String sid;
    
    @ApiModelProperty(name="sessionKey",value="微信小程序登录会话密钥sessionKey")
    private String sessionKey;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
    
}
