package com.happy.service.apply.data;

import java.util.List;

import com.happy.entity.HpCompanyApplyEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModelProperty;

public class ApplyListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="我要招聘对象集合")
    private List<HpCompanyApplyEntity> list;
    @ApiModelProperty(name="page",value="查询对象")
    private ApplySearch page;
    
	public List<HpCompanyApplyEntity> getList() {
		return list;
	}
	public void setList(List<HpCompanyApplyEntity> list) {
		this.list = list;
	}
	public ApplySearch getPage() {
		return page;
	}
	public void setPage(ApplySearch page) {
		this.page = page;
	}

   

}
