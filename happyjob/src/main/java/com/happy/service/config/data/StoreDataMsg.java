package com.happy.service.config.data;

import com.happy.entity.HpCompanyStoreEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="StoreDataMsg",description="门店信息返回信息类")
public class StoreDataMsg extends BaseMsg {

    @ApiModelProperty(name="data",value="门店信息对象")
    private HpCompanyStoreEntity data;

    public HpCompanyStoreEntity getData() {
        return data;
    }

    public void setData(HpCompanyStoreEntity data) {
        this.data = data;
    }
    
}
