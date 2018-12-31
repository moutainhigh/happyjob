
package com.happy.util.sms;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@Component
public class SmsUtil {

    @Autowired
    private static Zz253Property zz253Property;

    private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    private static final OkHttpClient client = new OkHttpClient();

    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    
    public static final String MSG_MODEL = "【开心工作】尊敬的用户： 您的验证码为${msgCode}，如非本人操作，请忽略此短信。";

    /**
     * @param msg 短信内容
     * @param phoneNum 手机号码
     * @return true 表示提交发送指令成功，false 表示提交指令失败
     */
    public static boolean sendSms(String msg, String phoneNum) {

        try {

            Zz253Request zz253Req = new Zz253Request();
            zz253Req.setAccount(zz253Property.getAccount());
            zz253Req.setPassword(zz253Property.getPassword());
            zz253Req.setMsg(msg);
            zz253Req.setPhone(phoneNum);
            String postBody = JSON.toJSONString(zz253Req);

            Request request = new Request.Builder().url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_JSON, postBody)).build();

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
