 package com.happy.service.user.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="OtherLoginData",description="第三方登录后返回信息封装类")
public class OtherLoginData {

    
    @ApiModelProperty(name="oid",value="第三方登录通行证")
    private String oid;
    
    @ApiModelProperty(name="sid",value="用户通行证")
    private String sid;
    
    @ApiModelProperty(name="shareToken",value="用户分享识别码")
    private String shareToken;
    
    @ApiModelProperty(name="sessionKey",value="微信小程序登录会话密钥sessionKey")
    private String sessionKey;
    
    @ApiModelProperty(name="userName",value="用户名")
    private String userName;
    
    @ApiModelProperty(name="headerPic",value="用户头像")
    private String headerPic;
    
    @ApiModelProperty(name="phoneNo",value="用户微信绑定手机号码")
    private String phoneNo;

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

    public String getShareToken() {
        return shareToken;
    }

    public void setShareToken(String shareToken) {
        this.shareToken = shareToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeaderPic() {
        return headerPic;
    }

    public void setHeaderPic(String headerPic) {
        this.headerPic = headerPic;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
}
