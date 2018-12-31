package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpAdvBannerEntity;

@Repository("hpAdvBannerMapper")
public interface HpAdvBannerMapper{

	void insert(HpAdvBannerEntity hpAdvBanner);

	HpAdvBannerEntity selectByPK(long hpAdvBannerId);

	void updateByPK(HpAdvBannerEntity hpAdvBanner);

	void deleteByPK(long hpAdvBannerId);

	List< HpAdvBannerEntity> selectAll();

	List< HpAdvBannerEntity> selectAllIsUse();

}
