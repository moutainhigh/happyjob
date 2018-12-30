 package com.happy.service.user.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;

/**
 *
 *   TODO: 第三方登录信息返回类
 *
 */
@ApiModel(value="OtherUserData",description="登录信息封装类")
public class OtherUserData extends BaseMsg {

    private Long ygfUserId;
    
    private String openId;

    public Long getYgfUserId() {
        return ygfUserId;
    }

    public void setYgfUserId(Long ygfUserId) {
        this.ygfUserId = ygfUserId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
    
    
}
