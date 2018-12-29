package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司规模表
 */
@ApiModel(value="HappyCompanyScale对象",description="公司规模表")
public class HappyCompanyScaleEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司规模表id
	@ApiModelProperty(name="happyCompanyScaleId",value="公司规模表id",dataType="java.lang.Long")
	private java.lang.Long happyCompanyScaleId;
	//下限值（为0显示上限值人以下）
	@ApiModelProperty(name="lowerNum",value="下限值（为0显示上限值人以下）",dataType="java.lang.Integer")
	private java.lang.Integer lowerNum;
	//上限值（为0显示下限值人以上）
	@ApiModelProperty(name="hightNum",value="上限值（为0显示下限值人以上）",dataType="java.lang.Integer")
	private java.lang.Integer hightNum;

	public java.lang.Long getHappyCompanyScaleId() {
		return happyCompanyScaleId;
	}


	public void setHappyCompanyScaleId(java.lang.Long happyCompanyScaleId) {
		this.happyCompanyScaleId = happyCompanyScaleId;
	}


	public java.lang.Integer getLowerNum() {
		return lowerNum;
	}


	public void setLowerNum(java.lang.Integer lowerNum) {
		this.lowerNum = lowerNum;
	}


	public java.lang.Integer getHightNum() {
		return hightNum;
	}


	public void setHightNum(java.lang.Integer hightNum) {
		this.hightNum = hightNum;
	}

}