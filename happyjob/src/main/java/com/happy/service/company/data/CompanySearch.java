package com.happy.service.company.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModelProperty;

public class CompanySearch extends Page {

    @ApiModelProperty(name="comName",value="公司名称")
    private String comName;
    @ApiModelProperty(name="startTime",value="开始时间")
    private Long startTime;
    @ApiModelProperty(name="endTime",value="结束时间")
    private Long endTime;
    
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
   
    
    
    
    
    

}
