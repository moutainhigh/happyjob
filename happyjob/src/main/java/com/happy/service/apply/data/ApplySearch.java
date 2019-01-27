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
    
	
   
    
}
