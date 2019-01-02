package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司规模表
 */
@ApiModel(value="HpCompanyScale对象",description="公司规模表")
public class HpCompanyScaleEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司规模表id
	@ApiModelProperty(name="hpCompanyScaleId",value="公司规模表id")
	private java.lang.Long hpCompanyScaleId;
	//下限值（为0显示上限值人以下）
	@ApiModelProperty(name="lowerNum",value="下限值（为0显示上限值人以下）")
	private java.lang.Integer lowerNum;
	//上限值（为0显示下限值人以上）
	@ApiModelProperty(name="hightNum",value="上限值（为0显示下限值人以上）")
	private java.lang.Integer hightNum;

	public java.lang.Long getHpCompanyScaleId() {
		return hpCompanyScaleId;
	}


	public void setHpCompanyScaleId(java.lang.Long hpCompanyScaleId) {
		this.hpCompanyScaleId = hpCompanyScaleId;
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