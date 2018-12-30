package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpAreaCityEntity;

@Repository("hpAreaCityMapper")
public interface HpAreaCityMapper{

	void insert(HpAreaCityEntity hpAreaCity);

	HpAreaCityEntity selectByPK(long cityId);

	void updateByPK(HpAreaCityEntity hpAreaCity);

	void deleteByPK(long cityId);

	List< HpAreaCityEntity> selectAll();

	List< HpAreaCityEntity> selectAllIsUse();

}
