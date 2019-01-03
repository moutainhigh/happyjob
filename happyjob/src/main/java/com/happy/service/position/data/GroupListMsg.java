 package com.happy.service.position.data;

import java.util.List;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GroupListMsg",description="拼团岗位正在进行的拼团列表返回信息类")
public class GroupListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="招聘岗位拼团信息封装类集合")
    private List<GroupData> list;
    @ApiModelProperty(name="page",value="分页信息封装类")
    private GroupSearch page;
    
    public List<GroupData> getList() {
        return list;
    }
    public void setList(List<GroupData> list) {
        this.list = list;
    }
    public GroupSearch getPage() {
        return page;
    }
    public void setPage(GroupSearch page) {
        this.page = page;
    }
    
}
