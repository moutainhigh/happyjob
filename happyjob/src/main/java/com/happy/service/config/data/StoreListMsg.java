package com.happy.service.config.data;

import java.util.List;

import com.happy.entity.HpCompanyStoreEntity;
import com.happy.plugin.BaseMsg;
import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value="StoreListMsg",description="门店列表返回信息类")
public class StoreListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="门店信息类集合")
    private List<HpCompanyStoreEntity> list;
    
    @ApiModelProperty(name="page",value="分页对象")
    private Page page;

    public List<HpCompanyStoreEntity> getList() {
        return list;
    }

    public void setList(List<HpCompanyStoreEntity> list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
    
}
