package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.entity.HpUserExpEntity;
import com.happy.entity.HpUserPayrollEntity;
import com.happy.entity.HpUserResumeEntity;
import com.happy.service.user.data.OtherUserData;
import com.happy.service.user.data.UserEduDate;
import com.happy.service.user.data.UserIntentionData;
import com.happy.service.user.data.UserManageSearch;
import com.happy.service.user.data.UserSimpleData;

@Repository("hpUserExMapper")
public interface HpUserExMapper{

    /**
    *
    * @TODO:     描述一下这个方法是干什么的
    */
   String getTokenByUserId(@Param("hpUserId") Long hpUserId);
   /**
    *
    * @TODO:     描述一下这个方法是干什么的
    */
   UserSimpleData getUserByToken(@Param("sid") String sid);
   /**
    *
    * @TODO:     描述一下这个方法是干什么的
    */
   Long getUserIdBySid(@Param("sid") String sid);
   /**
    *
    * @TODO:     描述一下这个方法是干什么的
    */
   UserSimpleData getSimpleUserByKey(@Param("hpUserId") Long hpUserId,@Param("sid") String sid);
   /**
   *
   * @TODO:     描述一下这个方法是干什么的
   */
  Long getIdByShareToken(@Param("shareToken")String shareToken);
  /**
  *
  * @TODO:     描述一下这个方法是干什么的
  */
  List<UserSimpleData> getUserlistPage(UserManageSearch page);
  /**
  *
  * @TODO:     验证手机号是否被注册
  */
  OtherUserData getUserByPhone(@Param("phoneNo") String phoneNo,@Param("userType") int userType);
  /**
   *
   * @TODO:     描述一下这个方法是干什么的
   */
  Long getUserResumeId(@Param("sid") String sid);
  /**
  *
  * @TODO:     描述一下这个方法是干什么的
  */
  HpUserResumeEntity getUserResumBySid(@Param("sid") String sid);
  /**
  *
  * @TODO:     描述一下这个方法是干什么的
  */
  List<UserEduDate> getUserEduByResumeId(@Param("hpResumeId") Long hpResumeId);
  /**
   *
   * @TODO:     描述一下这个方法是干什么的
   */
  List<UserIntentionData> getUserIntendByResumeId(@Param("hpResumeId") Long hpResumeId);
  /**
   *
   * @TODO:     描述一下这个方法是干什么的
   */
  List<HpUserExpEntity> getUserExpByResumeId(@Param("hpResumeId") Long hpResumeId);
  /**
  *
  * @TODO:    根据手机号获取用户真实信息
  */
  UserSimpleData getUserRealByphone(@Param("phoneNo") String phoneNo);
  /**
   *
   * @TODO:    根据身份证号获取工资条信息
   */
  HpUserPayrollEntity getPayrollByIdNum(@Param("idNum") String idNum,@Param("time")Long time);
}
