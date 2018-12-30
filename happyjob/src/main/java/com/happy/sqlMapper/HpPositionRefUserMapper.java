package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionRefUserEntity;

@Repository("hpPositionRefUserMapper")
public interface HpPositionRefUserMapper{

	void insert(HpPositionRefUserEntity hpPositionRefUser);

	HpPositionRefUserEntity selectByPK(long hpPositionRefUserId);

	void updateByPK(HpPositionRefUserEntity hpPositionRefUser);

	void deleteByPK(long hpPositionRefUserId);

	List< HpPositionRefUserEntity> selectAll();

	List< HpPositionRefUserEntity> selectAllIsUse();

}
