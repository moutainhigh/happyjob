package com.happy.service.delivery.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModelProperty;

public class DeliverySearch  extends Page {
 
		@ApiModelProperty(name="userName",value="用户名")
	    private String userName;
		@ApiModelProperty(name="comName",value="公司名称")
		private String comName;
		@ApiModelProperty(name="posName",value="职位名称")
	    private String posName;
		@ApiModelProperty(name="startTime",value="投递时间")
		private Long startTime;
		@ApiModelProperty(name="endTime",value="投递时间")
		private Long endTime;
		 
	    @ApiModelProperty(name="realName",value="姓名")
	    private String realName;
	    @ApiModelProperty(name="gender",value="性别")
	    private Integer gender;
	    @ApiModelProperty(name="contactStat",value="联系状态")
	    private String contactStat;
	    
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
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
		public String getContactStat() {
			return contactStat;
		}
		public void setContactStat(String contactStat) {
			this.contactStat = contactStat;
		}
		
	    
	  
}
