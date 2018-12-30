package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserEntity;

@Repository("hpUserMapper")
public interface HpUserMapper{

	void insert(HpUserEntity hpUser);

	HpUserEntity selectByPK(long hpUserId);

	void updateByPK(HpUserEntity hpUser);

	void deleteByPK(long hpUserId);

	List< HpUserEntity> selectAll();

	List< HpUserEntity> selectAllIsUse();

}
