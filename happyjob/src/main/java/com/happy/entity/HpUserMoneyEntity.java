package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 求职者余额记录表
 */
@ApiModel(value="HpUserMoney对象",description="求职者余额记录表")
public class HpUserMoneyEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//求职者余额记录表ID
	@ApiModelProperty(name="hpUserMoneyId",value="求职者余额记录表ID")
	private java.lang.Long hpUserMoneyId;
	//员工信息表id
	@ApiModelProperty(name="hpUserId",value="员工信息表id")
	private java.lang.Long hpUserId;
	//交易类型（1、收入，2、支出）
	@ApiModelProperty(name="state",value="交易类型（1、收入，2、支出）")
	private java.lang.Integer state;
	//记录时间
	@ApiModelProperty(name="createTime",value="记录时间")
	private java.lang.Long createTime;
	//操作描述
	@ApiModelProperty(name="optDesc",value="操作描述")
	private String optDesc;

	public java.lang.Long getHpUserMoneyId() {
		return hpUserMoneyId;
	}


	public void setHpUserMoneyId(java.lang.Long hpUserMoneyId) {
		this.hpUserMoneyId = hpUserMoneyId;
	}


	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	public java.lang.Integer getState() {
		return state;
	}


	public void setState(java.lang.Integer state) {
		this.state = state;
	}


	public java.lang.Long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(java.lang.Long createTime) {
		this.createTime = createTime;
	}


	public String getOptDesc() {
		return optDesc;
	}


	public void setOptDesc(String optDesc) {
		this.optDesc = optDesc;
	}

}