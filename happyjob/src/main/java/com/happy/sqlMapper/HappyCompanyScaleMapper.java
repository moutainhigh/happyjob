package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HappyCompanyScaleEntity;

@Repository("happyCompanyScaleMapper")
public interface HappyCompanyScaleMapper{

	void insert(HappyCompanyScaleEntity happyCompanyScale);

	HappyCompanyScaleEntity selectByPK(long happyCompanyScaleId);

	void updateByPK(HappyCompanyScaleEntity happyCompanyScale);

	void deleteByPK(long happyCompanyScaleId);

	List< HappyCompanyScaleEntity> selectAll();

	List< HappyCompanyScaleEntity> selectAllIsUse();

}
