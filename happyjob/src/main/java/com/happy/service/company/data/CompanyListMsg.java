package com.happy.service.company.data;

import java.util.List;

import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModelProperty;

public class CompanyListMsg extends BaseMsg{

	    @ApiModelProperty(name="list",value="广告位轮播对象集合")
	    private List<HpCompanyExt> list;
	    
	    @ApiModelProperty(name="page",value="查询对象")
	    private CompanySearch page;

	    public List<HpCompanyExt> getList() {
	        return list;
	    }

	    public void setList(List<HpCompanyExt> list) {
	        this.list = list;
	    }

	    public CompanySearch getPage() {
	        return page;
	    }

	    public void setPage(CompanySearch page) {
	        this.page = page;
	    }
}
