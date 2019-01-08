 package com.happy.service.config.data;

import java.util.List;

import com.happy.entity.HpPositionOfferEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PosOfferListMsg",description="职位招聘方式信息返回封装类")
public class PosOfferListMsg extends BaseMsg {

    @ApiModelProperty(name="list",value="职位招聘方式信息对象集合")
    private List<HpPositionOfferEntity> list;
    
    @ApiModelProperty(name="page",value="搜索对象")
    private AreaSearch page;

    public List<HpPositionOfferEntity> getList() {
        return list;
    }

    public void setList(List<HpPositionOfferEntity> list) {
        this.list = list;
    }

    public AreaSearch getPage() {
        return page;
    }

    public void setPage(AreaSearch page) {
        this.page = page;
    }
    
}
