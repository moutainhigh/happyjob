 package com.happy.plugin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  *   TODO: 返回信息公共父类
  */
 @ApiModel(value="BaseMsg",description="返回信息公共父类")
 public class BaseMsg {

     @ApiModelProperty(name="errorCode",value="错误码")
     private int errorCode = 0;
     @ApiModelProperty(name="message",value="错误码提示信息")
     private String message = "success";

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
     
     
}
