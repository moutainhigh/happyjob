package com.happy.service.apply.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModelProperty;

public class ApplySearch  extends Page {

    @ApiModelProperty(name="name",value="名称")
    private String name;
    
    @ApiModelProperty(name="comName",value="公司")
    private String comName;
    
    @ApiModelProperty(name="contactNum",value="联系方式")
    private String contactNum;
    
    @ApiModelProperty(name="startTime",value="开始时间")
    private Long startTime ;
    
    @ApiModelProperty(name="endTime",value="结束时间")
    private Long endTime ;
    
    @ApiModelProperty(name="contactOn",value="是否联系")
    private Integer contactOn ;
    
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
    public Integer getContactOn() {
        return contactOn;
    }
    public void setContactOn(Integer contactOn) {
        this.contactOn = contactOn;
    }
}
