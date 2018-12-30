package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionWelfareEntity;

@Repository("hpPositionWelfareMapper")
public interface HpPositionWelfareMapper{

	void insert(HpPositionWelfareEntity hpPositionWelfare);

	HpPositionWelfareEntity selectByPK(long hpPositionWelfareId);

	void updateByPK(HpPositionWelfareEntity hpPositionWelfare);

	void deleteByPK(long hpPositionWelfareId);

	List< HpPositionWelfareEntity> selectAll();

	List< HpPositionWelfareEntity> selectAllIsUse();

}
