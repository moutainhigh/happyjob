
 package com.happy.util.wxUtil;

import com.happy.util.Util;

/**
 *
 *  @TODO: 公众号模板公共常量类
 *
 *  @CreateTime  : 2018年12月29日下午5:05:11
 *  @CreateAuthor: chenwei
 *  @Email       : 
 *
 */
public class WxModelConst {
    
    /** 公众号获取access_token */
    public static final String WX_PUBLIC_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${appid}&secret=${secret}";
    
    /** 微信access_token有效时长 （s）*/
    public static final int WX_ACCESS_TOKEN_AGE = 7000;
    
    /**
     * 接口只能生成已发布的小程序的二维码
     * 接口 A 加上接口 C，总共生成的码数量限制为 100,000，请谨慎调用。
     * 接口 B 调用分钟频率受限(5000次/分钟)，如需大量小程序码，建议预生成。
     */
    /** 获取小程序二维码接口 A，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制  */
    public static final String WX_APPLETS_CREATEWXAQRCODE_URL = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=${access_token}";
    /** 获取小程序码接口 C，适用于需要的码数量较少的业务场景。通过该接口生成的小程序码，永久有效，有数量限制 */
    public static final String WX_APPLETS_GETWXACODE_URL = "https://api.weixin.qq.com/wxa/getwxacode?access_token=${access_token}";
    /** 获取小程序码接口 B，适用于需要的码数量极多的业务场景。通过该接口生成的小程序码，永久有效，数量暂无限制 */
    public static final String WX_APPLETS_GETWXACODEUNLIMIT_URL = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=${access_token}";
    
    /** 开心工作小程序access_token */
    private static String applets_job_access_token = "acb";
   /** 开心工作小程序access_token有效期截止 */
    private static long applets_job_access_token_endTime = 0;
    
    /** 商城小程序access_token */
    private static String applets_mall_access_token = "acb";
    /** 商城小程序access_token有效期截止 */
    private static long applets_mall_access_token_endTime = 0;
    
    
    /**微信小程序根据code获取openId、unionId接口*/
    public static final String XCX_JSCODE_SEESION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=${appid}"
        + "&secret=${secret}&js_code=${js_code}&grant_type=authorization_code";
    
    /**微信小程序订单body*/
    public static final String XCX_ORDER_BODY = "待定";
    /**微信小程序统一下单支付类型*/
    public static final String XCX_ORDER_TRADE_TYPE = "JSAPI";
    
    /** 小程序模板消息发送接口 */
    public static final String WX_APPLETS_MSG_TEMP_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=${access_token}";
    /** 小程序已添加模板列表获取接口 */
    public static final String WX_APPLETS_MSG_TEMP_LIST_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=${access_token}";
   
   
    /**
     *
     * @TODO:     根据微信应用类型获取access_token
     * @param appType
     */
    public static String getAppAccessToken(WxAppParamsEnum appEnum,boolean refresh) {
        long curTime = Util.getDateSecond(Util.getCurrentDate());
        switch (appEnum) {
            case PARAMS_APPLETS_JOB:
                if(Util.isEmpty(applets_job_access_token) ||curTime>applets_job_access_token_endTime || refresh) {
                    applets_job_access_token = Util.getAccessToken(appEnum.getAppId(), appEnum.getAppSecret());
                    applets_job_access_token_endTime = curTime + WX_ACCESS_TOKEN_AGE;
                }
                return applets_job_access_token;
            case PARAMS_APPLETS_MALL:
                if(Util.isEmpty(applets_mall_access_token) ||curTime>applets_mall_access_token_endTime || refresh) {
                    applets_mall_access_token = Util.getAccessToken(appEnum.getAppId(), appEnum.getAppSecret());
                    applets_mall_access_token_endTime = curTime + WX_ACCESS_TOKEN_AGE;
                }
                return applets_mall_access_token;
            default:
                return null;
        }
    }
    /**
     *
     * @TODO:     根据微信应用类型获取access_token有效时间
     * @param appType
     * @return
     */
    public static long getAppAccessTokenEndTIme(WxAppParamsEnum appEnum) {
        switch (appEnum) {
            case PARAMS_APPLETS_JOB:
                return applets_job_access_token_endTime;
            case PARAMS_APPLETS_MALL:
                return applets_mall_access_token_endTime;
            default:
                return 0;
        }
    }

    
}
