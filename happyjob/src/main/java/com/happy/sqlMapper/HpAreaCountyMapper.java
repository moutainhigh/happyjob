package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpAreaCountyEntity;

@Repository("hpAreaCountyMapper")
public interface HpAreaCountyMapper{

	void insert(HpAreaCountyEntity hpAreaCounty);

	HpAreaCountyEntity selectByPK(long countyId);

	void updateByPK(HpAreaCountyEntity hpAreaCounty);

	void deleteByPK(long countyId);

	List< HpAreaCountyEntity> selectAll();

	List< HpAreaCountyEntity> selectAllIsUse();

}
