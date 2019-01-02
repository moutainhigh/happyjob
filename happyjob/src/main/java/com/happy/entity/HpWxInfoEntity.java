package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 微信token信息保存表
 */
@ApiModel(value="HpWxInfo对象",description="微信token信息保存表")
public class HpWxInfoEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//微信token信息保存表ID
	@ApiModelProperty(name="hpWxInfoId",value="微信token信息保存表ID")
	private java.lang.Long hpWxInfoId;
	//access_token
	@ApiModelProperty(name="accessToken",value="access_token")
	private String accessToken;
	//有效时间
	@ApiModelProperty(name="tokenTime",value="有效时间")
	private java.lang.Long tokenTime;

	public java.lang.Long getHpWxInfoId() {
		return hpWxInfoId;
	}


	public void setHpWxInfoId(java.lang.Long hpWxInfoId) {
		this.hpWxInfoId = hpWxInfoId;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public java.lang.Long getTokenTime() {
		return tokenTime;
	}


	public void setTokenTime(java.lang.Long tokenTime) {
		this.tokenTime = tokenTime;
	}

}