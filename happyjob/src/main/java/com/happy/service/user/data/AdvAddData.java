package com.happy.service.user.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="AdvAddData对象",description="后台添加广告信息封装类")
public class AdvAddData {

	@ApiModelProperty(name="userType",value="账号类型（1、超级管理员，2、求职者）")
    private java.lang.Integer userType;
    @ApiModelProperty(name="title",value="广告标题")
    private String title;
    @ApiModelProperty(name="location",value="位置")
    private String location;
    @ApiModelProperty(name="endTime",value="结束时间")
    private java.lang.Integer endTime;
    @ApiModelProperty(name="sortNum",value="排序")
    private java.lang.Integer sortNum;
    
    @ApiModelProperty(name="picUrl",value="图片地址")
    private String picUrl;
    @ApiModelProperty(name="target",value="确认密码")
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
    
}
