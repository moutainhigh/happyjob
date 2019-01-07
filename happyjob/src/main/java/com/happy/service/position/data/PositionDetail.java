 package com.happy.service.position.data;

import com.happy.entity.HpPositionEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PositionDetail",description="招聘岗位信息封装类")
 public class PositionDetail extends HpPositionEntity {

    private static final long serialVersionUID = 1L;
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
    @ApiModelProperty(name="welfareIdArr",value="岗位福利ID，逗号分隔")
    private String welfareArr;
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
    public String getWelfareArr() {
        return welfareArr;
    }
    public void setWelfareArr(String welfareArr) {
        this.welfareArr = welfareArr;
    }
    
}
