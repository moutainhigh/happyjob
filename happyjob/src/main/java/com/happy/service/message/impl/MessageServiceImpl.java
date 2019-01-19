 package com.happy.service.message.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.happy.plugin.BaseMsg;
import com.happy.service.message.MessageService;
import com.happy.util.Util;
import com.happy.util.wxUtil.WxAppParamsEnum;
import com.happy.util.wxUtil.WxModelConst;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Override
    public BaseMsg pushWxMsg(String content) {
        BaseMsg msg = new BaseMsg();
        logger.info("pushWxMsg==content+++++++{}",content);
        if (Util.isEmpty(content)) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：content为空");
            return msg;
        }
        String access_token = WxModelConst.getAppAccessToken(WxAppParamsEnum.PARAMS_APPLETS_JOB, false);
        
        String postResult = Util.sendPost(WxModelConst.WX_APPLETS_MSG_TEMP_URL
            .replace("${access_token}",access_token), content);
        logger.info("第一次=postResult:{}",postResult);
        JSONObject data = JSONObject.parseObject(postResult);
        if (data.getIntValue("errcode") != 0) {//invalid credential, access_token is invalid or not latest hint
                
            access_token = WxModelConst.getAppAccessToken(WxAppParamsEnum.PARAMS_APPLETS_JOB, false);
            postResult = Util.sendPost(WxModelConst.WX_APPLETS_MSG_TEMP_URL
                .replace("${access_token}",access_token), content);
            logger.info("第二次=postResult:{}",postResult);
            if(data.containsKey("errcode") && data.getIntValue("errcode") != 0) {
                msg.setErrorCode(1);
                msg.setMessage("微信请求接口返回错误");
            }{
            msg.setErrorCode(2);
            msg.setMessage("消息发放失败");
            }
        }
        msg.setWxMsg(data);
        return msg;
    }

    @Override
    public BaseMsg getAllWxTemplateIds(Integer currentPage, Integer showCount) {
        BaseMsg msg = new BaseMsg();
        String access_token = WxModelConst.getAppAccessToken(WxAppParamsEnum.PARAMS_APPLETS_JOB, false);
        String url = WxModelConst.WX_APPLETS_MSG_TEMP_LIST_URL;
        String params = "";
        if(currentPage != null && showCount != null) {
            JSONObject json = new JSONObject();
            json.put("offset", currentPage);
            json.put("count", showCount);
            params = json.toString();
        }
        String postResult = Util.sendPost(url.replace("${access_token}",access_token), params);
        logger.info("第一次=postResult:{}",postResult);
        JSONObject jsonObj = JSONObject.parseObject(postResult);
        if(jsonObj.containsKey("errcode") && jsonObj.getIntValue("errcode") != 0) {
            access_token = WxModelConst.getAppAccessToken(WxAppParamsEnum.PARAMS_APPLETS_JOB, false);
            
            postResult = Util.sendPost(url.replace("${access_token}",access_token), params);
            logger.info("第二次=postResult:{}",postResult);
            jsonObj = JSONObject.parseObject(postResult);
            if(jsonObj.containsKey("errcode") && jsonObj.getIntValue("errcode") != 0) {
                msg.setErrorCode(1);
                msg.setMessage("微信请求接口返回错误");
            }
        }
        msg.setWxMsg(jsonObj);
        return msg;
    }

   
}
