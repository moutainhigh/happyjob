package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HappyAreaCityEntity;

@Repository("happyAreaCityMapper")
public interface HappyAreaCityMapper{

	void insert(HappyAreaCityEntity happyAreaCity);

	HappyAreaCityEntity selectByPK(long hpCityId);

	void updateByPK(HappyAreaCityEntity happyAreaCity);

	void deleteByPK(long hpCityId);

	List< HappyAreaCityEntity> selectAll();

	List< HappyAreaCityEntity> selectAllIsUse();

}
