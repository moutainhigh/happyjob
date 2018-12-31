 package com.happy.service.user;

import com.alibaba.fastjson.JSONObject;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherUserData;
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
}
