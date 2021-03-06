 package com.happy.service.user.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpCompanyApplyEntity;
import com.happy.entity.HpUserBoundEntity;
import com.happy.entity.HpUserEducationEntity;
import com.happy.entity.HpUserEntity;
import com.happy.entity.HpUserExpEntity;
import com.happy.entity.HpUserIntentionEntity;
import com.happy.entity.HpUserMoneyEntity;
import com.happy.entity.HpUserPayrollEntity;
import com.happy.entity.HpUserRecommendEntity;
import com.happy.entity.HpUserResumeEntity;
import com.happy.entity.HpUserSearchEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.UserService;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherLoginMsg;
import com.happy.service.user.data.OtherUserData;
import com.happy.service.user.data.UserAddData;
import com.happy.service.user.data.UserManageSearch;
import com.happy.service.user.data.UserPayrollDataMsg;
import com.happy.service.user.data.UserResume;
import com.happy.service.user.data.UserResumeData;
import com.happy.service.user.data.UserResumeDataMsg;
import com.happy.service.user.data.UserSearch;
import com.happy.service.user.data.UserSerachListMsg;
import com.happy.service.user.data.UserSimpleData;
import com.happy.service.user.data.UserSimpleDataMsg;
import com.happy.service.user.data.UserSimpleListMsg;
import com.happy.sqlExMapper.HpConfigExMapper;
import com.happy.sqlExMapper.HpUserBoundExMapper;
import com.happy.sqlExMapper.HpUserExMapper;
import com.happy.sqlMapper.HpCompanyApplyMapper;
import com.happy.sqlMapper.HpUserBoundMapper;
import com.happy.sqlMapper.HpUserEducationMapper;
import com.happy.sqlMapper.HpUserExpMapper;
import com.happy.sqlMapper.HpUserIntentionMapper;
import com.happy.sqlMapper.HpUserMapper;
import com.happy.sqlMapper.HpUserMoneyMapper;
import com.happy.sqlMapper.HpUserRecommendMapper;
import com.happy.sqlMapper.HpUserResumeMapper;
import com.happy.sqlMapper.HpUserSearchMapper;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;
import com.happy.util.pubConst.ResultMsg;
import com.happy.util.wxUtil.WxModelConst;

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
    @Autowired
    private HpCompanyApplyMapper hpCompanyApplyMapper;
    @Autowired
    private HpUserResumeMapper hpUserResumeMapper;
    @Autowired
    private HpUserIntentionMapper hpUserIntentionMapper;
    @Autowired
    private HpUserEducationMapper hpUserEducationMapper;
    @Autowired
    private HpUserExpMapper hpUserExpMapper;
    @Autowired
    private HpConfigExMapper hpConfigExMapper;
    @Autowired
    private HpUserMoneyMapper hpUserMoneyMapper;

    @Override
    public OtherUserData confirmUser(String sid, String oid, int isUser, int isOther) {
        
        logger.info("confirmUser 参数信息：sid=={},oid=={},isUser=={},isOther=={}",sid,oid,isUser,isOther);
        
        OtherUserData msg = new OtherUserData();
        Long ygfUserId = null;
        if(isUser == 1 || isUser == 2 || !Util.isEmpty(sid)) { // 需要验证手机号用户身份：1、管理员，2、求职者
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
            if (blackOn == 1) { // 判断用户是否处于黑名单
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_4);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_4);
                return msg;
            }
            ygfUserId = user.getHpUserId();
            if(isUser == 1 && user.getUserType() != 1) { // 判断是否是管理员账户
                msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_7);
                msg.setMessage(ResultMsg.LOGIN_FILTER_RESULT_CONTENT_7);
                return msg;
            }
            
        }
        if(isOther == 1 || !Util.isEmpty(oid)) { // 需要验证用户第三方登录信息
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
            msg.setOpenid(userBound.getOpenid());
        }
        msg.setHpUserId(ygfUserId);
        
         return msg;
    }

    
    @Override
    public OtherLoginData insertWxLogin(String openId,String unionid,String storeToken,String sessionKey) {
        OtherLoginData data = new OtherLoginData();
        
        HpUserBoundEntity bound = this.hpUserBoundExMapper.getBoundByOpenId(openId);
        Date curDate = Util.getCurrentDate();
        long curTime = Util.getDateSecond(curDate);
        if(bound == null) { // 未写入过
            
            bound = new HpUserBoundEntity();
            String boundToken = Util.getUuidRd();
            bound.setBoundToken(boundToken);
            bound.setOpenid(openId);
            bound.setUnionid(unionid);
            bound.setCreateTime(curTime);
            bound.setGender(1);
            bound.setSessionKey(sessionKey);
            
            if(!Util.isEmpty(storeToken)) { // 门店信息非空
                Long storeId = this.hpConfigExMapper.getStoreIdByToken(storeToken);
                bound.setHpCompanyStoreId(storeId);
            }
            
            this.hpUserBoundMapper.insert(bound);
            
        }else {
            HpUserBoundEntity newBound = new HpUserBoundEntity();
            newBound.setHpUserBoundId(bound.getHpUserBoundId());
            if(!Util.isEmpty(unionid)) {
                newBound.setUnionid(unionid);
            }
            newBound.setSessionKey(sessionKey);
            this.hpUserBoundMapper.updateByPK(newBound);
        }
        Long userId = bound.getHpUserId();
        data.setOid(bound.getBoundToken());
        if(userId != null) {
            UserSimpleData user = this.hpUserExMapper.getSimpleUserByKey(userId,null);
            data.setSid(user.getUserToken());
            data.setShareToken(user.getShareToken());
        }
        return data;
    }

    @Override
    public BaseMsg updateLoginBound(String oid, String headerUrl, String nickName, int gender, String unionid) {
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
         userBound.setUnionid(unionid);
         this.hpUserBoundMapper.updateByPK(userBound);
         // 同步头像信息到对应用户
         if(userBound.getHpUserId() != null) {
             this.hpUserBoundExMapper.updateUserPicByUserId(userBound.getHpUserId());
         }
         
         return msg;
    }

    
    @Override
    public JSONObject getSessionKeyAndOropenid(String wxCode, String appId, String secretKey) {
         
        String url = WxModelConst.XCX_JSCODE_SEESION_URL.replace("${appid}", appId).
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
        HpUserBoundEntity bound = this.hpUserBoundExMapper.getBoundByToken(oid);
        if(bound.getHpUserId() !=null) {
            msg.setErrorCode(2);
            msg.setMessage("已经注册");
            return msg;
        }
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
        Long recommendUserId = this.hpUserExMapper.getIdByShareToken(shareToken);
        if(recommendUserId == null) {
            msg.setErrorCode(1);
            msg.setMessage("推荐人识别码错误");
            return msg;
        }
        HpUserRecommendEntity userRecd = this.hpUserBoundExMapper.getRecdByPhoneNo(phone);
        if(userRecd != null) {
            msg.setErrorCode(2);
            msg.setMessage("您已绑定过推荐人");
            return msg;
        }
        
        userRecd = new HpUserRecommendEntity();
        userRecd.setHpUserBoundId(bound.getHpUserBoundId());
        userRecd.setRecommendUserId(recommendUserId);
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
         newUser.setBornYear(Util.getBornIDcard(idNum));
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
        HpUserEntity user = new HpUserEntity();
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
        OtherUserData userData = this.hpUserExMapper.getUserByParam(phoneNo,null,userType);
        if(userData != null && userData.getHpUserId() !=null) {
            msg.setErrorCode(1);
            msg.setMessage("手机号码已经被注册，请更换手机号");
            return msg;
        }
        
        String userName = data.getUserName();
        if(userType == 1) { //如果是超级管理员 ，用户名，密码必填
        	if(userName == null || !userName.matches(REGEX_USERNAME)) {
        		msg.setErrorCode(1);
        		msg.setMessage("参数格式错误：userName");
        		return msg;
        	}
        	userData = this.hpUserExMapper.getUserByParam(null,userName,userType);
        	if(userData != null && userData.getHpUserId() !=null) {
        		msg.setErrorCode(1);
        		msg.setMessage("用户名已经被注册，请更换用户名");
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
        	 String passwMD5 = Util.MD5(password1);
        	 String salt = Util.getRandomStringByLength(4, "az");
        	 String passwSaltMD5 = Util.generateMD5(password1,salt);
        	 logger.info("salt=={},passwMD5=={},passwSaltMD5=={},isEqual=={}",salt,passwMD5,passwSaltMD5,Util.verify(password1, passwSaltMD5));
        	 user.setPassword(passwSaltMD5);
             user.setSalt(salt);
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
        
        Long bornYear = data.getBornTime();
        String realName = data.getRealName();
        Long curTime = Util.getDateSecond(Util.getCurrentDate());
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
        user.setRegistResource(2);
        user.setCreateTime(System.currentTimeMillis()/1000);
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
        if(approve !=null) {
        	user.setApproveState(approve == 1?1:2);
        	if(approve == 1) {
        	    msg.setSendOn(1);
        	}
        }
        if(blackOn != null) {
        	user.setBlackOn(blackOn==1?1:0);
        }
        this.hpUserMapper.updateByPK(user);
        return msg;
    }

//    public static void main(String[] args) {
//		System.out.println(null == 1?1:0);
//	}
    @Override
    public BaseMsg insertCompanyApply(String name, String comName, String contactNo, String position) {
        BaseMsg msg = new BaseMsg();
        if(Util.isEmpty(name) || name.length()>50) {
            msg.setErrorCode(1);
            msg.setMessage("姓名必填，长度50以内");
            return msg;
        }
        if(Util.isEmpty(comName) || comName.length()>50) {
            msg.setErrorCode(1);
            msg.setMessage("公司必填，长度50以内");
            return msg;
        }
        if(Util.isEmpty(contactNo) || contactNo.length()>50) {
            msg.setErrorCode(1);
            msg.setMessage("联系方式必填，长度50以内");
            return msg;
        }
        HpCompanyApplyEntity data = new HpCompanyApplyEntity();
        data.setName(name);
        data.setComName(comName);
        data.setContactNum(contactNo);
        data.setPosition(position);
        data.setContactOn(0);
        data.setDelOn(0);
        data.setCreateTime(Util.getDateSecond(Util.getCurrentDate()));
        this.hpCompanyApplyMapper.insert(data);
        return msg;
    }


    @Override
    public BaseMsg insertOrUpUserResumeBase(String sid, HpUserResumeEntity data) {
        BaseMsg msg = new BaseMsg();
        if(data == null) {
            msg.setErrorCode(1);
            msg.setMessage("上传内容为空");
            return msg;
        }
        Long hasResumeId = this.hpUserExMapper.getUserResumeId(sid);
        Long hpUserId = this.hpUserExMapper.getUserIdBySid(sid);
        Long hpUserResumeId = data.getHpUserResumeId();
        long curTime = Util.getDateSecond(Util.getCurrentDate());
        data.setHpUserId(hpUserId);
        data.setResTime(curTime);
        if(hpUserResumeId == null) { // 新增
            if(hasResumeId != null) {
                msg.setErrorCode(2);
                msg.setMessage("已经存在简历，不可继续添加");
                return msg;
            }
            this.hpUserResumeMapper.insert(data);
            // 是否存在推荐人记录，红包奖励
            insertRecommedRedPack(hpUserId);
        }else {
            if(hasResumeId == null || !hpUserResumeId.equals(hasResumeId)) {
                msg.setErrorCode(1);
                msg.setMessage("参数错误hpUserResumeId");
                return msg;
            }
            this.hpUserResumeMapper.updateByPK(data);
        }
        
        return msg;
    }

    /**
     *
     * @TODO:     根据推荐记录，添加红包发放
     * @CreateTime:  2019年1月13日下午7:55:32 
     * @CreateAuthor: chenwei
     * @param hpUserId
     */
    public void insertRecommedRedPack(Long hpUserId) {
        
        HpUserRecommendEntity recData = this.hpUserBoundExMapper.getRecdByUserId(hpUserId);
        if(recData == null) {
            return ;
        }
        Long recommendUserId = recData.getRecommendUserId();
        String phoneNo = recData.getRecPhoneNo();
        // 存在推荐人
        HpUserMoneyEntity record = new HpUserMoneyEntity();
        record.setHpUserId(recommendUserId);
        record.setMoney(Const.MONEY_RECOMMEND_NUM);
        record.setOptType(1);
        record.setState(1);
        record.setCreateTime(Util.getDateSecond(Util.getCurrentDate()));
        record.setOptDesc("被推荐手机号:"+phoneNo+"已成功注册并创建简历");
        this.hpUserMoneyMapper.insert(record);
        this.updateUserMoeny(recommendUserId, Const.MONEY_RECOMMEND_NUM);
    }
    
    public synchronized void updateUserMoeny(Long hpUserId,double money) {
        HpUserEntity user = new HpUserEntity();
        user.setHpUserId(hpUserId);
        user.setUserMoney(money);
        this.hpUserExMapper.updateUserMoney(hpUserId, money);
    }
    
    @Override
    public UserResumeDataMsg getUserResume(String sid) {
        UserResumeDataMsg msg = new UserResumeDataMsg();
        UserResumeData data = new UserResumeData();
        
        UserResume base = this.hpUserExMapper.getUserResumBySid(sid);
        if(base == null) {
            msg.setErrorCode(ResultMsg.LOGIN_FILTER_RESULT_CODE_6);
            msg.setMessage("没有创建简历信息");
            return msg;
        }
        Long hpResumeId = base.getHpUserResumeId();
        data.setResumeBase(base);
        data.setEduList(this.hpUserExMapper.getUserEduByResumeId(hpResumeId));
        data.setExpList(this.hpUserExMapper.getUserExpByResumeId(hpResumeId));
        data.setIntentionList(this.hpUserExMapper.getUserIntendByResumeId(hpResumeId));
        msg.setData(data);
        return msg;
    }


    @Override
    public BaseMsg insertOrUpUserIntent(String sid, HpUserIntentionEntity data) {
        BaseMsg msg = new BaseMsg();
        // TODO 安全验证
        Long intentId = data.getHpUserIntentionId();
        if(intentId == null || intentId.compareTo(1L)<0) { // 新增 
            this.hpUserIntentionMapper.insert(data);
        }else {
            this.hpUserIntentionMapper.updateByPK(data);
        }
        
        return msg;
    }


    @Override
    public BaseMsg insertOrUpUserEdu(String sid, HpUserEducationEntity data) {
        BaseMsg msg = new BaseMsg();
        // TODO 安全验证
        Long eduId = data.getHpUserEducationId();
        if(eduId == null || eduId.compareTo(1L)<0) { // 新增 
            this.hpUserEducationMapper.insert(data);
        }else {
            this.hpUserEducationMapper.updateByPK(data);
        }
        return msg;
    }


    @Override
    public BaseMsg insertOrUpUserExp(String sid, HpUserExpEntity data) {
        BaseMsg msg = new BaseMsg();
        // TODO 安全验证
        Long expId = data.getHpUserExpId();
        if(expId == null || expId.compareTo(1L)<0) { // 新增 
            this.hpUserExpMapper.insert(data);
        }else {
            this.hpUserExpMapper.updateByPK(data);
        }
        return msg;
    }


    @Override
    public OtherLoginMsg insertOrUpUserByPhone(String sid,String oid,String phoneNo,Integer gender,String realName,Long bornTime) {
        OtherLoginMsg msg = new OtherLoginMsg();
        OtherUserData userData = this.hpUserExMapper.getUserByParam(phoneNo, null, 2);
        HpUserBoundEntity bound = this.hpUserBoundExMapper.getBoundByToken(oid);
        Long userId = bound.getHpUserId();
        Long boundId = bound.getHpUserBoundId();
        Long phoneUserId = null; // 手机号绑定用户ID
        Long phoneBoundId = null; 
        if(userData != null) {
            phoneUserId = userData.getHpUserId();
            phoneBoundId = userData.getHpUserBoundId();
        }
        if(phoneBoundId != null) {// 手机号已注册，并绑定微信
            msg.setErrorCode(1);
            msg.setMessage("手机号已被其他用户绑定，请更换手机号");
            return msg;
        }
        gender = gender==null?bound.getGender():gender;
        if(phoneUserId == null) { // 手机号未注册，新增用户
            HpUserEntity user = new HpUserEntity();
            user.setHpUserId(userId);
            user.setPhoneNo(phoneNo);
            user.setApproveNum(0);
            user.setApproveState(0);
            String shareToken = Util.getUuidRd();
            user.setShareToken(shareToken);
            user.setUserMoney(0d);
            String userToken = Util.getUuidRd();
            user.setUserToken(userToken);
            user.setVipOn(0);
            user.setRegistResource(2);
            user.setUserName(bound.getNickName());
            user.setHeaderPic(bound.getHeaderPic());
            user.setUserType(2);
            user.setBlackOn(0);
            user.setUserMoney(0d);
            user.setCreateTime(System.currentTimeMillis()/1000);
            user.setGender(gender);
            user.setBornYear(bornTime);
            user.setRealName(realName);
            
            this.hpUserMapper.insert(user);
            userId = user.getHpUserId();
            OtherLoginData data = new OtherLoginData();
            bound = new HpUserBoundEntity();
            bound.setHpUserBoundId(boundId);
            bound.setHpUserId(userId);
            this.hpUserBoundMapper.updateByPK(bound);
            data.setOid(oid);
            data.setSid(userToken);
            data.setPhoneNo(phoneNo);
            data.setShareToken(shareToken);
            msg.setData(data);
            return msg;
        }else if(phoneUserId != null && phoneBoundId == null) { // 手机号已被添加为用户，但是未绑定微信：微信用户绑定后台添加用户
            bound = new HpUserBoundEntity();
            bound.setHpUserBoundId(boundId);
            bound.setHpUserId(phoneUserId);
            this.hpUserBoundMapper.updateByPK(bound);
            HpUserEntity user = new HpUserEntity();
            user.setHpUserId(phoneUserId);
            user.setGender(gender);
            user.setBornYear(bornTime);
            user.setRealName(realName);
            this.hpUserMapper.updateByPK(user);
            OtherLoginData data = new OtherLoginData();
            data.setOid(oid);
            data.setSid(userData.getUserToken());
            data.setPhoneNo(phoneNo);
            data.setShareToken(userData.getShareToken());
            msg.setData(data);
            return msg;
        }
            
        return msg;
    }


    @Override
    public UserSimpleDataMsg getPayrollIdByPhone(String phoneNo) {
        UserSimpleDataMsg msg = new UserSimpleDataMsg();
        
        UserSimpleData data = this.hpUserExMapper.getUserRealByphone(phoneNo);
        if(data == null) {
            msg.setErrorCode(1);
            msg.setMessage("该手机号还未成为注册用户");
            return msg;
        }
        if(Util.isEmpty(data.getIdNum())) {
            msg.setErrorCode(1);
            msg.setMessage("该手机号用户还未进行实名认证");
            return msg;
        }
        msg.setData(data);
        return msg;
    }


    @Override
    public UserPayrollDataMsg getPayrollByIdNum(String idNum, Long time) {
        UserPayrollDataMsg msg = new UserPayrollDataMsg();
        if(Util.isEmpty(idNum)) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：idNum");
            return msg;
        }
        if(Util.isEmpty(time) || time.compareTo(1L)<0) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：time");
            return msg;
        }
        HpUserPayrollEntity data = this.hpUserExMapper.getPayrollByIdNum(idNum, time);
        if(data == null) {
            msg.setErrorCode(2);
            msg.setMessage("未查询到工资条");
            return msg;
        }
        msg.setData(data);
        return msg;
    }


    @Override
    public OtherUserData checkUserLogin(String userName, String password, String validCode) {
        OtherUserData msg = new OtherUserData();
        if(Util.isEmpty(userName) || Util.isEmpty(password) || Util.isEmpty(validCode) ) {
            msg.setErrorCode(1);
            msg.setMessage("参数缺失");
            return msg;
        }
        OtherUserData userData = this.hpUserExMapper.getUserByParam(null, userName, 1); // 查询用户信息
        if(userData == null || userData.getHpUserId() == null) {
            msg.setErrorCode(1);
            msg.setMessage("用户名不存在");
            return msg;
        }
        String pasw = userData.getPassword();
        if(!Util.verify(password, pasw)) { // 密码匹配
            msg.setErrorCode(1);
            msg.setMessage("密码错误");
            return msg;
        }
        return userData;
    }


    @Override
    public void UpdateUserLogin(Long hpUserId, String ip) {
        
        HpUserEntity user = new HpUserEntity();
        user.setHpUserId(hpUserId);
        user.setLoginIp(ip);
        user.setLoginTime(Util.getDateSecond(Util.getCurrentDate()));
        this.hpUserMapper.updateByPK(user);
    }


    @Override
    public JSONObject decodeWxData(String oid, String encryptedData, String iv) {
        
        String sessionKey = this.hpUserBoundExMapper.getSessionKey(oid);
        if(Util.isEmpty(sessionKey)) {
            JSONObject json = new JSONObject();
            json.put("errcode", 3);
            json.put("message", "重新登录获取sessionKey");
            return json;
        }
        
        return Util.decodeWxData(encryptedData, iv, sessionKey);
         
    }


    @Override
    public void updateBoundFormId(String oid,String formId) {
        
         this.hpUserBoundExMapper.updateBoundFormId(oid, formId);
    }


    
}
