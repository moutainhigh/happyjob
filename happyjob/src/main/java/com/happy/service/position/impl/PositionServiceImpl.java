 package com.happy.service.position.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.service.position.PositionService;
import com.happy.service.position.data.PositionData;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;
import com.happy.service.position.data.PositionSearch;
import com.happy.sqlExMapper.HpPositionExMapper;
import com.happy.util.Util;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private HpPositionExMapper hpPositionExMapper;
    
    @Override
    public PositionListMsg getPostionlistPage(String cityName, Integer posNature, Integer retOn, Integer hotOn,
        Integer welfareOn, Integer currentPage, Integer showCount) {
        
        Date curDate = Util.getCurrentDate();
        Long curTime = Util.getDateSecond(curDate);
        
        PositionListMsg msg = new PositionListMsg();
        
        PositionSearch search = new PositionSearch();
        search.setCurrentPage(currentPage);
        search.setShowCount(showCount);
        search.setCityName(cityName);
        search.setHotOn(hotOn);
        search.setPosNature(posNature);
        search.setRetOn(retOn);
        search.setWelfareOn(welfareOn);
        search.setCurTime(curTime);
        
        List<PositionData> posList = this.hpPositionExMapper.getFrontPoslistPage(search);
        msg.setList(posList);
        msg.setPage(search);
        return msg;
    }

    @Override
    public PositionMsg getPostion(String sid, String oid, Long hpPositionId) {
         PositionMsg msg = new PositionMsg();
         if(Util.isEmpty(hpPositionId)) {
             msg.setErrorCode(1);
             msg.setMessage("缺少参数hpPositionId");
             return msg;
         }
         PositionData data = this.hpPositionExMapper.getFrontPosByKey(hpPositionId);
         
         if(data !=null) {
             // 是否正在投递该岗位:普通方式
             PositionSearch search = new PositionSearch();
             search.setSid(sid);
             search.setHpPositionId(hpPositionId);
             search.setState(1);
             long curTime = Util.getDateSecond(Util.getCurrentDate());
             search.setCurTime(curTime);
             int comNum = this.hpPositionExMapper.getGroupPosNumBySearch(search);
             // 拼团
             int groupNum = this.hpPositionExMapper.getGroupPosNumBySearch(search);
             data.setComApplyNum(comNum);
             data.setGroupApplyNum(groupNum);
         }
         msg.setData(data);
         return msg;
    }
    

}
