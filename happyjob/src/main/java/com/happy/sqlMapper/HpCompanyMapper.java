package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpCompanyEntity;

@Repository("hpCompanyMapper")
public interface HpCompanyMapper{

	void insert(HpCompanyEntity hpCompany);

	HpCompanyEntity selectByPK(long hpCompanyId);

	void updateByPK(HpCompanyEntity hpCompany);

	void deleteByPK(long hpCompanyId);

	List< HpCompanyEntity> selectAll();

	List< HpCompanyEntity> selectAllIsUse();

}
