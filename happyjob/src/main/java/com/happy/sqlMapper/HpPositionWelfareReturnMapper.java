package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionWelfareReturnEntity;

@Repository("hpPositionWelfareReturnMapper")
public interface HpPositionWelfareReturnMapper{

	void insert(HpPositionWelfareReturnEntity hpPositionWelfareReturn);

	HpPositionWelfareReturnEntity selectByPK(long hpPositionWelfareReturnId);

	void updateByPK(HpPositionWelfareReturnEntity hpPositionWelfareReturn);

	void deleteByPK(long hpPositionWelfareReturnId);

	List< HpPositionWelfareReturnEntity> selectAll();

	List< HpPositionWelfareReturnEntity> selectAllIsUse();

}
