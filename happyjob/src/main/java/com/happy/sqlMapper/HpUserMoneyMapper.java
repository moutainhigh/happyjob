package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserMoneyEntity;

@Repository("hpUserMoneyMapper")
public interface HpUserMoneyMapper{

	void insert(HpUserMoneyEntity hpUserMoney);

	HpUserMoneyEntity selectByPK(long hpUserMoneyId);

	void updateByPK(HpUserMoneyEntity hpUserMoney);

	void deleteByPK(long hpUserMoneyId);

	List< HpUserMoneyEntity> selectAll();

	List< HpUserMoneyEntity> selectAllIsUse();

}
