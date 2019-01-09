 package com.happy.service.position.data;

import java.util.List;

import com.happy.entity.HpPositionGroupEntity;
import com.happy.entity.HpUserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GroupData",description="招聘岗位信息拼团封装类")
 public class GroupData extends HpPositionGroupEntity {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(name="leaderName",value="发起人用户名")
    private String leaderName;
    
    @ApiModelProperty(name="leaderPic",value="发起人头像")
    private String leaderPic;
    
    @ApiModelProperty(name="leftTime",value="剩余时间（单位s）")
    private Long leftTime;
    
    @ApiModelProperty(name="partNum",value="正在参与的人数")
    private Integer partNum;
    
    @ApiModelProperty(name="comName",value="公司名称")
    private String comName;
    
    @ApiModelProperty(name="posName",value="岗位名称")
    private String posName;
    
    @ApiModelProperty(name="lowerNum",value="下限值（为0显示上限值元/月以下）")
    private Integer lowerNum;
    
    @ApiModelProperty(name="hightNum",value="上限值（为0显示下限值元/月以上）")
    private Integer hightNum;
    
    @ApiModelProperty(name="posComDesc",value="公司介绍")
    private String posComDesc;
    
    @ApiModelProperty(name="userList",value="参与者信息列表")
    private List<HpUserEntity> userList;
    
    @ApiModelProperty(name="groupStatus",value="拼团进行状态：1、进行中，2、时间已结束")
    private Integer groupStatus;
    
    @ApiModelProperty(name="userIsPart",value="当前用户是否参与该拼团")
    private Integer userIsPart;
    
    public String getLeaderName() {
        return leaderName;
    }
    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
    public Long getLeftTime() {
        return leftTime;
    }
    public void setLeftTime(Long leftTime) {
        this.leftTime = leftTime;
    }
    public Integer getPartNum() {
        return partNum;
    }
    public void setPartNum(Integer partNum) {
        this.partNum = partNum;
    }
    public String getComName() {
        return comName;
    }
    public void setComName(String comName) {
        this.comName = comName;
    }
    public String getPosName() {
        return posName;
    }
    public void setPosName(String posName) {
        this.posName = posName;
    }
    public Integer getLowerNum() {
        return lowerNum;
    }
    public void setLowerNum(Integer lowerNum) {
        this.lowerNum = lowerNum;
    }
    public Integer getHightNum() {
        return hightNum;
    }
    public void setHightNum(Integer hightNum) {
        this.hightNum = hightNum;
    }
    public String getPosComDesc() {
        return posComDesc;
    }
    public void setPosComDesc(String posComDesc) {
        this.posComDesc = posComDesc;
    }
    public List<HpUserEntity> getUserList() {
        return userList;
    }
    public void setUserList(List<HpUserEntity> userList) {
        this.userList = userList;
    }
    public Integer getGroupStatus() {
        return groupStatus;
    }
    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }
    public Integer getUserIsPart() {
        return userIsPart;
    }
    public void setUserIsPart(Integer userIsPart) {
        this.userIsPart = userIsPart;
    }
    public String getLeaderPic() {
        return leaderPic;
    }
    public void setLeaderPic(String leaderPic) {
        this.leaderPic = leaderPic;
    }
}
