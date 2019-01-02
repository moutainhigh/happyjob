package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司招聘岗位月薪表
 */
@ApiModel(value="HpPositionSalary对象",description="公司招聘岗位月薪表")
public class HpPositionSalaryEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司招聘岗位月薪表ID
	@ApiModelProperty(name="hpPositionSalaryId",value="公司招聘岗位月薪表ID")
	private java.lang.Long hpPositionSalaryId;
	//下限值（为0显示上限值元/月以下）
	@ApiModelProperty(name="lowerNum",value="下限值（为0显示上限值元/月以下）")
	private java.lang.Integer lowerNum;
	//上限值（为0显示下限值元/月以上）
	@ApiModelProperty(name="hightNum",value="上限值（为0显示下限值元/月以上）")
	private java.lang.Integer hightNum;

	public java.lang.Long getHpPositionSalaryId() {
		return hpPositionSalaryId;
	}


	public void setHpPositionSalaryId(java.lang.Long hpPositionSalaryId) {
		this.hpPositionSalaryId = hpPositionSalaryId;
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