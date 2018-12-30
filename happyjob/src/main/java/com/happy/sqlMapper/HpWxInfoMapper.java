package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpWxInfoEntity;

@Repository("hpWxInfoMapper")
public interface HpWxInfoMapper{

	void insert(HpWxInfoEntity hpWxInfo);

	HpWxInfoEntity selectByPK(long hpWxInfoId);

	void updateByPK(HpWxInfoEntity hpWxInfo);

	void deleteByPK(long hpWxInfoId);

	List< HpWxInfoEntity> selectAll();

	List< HpWxInfoEntity> selectAllIsUse();

}
