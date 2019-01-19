 package com.happy.service.message.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpUserBoundEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.message.MessageService;
import com.happy.service.message.data.UserApprove;
import com.happy.sqlExMapper.HpPositionExMapper;
import com.happy.sqlExMapper.HpUserBoundExMapper;
import com.happy.util.Util;
import com.happy.util.wxUtil.WxAppParamsEnum;
import com.happy.util.wxUtil.WxModelConst;

@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private HpUserBoundExMapper hpUserBoundExMapper;
    @Autowired
    private HpPositionExMapper hpPositionExMapper;
    
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

    @Override
    public void sendPositionMsg(String oid, Long hpPositionGroupId) {
        
        HpUserBoundEntity bound = this.hpUserBoundExMapper.getBoundByToken(oid);
        String form_id = bound.getFormId();
        String openId = bound.getOpenid();
        if(Util.isEmpty(form_id)) {
            logger.info("消息推送失败====无formId==oid=={}",oid);
            return;
        }
        String posName = this.hpPositionExMapper.getPosNameByGroupKey(hpPositionGroupId);
        String remark = "恭喜您拼团上班成功";
        this.pushWxMsg(Util.createPositionMsg(posName, openId, remark, form_id));
    }

    @Override
    public void sendUserApproveMsg(Long hpUserId) {
        
        UserApprove data = this.hpUserBoundExMapper.getSendDataByUserKey(hpUserId);
        
        String form_id = data.getFormId();
        String openId = data.getOpenId();
        String realName = data.getRealName();
        if(Util.isEmpty(form_id)) {
            logger.info("消息推送失败====无formId==hpUserId=={}",hpUserId);
            return;
        }
        if(Util.isEmpty(openId)) {
            logger.info("消息推送失败====无openId==hpUserId=={}",hpUserId);
            return;
        }
        String remark = "尊敬的{{realName}}您好，您的身份认证已经通过审核，可通过详情查看。";
        remark = remark.replace("{{realName}}", realName);
        this.pushWxMsg(Util.createApproveMsg(openId, remark, form_id));
    }

   
}
