package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpUserResume对象",description="")
public class HpUserResumeEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//求职者简历表ID
	@ApiModelProperty(name="hpUserResumeId",value="求职者简历表ID")
	private java.lang.Long hpUserResumeId;
	//活动背景图id
	@ApiModelProperty(name="hpUserId",value="活动背景图id")
	private java.lang.Long hpUserId;
	//学历选项表ID
	@ApiModelProperty(name="hpEducationId",value="学历选项表ID")
	private java.lang.Long hpEducationId;
	//头像图片
	@ApiModelProperty(name="resPic",value="头像图片")
	private String resPic;
	//姓名
	@ApiModelProperty(name="resName",value="姓名")
	private String resName;
	//性别（1、男，2、女）
	@ApiModelProperty(name="resGender",value="性别（1、男，2、女）")
	private java.lang.Integer resGender;
	//出生时间
	@ApiModelProperty(name="resBornTime",value="出生时间")
	private java.lang.Long resBornTime;
	//手机号码
	@ApiModelProperty(name="resPhone",value="手机号码")
	private String resPhone;
	//创建时间
	@ApiModelProperty(name="resTime",value="创建时间")
	private java.lang.Long resTime;

	public java.lang.Long getHpUserResumeId() {
		return hpUserResumeId;
	}


	public void setHpUserResumeId(java.lang.Long hpUserResumeId) {
		this.hpUserResumeId = hpUserResumeId;
	}


	public java.lang.Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	public java.lang.Long getHpEducationId() {
		return hpEducationId;
	}


	public void setHpEducationId(java.lang.Long hpEducationId) {
		this.hpEducationId = hpEducationId;
	}


	public String getResPic() {
		return resPic;
	}


	public void setResPic(String resPic) {
		this.resPic = resPic;
	}


	public String getResName() {
		return resName;
	}


	public void setResName(String resName) {
		this.resName = resName;
	}


	public java.lang.Integer getResGender() {
		return resGender;
	}


	public void setResGender(java.lang.Integer resGender) {
		this.resGender = resGender;
	}


	public java.lang.Long getResBornTime() {
		return resBornTime;
	}


	public void setResBornTime(java.lang.Long resBornTime) {
		this.resBornTime = resBornTime;
	}


	public String getResPhone() {
		return resPhone;
	}


	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}


	public java.lang.Long getResTime() {
		return resTime;
	}


	public void setResTime(java.lang.Long resTime) {
		this.resTime = resTime;
	}

}