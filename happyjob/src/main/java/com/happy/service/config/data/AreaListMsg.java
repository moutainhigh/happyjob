 package com.happy.service.config.data;

import java.util.List;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="AreaListMsg",description="地区信息返回封装类")
public class AreaListMsg extends BaseMsg {

    @ApiModelProperty(name="list",value="地区信息对象集合")
    private List<AreaData> list;
    
    @ApiModelProperty(name="page",value="搜索对象")
    private AreaSearch page;

    public List<AreaData> getList() {
        return list;
    }

    public void setList(List<AreaData> list) {
        this.list = list;
    }

    public AreaSearch getPage() {
        return page;
    }

    public void setPage(AreaSearch page) {
        this.page = page;
    }
    
}
