package com.happy.sqlMapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.happy.entity.HpPositionOfferEntity;

@Repository("hpPositionOfferMapper")
public interface HpPositionOfferMapper{

	void insert(HpPositionOfferEntity hpPositionOffer);

	HpPositionOfferEntity selectByPK(long hpPositionOfferId);

	void updateByPK(HpPositionOfferEntity hpPositionOffer);

	void deleteByPK(long hpPositionOfferId);

	List< HpPositionOfferEntity> selectAll();

	List< HpPositionOfferEntity> selectAllIsUse();

}
