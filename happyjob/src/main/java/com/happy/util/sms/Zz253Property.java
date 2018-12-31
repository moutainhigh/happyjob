
package com.happy.util.sms;

/**
 * https://zz.253.com/v5.html#/api_doc https://www.253.com 短信平台参数
 */
public class Zz253Property {

    private String account;// N6000001" 用户在253云通讯平台上申请的API账号
    private String password;// 123456" 用户在253云通讯平台上申请的API账号对应的API密钥
    private String smsUr; // http://xxx/msg/send/json 或者 https://xxx/msg/send/json

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

    public String getSmsUr() {
        return smsUr;
    }

    public void setSmsUr(String smsUr) {
        this.smsUr = smsUr;
    }

    @Override
    public String toString() {
        return "Zz253Property [account=" + account + ", password=" + password + ", smsUr=" + smsUr + "]";
    }

}
