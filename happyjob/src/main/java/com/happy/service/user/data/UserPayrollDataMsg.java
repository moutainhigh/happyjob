 package com.happy.service.user.data;

import com.happy.entity.HpUserPayrollEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserPayrollDataMsg",description="工资条信息返回信息封装类")
public class UserPayrollDataMsg extends BaseMsg {

    @ApiModelProperty(name="data",value="工资条信息封装类")
    private HpUserPayrollEntity data;

    public HpUserPayrollEntity getData() {
        return data;
    }

    public void setData(HpUserPayrollEntity data) {
        this.data = data;
    }
    
}
