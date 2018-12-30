package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpCompanyScaleEntity;

@Repository("hpCompanyScaleMapper")
public interface HpCompanyScaleMapper{

	void insert(HpCompanyScaleEntity hpCompanyScale);

	HpCompanyScaleEntity selectByPK(long hpCompanyScaleId);

	void updateByPK(HpCompanyScaleEntity hpCompanyScale);

	void deleteByPK(long hpCompanyScaleId);

	List< HpCompanyScaleEntity> selectAll();

	List< HpCompanyScaleEntity> selectAllIsUse();

}
