package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.entity.HpUserBoundEntity;
import com.happy.entity.HpUserEntity;
import com.happy.entity.HpUserSearchEntity;
import com.happy.service.user.data.UserSearch;

@Repository("hpUserBoundExMapper")
public interface HpUserBoundExMapper{

    /**
     *
     * @TODO:     根据token获取微信登录信息
     */
    HpUserBoundEntity getBoundByToken(@Param("oid") String oid);
    /**
     *
     * @TODO:     根据token获取微信登录信息记录ID
     */
    Long getBoundIdByToken(@Param("oid") String oid);
    /**
     *
     * @TODO:     根据openId获取微信登录信息
     */
    HpUserBoundEntity getBoundByOpenId(@Param("openId") String openId);
    /**
     *
     * @TODO:     描述一下这个方法是干什么的
     */
    String getTokenByUserId(@Param("hpUserId") Long hpUserId);
    /**
     *
     * @TODO:     描述一下这个方法是干什么的
     */
    HpUserEntity getUserByToken(@Param("sid") String sid);
    /**
     *
     * @TODO:     描述一下这个方法是干什么的
     */
    List<HpUserSearchEntity> getUserSearchList(UserSearch page);
    /**
     *
     * @TODO:     描述一下这个方法是干什么的
     */
    int getUserSearchNum(UserSearch page);
}
