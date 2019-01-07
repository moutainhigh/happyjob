 package com.happy.service.config.data;

import java.util.List;

import com.happy.entity.HpPositionTypeEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PosTypeListMsg",description="职位行业类型信息返回封装类")
public class PosTypeListMsg extends BaseMsg {

    @ApiModelProperty(name="list",value="职位行业类型信息对象集合")
    private List<HpPositionTypeEntity> list;
    
    @ApiModelProperty(name="page",value="搜索对象")
    private AreaSearch page;

    public List<HpPositionTypeEntity> getList() {
        return list;
    }

    public void setList(List<HpPositionTypeEntity> list) {
        this.list = list;
    }

    public AreaSearch getPage() {
        return page;
    }

    public void setPage(AreaSearch page) {
        this.page = page;
    }
    
}
