package com.happy.service.salary.data;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="LoginUserMsg对象",description="联系信息")
public class LoginUserMsg extends BaseMsg{

	//用户ID
	@ApiModelProperty(name="hpUserId",value="用户ID")
	private java.lang.Long hpUserId;
	
	//手机号码
	@ApiModelProperty(name="phoneNo",value="手机号码")
	private String phoneNo;
	
	//真实姓名
	@ApiModelProperty(name="realName",value="真实姓名")
	private String realName;

	public java.lang.Long getHpUserId() {
		return hpUserId;
	}

	public void setHpUserId(java.lang.Long hpUserId) {
		this.hpUserId = hpUserId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
}
