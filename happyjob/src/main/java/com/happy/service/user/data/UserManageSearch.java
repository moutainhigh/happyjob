 package com.happy.service.user.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserManageSearch",description="用户搜索信息封装类")
public class UserManageSearch extends Page {

    @ApiModelProperty(name="phoneNo",value="用户手机号")
    private String phoneNo;
    @ApiModelProperty(name="resource",value="用户注册来源")
    private Integer resource;
    @ApiModelProperty(name="startTime",value="注册时间开始")
    private Long startTime;
    @ApiModelProperty(name="endTime",value="注册时间截止")
    private Long endTime;
    @ApiModelProperty(name="blackOn",value="用户是否被禁用")
    private Integer blackOn;
    @ApiModelProperty(name="userType",value="用户是否被禁用")
    private Integer userType;
    
    
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Integer getResource() {
        return resource;
    }
    public void setResource(Integer resource) {
        this.resource = resource;
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
    public Integer getBlackOn() {
        return blackOn;
    }
    public void setBlackOn(Integer blackOn) {
        this.blackOn = blackOn;
    }
    public Integer getUserType() {
        return userType;
    }
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
