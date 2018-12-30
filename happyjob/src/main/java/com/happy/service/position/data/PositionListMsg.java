 package com.happy.service.position.data;

import java.util.List;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PositionListMsg",description="首页活动列表返回信息类")
public class PositionListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="招聘岗位信息封装类集合")
    private List<PositionData> list;
    @ApiModelProperty(name="page",value="分页信息封装类")
    private PositionSearch page;
    public List<PositionData> getList() {
        return list;
    }
    public void setList(List<PositionData> list) {
        this.list = list;
    }
    public PositionSearch getPage() {
        return page;
    }
    public void setPage(PositionSearch page) {
        this.page = page;
    }
    
}
