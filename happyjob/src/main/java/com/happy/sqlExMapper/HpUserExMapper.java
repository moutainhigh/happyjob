package com.happy.sqlExMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.service.user.data.UserManageSearch;
import com.happy.service.user.data.UserSimpleData;
import java.util.List;

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
  * @TODO:     描述一下这个方法是干什么的
  */
  int getUserCountByPhone(@Param("phoneNo") String phoneNo);

}
