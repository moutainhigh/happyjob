package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpPosition对象",description="")
public class HpPositionEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司招聘岗位表id
	@ApiModelProperty(name="hpPositionId",value="公司招聘岗位表id")
	private java.lang.Long hpPositionId;
	//企业id
	@ApiModelProperty(name="hpCompanyId",value="企业id")
	private java.lang.Long hpCompanyId;
	//公司职位招聘形式表
	@ApiModelProperty(name="hpPositionOfferId",value="公司职位招聘形式表")
	private java.lang.Long hpPositionOfferId;
	//区ID（工作地点）
	@ApiModelProperty(name="countyId",value="区ID（工作地点）")
	private java.lang.Long countyId;
	//公司招聘岗位月薪表ID
	@ApiModelProperty(name="hpPositionSalaryId",value="公司招聘岗位月薪表ID")
	private java.lang.Long hpPositionSalaryId;
	//学历选项表ID（-1、学历不限，0、其他）
	@ApiModelProperty(name="hpEducationId",value="学历选项表ID（-1、学历不限，0、其他）")
	private java.lang.Long hpEducationId;
	//职位名称
	@ApiModelProperty(name="posName",value="职位名称")
	private String posName;
	//入职返现金额男
	@ApiModelProperty(name="retManMoney",value="入职返现金额男")
	private java.lang.Integer retManMoney;
	//多少天后入职返现男
	@ApiModelProperty(name="manDayNum",value="多少天后入职返现男")
	private java.lang.Integer manDayNum;
	//入职返现金额女
	@ApiModelProperty(name="retWomanMoney",value="入职返现金额女")
	private java.lang.Integer retWomanMoney;
	//多少天后入职返现女
	@ApiModelProperty(name="womenDayNum",value="多少天后入职返现女")
	private java.lang.Integer womenDayNum;
	//是否开启高薪
	@ApiModelProperty(name="urgentOn",value="是否开启高薪")
	private java.lang.Integer urgentOn;
	//高薪急聘平台补贴金额
	@ApiModelProperty(name="urgentMoney",value="高薪急聘平台补贴金额")
	private java.lang.Integer urgentMoney;
	//是否是拼团岗位
	@ApiModelProperty(name="groupOn",value="是否是拼团岗位")
	private java.lang.Integer groupOn;
	//三人团奖励金额
	@ApiModelProperty(name="threeMoney",value="三人团奖励金额")
	private java.lang.Integer threeMoney;
	//五人团及以上奖励金额
	@ApiModelProperty(name="fiveMoney",value="五人团及以上奖励金额")
	private java.lang.Integer fiveMoney;
	//是否是福利岗位
	@ApiModelProperty(name="welfareOn",value="是否是福利岗位")
	private java.lang.Integer welfareOn;
	//福利岗位详情
	@ApiModelProperty(name="welfareDetail",value="福利岗位详情")
	private String welfareDetail;
	//工作时限
	@ApiModelProperty(name="jobHours",value="工作时限")
	private String jobHours;
	//公司客服
	@ApiModelProperty(name="comCustPhone",value="公司客服")
	private String comCustPhone;
	//职位行业类型ID
	@ApiModelProperty(name="hpPositionTypeId",value="职位行业类型ID")
	private java.lang.Long hpPositionTypeId;
	//基本信息
	@ApiModelProperty(name="posDetail",value="基本信息")
	private String posDetail;
	//是否有班车
	@ApiModelProperty(name="carOn",value="是否有班车")
	private java.lang.Integer carOn;
	//班车信息
	@ApiModelProperty(name="carDesc",value="班车信息")
	private String carDesc;
	//公司介绍
	@ApiModelProperty(name="posComDesc",value="公司介绍")
	private String posComDesc;
	//其他福利
	@ApiModelProperty(name="otherWelfare",value="其他福利")
	private String otherWelfare;
	//职位性质（1、实习，2、兼职，3、全职）
	@ApiModelProperty(name="posNature",value="职位性质（1、实习，2、兼职，3、全职）")
	private java.lang.Integer posNature;
	//工作经验
	@ApiModelProperty(name="posWorkYear",value="工作经验")
	private String posWorkYear;
	//开始时间
	@ApiModelProperty(name="startTime",value="开始时间")
	private java.lang.Long startTime;
	//结束时间
	@ApiModelProperty(name="endTime",value="结束时间")
	private java.lang.Long endTime;
	//招聘人数（0,、表示若干）
	@ApiModelProperty(name="posNum",value="招聘人数（0,、表示若干）")
	private java.lang.Integer posNum;
	//联系人
	@ApiModelProperty(name="posPerson",value="联系人")
	private String posPerson;
	//联系电话
	@ApiModelProperty(name="posPhone",value="联系电话")
	private String posPhone;
	//接收邮箱
	@ApiModelProperty(name="posEmail",value="接收邮箱")
	private String posEmail;
	//是否热门
	@ApiModelProperty(name="hotOn",value="是否热门")
	private java.lang.Integer hotOn;
	//是否开启入职返现
	@ApiModelProperty(name="retOn",value="是否开启入职返现")
	private java.lang.Integer retOn;
	//发布时间
	@ApiModelProperty(name="applyTime",value="发布时间")
	private java.lang.Long applyTime;
	//是否通过认证
	@ApiModelProperty(name="posState",value="是否通过认证")
	private java.lang.Integer posState;

	public java.lang.Long getHpPositionId() {
		return hpPositionId;
	}


	public void setHpPositionId(java.lang.Long hpPositionId) {
		this.hpPositionId = hpPositionId;
	}


	public java.lang.Long getHpCompanyId() {
		return hpCompanyId;
	}


	public void setHpCompanyId(java.lang.Long hpCompanyId) {
		this.hpCompanyId = hpCompanyId;
	}


	public java.lang.Long getHpPositionOfferId() {
		return hpPositionOfferId;
	}


	public void setHpPositionOfferId(java.lang.Long hpPositionOfferId) {
		this.hpPositionOfferId = hpPositionOfferId;
	}


	public java.lang.Long getCountyId() {
		return countyId;
	}


	public void setCountyId(java.lang.Long countyId) {
		this.countyId = countyId;
	}


	public java.lang.Long getHpPositionSalaryId() {
		return hpPositionSalaryId;
	}


	public void setHpPositionSalaryId(java.lang.Long hpPositionSalaryId) {
		this.hpPositionSalaryId = hpPositionSalaryId;
	}


	public java.lang.Long getHpEducationId() {
		return hpEducationId;
	}


	public void setHpEducationId(java.lang.Long hpEducationId) {
		this.hpEducationId = hpEducationId;
	}


	public String getPosName() {
		return posName;
	}


	public void setPosName(String posName) {
		this.posName = posName;
	}


	public java.lang.Integer getRetManMoney() {
		return retManMoney;
	}


	public void setRetManMoney(java.lang.Integer retManMoney) {
		this.retManMoney = retManMoney;
	}


	public java.lang.Integer getManDayNum() {
		return manDayNum;
	}


	public void setManDayNum(java.lang.Integer manDayNum) {
		this.manDayNum = manDayNum;
	}


	public java.lang.Integer getRetWomanMoney() {
		return retWomanMoney;
	}


	public void setRetWomanMoney(java.lang.Integer retWomanMoney) {
		this.retWomanMoney = retWomanMoney;
	}


	public java.lang.Integer getWomenDayNum() {
		return womenDayNum;
	}


	public void setWomenDayNum(java.lang.Integer womenDayNum) {
		this.womenDayNum = womenDayNum;
	}


	public java.lang.Integer getUrgentOn() {
		return urgentOn;
	}


	public void setUrgentOn(java.lang.Integer urgentOn) {
		this.urgentOn = urgentOn;
	}


	public java.lang.Integer getUrgentMoney() {
		return urgentMoney;
	}


	public void setUrgentMoney(java.lang.Integer urgentMoney) {
		this.urgentMoney = urgentMoney;
	}


	public java.lang.Integer getGroupOn() {
		return groupOn;
	}


	public void setGroupOn(java.lang.Integer groupOn) {
		this.groupOn = groupOn;
	}


	public java.lang.Integer getThreeMoney() {
		return threeMoney;
	}


	public void setThreeMoney(java.lang.Integer threeMoney) {
		this.threeMoney = threeMoney;
	}


	public java.lang.Integer getFiveMoney() {
		return fiveMoney;
	}


	public void setFiveMoney(java.lang.Integer fiveMoney) {
		this.fiveMoney = fiveMoney;
	}


	public java.lang.Integer getWelfareOn() {
		return welfareOn;
	}


	public void setWelfareOn(java.lang.Integer welfareOn) {
		this.welfareOn = welfareOn;
	}


	public String getWelfareDetail() {
		return welfareDetail;
	}


	public void setWelfareDetail(String welfareDetail) {
		this.welfareDetail = welfareDetail;
	}


	public String getJobHours() {
		return jobHours;
	}


	public void setJobHours(String jobHours) {
		this.jobHours = jobHours;
	}


	public String getComCustPhone() {
		return comCustPhone;
	}


	public void setComCustPhone(String comCustPhone) {
		this.comCustPhone = comCustPhone;
	}


	public java.lang.Long getHpPositionTypeId() {
		return hpPositionTypeId;
	}


	public void setHpPositionTypeId(java.lang.Long hpPositionTypeId) {
		this.hpPositionTypeId = hpPositionTypeId;
	}


	public String getPosDetail() {
		return posDetail;
	}


	public void setPosDetail(String posDetail) {
		this.posDetail = posDetail;
	}


	public java.lang.Integer getCarOn() {
		return carOn;
	}


	public void setCarOn(java.lang.Integer carOn) {
		this.carOn = carOn;
	}


	public String getCarDesc() {
		return carDesc;
	}


	public void setCarDesc(String carDesc) {
		this.carDesc = carDesc;
	}


	public String getPosComDesc() {
		return posComDesc;
	}


	public void setPosComDesc(String posComDesc) {
		this.posComDesc = posComDesc;
	}


	public String getOtherWelfare() {
		return otherWelfare;
	}


	public void setOtherWelfare(String otherWelfare) {
		this.otherWelfare = otherWelfare;
	}


	public java.lang.Integer getPosNature() {
		return posNature;
	}


	public void setPosNature(java.lang.Integer posNature) {
		this.posNature = posNature;
	}


	public String getPosWorkYear() {
		return posWorkYear;
	}


	public void setPosWorkYear(String posWorkYear) {
		this.posWorkYear = posWorkYear;
	}


	public java.lang.Long getStartTime() {
		return startTime;
	}


	public void setStartTime(java.lang.Long startTime) {
		this.startTime = startTime;
	}


	public java.lang.Long getEndTime() {
		return endTime;
	}


	public void setEndTime(java.lang.Long endTime) {
		this.endTime = endTime;
	}


	public java.lang.Integer getPosNum() {
		return posNum;
	}


	public void setPosNum(java.lang.Integer posNum) {
		this.posNum = posNum;
	}


	public String getPosPerson() {
		return posPerson;
	}


	public void setPosPerson(String posPerson) {
		this.posPerson = posPerson;
	}


	public String getPosPhone() {
		return posPhone;
	}


	public void setPosPhone(String posPhone) {
		this.posPhone = posPhone;
	}


	public String getPosEmail() {
		return posEmail;
	}


	public void setPosEmail(String posEmail) {
		this.posEmail = posEmail;
	}


	public java.lang.Integer getHotOn() {
		return hotOn;
	}


	public void setHotOn(java.lang.Integer hotOn) {
		this.hotOn = hotOn;
	}


	public java.lang.Integer getRetOn() {
		return retOn;
	}


	public void setRetOn(java.lang.Integer retOn) {
		this.retOn = retOn;
	}


	public java.lang.Long getApplyTime() {
		return applyTime;
	}


	public void setApplyTime(java.lang.Long applyTime) {
		this.applyTime = applyTime;
	}


	public java.lang.Integer getPosState() {
		return posState;
	}


	public void setPosState(java.lang.Integer posState) {
		this.posState = posState;
	}

}