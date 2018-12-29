package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HappyAreaProvinceEntity;

@Repository("happyAreaProvinceMapper")
public interface HappyAreaProvinceMapper{

	void insert(HappyAreaProvinceEntity happyAreaProvince);

	HappyAreaProvinceEntity selectByPK(long hpProvinceId);

	void updateByPK(HappyAreaProvinceEntity happyAreaProvince);

	void deleteByPK(long hpProvinceId);

	List< HappyAreaProvinceEntity> selectAll();

	List< HappyAreaProvinceEntity> selectAllIsUse();

}
