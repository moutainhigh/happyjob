package com.happy.service.config.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.service.config.ConfigService;
import com.happy.service.config.data.EduListMsg;
import com.happy.service.config.data.SalaryListMsg;
import com.happy.sqlExMapper.HpConfigExMapper;
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

    
}
