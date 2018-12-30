package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpEducationEntity;

@Repository("hpEducationMapper")
public interface HpEducationMapper{

	void insert(HpEducationEntity hpEducation);

	HpEducationEntity selectByPK(long hpEducationId);

	void updateByPK(HpEducationEntity hpEducation);

	void deleteByPK(long hpEducationId);

	List< HpEducationEntity> selectAll();

	List< HpEducationEntity> selectAllIsUse();

}
