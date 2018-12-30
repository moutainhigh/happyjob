package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionGroupUserEntity;

@Repository("hpPositionGroupUserMapper")
public interface HpPositionGroupUserMapper{

	void insert(HpPositionGroupUserEntity hpPositionGroupUser);

	HpPositionGroupUserEntity selectByPK(long hpPositionRefUserId);

	void updateByPK(HpPositionGroupUserEntity hpPositionGroupUser);

	void deleteByPK(long hpPositionRefUserId);

	List< HpPositionGroupUserEntity> selectAll();

	List< HpPositionGroupUserEntity> selectAllIsUse();

}
