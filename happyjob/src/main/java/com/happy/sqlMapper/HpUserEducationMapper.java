package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpUserEducationEntity;

@Repository("hpUserEducationMapper")
public interface HpUserEducationMapper{

	void insert(HpUserEducationEntity hpUserEducation);

	HpUserEducationEntity selectByPK(long hpUserEducationId);

	void updateByPK(HpUserEducationEntity hpUserEducation);

	void deleteByPK(long hpUserEducationId);

	List< HpUserEducationEntity> selectAll();

	List< HpUserEducationEntity> selectAllIsUse();

}
