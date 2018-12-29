package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HappyCompanyEntity;

@Repository("happyCompanyMapper")
public interface HappyCompanyMapper{

	void insert(HappyCompanyEntity happyCompany);

	HappyCompanyEntity selectByPK(long happyCompanyId);

	void updateByPK(HappyCompanyEntity happyCompany);

	void deleteByPK(long happyCompanyId);

	List< HappyCompanyEntity> selectAll();

	List< HappyCompanyEntity> selectAllIsUse();

}
