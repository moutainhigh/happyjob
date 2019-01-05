package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 公司门店表
 */
@ApiModel(value="HpCompanyStore对象",description="公司门店表")
public class HpCompanyStoreEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//公司门店表ID
	@ApiModelProperty(name="hpCompanyStoreId",value="公司门店表ID")
	private java.lang.Long hpCompanyStoreId;
	//姓名
	@ApiModelProperty(name="storeName",value="姓名")
	private String storeName;
	//编号
	@ApiModelProperty(name="storeNum",value="编号")
	private String storeNum;
	//固定电话
	@ApiModelProperty(name="contactNum",value="固定电话")
	private String contactNum;
	//详细地址
	@ApiModelProperty(name="storeAddr",value="详细地址")
	private String storeAddr;
	//交通指引
	@ApiModelProperty(name="storeTraffic",value="交通指引")
	private String storeTraffic;
	//店员信息（[{"name":"张三","phoneNos":"12345678901,12345678902"}]）
	@ApiModelProperty(name="clerkData",value="店员信息（[{'name':'张三','phoneNos':'12345678901,12345678902'}]）")
	private String clerkData;
	//工作时间
	@ApiModelProperty(name="workTime",value="工作时间")
	private String workTime;
	//门店识别码
	@ApiModelProperty(name="storeToken",value="门店识别码")
	private String storeToken;

	public java.lang.Long getHpCompanyStoreId() {
		return hpCompanyStoreId;
	}


	public void setHpCompanyStoreId(java.lang.Long hpCompanyStoreId) {
		this.hpCompanyStoreId = hpCompanyStoreId;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreNum() {
		return storeNum;
	}


	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}


	public String getContactNum() {
		return contactNum;
	}


	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}


	public String getStoreAddr() {
		return storeAddr;
	}


	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}


	public String getStoreTraffic() {
		return storeTraffic;
	}


	public void setStoreTraffic(String storeTraffic) {
		this.storeTraffic = storeTraffic;
	}


	public String getClerkData() {
		return clerkData;
	}


	public void setClerkData(String clerkData) {
		this.clerkData = clerkData;
	}


	public String getWorkTime() {
		return workTime;
	}


	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}


	public String getStoreToken() {
		return storeToken;
	}


	public void setStoreToken(String storeToken) {
		this.storeToken = storeToken;
	}

}