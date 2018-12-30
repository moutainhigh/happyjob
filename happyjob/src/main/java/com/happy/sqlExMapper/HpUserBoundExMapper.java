package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserBoundEntity;

@Repository("hpUserBoundExMapper")
public interface HpUserBoundExMapper{

    /**
     *
     * @TODO:     根据token获取微信登录信息
     */
    HpUserBoundEntity getBoundByToken(@Param("oid") String oid);
}
