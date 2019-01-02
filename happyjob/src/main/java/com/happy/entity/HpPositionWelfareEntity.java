package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司岗位福利表
 */
@ApiModel(value="HpPositionWelfare对象",description="公司岗位福利表")
public class HpPositionWelfareEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司岗位福利表id
	@ApiModelProperty(name="hpPositionWelfareId",value="公司岗位福利表id")
	private java.lang.Long hpPositionWelfareId;
	//福利名称
	@ApiModelProperty(name="welfareName",value="福利名称")
	private String welfareName;
	//是否启用
	@ApiModelProperty(name="useOn",value="是否启用")
	private java.lang.Integer useOn;

	public java.lang.Long getHpPositionWelfareId() {
		return hpPositionWelfareId;
	}


	public void setHpPositionWelfareId(java.lang.Long hpPositionWelfareId) {
		this.hpPositionWelfareId = hpPositionWelfareId;
	}


	public String getWelfareName() {
		return welfareName;
	}


	public void setWelfareName(String welfareName) {
		this.welfareName = welfareName;
	}


	public java.lang.Integer getUseOn() {
		return useOn;
	}


	public void setUseOn(java.lang.Integer useOn) {
		this.useOn = useOn;
	}

}