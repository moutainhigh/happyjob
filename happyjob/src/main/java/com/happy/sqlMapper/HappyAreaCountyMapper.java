package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HappyAreaCountyEntity;

@Repository("happyAreaCountyMapper")
public interface HappyAreaCountyMapper{

	void insert(HappyAreaCountyEntity happyAreaCounty);

	HappyAreaCountyEntity selectByPK(long hpCountyId);

	void updateByPK(HappyAreaCountyEntity happyAreaCounty);

	void deleteByPK(long hpCountyId);

	List< HappyAreaCountyEntity> selectAll();

	List< HappyAreaCountyEntity> selectAllIsUse();

}
