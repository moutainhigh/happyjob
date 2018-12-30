 package com.happy.util.pubConst;

/**
 *   TODO: 微信小程序相关常量
 *
 */
public class WxAppletsConst {
    
    /**微信小程序根据code获取openId、unionId接口*/
    public static final String XCX_JSCODE_SEESION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=${appid}"
        + "&secret=${secret}&js_code=${js_code}&grant_type=authorization_code";
    
    
    /**微信小程序订单body*/
    public static final String XCX_ORDER_BODY = "待定";
    /**微信小程序统一下单支付类型*/
    public static final String XCX_ORDER_TRADE_TYPE = "JSAPI";
    

    /**开心工作微信小程序APPID*/
    public static final String XCX_JOB_APPID = "";
    /**开心工作微信小程序SECRET*/
    public static final String XCX_JOB_SECRET = "";
    
    
}
