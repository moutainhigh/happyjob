package com.happy.sqlExMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.happy.entity.HpCompanyStoreEntity;
import com.happy.entity.HpEducationEntity;
import com.happy.plugin.Page;
import com.happy.service.config.data.AreaData;
import com.happy.service.config.data.AreaSearch;

@Repository("hpConfigExMapper")
public interface HpConfigExMapper{
    /**
     * @TODO:     描述一下这个方法是干什么的
     */
	List<HpEducationEntity> getUseEduList(@Param("useOn") Integer useOn);
    /**
     * @TODO:     描述一下这个方法是干什么的
     */
	List<HpCompanyStoreEntity> getStoreList(Page page);
	/**
	 * @TODO:     描述一下这个方法是干什么的
	 */
	int getStoreNum();
	/**
     * @TODO:     描述一下这个方法是干什么的
     */
	Long getStoreIdByToken(@Param("storeToken") String storeToken);
	/**
     * @TODO:     描述一下这个方法是干什么的
     */
	List<AreaData> getAreaList(AreaSearch page);
}

