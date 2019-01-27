package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpCompanyApply对象",description="")
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
	//是否联系
	@ApiModelProperty(name="contactOn",value="是否联系")
	private java.lang.Integer contactOn;
	//联系人名称
	@ApiModelProperty(name="optionPerson",value="联系人名称")
	private String optionPerson;
	//联系时间
	@ApiModelProperty(name="optionTime",value="联系时间")
	private java.lang.Long optionTime;
	//是否删除
	@ApiModelProperty(name="delOn",value="是否删除")
	private java.lang.Integer delOn;

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


	public java.lang.Integer getContactOn() {
		return contactOn;
	}


	public void setContactOn(java.lang.Integer contactOn) {
		this.contactOn = contactOn;
	}


	public String getOptionPerson() {
		return optionPerson;
	}


	public void setOptionPerson(String optionPerson) {
		this.optionPerson = optionPerson;
	}


	public java.lang.Long getOptionTime() {
		return optionTime;
	}


	public void setOptionTime(java.lang.Long optionTime) {
		this.optionTime = optionTime;
	}


	public java.lang.Integer getDelOn() {
		return delOn;
	}


	public void setDelOn(java.lang.Integer delOn) {
		this.delOn = delOn;
	}

}