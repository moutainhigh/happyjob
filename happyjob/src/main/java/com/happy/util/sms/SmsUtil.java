
package com.happy.util.sms;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 短信发送工具
 */
@Configuration
@Component
public class SmsUtil {

    private static String account;// N6000001" 用户在253云通讯平台上申请的API账号
    private static String password;// 123456" 用户在253云通讯平台上申请的API账号对应的API密钥
    private static String smsUrl; // http://xxx/msg/send/json 或者 https://xxx/msg/send/json
    private static String smsSign; // 在zz.253.com 后台设置签名管理

    @Autowired
    private Zz253Property property;

    @Bean
    public Object virtualObject() {
        account = property.getAccount();
        password = property.getPassword();
        smsUrl = property.getSmsUrl();
        smsSign = property.getSmsSign();
        return new Object();
    }

    private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    private static final OkHttpClient client = new OkHttpClient();

    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    public static final String MSG_MODEL = "尊敬的用户： 您的验证码为${msgCode}，如非本人操作，请忽略此短信。";

    /**
     * @param msg 短信内容
     * @param phoneNum 手机号码
     * @return true 表示提交发送指令成功，false 表示提交指令失败
     */

    public static boolean sendSms(String msg, String phoneNum) {
        try {

            Zz253Request zz253Req = new Zz253Request();
            zz253Req.setAccount(account);
            zz253Req.setPassword(password);
            // 拼接签名
            zz253Req.setMsg(StringUtils.appendIfMissing(smsSign, msg));
            zz253Req.setPhone(phoneNum);
            String postBody = JSON.toJSONString(zz253Req);

            Request request =
                new Request.Builder().url(smsUrl).post(RequestBody.create(MEDIA_TYPE_JSON, postBody)).build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                String jsonString = new String(response.body().bytes(), Charset.forName("utf-8"));

                Zz253Response res = JSON.parseObject(jsonString, Zz253Response.class);

                if (res.getCode() != null && res.getCode().equals(Zz253Response.okCode)) {
                    return true;
                } else {
                    logger.debug("Zz253Response : {} ", res);
                    return false;
                }
            }

        } catch (Exception e) {
            logger.debug("sendSms  exception : { } ", e);
        }
        return false;
    }
}
