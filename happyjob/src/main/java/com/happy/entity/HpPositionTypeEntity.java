package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpPositionType对象",description="")
public class HpPositionTypeEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司职位招聘类型表
	@ApiModelProperty(name="hpPositionTypeId",value="公司职位招聘类型表")
	private java.lang.Long hpPositionTypeId;
	//类型名称
	@ApiModelProperty(name="typeName",value="类型名称")
	private String typeName;
	//是否启用
	@ApiModelProperty(name="useOn",value="是否启用")
	private java.lang.Integer useOn;
	//上级类型ID
	@ApiModelProperty(name="parentId",value="上级类型ID")
	private java.lang.Long parentId;

	public java.lang.Long getHpPositionTypeId() {
		return hpPositionTypeId;
	}


	public void setHpPositionTypeId(java.lang.Long hpPositionTypeId) {
		this.hpPositionTypeId = hpPositionTypeId;
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


	public java.lang.Long getParentId() {
		return parentId;
	}


	public void setParentId(java.lang.Long parentId) {
		this.parentId = parentId;
	}

}