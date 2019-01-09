/**
 * @CreateTime: sunning2018年12月31日
 * @CreateUser: sunning
 * @Copyright: http://www.yugyg.com 无锡愚公网络科技有限公司 Inc. All rights reserved.
 */

package com.happy.util.excel;

import com.alibaba.fastjson.JSONObject;

/**
 * @author sunning
 * @date 2019/12/31
 */
public class PayrollPojo {
    public static final String dateFormat ="Date";

    // 姓名
    @PayrollProperty(name = "姓名")
    private String payName;
    // 身份证号
    @PayrollProperty(name = "身份证")
    private String payIdNum;
    // 工号
    @PayrollProperty(name = "工号")
    private String workNum;
    // 公司名称
    @PayrollProperty(name = "公司名称")
    private String payComName;
    // 工资月份时间
    @PayrollProperty(name = "工资月份",format ="Date")
    private java.lang.Long payTime;
    // 应发合计
    @PayrollProperty(name = "应发合计",format ="Double")
    private Double shouldMoney;
    // 扣款合计
    @PayrollProperty(name = "扣款合计",format ="Double")
    private Double deductionMoney;
    // 实发工资
    @PayrollProperty(name = "实发工资",format ="Double")
    private Double realMoney;
    // 其他详细信息 json格式
    private JSONObject payDetail = new JSONObject();

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayIdNum() {
        return payIdNum;
    }

    public void setPayIdNum(String payIdNum) {
        this.payIdNum = payIdNum;
    }

    public String getWorkNum() {
        return workNum;
    }

    public void setWorkNum(String workNum) {
        this.workNum = workNum;
    }

    public String getPayComName() {
        return payComName;
    }

    public void setPayComName(String payComName) {
        this.payComName = payComName;
    }

    public java.lang.Long getPayTime() {
        return payTime;
    }

    public void setPayTime(java.lang.Long payTime) {
        this.payTime = payTime;
    }

    public Double getShouldMoney() {
        return shouldMoney;
    }

    public void setShouldMoney(Double shouldMoney) {
        this.shouldMoney = shouldMoney;
    }

    public Double getDeductionMoney() {
        return deductionMoney;
    }

    public void setDeductionMoney(Double deductionMoney) {
        this.deductionMoney = deductionMoney;
    }

    public Double getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(Double realMoney) {
        this.realMoney = realMoney;
    }

    public JSONObject getPayDetail() {
        return payDetail;
    }

    public void setPayDetail(JSONObject payDetail) {
        this.payDetail = payDetail;
    }

    @Override
    public String toString() {
        return "PayrollPojo [payName=" + payName + ", payIdNum=" + payIdNum + ", workNum=" + workNum + ", payComName="
            + payComName + ", payTime=" + payTime + ", shouldMoney=" + shouldMoney + ", deductionMoney="
            + deductionMoney + ", realMoney=" + realMoney + ", payDetail=" + payDetail + "]";
    }

}
