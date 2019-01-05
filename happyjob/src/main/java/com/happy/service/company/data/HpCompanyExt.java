package com.happy.service.company.data;

import com.happy.entity.HpCompanyEntity;

import io.swagger.annotations.ApiModelProperty;

public class HpCompanyExt extends HpCompanyEntity{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(name="typeName",value="所属行业")
    private String typeName;
    @ApiModelProperty(name="lowerNum",value="下限")
    private Integer lowerNum;
    @ApiModelProperty(name="hightNum",value="上限")
    private Integer hightNum;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getLowerNum() {
		return lowerNum;
	}
	public void setLowerNum(Integer lowerNum) {
		this.lowerNum = lowerNum;
	}
	public Integer getHightNum() {
		return hightNum;
	}
	public void setHightNum(Integer hightNum) {
		this.hightNum = hightNum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}
