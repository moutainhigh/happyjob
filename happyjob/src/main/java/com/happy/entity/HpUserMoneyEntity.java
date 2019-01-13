package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpUserMoney对象",description="")
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
	//操作类型（1、作为推荐人红包）
	@ApiModelProperty(name="optType",value="操作类型（1、作为推荐人红包）")
	private java.lang.Integer optType;
	//交易金额
	@ApiModelProperty(name="money",value="交易金额")
	private Double money;

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


	public java.lang.Integer getOptType() {
		return optType;
	}


	public void setOptType(java.lang.Integer optType) {
		this.optType = optType;
	}


	public Double getMoney() {
		return money;
	}


	public void setMoney(Double money) {
		this.money = money;
	}

}