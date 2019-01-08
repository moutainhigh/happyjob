package com.happy.service.config.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpCompanyStoreEntity;
import com.happy.plugin.Page;
import com.happy.service.company.data.CompanyListMsg;
import com.happy.service.config.ConfigService;
import com.happy.service.config.data.AreaListMsg;
import com.happy.service.config.data.AreaSearch;
import com.happy.service.config.data.EduListMsg;
import com.happy.service.config.data.PosOfferListMsg;
import com.happy.service.config.data.PosTypeListMsg;
import com.happy.service.config.data.SalaryListMsg;
import com.happy.service.config.data.StoreDataMsg;
import com.happy.service.config.data.StoreListMsg;
import com.happy.service.config.data.WelfareListMsg;
import com.happy.sqlExMapper.HpConfigExMapper;
import com.happy.sqlMapper.HpCompanyStoreMapper;
import com.happy.sqlMapper.HpPositionOfferMapper;
import com.happy.sqlMapper.HpPositionSalaryMapper;
import com.happy.sqlMapper.HpPositionTypeMapper;
import com.happy.sqlMapper.HpPositionWelfareMapper;
/**
 *
 *   TODO: 数据库中一些配置表数据操作处理
 *  @CreateTime  : 2019年1月2日下午8:17:18
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    
    public static final int AREA_CODE_0 = 0;
    public static final int AREA_CODE_1 = 1;
    public static final int AREA_CODE_2 = 2;

    @Autowired
    private HpConfigExMapper hpConfigExMapper;
    @Autowired
    private HpPositionSalaryMapper hpPositionSalaryMapper;
    @Autowired
    private HpCompanyStoreMapper hpCompanyStoreMapper;
    @Autowired
    private HpPositionWelfareMapper hpPositionWelfareMapper;
    @Autowired
    private HpPositionTypeMapper hpPositionTypeMapper;
    @Autowired
    private HpPositionOfferMapper hpPositionOfferMapper;
    
    @Override
    public EduListMsg getEduList(int useOn) {
        EduListMsg msg = new EduListMsg();
        msg.setList(this.hpConfigExMapper.getUseEduList(useOn));
        return msg;
    }

    @Override
    public SalaryListMsg getSalaryList() {
        SalaryListMsg msg = new SalaryListMsg();
        msg.setList(this.hpPositionSalaryMapper.selectAll());
        
        return msg;
    }

    @Override
    public StoreListMsg getStoreListPage(int isPage, Integer currentPage, Integer showCount) {
        StoreListMsg msg = new StoreListMsg();
        Page page = new Page();
        if(isPage == 1) {
            page.setIsPage(isPage);
            page.setCurrentPage(currentPage);
            page.setShowCount(showCount);
            int totalCount = this.hpConfigExMapper.getStoreNum();
            page.setTotalResult(totalCount);
        }
        List<HpCompanyStoreEntity> list = this.hpConfigExMapper.getStoreList(page);
        msg.setList(list);
        msg.setPage(page);
        return msg;
    }

    @Override
    public StoreDataMsg getStoreDetail(Long hpCompanyStoreId) {
        StoreDataMsg msg = new StoreDataMsg();
        if(hpCompanyStoreId !=null) {
            HpCompanyStoreEntity data = this.hpCompanyStoreMapper.selectByPK(hpCompanyStoreId);
            msg.setData(data);
        }
        
        return msg;
    }

    @Override
    public WelfareListMsg getPositionWelfare() {
        WelfareListMsg msg = new WelfareListMsg();
        msg.setList(this.hpPositionWelfareMapper.selectAll());
        return msg;
    }

    @Override
    public AreaListMsg getAreaList(int areaCode, Long areaId) {
        AreaListMsg msg = new AreaListMsg();
        AreaSearch page = new AreaSearch();
        if(areaCode == AREA_CODE_1) {
            page.setProvinceId(areaId);
        }else if(areaCode == AREA_CODE_2) {
            page.setCityId(areaId);
        }
        msg.setList(this.hpConfigExMapper.getAreaList(page));
        msg.setPage(page);
        return msg;
    }

    @Override
    public PosTypeListMsg getPosTypeList() {
        PosTypeListMsg msg = new PosTypeListMsg();
        msg.setList(this.hpPositionTypeMapper.selectAll());
        return msg;
    }

    @Override
    public PosOfferListMsg getPosOfferList() {
        PosOfferListMsg msg = new PosOfferListMsg();
        msg.setList(this.hpPositionOfferMapper.selectAll());
        return msg;
    }

    @Override
    public CompanyListMsg getPosCompanyList() {
        CompanyListMsg msg = new CompanyListMsg();
        msg.setList(this.hpConfigExMapper.getCompanyList());
        
        return msg;
    }
    
}
