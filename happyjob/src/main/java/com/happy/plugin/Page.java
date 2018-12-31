package com.happy.plugin;


import io.swagger.annotations.ApiModelProperty;

public class Page {
	
    @ApiModelProperty(name="showCount",value="每页显示记录数",dataType="java.lang.Integer")
    private int showCount; //每页显示记录数
    @ApiModelProperty(name="totalPage",value="总页数",dataType="java.lang.Integer")
    private int totalPage;      //总页数
    @ApiModelProperty(name="totalResult",value="总记录数",dataType="java.lang.Integer")
    private int totalResult;    //总记录数
    @ApiModelProperty(name="currentPage",value="当前页",dataType="java.lang.Integer")
    private int currentPage;    //当前页
    @ApiModelProperty(name="currentResult",value="当前记录起始索引",dataType="java.lang.Integer")
    private int currentResult;  //当前记录起始索引
    @ApiModelProperty(name="entityOrField",value="true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性",dataType="java.lang.Boolean")
    private boolean entityOrField;  //true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性
    @ApiModelProperty(name="isPage",value="是否分页")
    private int isPage;
	
	public Page(){
			this.showCount = 10;
	}
	
	public int getTotalPage() {
		if(totalResult%showCount==0)
			totalPage = totalResult/showCount;
		else
			totalPage = totalResult/showCount+1;
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalResult() {
		return totalResult;
	}
	
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	
	public int getCurrentPage() {
		if(currentPage<=0)
			currentPage = 1;
		if(currentPage>getTotalPage())
			currentPage = getTotalPage();
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getShowCount() {
		return showCount;
	}
	
	public void setShowCount(int showCount) {
		
		this.showCount = showCount;
	}
	
	public int getCurrentResult() {
		currentResult = (getCurrentPage()-1)*getShowCount();
		if(currentResult<0)
			currentResult = 0;
		return currentResult;
	}
	
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

    public boolean isEntityOrField() {
        return entityOrField;
    }

    public void setEntityOrField(boolean entityOrField) {
        this.entityOrField = entityOrField;
    }

    public int getIsPage() {
        return isPage;
    }

    public void setIsPage(int isPage) {
        this.isPage = isPage;
    }
	
}
