 package com.happy.service.user.data;

import java.util.List;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserSimpleListMsg对象",description="员工信息")
public class UserSimpleListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="员工信息封装类集合")
    private List<UserSimpleData> list;
    
    @ApiModelProperty(name="page",value="员工查询对象")
    private UserManageSearch page;

    public List<UserSimpleData> getList() {
        return list;
    }

    public void setList(List<UserSimpleData> list) {
        this.list = list;
    }

    public UserManageSearch getPage() {
        return page;
    }

    public void setPage(UserManageSearch page) {
        this.page = page;
    }

}
