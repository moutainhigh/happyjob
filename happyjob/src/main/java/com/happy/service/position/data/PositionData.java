 package com.happy.service.position.data;

import com.happy.entity.HpPositionEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PositionData",description="招聘岗位信息封装类")
 public class PositionData extends HpPositionEntity {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(name="comName",value="公司名称")
    private String comName;
    @ApiModelProperty(name="reTotalMoney",value="总返现金额")
    private int reTotalMoney;
    @ApiModelProperty(name="countyName",value="区县名称")
    private String countyName;
    @ApiModelProperty(name="cityName",value="城市名称")
    private String cityName;
    @ApiModelProperty(name="provinceName",value="省名称")
    private String provinceName;
    @ApiModelProperty(name="lowerNum",value="工资最低值")
    private Integer lowerNum;
    @ApiModelProperty(name="hightNum",value="工资最高值")
    private Integer hightNum;
    @ApiModelProperty(name="reqGender",value="性别要求")
    private String reqGender;
    @ApiModelProperty(name="reqAge",value="年龄要求")
    private String reqAge;
    @ApiModelProperty(name="reqEducation",value="学历要求")
    private String reqEducation;
    @ApiModelProperty(name="reqSkill",value="专业技能要求")
    private String reqSkill;
    @ApiModelProperty(name="reqExp",value="工作经验要求")
    private String reqExp;
    @ApiModelProperty(name="reqWorkYears",value="工作年限要求")
    private String reqWorkYears;
    @ApiModelProperty(name="reqOther",value="其他要求")
    private String reqOther;
    @ApiModelProperty(name="comApplyNum",value="用户正在进行的非拼团申请数")
    private int comApplyNum;
    @ApiModelProperty(name="groupApplyNum",value="用户正在进行的拼团申请数")
    private int groupApplyNum;
    @ApiModelProperty(name="welfareArr",value="岗位福利名称，逗号分隔")
    private String welfareArr;
    @ApiModelProperty(name="groupSccNum",value="岗位拼团成功人数")
    private Integer groupSccNum;
    @ApiModelProperty(name="approveState",value="公司认证状态（0、未认证，1、已认证）")
    private Integer approveState;
    
    public String getComName() {
        return comName;
    }
    public void setComName(String comName) {
        this.comName = comName;
    }
    public int getReTotalMoney() {
        return reTotalMoney;
    }
    public void setReTotalMoney(int reTotalMoney) {
        this.reTotalMoney = reTotalMoney;
    }
    public String getCountyName() {
        return countyName;
    }
    public void setCountyName(String countyName) {
        this.countyName = countyName;
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
    public String getReqGender() {
        return reqGender;
    }
    public void setReqGender(String reqGender) {
        this.reqGender = reqGender;
    }
    public String getReqAge() {
        return reqAge;
    }
    public void setReqAge(String reqAge) {
        this.reqAge = reqAge;
    }
    public String getReqEducation() {
        return reqEducation;
    }
    public void setReqEducation(String reqEducation) {
        this.reqEducation = reqEducation;
    }
    public String getReqSkill() {
        return reqSkill;
    }
    public void setReqSkill(String reqSkill) {
        this.reqSkill = reqSkill;
    }
    public String getReqExp() {
        return reqExp;
    }
    public void setReqExp(String reqExp) {
        this.reqExp = reqExp;
    }
    public String getReqWorkYears() {
        return reqWorkYears;
    }
    public void setReqWorkYears(String reqWorkYears) {
        this.reqWorkYears = reqWorkYears;
    }
    public String getReqOther() {
        return reqOther;
    }
    public void setReqOther(String reqOther) {
        this.reqOther = reqOther;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getProvinceName() {
        return provinceName;
    }
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    public int getComApplyNum() {
        return comApplyNum;
    }
    public void setComApplyNum(int comApplyNum) {
        this.comApplyNum = comApplyNum;
    }
    public int getGroupApplyNum() {
        return groupApplyNum;
    }
    public void setGroupApplyNum(int groupApplyNum) {
        this.groupApplyNum = groupApplyNum;
    }
    public String getWelfareArr() {
        return welfareArr;
    }
    public void setWelfareArr(String welfareArr) {
        this.welfareArr = welfareArr;
    }
    public Integer getGroupSccNum() {
        return groupSccNum;
    }
    public void setGroupSccNum(Integer groupSccNum) {
        this.groupSccNum = groupSccNum;
    }
    public Integer getApproveState() {
        return approveState;
    }
    public void setApproveState(Integer approveState) {
        this.approveState = approveState;
    }
}
