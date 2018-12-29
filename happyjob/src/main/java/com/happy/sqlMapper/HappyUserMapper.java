package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HappyUserEntity;

@Repository("happyUserMapper")
public interface HappyUserMapper{

	void insert(HappyUserEntity happyUser);

	HappyUserEntity selectByPK(long happyUserId);

	void updateByPK(HappyUserEntity happyUser);

	void deleteByPK(long happyUserId);

	List< HappyUserEntity> selectAll();

	List< HappyUserEntity> selectAllIsUse();

}
