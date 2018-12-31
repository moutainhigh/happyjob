
package com.happy.util.sms;

/**
 * https://zz.253.com/v5.html#/api_doc
 */
public class Zz253Response {

    public  static final  String okCode ="0";//提交成功
    private String code; // 状态码
    private String msgId; // 消息Id
    private String errorMsg; // 失败状态码说明（成功返回空）
    private String time;// 响应时间

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Zz253Response [code=" + code + ", msgId=" + msgId + ", errorMsg=" + errorMsg + ", time=" + time + "]";
    }

}
