package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 员工信息表
 */
@ApiModel(value="HappyUser对象",description="员工信息表")
public class HappyUserEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//活动背景图id
	@ApiModelProperty(name="happyUserId",value="活动背景图id",dataType="java.lang.Long")
	private java.lang.Long happyUserId;
	//企业id
	@ApiModelProperty(name="happyCompanyId",value="企业id",dataType="java.lang.Long")
	private java.lang.Long happyCompanyId;
	//用户名（数字、字母、下划线）
	@ApiModelProperty(name="userName",value="用户名（数字、字母、下划线）",dataType="String")
	private String userName;
	//密码
	@ApiModelProperty(name="password",value="密码",dataType="String")
	private String password;
	//性别（1、男，2、女）
	@ApiModelProperty(name="gender",value="性别（1、男，2、女）",dataType="java.lang.Integer")
	private java.lang.Integer gender;
	//手机号码
	@ApiModelProperty(name="phoneNo",value="手机号码",dataType="String")
	private String phoneNo;
	//出生年份
	@ApiModelProperty(name="bornYear",value="出生年份",dataType="String")
	private String bornYear;
	//真实姓名
	@ApiModelProperty(name="realName",value="真实姓名",dataType="String")
	private String realName;
	//是否启用
	@ApiModelProperty(name="userOn",value="是否启用",dataType="java.lang.Integer")
	private java.lang.Integer userOn;
	//是否通过认证
	@ApiModelProperty(name="approveOn",value="是否通过认证",dataType="java.lang.Integer")
	private java.lang.Integer approveOn;
	//头像
	@ApiModelProperty(name="headerPic",value="头像",dataType="String")
	private String headerPic;
	//身份证号
	@ApiModelProperty(name="idNum",value="身份证号",dataType="String")
	private String idNum;
	//身份证正面图片
	@ApiModelProperty(name="idFrontPic",value="身份证正面图片",dataType="String")
	private String idFrontPic;
	//身份证反面图片
	@ApiModelProperty(name="idBackPic",value="身份证反面图片",dataType="String")
	private String idBackPic;
	//身份证手持图片
	@ApiModelProperty(name="idPersonPic",value="身份证手持图片",dataType="String")
	private String idPersonPic;
	//创建时间
	@ApiModelProperty(name="createTime",value="创建时间",dataType="java.lang.Long")
	private java.lang.Long createTime;
	//注册来源（1、小程序，2、APP）
	@ApiModelProperty(name="registResource",value="注册来源（1、小程序，2、APP）",dataType="java.lang.Integer")
	private java.lang.Integer registResource;

	public java.lang.Long getHappyUserId() {
		return happyUserId;
	}


	public void setHappyUserId(java.lang.Long happyUserId) {
		this.happyUserId = happyUserId;
	}


	public java.lang.Long getHappyCompanyId() {
		return happyCompanyId;
	}


	public void setHappyCompanyId(java.lang.Long happyCompanyId) {
		this.happyCompanyId = happyCompanyId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public java.lang.Integer getGender() {
		return gender;
	}


	public void setGender(java.lang.Integer gender) {
		this.gender = gender;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getBornYear() {
		return bornYear;
	}


	public void setBornYear(String bornYear) {
		this.bornYear = bornYear;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public java.lang.Integer getUserOn() {
		return userOn;
	}


	public void setUserOn(java.lang.Integer userOn) {
		this.userOn = userOn;
	}


	public java.lang.Integer getApproveOn() {
		return approveOn;
	}


	public void setApproveOn(java.lang.Integer approveOn) {
		this.approveOn = approveOn;
	}


	public String getHeaderPic() {
		return headerPic;
	}


	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}


	public String getIdNum() {
		return idNum;
	}


	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}


	public String getIdFrontPic() {
		return idFrontPic;
	}


	public void setIdFrontPic(String idFrontPic) {
		this.idFrontPic = idFrontPic;
	}


	public String getIdBackPic() {
		return idBackPic;
	}


	public void setIdBackPic(String idBackPic) {
		this.idBackPic = idBackPic;
	}


	public String getIdPersonPic() {
		return idPersonPic;
	}


	public void setIdPersonPic(String idPersonPic) {
		this.idPersonPic = idPersonPic;
	}


	public java.lang.Long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(java.lang.Long createTime) {
		this.createTime = createTime;
	}


	public java.lang.Integer getRegistResource() {
		return registResource;
	}


	public void setRegistResource(java.lang.Integer registResource) {
		this.registResource = registResource;
	}

}