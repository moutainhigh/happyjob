package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 员工小程序登录信息表
 */
@ApiModel(value="HpUserBound对象",description="员工小程序登录信息表")
public class HpUserBoundEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//员工小程序登录信息表ID
	@ApiModelProperty(name="hpUserBoundId",value="员工小程序登录信息表ID",dataType="java.lang.Long")
	private java.lang.Long hpUserBoundId;
	//活动背景图id
	@ApiModelProperty(name="hpUserId",value="活动背景图id",dataType="java.lang.Long")
	private java.lang.Long hpUserId;
	//昵称
	@ApiModelProperty(name="nickName",value="昵称",dataType="String")
	private String nickName;
	//头像
	@ApiModelProperty(name="headerPic",value="头像",dataType="String")
	private String headerPic;
	//小程序用户opendID
	@ApiModelProperty(name="openid",value="小程序用户opendID",dataType="String")
	private String openid;
	//小程序用户unionid
	@ApiModelProperty(name="unionid",value="小程序用户unionid",dataType="String")
	private String unionid;
	//性别（1、男，2、女，其他保密）
	@ApiModelProperty(name="gender",value="性别（1、男，2、女，其他保密）",dataType="java.lang.Integer")
	private java.lang.Integer gender;
	//创建时间
	@ApiModelProperty(name="createTime",value="创建时间",dataType="java.lang.Long")
	private java.lang.Long createTime;
	//登录验证token
	@ApiModelProperty(name="boundToken",value="登录验证token",dataType="String")
	private String boundToken;
	//token生成时间
	@ApiModelProperty(name="tokenTime",value="token生成时间",dataType="java.lang.Long")
	private java.lang.Long tokenTime;
	//微信绑定手机号码
	@ApiModelProperty(name="boundPhone",value="微信绑定手机号码",dataType="String")
	private String boundPhone;

	public java.lang.Long getHpUserBoundId() {
		return hpUserBoundId;
	}


	public void setHpUserBoundId(java.lang.Long hpUserBoundId) {
		this.hpUserBoundId = hpUserBoundId;
	}


	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getHeaderPic() {
		return headerPic;
	}


	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}


	public String getOpenid() {
		return openid;
	}


	public void setOpenid(String openid) {
		this.openid = openid;
	}


	public String getUnionid() {
		return unionid;
	}


	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}


	public java.lang.Integer getGender() {
		return gender;
	}


	public void setGender(java.lang.Integer gender) {
		this.gender = gender;
	}


	public java.lang.Long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(java.lang.Long createTime) {
		this.createTime = createTime;
	}


	public String getBoundToken() {
		return boundToken;
	}


	public void setBoundToken(String boundToken) {
		this.boundToken = boundToken;
	}


	public java.lang.Long getTokenTime() {
		return tokenTime;
	}


	public void setTokenTime(java.lang.Long tokenTime) {
		this.tokenTime = tokenTime;
	}


	public String getBoundPhone() {
		return boundPhone;
	}


	public void setBoundPhone(String boundPhone) {
		this.boundPhone = boundPhone;
	}

}