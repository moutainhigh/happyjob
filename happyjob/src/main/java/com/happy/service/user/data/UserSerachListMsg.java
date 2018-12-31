 package com.happy.service.user.data;

import java.util.List;

import com.happy.entity.HpUserSearchEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SerachRecordListMsg",description="搜索记录列表查询返回信息")
public class UserSerachListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="登录信息封装类")
    List<HpUserSearchEntity> list;
    @ApiModelProperty(name="page",value="用户搜索信息封装类")
    UserSearch page;
    
    public List<HpUserSearchEntity> getList() {
        return list;
    }
    public void setList(List<HpUserSearchEntity> list) {
        this.list = list;
    }
    public UserSearch getPage() {
        return page;
    }
    public void setPage(UserSearch page) {
        this.page = page;
    }
    
}
