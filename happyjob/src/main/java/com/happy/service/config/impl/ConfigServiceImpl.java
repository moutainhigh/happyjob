package com.happy.service.config.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpCompanyStoreEntity;
import com.happy.plugin.Page;
import com.happy.service.config.ConfigService;
import com.happy.service.config.data.EduListMsg;
import com.happy.service.config.data.SalaryListMsg;
import com.happy.service.config.data.StoreDataMsg;
import com.happy.service.config.data.StoreListMsg;
import com.happy.sqlExMapper.HpConfigExMapper;
import com.happy.sqlMapper.HpCompanyStoreMapper;
import com.happy.sqlMapper.HpPositionSalaryMapper;
/**
 *
 *   TODO: 数据库中一些配置表数据操作处理
 *  @CreateTime  : 2019年1月2日下午8:17:18
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private HpConfigExMapper hpConfigExMapper;
    @Autowired
    private HpPositionSalaryMapper hpPositionSalaryMapper;
    @Autowired
    private HpCompanyStoreMapper hpCompanyStoreMapper;
    
    @Override
    public EduListMsg getEduList(int useOn) {
        EduListMsg msg = new EduListMsg();
        msg.setData(this.hpConfigExMapper.getUseEduList(useOn));
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
    
}
