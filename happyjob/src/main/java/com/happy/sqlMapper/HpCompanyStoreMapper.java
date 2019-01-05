package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpCompanyStoreEntity;

@Repository("hpCompanyStoreMapper")
public interface HpCompanyStoreMapper{

	void insert(HpCompanyStoreEntity hpCompanyStore);

	HpCompanyStoreEntity selectByPK(long hpCompanyStoreId);

	void updateByPK(HpCompanyStoreEntity hpCompanyStore);

	void deleteByPK(long hpCompanyStoreId);

	List< HpCompanyStoreEntity> selectAll();

	List< HpCompanyStoreEntity> selectAllIsUse();

}
