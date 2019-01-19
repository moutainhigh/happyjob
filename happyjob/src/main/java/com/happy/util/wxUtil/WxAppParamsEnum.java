
 package com.happy.util.wxUtil;


/**
 *
 *   TODO: 微信应用appid等参数枚举类
 *
 *  @CreateTime  : 2019年1月3日下午2:35:34
 *  @CreateAuthor: chenwei
 *  @Email       : 
 *
 */
public enum WxAppParamsEnum {

    
    // 小程序
    /** 开心工作小程序 */
    PARAMS_APPLETS_JOB("wx1e8ed93850777ffb","bdb3b5d07fe0678911c57d4433de2ebb"),
    
    PARAMS_APPLETS_MALL("移除","移除");
    
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
    /**
     *  @TODO: 小城序消息模板ID枚举类
     *  @CreateTime  : 2019年1月19日下午8:14:51
     */
    public static enum  WxMsgModel{
        TEMP_POSITION("fslUdT1obHUu13l3sWDlX9awAxe6MNXhZippyNtvr4w"),
        TEMP_APPROVE("FkP_cU55lxfhUeV-XB2a4zW0Qb2UYMBUkaSxIQIVgTs");
        
        private String modelId;
        
        WxMsgModel(String modelId) {
            this.modelId = modelId;
        }

        public String getModelId() {
            return modelId;
        }

        public void setModelId(String modelId) {
            this.modelId = modelId;
        }

    }
    
    /**
     *  @TODO: 小城序消息模板参数名称枚举类
     *  @CreateTime  : 2019年1月19日下午8:14:51
     */
    public static enum  WxMsgKeyModel{
        TEMP_TOUSER("touser"),
        TEMP_TEMPLATE_ID("template_id"),
        TEMP_PAGE("page"),
        TEMP_FORM_ID("form_id"),
        TEMP_DATA("data");
        
        private String keyName;

        WxMsgKeyModel(String keyName) {
            this.keyName = keyName;
        }
        
        public String getKeyName() {
            return keyName;
        }

        
    }
}
