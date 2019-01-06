 package com.happy.service.user.data;

import com.happy.plugin.BaseMsg;

/**
 *
 *   @TODO: 第三方登录信息返回类，程序内使用
 *
 */
public class OtherUserData extends BaseMsg{

    private Long hpUserId;
    
    private Long hpUserBoundId;
    
    private String openid;
    
    private String userToken;
    
    private String shareToken;
    
    private String userName;

    private String headerPic;
    
    private String password;

    
    public Long getHpUserId() {
        return hpUserId;
    }

    public void setHpUserId(Long hpUserId) {
        this.hpUserId = hpUserId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getHpUserBoundId() {
        return hpUserBoundId;
    }

    public void setHpUserBoundId(Long hpUserBoundId) {
        this.hpUserBoundId = hpUserBoundId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
