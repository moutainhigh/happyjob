/** 
 *  @Copyright:  http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 *  @CreateTime: 2019年1月3日下午2:35:34
 *  @CreateUser: chenwei 
 *  
 *
*/
 package com.happy.util.wxUtil;


/**
 *
 *   TODO: 微信应用appid等参数枚举类
 *
 *  @CreateTime  : 2019年1月3日下午2:35:34
 *  @CreateAuthor: chenwei
 *  @Email       : yg_chenwei@yugyg.com
 *
 */
public enum WxAppParamsEnum {

    
    // 小程序
    /** 开心工作小程序 */
    PARAMS_APPLETS_JOB("wx1e8ed93850777ffb","未生成"),
    
    PARAMS_APPLETS_MALL("wx86ff80510776f383","07cd69cb9bcf942336a56ef1dfed9129");
    
    private String appId;
    
    private String appSecret;

    WxAppParamsEnum(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    
}
