 package com.happy.plugin;

import io.swagger.annotations.ApiModel;

/**
  *   TODO: 返回信息公共父类
  */
 @ApiModel(value="BaseMsg",description="返回信息公共父类")
 public class BaseMsg {

     private int errorCode = 0;
     
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
