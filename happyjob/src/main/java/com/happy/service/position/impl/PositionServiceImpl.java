 package com.happy.service.position.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happy.entity.HpPositionEntity;
import com.happy.service.position.PositionService;
import com.happy.service.position.data.GroupData;
import com.happy.service.position.data.GroupDataMsg;
import com.happy.service.position.data.GroupListMsg;
import com.happy.service.position.data.GroupSearch;
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
    public PositionListMsg getPostionlistPage(String oid, String keyWord, String cityName, Integer posNature, Integer retOn, Integer hotOn,
        Integer welfareOn, Integer urgentOn, Integer groupOn, Integer currentPage, Integer showCount) {
        
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
        search.setUrgentOn(urgentOn);
        search.setGroupOn(groupOn);
        if(!Util.isEmpty(keyWord)) { // 首页搜索
            keyWord = keyWord.trim();
            search.setKeyWord(keyWord);
        }
        
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
    
    @Override
    public GroupListMsg getGrouplistPage(String sid, Long hpPositionId, int isPage, Integer currentPage,
        Integer showCount) {
        GroupListMsg msg = new GroupListMsg();
        GroupSearch page = new GroupSearch();
        Date curDate = Util.getCurrentDate();
        Long curTime = Util.getDateSecond(curDate);
        page.setCurTime(curTime);
        page.setHpPositionId(hpPositionId);
        if(isPage == 1) {
            
            page.setCurrentPage(currentPage);
            page.setShowCount(showCount);
            page.setIsPage(isPage);
            int totalCount = this.hpPositionExMapper.getGroupNumBySearch(page);
            page.setTotalResult(totalCount);
        }
        List<GroupData> list = this.hpPositionExMapper.getGroupListBySearch(page);
        msg.setList(list);
        msg.setPage(page);
        return msg;
    }

    @Override
    public GroupDataMsg getGroupDetail(String sid, Long hpPositionGroupId) {
        GroupDataMsg msg = new GroupDataMsg();
        Long curTime = Util.getDateSecond(Util.getCurrentDate());
        GroupData data = this.hpPositionExMapper.getGroupDetail(sid, hpPositionGroupId, curTime);
        if(data == null) {
            msg.setErrorCode(1);
            msg.setMessage("要查看拼团信息不存在");
            return msg;
        }
        msg.setData(data);
        return msg;
    }

    @Override
    public GroupDataMsg insertUserPostionApply(String sid, Long hpPositionId) {
        // TODO 暂定单人仅可申请同一岗位一次
        GroupDataMsg msg = new GroupDataMsg();
        if(hpPositionId == null) {
            msg.setErrorCode(1);
            msg.setMessage("参数错误：hpPositionId为空");
            return msg;
        }
        HpPositionEntity postion = this.hpPositionExMapper.getSimplePosByKey(hpPositionId);
        if(postion == null) {
            msg.setErrorCode(1);
            msg.setMessage("招聘岗位信息不存在");
            return msg;
        }
        int groupOn = postion.getGroupOn();
        Long curTime = Util.getDateSecond(Util.getCurrentDate());
        if(groupOn == 1) { // 拼团岗位每天一个求职者只能参加一次，拼团失效时间为三天（原型图有误需要修改
            
        }else { // 可以同时申请不同非拼团岗位
            
        }
        
        return null;
    }

}
