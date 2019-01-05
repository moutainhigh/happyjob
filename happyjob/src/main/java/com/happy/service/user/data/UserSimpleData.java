package com.happy.service.user.data;

import com.happy.entity.HpUserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserData对象",description="员工信息表")
public class UserSimpleData extends HpUserEntity {
    
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name="comName",value="公司名称")
    private String comName;
    @ApiModelProperty(name="storeName",value="来源门店名称")
    private String storeName;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
}
