package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpPositionRequire对象",description="")
public class HpPositionRequireEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司职位招聘要求表
	@ApiModelProperty(name="hpPositionRequireId",value="公司职位招聘要求表")
	private java.lang.Long hpPositionRequireId;
	//公司招聘岗位表id
	@ApiModelProperty(name="hpPositionId",value="公司招聘岗位表id")
	private java.lang.Long hpPositionId;
	//性别要求
	@ApiModelProperty(name="reqGender",value="性别要求")
	private String reqGender;
	//年龄要求
	@ApiModelProperty(name="reqAge",value="年龄要求")
	private String reqAge;
	//学历要求
	@ApiModelProperty(name="reqEducation",value="学历要求")
	private String reqEducation;
	//专业技能
	@ApiModelProperty(name="reqSkill",value="专业技能")
	private String reqSkill;
	//工作经验
	@ApiModelProperty(name="reqExp",value="工作经验")
	private String reqExp;
	//工作年限
	@ApiModelProperty(name="reqWorkYears",value="工作年限")
	private String reqWorkYears;
	//其他要求
	@ApiModelProperty(name="reqOther",value="其他要求")
	private String reqOther;

	public java.lang.Long getHpPositionRequireId() {
		return hpPositionRequireId;
	}


	public void setHpPositionRequireId(java.lang.Long hpPositionRequireId) {
		this.hpPositionRequireId = hpPositionRequireId;
	}


	public java.lang.Long getHpPositionId() {
		return hpPositionId;
	}


	public void setHpPositionId(java.lang.Long hpPositionId) {
		this.hpPositionId = hpPositionId;
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

}