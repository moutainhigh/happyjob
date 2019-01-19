
package com.happy.util.sms;

import java.io.UnsupportedEncodingException;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * https://zz.253.com/v5.html#/api_doc https://www.253.com 短信平台参数
 */
@ConfigurationProperties(prefix = "sms")
@Component
public class Zz253Property {

    private String account;// N6000001" 用户在253云通讯平台上申请的API账号
    private String password;// 123456" 用户在253云通讯平台上申请的API账号对应的API密钥
    private String smsUrl; // http://xxx/msg/send/json 或者 https://xxx/msg/send/json
    private String smsSign; // 在zz.253.com 后台设置签名管理

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSmsUrl() {
        return smsUrl;
    }

    public void setSmsUrl(String smsUrl) {
        this.smsUrl = smsUrl;
    }

    public String getSmsSign() {
        
       // *.properties文件中的中文默认以ISO-8859-1方式编码，因此需要对中文内容进行重新编码
        try {
            return new String(smsSign.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return smsSign;
    }

    public void setSmsSign(String smsSign) {
        this.smsSign = smsSign;
    }

    @Override
    public String toString() {
        return "Zz253Property [account=" + account + ", password=" + password + ", smsUrl=" + smsUrl + ", smsSign="
            + smsSign + "]";
    }

}
