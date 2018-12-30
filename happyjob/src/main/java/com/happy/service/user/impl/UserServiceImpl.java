 package com.happy.service.user.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpUserBoundEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.applets.data.OtherLoginData;
import com.happy.service.user.UserService;
import com.happy.service.user.data.OtherUserData;
import com.happy.service.user.data.WxPrePayData;
import com.happy.sqlExMapper.HpUserBoundExMapper;
import com.happy.sqlMapper.HpUserBoundMapper;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;
import com.happy.util.pubConst.ResultMsg;
import com.happy.util.pubConst.WxAppletsConst;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private HpUserBoundMapper hpUserBoundMapper;
    @Autowired
    private HpUserBoundExMapper hpUserBoundExMapper;

    @Override
    public OtherUserData confirmUser(String sid, String userToken, String oid, String resource, int isUser, int isOther) {
        OtherUserData msg = new OtherUserData();
//        Long ygfUserId = null;
//        if(isUser == 1) { // 需要验证手机号用户身份
//            if(Util.isEmpty(sid) || Util.isEmpty(userToken)) {
//                msg.setErrorCode(1);
//                msg.setMessage("缺少用户认证参数");
//                return msg;
//            }
//            YgfUserBaseEntity user = null;
//            try {
//                user = this.ygfUserBaseExMapper.selectUserBySid(sid);
//            } catch (Exception e) {
//                logger.error("用户查询出现异常sid====={}",sid,e);
//                msg.setErrorCode(2);
//                msg.setMessage("用户信息异常");
//                return msg;
//            }
//            if(user == null || user.getYgfUserId() == null) {
//                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_2);
//                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_2);
//                return msg;
//            }
//            if (!userToken.equals(user.getUserToken())) {// TOKEN验证不通过，密码已被修改
//                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_4);
//                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_4);
//                return msg;
//            }
//            if ("1".equals(user.getIsBlack() + "")) { // 判断用户是否处于黑名单
//                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_3);
//                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_3 + "原因："+user.getBlackDes());
//                return msg;
//            }
//            ygfUserId = user.getYgfUserId();
//            
//        }
//        if(isOther == 1) { // 需要验证用户第三方登录信息
//            if(Util.isEmpty(oid) || Util.isEmpty(resource)) {
//                msg.setErrorCode(1);
//                msg.setMessage("缺少第三方参数");
//                return msg;
//            }
//            YgfUserLoginBoundEntity userBound = this.ygfUserLoginBoundExMapper.getUserBoundByOidRes(oid, resource);
//            if(Util.isEmpty(userBound)) {
//                msg.setErrorCode(1);
//                msg.setMessage("第三方登录参数错误");
//                return msg;
//            }
//            if(ygfUserId !=null && !ygfUserId.equals(userBound.getYgfUserId())) {
//                msg.setErrorCode(2);
//                msg.setMessage("第三方登录信息和用户商城信息不符");
//                return msg;
//            }
//            msg.setOpenId(userBound.getOpenId());
//        }
//        msg.setYgfUserId(ygfUserId);
        
         return msg;
    }

    
    @Override
    public OtherLoginData insertWxLogin(String openId,String unionid) {
        OtherLoginData data = new OtherLoginData();
        int errorCode = 0;
        String message = "success";
        if(!Util.isEmpty(openId)){//openId不为空,根据openId查询用户是否绑定
            HpUserBoundEntity bound = this.hpUserBoundExMapper.getBoundByToken(openId);
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
