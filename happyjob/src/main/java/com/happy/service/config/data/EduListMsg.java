 package com.happy.service.config.data;

import java.util.List;

import com.happy.entity.HpEducationEntity;
import com.happy.plugin.BaseMsg;
import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="EduListMsg",description="学历选项列表返回信息类")
 public class EduListMsg extends BaseMsg {

    @ApiModelProperty(name="list",value="学历选项")
    private List<HpEducationEntity> list;

    @ApiModelProperty(name="page",value="查询对象")
    private Page page;
    

    public List<HpEducationEntity> getList() {
        return list;
    }

    public void setList(List<HpEducationEntity> list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
