 package com.happy.service.user.data;

import com.happy.plugin.BaseMsg;

/**
 *
 *   TODO: 第三方登录信息返回类，程序内使用
 *
 */
public class OtherUserData extends BaseMsg{

    private Long hpUserId;
    
    private Long hpUserBoundId;
    
    private String openid;
    
    private String userToken;
    
    private String shareToken;

    
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
}
