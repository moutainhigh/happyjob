package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 企业招聘合作申请表
 */
@ApiModel(value="HpCompanyApply对象",description="企业招聘合作申请表")
public class HpCompanyApplyEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//企业招聘合作申请表ID
	@ApiModelProperty(name="hpCompanyApplyId",value="企业招聘合作申请表ID")
	private java.lang.Long hpCompanyApplyId;
	//姓名
	@ApiModelProperty(name="name",value="姓名")
	private String name;
	//公司名称
	@ApiModelProperty(name="comName",value="公司名称")
	private String comName;
	//联系方式（固话、手机）
	@ApiModelProperty(name="contactNum",value="联系方式（固话、手机）")
	private String contactNum;
	//职务
	@ApiModelProperty(name="position",value="职务")
	private String position;

	public java.lang.Long getHpCompanyApplyId() {
		return hpCompanyApplyId;
	}


	public void setHpCompanyApplyId(java.lang.Long hpCompanyApplyId) {
		this.hpCompanyApplyId = hpCompanyApplyId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public String getContactNum() {
		return contactNum;
	}


	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}

}