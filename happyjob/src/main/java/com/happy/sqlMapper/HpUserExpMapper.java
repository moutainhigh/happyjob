package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserExpEntity;

@Repository("hpUserExpMapper")
public interface HpUserExpMapper{

	void insert(HpUserExpEntity hpUserExp);

	HpUserExpEntity selectByPK(long hpUserExpId);

	void updateByPK(HpUserExpEntity hpUserExp);

	void deleteByPK(long hpUserExpId);

	List< HpUserExpEntity> selectAll();

	List< HpUserExpEntity> selectAllIsUse();

}
