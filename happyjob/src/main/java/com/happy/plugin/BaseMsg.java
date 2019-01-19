 package com.happy.plugin;

import com.alibaba.fastjson.JSONObject;

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
     @ApiModelProperty(name="wxMsg",value="微信返回原始错误信息")
     private JSONObject wxMsg;

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

    public JSONObject getWxMsg() {
        return wxMsg;
    }

    public void setWxMsg(JSONObject wxMsg) {
        this.wxMsg = wxMsg;
    }
     
}
