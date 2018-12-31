package com.happy.sqlExMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpAdvBannerEntity;
import com.happy.service.banner.data.BannerSearch;

@Repository("hpAdvBannerExMapper")
public interface HpAdvBannerExMapper{


	List<HpAdvBannerEntity> getBannerListBySearch(BannerSearch page);

	int getBannerNumBySearch(BannerSearch page);
}
