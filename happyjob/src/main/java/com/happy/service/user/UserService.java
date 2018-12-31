 package com.happy.service.user;

import com.alibaba.fastjson.JSONObject;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherUserData;
import com.happy.service.user.data.UserDataMsg;
import com.happy.service.user.data.UserSerachListMsg;

public interface UserService {
     /**
     *
     * @TODO:     验证用户是否存在、是否注册、是否是微信用户
     */
    OtherUserData confirmUser(String sid,String oid,int isUser, int isOther);
    
    /**
    *
    * @TODO:     微信登录信息验证存贮
    */
   OtherLoginData insertWxLogin(String openId,String unionid);
    /**
    *
    * @TODO:     更新微信用户信息
    */
   BaseMsg updateLoginBound(String oid,String headerUrl,String nickName,int gender);
   /**
    * @TODO:     小程序获取微信openID、unionID、sessionKey
    */
   JSONObject getSessionKeyAndOropenid(String wxCode,String appId,String secretKey);
   /**
    * @TODO:     获取用户搜索记录
    */
   UserSerachListMsg getUserSearchList(String oid,Integer delOn,int isPage,Integer currentPage,Integer showCount);
   /**
    * @TODO:     添加用户搜索记录
    */
   void insertUserSearch(String oid,String keyWord);
   /**
    * @TODO:     删除用户搜索记录
    */
   BaseMsg updateUserSearchDel(String oid,Long hpUserSearchId);
   /**
    * @TODO:     添加分享推荐记录
    */
   BaseMsg insertShareRecom(String oid,String shareToken,String phone);
   /**
    *
    * @TODO:     获取用户中心用户数据
    */
   UserDataMsg getUserCenterDate(String oid ,String sid);
   /**
   *
   * @TODO:     用户提交认证信息，申请认证
   */
   BaseMsg updateUserIdApply(String sid,String realName,String idNum,String idFrontPic,String idBackPic,String idPersonPic);
}
