package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserSearchEntity;

@Repository("hpUserSearchMapper")
public interface HpUserSearchMapper{

	void insert(HpUserSearchEntity hpUserSearch);

	HpUserSearchEntity selectByPK(long hpUserSearchId);

	void updateByPK(HpUserSearchEntity hpUserSearch);

	void deleteByPK(long hpUserSearchId);

	List< HpUserSearchEntity> selectAll();

	List< HpUserSearchEntity> selectAllIsUse();

}
