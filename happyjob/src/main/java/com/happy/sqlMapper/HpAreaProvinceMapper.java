package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpAreaProvinceEntity;

@Repository("hpAreaProvinceMapper")
public interface HpAreaProvinceMapper{

	void insert(HpAreaProvinceEntity hpAreaProvince);

	HpAreaProvinceEntity selectByPK(long provinceId);

	void updateByPK(HpAreaProvinceEntity hpAreaProvince);

	void deleteByPK(long provinceId);

	List< HpAreaProvinceEntity> selectAll();

	List< HpAreaProvinceEntity> selectAllIsUse();

}
