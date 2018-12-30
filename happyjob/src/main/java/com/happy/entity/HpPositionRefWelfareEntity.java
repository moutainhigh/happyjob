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
	@ApiModelProperty(name="hpPositionRefWelfareId",value="公司岗位福利关联表ID",dataType="java.lang.Long")
	private java.lang.Long hpPositionRefWelfareId;
	//公司职位表id
	@ApiModelProperty(name="hpCompanyPositionId",value="公司职位表id",dataType="java.lang.Long")
	private java.lang.Long hpCompanyPositionId;
	//公司岗位福利表id
	@ApiModelProperty(name="hpPositionWelfareId",value="公司岗位福利表id",dataType="java.lang.Long")
	private java.lang.Long hpPositionWelfareId;

	public java.lang.Long getHpPositionRefWelfareId() {
		return hpPositionRefWelfareId;
	}


	public void setHpPositionRefWelfareId(java.lang.Long hpPositionRefWelfareId) {
		this.hpPositionRefWelfareId = hpPositionRefWelfareId;
	}


	public java.lang.Long getHpCompanyPositionId() {
		return hpCompanyPositionId;
	}


	public void setHpCompanyPositionId(java.lang.Long hpCompanyPositionId) {
		this.hpCompanyPositionId = hpCompanyPositionId;
	}


	public java.lang.Long getHpPositionWelfareId() {
		return hpPositionWelfareId;
	}


	public void setHpPositionWelfareId(java.lang.Long hpPositionWelfareId) {
		this.hpPositionWelfareId = hpPositionWelfareId;
	}

}