package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpCompanyTypeEntity;

@Repository("hpCompanyTypeMapper")
public interface HpCompanyTypeMapper{

	void insert(HpCompanyTypeEntity hpCompanyType);

	HpCompanyTypeEntity selectByPK(long hpCompanyTypeId);

	void updateByPK(HpCompanyTypeEntity hpCompanyType);

	void deleteByPK(long hpCompanyTypeId);

	List< HpCompanyTypeEntity> selectAll();

	List< HpCompanyTypeEntity> selectAllIsUse();

}
