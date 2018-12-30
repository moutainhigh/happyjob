package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserIntentionEntity;

@Repository("hpUserIntentionMapper")
public interface HpUserIntentionMapper{

	void insert(HpUserIntentionEntity hpUserIntention);

	HpUserIntentionEntity selectByPK(long hpUserIntentionId);

	void updateByPK(HpUserIntentionEntity hpUserIntention);

	void deleteByPK(long hpUserIntentionId);

	List< HpUserIntentionEntity> selectAll();

	List< HpUserIntentionEntity> selectAllIsUse();

}
