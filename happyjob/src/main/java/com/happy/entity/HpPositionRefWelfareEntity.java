package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司岗位福利关联表
 */
@ApiModel(value="HpPositionRefWelfare对象",description="公司岗位福利关联表")
public class HpPositionRefWelfareEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司岗位福利关联表ID
	@ApiModelProperty(name="hpPositionRefWelfareId",value="公司岗位福利关联表ID")
	private java.lang.Long hpPositionRefWelfareId;
	//招聘岗位表id
	@ApiModelProperty(name="hpPositionId",value="招聘岗位表id")
	private java.lang.Long hpPositionId;
	//公司岗位福利表id
	@ApiModelProperty(name="hpPositionWelfareId",value="公司岗位福利表id")
	private java.lang.Long hpPositionWelfareId;

	public java.lang.Long getHpPositionRefWelfareId() {
		return hpPositionRefWelfareId;
	}


	public void setHpPositionRefWelfareId(java.lang.Long hpPositionRefWelfareId) {
		this.hpPositionRefWelfareId = hpPositionRefWelfareId;
	}


	public java.lang.Long getHpPositionId() {
		return hpPositionId;
	}


	public void setHpPositionId(java.lang.Long hpPositionId) {
		this.hpPositionId = hpPositionId;
	}


	public java.lang.Long getHpPositionWelfareId() {
		return hpPositionWelfareId;
	}


	public void setHpPositionWelfareId(java.lang.Long hpPositionWelfareId) {
		this.hpPositionWelfareId = hpPositionWelfareId;
	}

}