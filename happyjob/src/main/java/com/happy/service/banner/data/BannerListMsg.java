 package com.happy.service.banner.data;

import java.util.List;

import com.happy.entity.HpAdvBannerEntity;
import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="BannerListMsg",description="轮播图列表返回信息类")
public class BannerListMsg extends BaseMsg {
    
    @ApiModelProperty(name="list",value="广告位轮播对象集合")
    private List<HpAdvBannerEntity> list;
    @ApiModelProperty(name="page",value="查询对象")
    private BannerSearch page;

    public List<HpAdvBannerEntity> getList() {
        return list;
    }

    public void setList(List<HpAdvBannerEntity> list) {
        this.list = list;
    }

    public BannerSearch getPage() {
        return page;
    }

    public void setPage(BannerSearch page) {
        this.page = page;
    }
    
}
