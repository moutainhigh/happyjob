 package com.happy.service.banner.data;

import com.happy.entity.HpAdvBannerEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="BannerDataMsg",description="轮播图详情返回信息类")
 public class BannerDataMsg {

    @ApiModelProperty(name="data",value="广告位轮播对象")
    private HpAdvBannerEntity data;

    public HpAdvBannerEntity getData() {
        return data;
    }

    public void setData(HpAdvBannerEntity data) {
        this.data = data;
    }
    
}
