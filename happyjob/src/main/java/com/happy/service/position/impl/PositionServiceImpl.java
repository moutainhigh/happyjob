 package com.happy.service.position.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.happy.entity.HpPositionEntity;
import com.happy.entity.HpPositionGroupEntity;
import com.happy.entity.HpPositionRefUserEntity;
import com.happy.entity.HpPositionRequireEntity;
import com.happy.entity.HpUserResumeEntity;
import com.happy.plugin.BaseMsg;
import com.happy.service.position.PositionService;
import com.happy.service.position.data.GroupData;
import com.happy.service.position.data.GroupDataMsg;
import com.happy.service.position.data.GroupListMsg;
import com.happy.service.position.data.GroupSearch;
import com.happy.service.position.data.PositionData;
import com.happy.service.position.data.PositionDetail;
import com.happy.service.position.data.PositionDetailMsg;
import com.happy.service.position.data.PositionListMsg;
import com.happy.service.position.data.PositionMsg;
import com.happy.service.position.data.PositionSearch;
import com.happy.sqlExMapper.HpPositionExMapper;
import com.happy.sqlExMapper.HpUserExMapper;
import com.happy.sqlMapper.HpPositionGroupMapper;
import com.happy.sqlMapper.HpPositionMapper;
import com.happy.sqlMapper.HpPositionRefUserMapper;
import com.happy.sqlMapper.HpPositionRequireMapper;
import com.happy.util.Util;
import com.happy.util.pubConst.Const;
import com.happy.util.pubConst.ResultMsg;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private HpPositionExMapper hpPositionExMapper;
    @Autowired
    private HpPositionMapper hpPositionMapper;
    @Autowired
    private HpUserExMapper hpUserExMapper;
    @Autowired
    private HpPositionGroupMapper hpPositionGroupMapper;
    @Autowired
    private HpPositionRefUserMapper hpPositionRefUserMapper;
    @Autowired
    private HpPositionRequireMapper hpPositionRequireMapper;
    
    @Override
    public PositionListMsg getPostionlistPage(String sid, String keyWord, String cityName, Integer posNature, Integer retOn, Integer hotOn,
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
        search.setSid(sid);
        if(!Util.isEmpty(keyWord)) { // 首页搜索
            keyWord = keyWord.trim();
            search.setKeyWord(keyWord);
        }
        
        List<PositionData> posList = this.hpPositionExMapper.getFrontPoslistPage(search);
        msg.setList(posList);
        msg.setPage(search);
        search.setSid(null);
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
         PositionData data = this.hpPositionExMapper.getFrontPosByKey(hpPositionId,sid);
         
         if(data !=null && !Util.isEmpty(sid)) {
             // 是否正在投递该岗位:普通方式
             PositionSearch search = new PositionSearch();
             search.setSid(sid);
             search.setHpPositionId(hpPositionId);
             search.setState(1);
             long curTime = Util.getDateSecond(Util.getCurrentDate());
             search.setCurTime(curTime);
             search.setPartType(1);
             int comNum = this.hpPositionExMapper.getPosNumBySearch(search);
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
    /**
     * 
     * @TODO:     验证用户是否可以进行岗位申请
     * @param partType 1、参与非拼团/发起拼团，2、参与拼团
     * @param sid
     * @param hpPositionId
     * @param hpPositionGroupId
     */
    public JSONObject confirmApply(int partType,String sid, Long hpPositionId, Long hpPositionGroupId) {
        JSONObject json = new JSONObject();
        if(partType != 1 && partType != 2) {
            json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
            json.put(Const.RESUTL_MESSAGE_MESSAGE, "参数错误：partType");
            return json;
        }
        if(partType == 1 && (hpPositionId == null || hpPositionId.compareTo(1L)<0) ) { // 非拼团申请
            json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
            json.put(Const.RESUTL_MESSAGE_MESSAGE, "参数错误：hpPositionId");
            return json;
        }
        if(partType == 2 && (hpPositionGroupId == null || hpPositionGroupId.compareTo(1L)<0) ) { // 非拼团申请
            json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
            json.put(Const.RESUTL_MESSAGE_MESSAGE, "参数错误：hpPositionGroupId");
            return json;
        }
        HpUserResumeEntity userResume = this.hpUserExMapper.getUserResumBySid(sid); // 判断用户是否已经有简历
        if(userResume == null) {
            json.put(Const.RESUTL_MESSAGE_ERRORCODE, ResultMsg.LOGIN_FILTER_RESULT_CODE_6);
            json.put(Const.RESUTL_MESSAGE_MESSAGE, ResultMsg.LOGIN_FILTER_RESULT_CONTENT_6);
            return json;
        }
        Long hpUserId = userResume.getHpUserId();
        json.put("hpUserId", hpUserId); // 用户ID
        long curTime = Util.getDateSecond(Util.getCurrentDate());
        int groupOn = 0;
        if(partType == 1) {
            
            HpPositionEntity postion = this.hpPositionExMapper.getSimplePosByKey(hpPositionId);
            if(postion == null) {
                json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
                json.put(Const.RESUTL_MESSAGE_MESSAGE, "招聘岗位信息不存在");
                return json;
            }
            long posEndTime = postion.getEndTime(); // 活动结束时间
            int delOn = postion.getDelOn();
            if(delOn == 1) {
                json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
                json.put(Const.RESUTL_MESSAGE_MESSAGE, "岗位招聘信息已被删除，请更换岗位");
                return json;
            }
            json.put("posEndTime", posEndTime);
            long posStartTime = postion.getStartTime();
            if(posStartTime>curTime || posEndTime < curTime) {
                json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
                json.put(Const.RESUTL_MESSAGE_MESSAGE, "不在岗位招聘时间内");
                return json;
            }
            groupOn = postion.getGroupOn();
        }else {
            groupOn = 1;
            HpPositionGroupEntity groupData = this.hpPositionGroupMapper.selectByPK(hpPositionGroupId);
            if(groupData == null) {
                json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
                json.put(Const.RESUTL_MESSAGE_MESSAGE, "拼团信息不存在");
                return json;
            }
            hpPositionId = groupData.getHpPositionId();
            long groupEndTime = groupData.getEndTime();
            if(groupEndTime < curTime) { // 已结束
                json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
                json.put(Const.RESUTL_MESSAGE_MESSAGE, "拼团时间已结束");
                return json;
            }
        }
        
        json.put("groupOn", groupOn); // 是否拼团职位
        PositionSearch page = new PositionSearch();
        page.setHpPositionId(hpPositionId);
        json.put("hpPositionId", hpPositionId); // 是否拼团职位
        page.setSid(sid);
        int targetPosNum = this.hpPositionExMapper.getPosNumBySearch(page); // 是否申请过该职位
        if(targetPosNum >0) {
            json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
            json.put(Const.RESUTL_MESSAGE_MESSAGE, "您已经申请过该职位，请不要重复申请");
            return json;
        }
        if(groupOn == 1) { // 拼团岗位每天一个求职者只能参加一次，拼团失效时间为三天（原型图有误需要修改
            page.setCurTime(curTime);
            page.setState(5);
            page.setHpPositionId(null);
            int groupPosNum = this.hpPositionExMapper.getGroupPosNumBySearch(page); // 获取当天已经申请的拼团岗位数量
            if(groupPosNum >0) {
                json.put(Const.RESUTL_MESSAGE_ERRORCODE, 1);
                json.put(Const.RESUTL_MESSAGE_MESSAGE, "您今天已经参与过拼团，每人每天仅可参与一次拼团");
                return json;
            }
        }
        return json;
    }
    
    @Override
    public GroupDataMsg insertUserPositionApply(String sid, Long hpPositionId) {
        // TODO 暂定单人仅可申请同一岗位一次
        GroupDataMsg msg = new GroupDataMsg();
        
        JSONObject json = this.confirmApply(1, sid, hpPositionId, null); // 判断用户是否可以申请岗位
        if(json.getIntValue(Const.RESUTL_MESSAGE_ERRORCODE) != 0) {
            msg.setErrorCode(json.getIntValue(Const.RESUTL_MESSAGE_ERRORCODE));
            msg.setMessage(json.getString(Const.RESUTL_MESSAGE_MESSAGE));
            return msg;
        }
        HpPositionRefUserEntity posUser = null;
        int groupOn = json.getIntValue("groupOn");
        int partType = 1;
        Long groupId = null;
        long curTime = Util.getDateSecond(Util.getCurrentDate());
        long hpUserId = json.getLongValue("hpUserId");
        long posEndTime = json.getLongValue("posEndTime");
        if(groupOn == 1) { // 拼团岗位每天一个求职者只能参加一次，拼团失效时间为三天（原型图有误需要修改
            HpPositionGroupEntity group = new HpPositionGroupEntity();
            group.setHpUserId(hpUserId);
            group.setGroupState(0);
            group.setHpPositionId(hpPositionId);
            group.setStartTime(curTime);
            long endTime = (curTime + Const.HP_POSITION_GROUP_MAX_AGE)>posEndTime?posEndTime:(curTime + Const.HP_POSITION_GROUP_MAX_AGE);
            group.setEndTime(endTime);
            this.hpPositionGroupMapper.insert(group); // 添加拼团发起记录
            partType = 2;
            groupId = group.getHpPositionGroupId();
            posUser = new HpPositionRefUserEntity();
            posUser.setHpPositionGroupId(groupId);
            posUser.setLeaderOn(1);
            
        }else { // 可以同时申请不同非拼团岗位
            posUser = new HpPositionRefUserEntity();
            posUser.setLeaderOn(0);
        }
        posUser.setHpPositionId(hpPositionId);
        posUser.setHpUserId(hpUserId);
        posUser.setPartTime(curTime);
        posUser.setPartType(partType);
        posUser.setWorkOn(0);
        
        this.hpPositionRefUserMapper.insert(posUser);
        GroupData data = new GroupData();
        data.setHpPositionId(hpPositionId);
        data.setHpPositionGroupId(groupId);
        msg.setData(data);
        return msg;
    }

    @Override
    public GroupDataMsg insertUserGroupApply(String sid, Long hpPositionGroupId) {
        GroupDataMsg msg = new GroupDataMsg();
        
        JSONObject json = this.confirmApply(2, sid, null, hpPositionGroupId); // 判断用户是否可以申请岗位
        if(json.getIntValue(Const.RESUTL_MESSAGE_ERRORCODE) != 0) {
            msg.setErrorCode(json.getIntValue(Const.RESUTL_MESSAGE_ERRORCODE));
            msg.setMessage(json.getString(Const.RESUTL_MESSAGE_MESSAGE));
            return msg;
        }
        Long hpUserId = json.getLong("hpUserId");
        Long hpPositionId = json.getLong("hpPositionId");
        int partNum = this.hpPositionExMapper.getGroupPartNum(hpPositionGroupId);
        long curTime = Util.getDateSecond(Util.getCurrentDate());
        HpPositionRefUserEntity posUser = new HpPositionRefUserEntity();
        posUser.setHpPositionGroupId(hpPositionGroupId);
        posUser.setHpPositionId(hpPositionId);
        posUser.setHpUserId(hpUserId);
        posUser.setLeaderOn(0);
        posUser.setPartTime(curTime);
        posUser.setPartType(2);
        posUser.setWorkOn(0);
        this.hpPositionRefUserMapper.insert(posUser);
        if(partNum + 1>=3) {
            HpPositionGroupEntity group = new HpPositionGroupEntity();
            group.setHpPositionGroupId(hpPositionGroupId);
            group.setGroupState(1);
            this.hpPositionGroupMapper.updateByPK(group);
            msg.setSendOn(1);
            if(partNum + 1==3) {
                msg.setSendOn(2);
            }
        }
        return msg;
    }

    @Override
    public PositionListMsg getBackPostionlistPage(String posName, String comName, Long startTime, Long endTime,
        Integer posState, Integer currentPage, Integer showCount) {
        
        Date curDate = Util.getCurrentDate();
        Long curTime = Util.getDateSecond(curDate);
        
        PositionListMsg msg = new PositionListMsg();
        PositionSearch page = new PositionSearch();
        page.setCurrentPage(currentPage);
        page.setShowCount(showCount);
        page.setComName(comName);
        page.setPosName(posName);
        page.setCreatStartTime(startTime);
        page.setCreatEndTime(endTime);
        page.setCurTime(curTime);
        page.setState(posState);
        
        List<PositionData> posList = this.hpPositionExMapper.getBackPoslistPage(page);
        msg.setList(posList);
        msg.setPage(page);
        return msg;
    }

    @Override
    public BaseMsg updatePositionHotOn(Long hpPositionId, Integer hotOn) {
        BaseMsg msg = new BaseMsg();
        if(hpPositionId == null || hotOn == null) {
            msg.setErrorCode(1);
            msg.setMessage("参数缺失");
        }
        HpPositionEntity position = new HpPositionEntity();
        position.setHpPositionId(hpPositionId);
        position.setHotOn(hotOn);
        this.hpPositionMapper.updateByPK(position);
        return msg;
    }

    @Override
    public PositionDetailMsg getPostionDetail(Long hpPositionId) {
        PositionDetailMsg msg = new PositionDetailMsg();
        if(hpPositionId != null) {
            msg.setData(this.hpPositionExMapper.getPosDetailByKey(hpPositionId));
        }
        return msg;
    }

    private static final String REGEX_NUMBER_STR_ARR = "([1-9],)*[1-9]";
    
    @Override
    public BaseMsg insertOrUpPosition(PositionDetail data) {
         long curTime = Util.getDateSecond(Util.getCurrentDate());
         Long hpPositionId = data.getHpPositionId();
         HpPositionEntity position = new HpPositionEntity();
         position.setHpPositionId(hpPositionId);
         position.setCarDesc(data.getCarDesc());
         position.setCarOn(data.getCarOn());
         position.setComCustPhone(data.getComCustPhone());
         position.setCountyId(data.getCountyId());
         position.setEndTime(data.getEndTime());
         position.setFiveMoney(data.getFiveMoney());
         position.setGroupOn(data.getGroupOn());
         position.setHotOn(data.getHotOn());
         position.setHpCompanyId(data.getHpCompanyId());
         position.setHpEducationId(data.getHpEducationId());
         position.setHpPositionOfferId(data.getHpPositionOfferId());
         position.setHpPositionSalaryId(data.getHpPositionSalaryId());
         position.setHpPositionTypeId(data.getHpPositionTypeId());
         position.setJobHours(data.getJobHours());
         position.setManDayNum(data.getManDayNum());
         position.setOtherWelfare(data.getOtherWelfare());
         position.setPosComDesc(data.getPosComDesc());
         position.setPosDetail(data.getPosDetail());
         position.setPosEmail(data.getPosEmail());
         position.setPosName(data.getPosName());
         position.setPosNature(data.getPosNature());
         position.setPosNum(data.getPosNum());
         position.setPosPerson(data.getPosPerson());
         position.setPosPhone(data.getPosPhone());
         position.setPosState(1);
//         position.setPosWorkYear(data.getPosWorkYear());
         position.setRetManMoney(data.getRetManMoney());
         position.setRetOn(data.getRetOn());
         position.setRetWomanMoney(data.getRetWomanMoney());
         position.setStartTime(data.getStartTime());
         position.setThreeMoney(data.getThreeMoney());
         position.setUrgentMoney(data.getUrgentMoney());
         position.setUrgentOn(data.getUrgentOn());
         position.setWelfareDetail(data.getWelfareDetail());
         position.setWelfareOn(data.getWelfareOn());
         position.setWomenDayNum(data.getWomenDayNum());
         
         if(hpPositionId == null ) { // 新增
             position.setApplyTime(curTime);
             position.setHotOn(position.getHotOn()==null?0:position.getHotOn());
             position.setDelOn(0);
             this.hpPositionMapper.insert(position);
             hpPositionId = position.getHpPositionId();
         }else {
             this.hpPositionMapper.updateByPK(position);
             // 清空福利关联表信息
             this.hpPositionExMapper.deleteGroupWelfare(hpPositionId);
         }
         
         String welfareIds = data.getWelfareArr();
         if(!Util.isEmpty(welfareIds) && welfareIds.matches(REGEX_NUMBER_STR_ARR)) { // 新增福利关联表信息
             String[] welfareIdArr = welfareIds.split(",");
             List<Long> list = new ArrayList<Long>();
             for(String str : welfareIdArr) {
                 list.add((Long)Util.typeChange(str, Long.class));
             }
             this.hpPositionExMapper.insertGroupWelfare(hpPositionId, list);
         }
         
         // 要求
         HpPositionRequireEntity require = new HpPositionRequireEntity();
         require.setHpPositionId(hpPositionId);
         require.setReqAge(data.getReqAge());
         require.setReqEducation(data.getReqEducation());
         require.setReqExp(data.getReqExp());
         require.setReqGender(data.getReqGender());
         require.setReqOther(data.getReqOther());
         require.setReqSkill(data.getReqSkill());
         require.setReqWorkYears(data.getReqWorkYears());
         Long hpPositionRequireId = this.hpPositionExMapper.getPositionRequireId(hpPositionId);
         require.setHpPositionRequireId(hpPositionRequireId);
         if(hpPositionRequireId == null) { // 新增岗位要求
             this.hpPositionRequireMapper.insert(require);
         }else {// 更新
             this.hpPositionRequireMapper.updateByPK(require);
         }
         
         return new BaseMsg();
    }

	@Override
	public BaseMsg positionDel(Long hpPositionId) {
		BaseMsg msg = new BaseMsg();
        if(hpPositionId == null ) {
            msg.setErrorCode(1);
            msg.setMessage("参数缺失");
        }
        HpPositionEntity position = new HpPositionEntity();
        position.setHpPositionId(hpPositionId);
        position.setDelOn(1);  //删除
        this.hpPositionMapper.updateByPK(position);
        return msg;
	}

//    @Override
//    public BaseMsg insertOrUpPositionTest(Long hpPositionId, String ids) {
//        if(!Util.isEmpty(ids) && ids.matches(REGEX_NUMBER_STR_ARR)) { // 新增福利关联表信息
//            String[] welfareIdArr = ids.split(",");
//            List<Long> list = new ArrayList<Long>();
//            for(String str : welfareIdArr) {
//                list.add((Long)Util.typeChange(str, Long.class));
//            }
//            this.hpPositionExMapper.insertGroupWelfare(hpPositionId, list);
//        }
//        return new BaseMsg();
//    }

}
