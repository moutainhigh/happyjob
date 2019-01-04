package com.happy.service.delivery.data;

import java.util.List;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModelProperty;

public class DeliveryListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="招聘岗位信息封装类集合")
    private List<DeliveryData> list;
    
    @ApiModelProperty(name="page",value="分页信息封装类")
    private DeliverySearch page;
    
    public List<DeliveryData> getList() {
        return list;
    }
    public void setList(List<DeliveryData> list) {
        this.list = list;
    }
    public DeliverySearch getPage() {
        return page;
    }
    public void setPage(DeliverySearch page) {
        this.page = page;
    }

}
