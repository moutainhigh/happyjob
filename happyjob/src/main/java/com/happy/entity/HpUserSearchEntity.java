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
	@ApiModelProperty(name="hpUserBoundId",value="员工信息表id",dataType="java.lang.Long")
	private java.lang.Long hpUserBoundId;
	//搜索内容
	@ApiModelProperty(name="content",value="搜索内容",dataType="String")
	private String content;
	//搜索时间
	@ApiModelProperty(name="time",value="搜索时间",dataType="java.lang.Long")
	private java.lang.Long time;
	//是否删除
	@ApiModelProperty(name="delOn",value="是否删除",dataType="java.lang.Integer")
	private java.lang.Integer delOn;
	//内容搜索次数
	@ApiModelProperty(name="num",value="内容搜索次数",dataType="java.lang.Integer")
	private java.lang.Integer num;

	public java.lang.Long getHpUserSearchId() {
		return hpUserSearchId;
	}


	public void setHpUserSearchId(java.lang.Long hpUserSearchId) {
		this.hpUserSearchId = hpUserSearchId;
	}


	public java.lang.Long getHpUserBoundId() {
		return hpUserBoundId;
	}


	public void setHpUserBoundId(java.lang.Long hpUserBoundId) {
		this.hpUserBoundId = hpUserBoundId;
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


	public java.lang.Integer getDelOn() {
		return delOn;
	}


	public void setDelOn(java.lang.Integer delOn) {
		this.delOn = delOn;
	}


	public java.lang.Integer getNum() {
		return num;
	}


	public void setNum(java.lang.Integer num) {
		this.num = num;
	}

}