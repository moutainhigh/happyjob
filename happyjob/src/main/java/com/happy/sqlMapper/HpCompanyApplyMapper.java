package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpCompanyApplyEntity;

@Repository("hpCompanyApplyMapper")
public interface HpCompanyApplyMapper{

	void insert(HpCompanyApplyEntity hpCompanyApply);

	HpCompanyApplyEntity selectByPK(long hpCompanyApplyId);

	void updateByPK(HpCompanyApplyEntity hpCompanyApply);

	void deleteByPK(long hpCompanyApplyId);

	List< HpCompanyApplyEntity> selectAll();

	List< HpCompanyApplyEntity> selectAllIsUse();

}
