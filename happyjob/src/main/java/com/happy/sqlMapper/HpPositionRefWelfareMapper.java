package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionRefWelfareEntity;

@Repository("hpPositionRefWelfareMapper")
public interface HpPositionRefWelfareMapper{

	void insert(HpPositionRefWelfareEntity hpPositionRefWelfare);

	HpPositionRefWelfareEntity selectByPK(long hpPositionRefWelfareId);

	void updateByPK(HpPositionRefWelfareEntity hpPositionRefWelfare);

	void deleteByPK(long hpPositionRefWelfareId);

	List< HpPositionRefWelfareEntity> selectAll();

	List< HpPositionRefWelfareEntity> selectAllIsUse();

}
