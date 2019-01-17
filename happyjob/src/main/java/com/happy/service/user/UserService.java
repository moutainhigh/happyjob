 package com.happy.service.user;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpUserEducationEntity;
import com.happy.entity.HpUserExpEntity;
import com.happy.entity.HpUserIntentionEntity;
import com.happy.entity.HpUserResumeEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.user.data.OtherLoginData;
import com.happy.service.user.data.OtherLoginMsg;
import com.happy.service.user.data.OtherUserData;
import com.happy.service.user.data.UserAddData;
import com.happy.service.user.data.UserPayrollDataMsg;
import com.happy.service.user.data.UserResumeDataMsg;
import com.happy.service.user.data.UserSerachListMsg;
import com.happy.service.user.data.UserSimpleDataMsg;
import com.happy.service.user.data.UserSimpleListMsg;

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
   OtherLoginData insertWxLogin(String openId,String unionid,String storeToken);
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
   UserSimpleDataMsg getUserCenterDate(String oid ,String sid);
   /**
   *
   * @TODO:     用户提交认证信息，申请认证
   */
   BaseMsg updateUserIdApply(String sid,String realName,String idNum,String idFrontPic,String idBackPic,String idPersonPic);
   /**
    *
    * @TODO:     提交信息指定专属方案
    */
   BaseMsg insertCompanyApply(String name,String comName,String contactNo,String position);
   /**
    *
    * @TODO:     新增或更新用户简历基本信息
    */
   BaseMsg insertOrUpUserResumeBase(String sid,HpUserResumeEntity data);
   /**
    *
    * @TODO:     获取用户简历详情
    */
   UserResumeDataMsg getUserResume(String sid);
   /**
    *
    * @TODO:     新增或更新用户简历求职意向
    */
   BaseMsg insertOrUpUserIntent(String sid,HpUserIntentionEntity data);
   /**
    *
    * @TODO:     新增或更新用户简历学历
    */
   BaseMsg insertOrUpUserEdu(String sid,HpUserEducationEntity data);
   /**
    *
    * @TODO:     新增或更新用户简历工作经验
    */
   BaseMsg insertOrUpUserExp(String sid,HpUserExpEntity data);
   /**
    *
    * @TODO:     新增或更新用户简历工作经验
    */
   OtherLoginMsg insertOrUpUserByPhone(String sid,String oid,String phoneNo,Integer gender,String realName,Long bornTime);
   /**
    *
    * @TODO:     根据手机号查询用户工资条身份证、姓名
    */
   UserSimpleDataMsg getPayrollIdByPhone(String phoneNo);
   /**
    *
    * @TODO:     根据手机号查询用户工资条
    */
   UserPayrollDataMsg getPayrollByIdNum(String idNum,Long time);
   
   
   
   
   
   ////////////////////////////////////////后台用户////////////////////////////////////////
   /**
   *
   * @TODO:     分页获取用户信息
   */ 
   UserSimpleListMsg getUserListPage(String phoneNo,Integer resource,Long startTime,
       Long endTime,Integer blackOn,Integer userType,Integer currentPage,Integer showCount);
   /**
   *
   * @TODO:     后台添加员工基本信息
   */ 
   BaseMsg insertUserBase(UserAddData data);
   /**
    *
    * @TODO:     用户认证、禁用
    */ 
   BaseMsg updateUserState(Long hpUserId,Integer approve,Integer blackOn);
   /**
    *
    * @TODO:     后台用户登录、更新登录状态
    */ 
   OtherUserData checkUserLogin(String userName,String password,String validCode);
   /**
    *
    * @TODO:     后台用户登录、更新登录状态
    */ 
   void UpdateUserLogin(Long hpUserId,String ip);
}
