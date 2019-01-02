 package com.happy.service.config.data;

import java.util.List;

import com.happy.entity.HpPositionSalaryEntity;
import com.happy.plugin.BaseMsg;
import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SalaryListMsg",description="轮播图列表返回信息类")
public class SalaryListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="工资水平对象集合")
    private List<HpPositionSalaryEntity> list;
    @ApiModelProperty(name="page",value="查询对象")
    private Page page;
    
    public List<HpPositionSalaryEntity> getList() {
        return list;
    }
    public void setList(List<HpPositionSalaryEntity> list) {
        this.list = list;
    }
    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }

    
}
