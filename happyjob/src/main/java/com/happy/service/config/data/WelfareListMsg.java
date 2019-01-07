 package com.happy.service.config.data;

import java.util.List;

import com.happy.entity.HpPositionWelfareEntity;
import com.happy.plugin.BaseMsg;
import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="WelfareListMsg",description="招聘福利选项返回信息封装类")
public class WelfareListMsg extends BaseMsg {

    @ApiModelProperty(name="list",value="招聘福利选项对象集合")
    private List<HpPositionWelfareEntity> list;
    
    @ApiModelProperty(name="page",value="搜索对象")
    private Page page;

    public List<HpPositionWelfareEntity> getList() {
        return list;
    }

    public void setList(List<HpPositionWelfareEntity> list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
    
}
