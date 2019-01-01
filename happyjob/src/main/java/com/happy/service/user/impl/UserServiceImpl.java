 package com.happy.service.user.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpUserBoundEntity;
import com.happy.entity.HpUserEntity;
import com.happy.entity.HpUserRecommendEntity;
import com.happy.entity.HpUserSearchEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.UserService;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherUserData;
import com.happy.service.user.data.UserAddData;
import com.happy.service.user.data.UserManageSearch;
import com.happy.service.user.data.UserSearch;
import com.happy.service.user.data.UserSerachListMsg;
import com.happy.service.user.data.UserSimpleData;
import com.happy.service.user.data.UserSimpleDataMsg;
import com.happy.service.user.data.UserSimpleListMsg;
import com.happy.sqlExMapper.HpUserBoundExMapper;
import com.happy.sqlExMapper.HpUserExMapper;
import com.happy.sqlMapper.HpUserBoundMapper;
import com.happy.sqlMapper.HpUserMapper;
import com.happy.sqlMapper.HpUserRecommendMapper;
import com.happy.sqlMapper.HpUserSearchMapper;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;
import com.happy.util.pubConst.ResultMsg;
import com.happy.util.pubConst.WxAppletsConst;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private HpUserExMapper hpUserExMapper;
    @Autowired
    private HpUserMapper hpUserMapper;
    @Autowired
    private HpUserBoundMapper hpUserBoundMapper;
    @Autowired
    private HpUserBoundExMapper hpUserBoundExMapper;
    @Autowired
    private HpUserSearchMapper hpUserSearchMapper;
    @Autowired
    private HpUserRecommendMapper hpUserRecommendMapper;

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
            HpUserEntity user = this.hpUserExMapper.getUserByToken(sid);
            if(user == null || user.getHpUserId() == null) {
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_3);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_3);
                return msg;
            }
            Integer blackOn = user.getBlackOn();
            if (blackOn == 0) { // 判断用户是否处于黑名单
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
            UserSimpleData user = this.hpUserExMapper.getSimpleUserByKey(userId,null);
            data.setSid(user.getUserToken());
            data.setShareToken(user.getShareToken());
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


    @Override
    public UserSerachListMsg getUserSearchList(String oid, Integer delOn, int isPage, Integer currentPage, Integer showCount) {
        
        UserSerachListMsg msg = new UserSerachListMsg();
        UserSearch page = new UserSearch();
        page.setOid(oid);
        page.setDelOn(delOn);
        if(isPage == 1) { // 分页
            page.setIsPage(isPage);
            page.setCurrentPage(currentPage);
            page.setShowCount(showCount);
            int totalCount = this.hpUserBoundExMapper.getUserSearchNum(page);
            page.setTotalResult(totalCount);
            msg.setPage(page);
        }
        List<HpUserSearchEntity> list = this.hpUserBoundExMapper.getUserSearchList(page);
        msg.setList(list);
        return msg;
    }


    @Override
    public void insertUserSearch(String oid, String keyWord) {
        
        if(Util.isEmpty(keyWord)) {
            return;
        }
        keyWord = keyWord.trim();
        Long boundId = this.hpUserBoundExMapper.getBoundIdByToken(oid);
        if(boundId==null) {
            return;
        }
        
        UserSearch page = new UserSearch();
        page.setKeyWord(keyWord);
        page.setOid(oid);
        page.setDelOn(0);
        List<HpUserSearchEntity> list = this.hpUserBoundExMapper.getUserSearchList(page);
        Long curTime = Util.getDateSecond(Util.getCurrentDate());
        HpUserSearchEntity userSearch = null;
        if(Util.isEmptyList(list)) { // 需要新增
            userSearch = new HpUserSearchEntity();
            userSearch.setContent(keyWord);
            userSearch.setHpUserBoundId(boundId);
            userSearch.setTime(curTime);
            userSearch.setDelOn(0);
            userSearch.setNum(1);
            this.hpUserSearchMapper.insert(userSearch);
        }else {
            userSearch = list.get(0);
            userSearch.setContent(null);
            userSearch.setHpUserBoundId(null);
            userSearch.setTime(curTime);
            userSearch.setNum(userSearch.getNum()+1);
            this.hpUserSearchMapper.updateByPK(userSearch);
        }
    }


    @Override
    public BaseMsg updateUserSearchDel(String oid, Long hpUserSearchId) {
        BaseMsg msg = new BaseMsg();
        this.hpUserBoundExMapper.updateUserSearchDel(oid, hpUserSearchId);
        
        return msg;
    }


    @Override
    public BaseMsg insertShareRecom(String oid, String shareToken, String phone) {
        BaseMsg msg = new BaseMsg();
        if(Util.isEmpty(shareToken)) {
            msg.setErrorCode(1);
            msg.setMessage("缺少推荐人参数");
            return msg;
        } 
        if(!Util.checkPhone(phone)) {
            msg.setErrorCode(1);
            msg.setMessage("手机号格式不正确");
            return msg;
        }
        Long recommenUserId = this.hpUserExMapper.getIdByShareToken(shareToken);
        if(recommenUserId == null) {
            msg.setErrorCode(1);
            msg.setMessage("推荐人识别码错误");
            return msg;
        }
        HpUserRecommendEntity userRecd = this.hpUserBoundExMapper.getRecdByOid(oid);
        if(userRecd != null) {
            msg.setErrorCode(1);
            msg.setMessage("您已绑定过推荐人");
            return msg;
        }
        Long boundId = this.hpUserBoundExMapper.getBoundIdByToken(oid);
        userRecd = new HpUserRecommendEntity();
        userRecd.setHpUserBoundId(boundId);
        userRecd.setHpUserRecommendId(recommenUserId);
        userRecd.setRecPhoneNo(phone);
        userRecd.setRecTime(Util.getDateSecond(Util.getCurrentDate()));
        this.hpUserRecommendMapper.insert(userRecd);
        
        return msg;
    }


    @Override
    public UserSimpleDataMsg getUserCenterDate(String oid, String sid) {
        UserSimpleDataMsg msg = new UserSimpleDataMsg();
        UserSimpleData data = this.hpUserExMapper.getSimpleUserByKey(null,sid);
        
        msg.setData(data);
        
        return msg;
    }


    @Override
    public BaseMsg updateUserIdApply(String sid, String realName, String idNum, String idFrontPic, String idBackPic,
        String idPersonPic) {
         BaseMsg msg = new BaseMsg();
         if(Util.isEmpty(realName)) {
             msg.setErrorCode(1);
             msg.setMessage("缺少参数：真实姓名");
             return msg;
         }
         realName = realName.trim();
         if(Util.isEmpty(idNum) || idNum.length()>=20) {
             msg.setErrorCode(1);
             msg.setMessage("身份证号格式错误");
             return msg;
         }
         if(!Util.checkUrl(idFrontPic)) {
             msg.setErrorCode(1);
             msg.setMessage("身份证正面照地址格式错误");
             return msg;
         }
         if(!Util.checkUrl(idBackPic)) {
             msg.setErrorCode(1);
             msg.setMessage("身份证反面照地址格式错误");
             return msg;
         }
         if(!Util.checkUrl(idPersonPic)) {
             msg.setErrorCode(1);
             msg.setMessage("身份证手持图片地址格式错误");
             return msg;
         }
         idNum = idNum.trim();
         UserSimpleData user = this.hpUserExMapper.getSimpleUserByKey(null, sid);
         Long curTime = Util.getDateSecond(Util.getCurrentDate());
         HpUserEntity newUser = new HpUserEntity();
         newUser.setHpUserId(user.getHpUserId());
         newUser.setApplyTime(curTime);
         newUser.setApproveNum(user.getApproveNum()+1);
         newUser.setApproveState(3);
         newUser.setRealName(realName);
         newUser.setIdBackPic(idBackPic);
         newUser.setIdFrontPic(idFrontPic);
         newUser.setIdNum(idNum);
         newUser.setIdPersonPic(idPersonPic);
         this.hpUserMapper.updateByPK(newUser);
         return msg;
    }


    @Override
    public UserSimpleListMsg getUserListPage(String phoneNo, Integer resource, Long startTime, Long endTime,
        Integer blackOn,Integer userType, Integer currentPage, Integer showCount) {
         UserSimpleListMsg msg = new UserSimpleListMsg();
         UserManageSearch page = new UserManageSearch();
         currentPage = currentPage==null||currentPage<1?1:currentPage;
         showCount = showCount==null||showCount<1?10:showCount;
         page.setCurrentPage(currentPage);
         page.setShowCount(showCount);
         page.setPhoneNo(phoneNo);
         page.setBlackOn(blackOn);
         page.setStartTime(startTime);
         page.setEndTime(endTime);
         page.setResource(resource);
         page.setUserType(userType);
         
         List<UserSimpleData> list = this.hpUserExMapper.getUserlistPage(page);
         msg.setList(list);
         msg.setPage(page);
         return msg;
    }

    private static final String REGEX_USERNAME = "[0-9a-zA-Z_]{1,50}";
    private static final String REGEX_PASSWORD = "\\d{6}";
    @Override
    public BaseMsg insertUserBase(UserAddData data) {
        BaseMsg msg = new BaseMsg();
        if(data == null ) {
            msg.setErrorCode(1);
            msg.setMessage("信息为空");
            return msg;
        }
        String phoneNo = data.getPhoneNo();
        if(!Util.checkPhone(phoneNo)) {
            msg.setErrorCode(1);
            msg.setMessage("参数格式错误：phoneNo");
            return msg;
        }
        // 验证手机号唯一
        Integer userType = data.getUserType();
        if(userType ==null || (userType!=1 && userType !=2)) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：userType");
            return msg;
        }
        int num = this.hpUserExMapper.getUserCountByPhone(phoneNo);
        if(num >0) {
            msg.setErrorCode(1);
            msg.setMessage("手机号码已经被注册，请更换手机号");
            return msg;
        }
        String userName = data.getUserName();
        if(userName ==null || !userName.matches(REGEX_USERNAME)) {
            msg.setErrorCode(1);
            msg.setMessage("参数格式错误：userName");
            return msg;
        }
        String password1 = data.getPassword1();
        if(password1 ==null || !password1.matches(REGEX_PASSWORD)) {
            msg.setErrorCode(1);
            msg.setMessage("参数格式错误：password1");
            return msg;
        }
        String password2 = data.getPassword1();
        if(password2 ==null || !password2.matches(REGEX_PASSWORD)) {
            msg.setErrorCode(1);
            msg.setMessage("参数格式错误：password2");
            return msg;
        }
        if(!password2.equals(password1)) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：password2、password1不等");
            return msg;
        }
        Integer gender = data.getGender();
        if(gender ==null || (gender!=1 && gender !=2)) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：gender");
        }
        Integer blackOn = data.getBlackOn();
        if(blackOn ==null || (blackOn!=0 && blackOn !=1)) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：blackOn");
        }
        String passwMD5 = Util.MD5(password1);
        String salt = Util.getRandomStringByLength(4, "az");
        String passwSaltMD5 = Util.generate(password1,salt);
        logger.info("salt=={},passwMD5=={},passwSaltMD5=={},isEqual=={}",salt,passwMD5,passwSaltMD5,Util.verify(password1, passwSaltMD5));
        Long bornYear = data.getBornTime();
        String realName = data.getRealName();
        Long curTime = Util.getDateSecond(Util.getCurrentDate());
        HpUserEntity user = new HpUserEntity();
        user.setApproveNum(0);
        user.setApproveState(0);
        user.setBlackOn(blackOn);
        user.setBornYear(bornYear);
        user.setCreateTime(curTime);
        user.setGender(gender);
        user.setPhoneNo(phoneNo);
        user.setRealName(realName);
        user.setShareToken(Util.getUuidRd());
        user.setUserMoney(0d);
        user.setUserName(userName);
        user.setUserToken(Util.getUuidRd());
        user.setUserType(userType);
        user.setVipOn(0);
        user.setRegistResource(0);
        user.setPassword(passwSaltMD5);
        user.setSalt(salt);
        this.hpUserMapper.insert(user);
        if(user.getHpUserId() == null) {
            msg.setErrorCode(1);
            msg.setMessage("添加失败，稍后再试");
        }
        return msg;
    }


    @Override
    public BaseMsg updateUserState(Long hpUserId, Integer approve, Integer blackOn) {
        BaseMsg msg = new BaseMsg();
        if(hpUserId == null) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：hpUserId");
            return msg;
        }
        if(approve == null && blackOn==null) {
            msg.setErrorCode(1);
            msg.setMessage("操作类型错误");
            return msg;
        }
        HpUserEntity user = new HpUserEntity();
        user.setHpUserId(hpUserId);
        user.setApproveState(approve == 1?1:2);
        user.setBlackOn(blackOn==1?1:0);
        this.hpUserMapper.updateByPK(user);
        return msg;
    }

}
