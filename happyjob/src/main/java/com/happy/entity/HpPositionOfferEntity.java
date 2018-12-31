package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司职位招聘形式表
 */
@ApiModel(value="HpPositionOffer对象",description="公司职位招聘形式表")
public class HpPositionOfferEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司职位招聘形式表
	@ApiModelProperty(name="hpPositionOfferId",value="公司职位招聘形式表",dataType="java.lang.Long")
	private java.lang.Long hpPositionOfferId;
	//所少天后返现
	@ApiModelProperty(name="typeName",value="所少天后返现",dataType="String")
	private String typeName;
	//是否启用
	@ApiModelProperty(name="useOn",value="是否启用",dataType="java.lang.Integer")
	private java.lang.Integer useOn;

	public java.lang.Long getHpPositionOfferId() {
		return hpPositionOfferId;
	}


	public void setHpPositionOfferId(java.lang.Long hpPositionOfferId) {
		this.hpPositionOfferId = hpPositionOfferId;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public java.lang.Integer getUseOn() {
		return useOn;
	}


	public void setUseOn(java.lang.Integer useOn) {
		this.useOn = useOn;
	}

}