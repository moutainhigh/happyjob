 package com.happy.service.user.data;


import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 *   TODO: 描述这个类用来做什么事情TODO
 */
@ApiModel(value="微信生成预支付ID信息封装类")
public class WxPrePayData extends BaseMsg {

    @ApiModelProperty(name="nonceStr",value="随机字符串")
    private String nonceStr;
    
    @ApiModelProperty(name="timeStamp",value="时间戳")
    private String timeStamp;
    
    @ApiModelProperty(name="pack",value="统一下单接口返回的 prepay_id 参数值，格式如：prepay_id=***")
    private String pack;
    
    @ApiModelProperty(name="sign",value="签名")
    private String sign;

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    
}
