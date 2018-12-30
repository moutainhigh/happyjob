package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserRecommendEntity;

@Repository("hpUserRecommendMapper")
public interface HpUserRecommendMapper{

	void insert(HpUserRecommendEntity hpUserRecommend);

	HpUserRecommendEntity selectByPK(long hpUserRecommendId);

	void updateByPK(HpUserRecommendEntity hpUserRecommend);

	void deleteByPK(long hpUserRecommendId);

	List< HpUserRecommendEntity> selectAll();

	List< HpUserRecommendEntity> selectAllIsUse();

}
