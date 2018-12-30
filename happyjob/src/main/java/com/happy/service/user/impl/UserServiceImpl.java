 package com.happy.service.user.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpUserBoundEntity;
import com.happy.entity.HpUserEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.applets.data.OtherLoginData;
import com.happy.service.user.UserService;
import com.happy.service.user.data.OtherUserData;
import com.happy.sqlExMapper.HpUserBoundExMapper;
import com.happy.sqlMapper.HpUserBoundMapper;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;
import com.happy.util.pubConst.ResultMsg;
import com.happy.util.pubConst.WxAppletsConst;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private HpUserBoundMapper hpUserBoundMapper;
    @Autowired
    private HpUserBoundExMapper hpUserBoundExMapper;

    @Override
    public OtherUserData confirmUser(String sid, String oid, int isUser, int isOther) {
        OtherUserData msg = new OtherUserData();
        Long ygfUserId = null;
        if(isUser == 1) { // 需要验证手机号用户身份
            if(Util.isEmpty(sid) ) {
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_1);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_1);
                return msg;
            }
            HpUserEntity user = this.hpUserBoundExMapper.getUserByToken(sid);
            if(user == null || user.getHpUserId() == null) {
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_3);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_3);
                return msg;
            }
            Integer userOn = user.getUserOn();
            if (userOn == 0) { // 判断用户是否处于黑名单
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_4);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_4);
                return msg;
            }
            ygfUserId = user.getHpUserId();
            
        }
        if(isOther == 1) { // 需要验证用户第三方登录信息
            if(Util.isEmpty(oid)) {
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_2);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_2);                
                return msg;
            }
            HpUserBoundEntity userBound = this.hpUserBoundExMapper.getBoundByToken(oid);
            if(userBound == null) {
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_2);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_2);                
                return msg;
            }
            if(ygfUserId !=null && userBound.getHpUserId()!= null && !ygfUserId.equals(userBound.getHpUserId())) {
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_5);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_5);                
                return msg;
            }
            msg.setOpenId(userBound.getOpenid());
        }
        msg.setYgfUserId(ygfUserId);
        
         return msg;
    }

    
    @Override
    public OtherLoginData insertWxLogin(String openId,String unionid) {
        OtherLoginData data = new OtherLoginData();
        
        HpUserBoundEntity bound = this.hpUserBoundExMapper.getBoundByToken(openId);
        Date curDate = Util.getCurrentDate();
        long curTime = Util.getDateSecond(curDate);
        if(bound == null) { // 未写入过
            bound = new HpUserBoundEntity();
            String boundToken = Util.getUuidRd();
            bound.setBoundToken(boundToken);
            bound.setOpenid(openId);
            bound.setUnionid(unionid);
            bound.setCreateTime(curTime);
            this.hpUserBoundMapper.insert(bound);
            data.setOid(openId);
        }
        Long userId = bound.getHpUserId();
        if(userId != null) {
            String sid = this.hpUserBoundExMapper.getTokenByUserId(userId);
            data.setSid(sid);
        }
        return data;
    }

    @Override
    public BaseMsg updateLoginBound(String oid, String headerUrl, String nickName, int gender) {
         BaseMsg msg = new BaseMsg();
         HpUserBoundEntity userBound = this.hpUserBoundExMapper.getBoundByToken(oid);
         if(userBound == null) {
             msg.setErrorCode(1);
             msg.setMessage("微信token验证失败");
             return msg;
         }
         Long boundId = userBound.getHpUserBoundId();
         userBound = new HpUserBoundEntity();
         userBound.setHeaderPic(headerUrl);
         nickName = Util.urlEncodeStr(nickName, Const.CODE_TYPE_STR);
         userBound.setNickName(nickName);
         userBound.setHpUserBoundId(boundId);
         userBound.setGender(gender);
         this.hpUserBoundMapper.updateByPK(userBound);
         return msg;
    }

    
    @Override
    public JSONObject getSessionKeyAndOropenid(String wxCode, String appId, String secretKey) {
         
        String url = WxAppletsConst.XCX_JSCODE_SEESION_URL.replace("${appid}", appId).
            replace("${secret}", secretKey).replace("${js_code}", wxCode);
        String result = Util.sendRequestGet(url);
        logger.info("微信code获取openId请求返回信息===={}",result);
        return JSONObject.parseObject(result);
    }

    
}
