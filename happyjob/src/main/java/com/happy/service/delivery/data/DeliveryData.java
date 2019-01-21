package com.happy.service.delivery.data;

import com.happy.entity.HpPositionRefUserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="DeliveryData",description="投递信息封装类")
public class DeliveryData extends HpPositionRefUserEntity {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(name="userName",value="用户名")
    private String userName;
    @ApiModelProperty(name="realName",value="姓名")
    private String realName;
    @ApiModelProperty(name="gender",value="性别")
    private Integer gender;
    @ApiModelProperty(name="bornYear",value="年龄")
    private Integer bornYear;
    
    @ApiModelProperty(name="comName",value="公司名称")
    private String comName;
  	@ApiModelProperty(name="hpCompanyId",value="企业id")
  	private java.lang.Long hpCompanyId;
    
    @ApiModelProperty(name="posName",value="职位名称")
    private String posName;
    @ApiModelProperty(name="reMoney",value="入职返现")
    private Integer reMoney;
    @ApiModelProperty(name="partTime",value="投递时间")
    private Long partTime;
    @ApiModelProperty(name="phoneNo",value="联系方式")
    private String phoneNo;
    @ApiModelProperty(name="hpUserId",value="用户表记录id")
    private Long hpUserId;
    @ApiModelProperty(name="headerPic",value="用户表记录id")
    private String headerPic;
   
    
	public java.lang.Long getHpCompanyId() {
		return hpCompanyId;
	}


	public void setHpCompanyId(java.lang.Long hpCompanyId) {
		this.hpCompanyId = hpCompanyId;
	}


	public String getHeaderPic() {
		return headerPic;
	}


	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public Integer getGender() {
		return gender;
	}


	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getBornYear() {
		return bornYear;
	}


	public void setBornYear(Integer bornYear) {
		this.bornYear = bornYear;
	}


	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public String getPosName() {
		return posName;
	}


	public void setPosName(String posName) {
		this.posName = posName;
	}


	public Integer getReMoney() {
		return reMoney;
	}


	public void setReMoney(Integer reMoney) {
		this.reMoney = reMoney;
	}
	

	public Long getPartTime() {
		return partTime;
	}

	public void setPartTime(Long partTime) {
		this.partTime = partTime;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Long getHpUserId() {
		return hpUserId;
	}


	public void setHpUserId(Long hpUserId) {
		this.hpUserId = hpUserId;
	}


	
   
   
}
