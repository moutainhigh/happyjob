package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 用户工资条表
 */
@ApiModel(value="HpUserPayroll对象",description="用户工资条表")
public class HpUserPayrollEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//用户工资条表ID
	@ApiModelProperty(name="hpUserPayrollId",value="用户工资条表ID")
	private java.lang.Long hpUserPayrollId;
	//姓名
	@ApiModelProperty(name="payName",value="姓名")
	private String payName;
	//身份证号
	@ApiModelProperty(name="payIdNum",value="身份证号")
	private String payIdNum;
	//工号
	@ApiModelProperty(name="workNum",value="工号")
	private String workNum;
	//公司名称
	@ApiModelProperty(name="payComName",value="公司名称")
	private String payComName;
	//工资月份时间
	@ApiModelProperty(name="payTime",value="工资月份时间")
	private java.lang.Long payTime;
	//应发合计
	@ApiModelProperty(name="shouldMoney",value="应发合计")
	private Double shouldMoney;
	//扣款合计
	@ApiModelProperty(name="deductionMoney",value="扣款合计")
	private Double deductionMoney;
	//实发工资
	@ApiModelProperty(name="realMoney",value="实发工资")
	private Double realMoney;
	//其他详细信息
	@ApiModelProperty(name="payDetail",value="其他详细信息")
	private String payDetail;
	//记录生成时间
	@ApiModelProperty(name="createTime",value="记录生成时间")
	private java.lang.Long createTime;

	public java.lang.Long getHpUserPayrollId() {
		return hpUserPayrollId;
	}


	public void setHpUserPayrollId(java.lang.Long hpUserPayrollId) {
		this.hpUserPayrollId = hpUserPayrollId;
	}


	public String getPayName() {
		return payName;
	}


	public void setPayName(String payName) {
		this.payName = payName;
	}


	public String getPayIdNum() {
		return payIdNum;
	}


	public void setPayIdNum(String payIdNum) {
		this.payIdNum = payIdNum;
	}


	public String getWorkNum() {
		return workNum;
	}


	public void setWorkNum(String workNum) {
		this.workNum = workNum;
	}


	public String getPayComName() {
		return payComName;
	}


	public void setPayComName(String payComName) {
		this.payComName = payComName;
	}


	public java.lang.Long getPayTime() {
		return payTime;
	}


	public void setPayTime(java.lang.Long payTime) {
		this.payTime = payTime;
	}


	public Double getShouldMoney() {
		return shouldMoney;
	}


	public void setShouldMoney(Double shouldMoney) {
		this.shouldMoney = shouldMoney;
	}


	public Double getDeductionMoney() {
		return deductionMoney;
	}


	public void setDeductionMoney(Double deductionMoney) {
		this.deductionMoney = deductionMoney;
	}


	public Double getRealMoney() {
		return realMoney;
	}


	public void setRealMoney(Double realMoney) {
		this.realMoney = realMoney;
	}


	public String getPayDetail() {
		return payDetail;
	}


	public void setPayDetail(String payDetail) {
		this.payDetail = payDetail;
	}


	public java.lang.Long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(java.lang.Long createTime) {
		this.createTime = createTime;
	}

}