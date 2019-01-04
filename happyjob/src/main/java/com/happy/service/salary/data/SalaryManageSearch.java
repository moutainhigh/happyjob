package com.happy.service.salary.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SalarySearch",description="salary搜索信息封装类")
public class SalaryManageSearch extends Page {

    @ApiModelProperty(name="workNum",value="工号")
    private String workNum;
    @ApiModelProperty(name="payName",value="姓名")
    private String payName;
    @ApiModelProperty(name="payIdNum",value="身份证")
    private String payIdNum;
    @ApiModelProperty(name="payComName",value="公司名称")
    private String payComName;
    @ApiModelProperty(name="payTime",value="工资月份")
    private Integer payTime;
    
    
	public String getWorkNum() {
		return workNum;
	}
	public void setWorkNum(String workNum) {
		this.workNum = workNum;
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
	public String getPayComName() {
		return payComName;
	}
	public void setPayComName(String payComName) {
		this.payComName = payComName;
	}
	public Integer getPayTime() {
		return payTime;
	}
	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}
    
  
}
