package com.happy.service.salary.data;

import java.util.List;

import com.happy.entity.HpUserPayrollEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="SalarySimpleListMsg对象",description="工资信息")
public class SalarySimpleListMsg extends BaseMsg{

	    @ApiModelProperty(name="list",value="员工信息封装类集合")
	    private List<HpUserPayrollEntity> list;
	    
	    @ApiModelProperty(name="page",value="员工查询对象")
	    private SalaryManageSearch page;

	    public List<HpUserPayrollEntity> getList() {
	        return list;
	    }

	    public void setList(List<HpUserPayrollEntity> list) {
	        this.list = list;
	    }

	    public SalaryManageSearch getPage() {
	        return page;
	    }

	    public void setPage(SalaryManageSearch page) {
	        this.page = page;
	    }
}
