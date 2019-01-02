package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserResumeEntity;

@Repository("hpUserResumeMapper")
public interface HpUserResumeMapper{

	void insert(HpUserResumeEntity hpUserResume);

	HpUserResumeEntity selectByPK(long hpUserResumeId);

	void updateByPK(HpUserResumeEntity hpUserResume);

	void deleteByPK(long hpUserResumeId);

	List< HpUserResumeEntity> selectAll();

	List< HpUserResumeEntity> selectAllIsUse();

}
