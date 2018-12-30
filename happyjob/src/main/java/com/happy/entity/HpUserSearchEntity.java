package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 求职者搜索历史表
 */
@ApiModel(value="HpUserSearch对象",description="求职者搜索历史表")
public class HpUserSearchEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//求职者搜索历史表ID
	@ApiModelProperty(name="hpUserSearchId",value="求职者搜索历史表ID",dataType="java.lang.Long")
	private java.lang.Long hpUserSearchId;
	//员工信息表id
	@ApiModelProperty(name="hpUserId",value="员工信息表id",dataType="java.lang.Long")
	private java.lang.Long hpUserId;
	//搜索内容
	@ApiModelProperty(name="content",value="搜索内容",dataType="String")
	private String content;
	//搜索时间
	@ApiModelProperty(name="time",value="搜索时间",dataType="java.lang.Long")
	private java.lang.Long time;

	public java.lang.Long getHpUserSearchId() {
		return hpUserSearchId;
	}


	public void setHpUserSearchId(java.lang.Long hpUserSearchId) {
		this.hpUserSearchId = hpUserSearchId;
	}


	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public java.lang.Long getTime() {
		return time;
	}


	public void setTime(java.lang.Long time) {
		this.time = time;
	}

}