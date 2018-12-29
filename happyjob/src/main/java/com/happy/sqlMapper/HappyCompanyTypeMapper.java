package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HappyCompanyTypeEntity;

@Repository("happyCompanyTypeMapper")
public interface HappyCompanyTypeMapper{

	void insert(HappyCompanyTypeEntity happyCompanyType);

	HappyCompanyTypeEntity selectByPK(long happCompanyTypeId);

	void updateByPK(HappyCompanyTypeEntity happyCompanyType);

	void deleteByPK(long happCompanyTypeId);

	List< HappyCompanyTypeEntity> selectAll();

	List< HappyCompanyTypeEntity> selectAllIsUse();

}
