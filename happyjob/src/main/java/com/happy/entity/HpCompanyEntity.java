package com.happy.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * 
 */
@ApiModel(value="HpCompany对象",description="")
public class HpCompanyEntity implements  Serializable  {
	private static final long serialVersionUID = 1L;

	//企业id
	@ApiModelProperty(name="hpCompanyId",value="企业id")
	private java.lang.Long hpCompanyId;
	//公司名称
	@ApiModelProperty(name="comName",value="公司名称")
	private String comName;
	//公司描述
	@ApiModelProperty(name="comDesc",value="公司描述")
	private String comDesc;
	//区ID
	@ApiModelProperty(name="countyId",value="区ID")
	private java.lang.Long countyId;
	//公司行业类型表id
	@ApiModelProperty(name="hpCompanyTypeId",value="公司行业类型表id")
	private java.lang.Long hpCompanyTypeId;
	//公司规模表id
	@ApiModelProperty(name="hpCompanyScaleId",value="公司规模表id")
	private java.lang.Long hpCompanyScaleId;
	//详细地址
	@ApiModelProperty(name="addrDetail",value="详细地址")
	private String addrDetail;
	//联系人
	@ApiModelProperty(name="comtPerson",value="联系人")
	private String comtPerson;
	//联系电话
	@ApiModelProperty(name="comPhone",value="联系电话")
	private String comPhone;
	//联系邮箱
	@ApiModelProperty(name="comEmail",value="联系邮箱")
	private String comEmail;
	//公司logo
	@ApiModelProperty(name="comLogo",value="公司logo")
	private String comLogo;
	//公司营业执照
	@ApiModelProperty(name="comLicense",value="公司营业执照")
	private String comLicense;
	//添加时间
	@ApiModelProperty(name="createTime",value="添加时间")
	private java.lang.Long createTime;
	//认证状态（0、未认证，1、已认证）
	@ApiModelProperty(name="approveState",value="认证状态（0、未认证，1、已认证）")
	private java.lang.Integer approveState;
	//公司地理位置经纬度值
	@ApiModelProperty(name="comLocation",value="公司地理位置经纬度值")
	private String comLocation;
	//1:已删除，0:未删除
	@ApiModelProperty(name="delOn",value="1:已删除，0:未删除")
	private java.lang.Integer delOn;

	public java.lang.Long getHpCompanyId() {
		return hpCompanyId;
	}


	public void setHpCompanyId(java.lang.Long hpCompanyId) {
		this.hpCompanyId = hpCompanyId;
	}


	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public String getComDesc() {
		return comDesc;
	}


	public void setComDesc(String comDesc) {
		this.comDesc = comDesc;
	}


	public java.lang.Long getCountyId() {
		return countyId;
	}


	public void setCountyId(java.lang.Long countyId) {
		this.countyId = countyId;
	}


	public java.lang.Long getHpCompanyTypeId() {
		return hpCompanyTypeId;
	}


	public void setHpCompanyTypeId(java.lang.Long hpCompanyTypeId) {
		this.hpCompanyTypeId = hpCompanyTypeId;
	}


	public java.lang.Long getHpCompanyScaleId() {
		return hpCompanyScaleId;
	}


	public void setHpCompanyScaleId(java.lang.Long hpCompanyScaleId) {
		this.hpCompanyScaleId = hpCompanyScaleId;
	}


	public String getAddrDetail() {
		return addrDetail;
	}


	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}


	public String getComtPerson() {
		return comtPerson;
	}


	public void setComtPerson(String comtPerson) {
		this.comtPerson = comtPerson;
	}


	public String getComPhone() {
		return comPhone;
	}


	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}


	public String getComEmail() {
		return comEmail;
	}


	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}


	public String getComLogo() {
		return comLogo;
	}


	public void setComLogo(String comLogo) {
		this.comLogo = comLogo;
	}


	public String getComLicense() {
		return comLicense;
	}


	public void setComLicense(String comLicense) {
		this.comLicense = comLicense;
	}


	public java.lang.Long getCreateTime() {
		return createTime;
	}


	public void setCreateTime(java.lang.Long createTime) {
		this.createTime = createTime;
	}


	public java.lang.Integer getApproveState() {
		return approveState;
	}


	public void setApproveState(java.lang.Integer approveState) {
		this.approveState = approveState;
	}


	public String getComLocation() {
		return comLocation;
	}


	public void setComLocation(String comLocation) {
		this.comLocation = comLocation;
	}


	public java.lang.Integer getDelOn() {
		return delOn;
	}


	public void setDelOn(java.lang.Integer delOn) {
		this.delOn = delOn;
	}

}