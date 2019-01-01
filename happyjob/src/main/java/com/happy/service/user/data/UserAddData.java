package com.happy.service.user.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserAddData对象",description="后台添加员工信息封装类")
public class UserAddData {

    @ApiModelProperty(name="userType",value="账号类型（1、超级管理员，2、求职者）")
    private java.lang.Integer userType;
    @ApiModelProperty(name="userName",value="用户名（数字、字母、下划线）")
    private String userName;
    @ApiModelProperty(name="password1",value="密码")
    private String password1;
    @ApiModelProperty(name="password2",value="确认密码")
    private String password2;
    @ApiModelProperty(name="gender",value="性别（1、男，2、女）")
    private java.lang.Integer gender;
    @ApiModelProperty(name="phoneNo",value="手机号码")
    private String phoneNo;
    @ApiModelProperty(name="bornTime",value="出生年份时间戳s")
    private Long bornTime;
    @ApiModelProperty(name="realName",value="真实姓名")
    private String realName;
    @ApiModelProperty(name="blackOn",value="是否被禁用")
    private java.lang.Integer blackOn;
    
    
    public java.lang.Integer getUserType() {
        return userType;
    }
    public void setUserType(java.lang.Integer userType) {
        this.userType = userType;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public java.lang.Integer getGender() {
        return gender;
    }
    public void setGender(java.lang.Integer gender) {
        this.gender = gender;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Long getBornTime() {
        return bornTime;
    }
    public void setBornTime(Long bornTime) {
        this.bornTime = bornTime;
    }
    public String getRealName() {
        return realName;
    }
    public void setRealName(String realName) {
        this.realName = realName;
    }
    public java.lang.Integer getBlackOn() {
        return blackOn;
    }
    public void setBlackOn(java.lang.Integer blackOn) {
        this.blackOn = blackOn;
    }
    
}
