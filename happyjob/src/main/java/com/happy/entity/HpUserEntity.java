package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 员工信息表
 */
@ApiModel(value="HpUser对象",description="员工信息表")
public class HpUserEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//活动背景图id
	@ApiModelProperty(name="hpUserId",value="活动背景图id",dataType="java.lang.Long")
	private java.lang.Long hpUserId;
	//企业id
	@ApiModelProperty(name="hpCompanyId",value="企业id",dataType="java.lang.Long")
	private java.lang.Long hpCompanyId;
	//账号类型（1、超级管理员，2、求职者）
	@ApiModelProperty(name="userType",value="账号类型（1、超级管理员，2、求职者）",dataType="java.lang.Integer")
	private java.lang.Integer userType;
	//用户名（数字、字母、下划线）
	@ApiModelProperty(name="userName",value="用户名（数字、字母、下划线）",dataType="String")
	private String userName;
	//密码
	@ApiModelProperty(name="password",value="密码",dataType="String")
	private String password;
	//密码加盐
	@ApiModelProperty(name="salt",value="密码加盐",dataType="String")
	private String salt;
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
	//认证状态（0、未认证，1、认证通过，2、认证不通过）
	@ApiModelProperty(name="approveState",value="认证状态（0、未认证，1、认证通过，2、认证不通过）",dataType="java.lang.Integer")
	private java.lang.Integer approveState;
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
	//注册来源（1、APP，2、小程序，3、微信，4、门店，5、邀请注册）
	@ApiModelProperty(name="registResource",value="注册来源（1、APP，2、小程序，3、微信，4、门店，5、邀请注册）",dataType="java.lang.Integer")
	private java.lang.Integer registResource;
	//邀请人ID
	@ApiModelProperty(name="inviteUserId",value="邀请人ID",dataType="java.lang.Long")
	private java.lang.Long inviteUserId;
	//账户余额
	@ApiModelProperty(name="userMoney",value="账户余额",dataType="Double")
	private Double userMoney;
	//认证申请次数
	@ApiModelProperty(name="approveNum",value="认证申请次数",dataType="java.lang.Integer")
	private java.lang.Integer approveNum;
	//是否会员
	@ApiModelProperty(name="vipOn",value="是否会员",dataType="java.lang.Integer")
	private java.lang.Integer vipOn;
	//登录token
	@ApiModelProperty(name="userToken",value="登录token",dataType="String")
	private String userToken;
	//token有效时间
	@ApiModelProperty(name="tokenTime",value="token有效时间",dataType="java.lang.Long")
	private java.lang.Long tokenTime;
	//最近登录时间
	@ApiModelProperty(name="loginTime",value="最近登录时间",dataType="java.lang.Long")
	private java.lang.Long loginTime;
	//登录ip
	@ApiModelProperty(name="loginIp",value="登录ip",dataType="String")
	private String loginIp;

	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	public java.lang.Long getHpCompanyId() {
		return hpCompanyId;
	}


	public void setHpCompanyId(java.lang.Long hpCompanyId) {
		this.hpCompanyId = hpCompanyId;
	}


	public java.lang.Integer getUserType() {
		return userType;
	}


	public void setUserType(java.lang.Integer userType) {
		this.userType = userType;
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


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
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


	public java.lang.Integer getApproveState() {
		return approveState;
	}


	public void setApproveState(java.lang.Integer approveState) {
		this.approveState = approveState;
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


	public java.lang.Long getInviteUserId() {
		return inviteUserId;
	}


	public void setInviteUserId(java.lang.Long inviteUserId) {
		this.inviteUserId = inviteUserId;
	}


	public Double getUserMoney() {
		return userMoney;
	}


	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}


	public java.lang.Integer getApproveNum() {
		return approveNum;
	}


	public void setApproveNum(java.lang.Integer approveNum) {
		this.approveNum = approveNum;
	}


	public java.lang.Integer getVipOn() {
		return vipOn;
	}


	public void setVipOn(java.lang.Integer vipOn) {
		this.vipOn = vipOn;
	}


	public String getUserToken() {
		return userToken;
	}


	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}


	public java.lang.Long getTokenTime() {
		return tokenTime;
	}


	public void setTokenTime(java.lang.Long tokenTime) {
		this.tokenTime = tokenTime;
	}


	public java.lang.Long getLoginTime() {
		return loginTime;
	}


	public void setLoginTime(java.lang.Long loginTime) {
		this.loginTime = loginTime;
	}


	public String getLoginIp() {
		return loginIp;
	}


	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

}