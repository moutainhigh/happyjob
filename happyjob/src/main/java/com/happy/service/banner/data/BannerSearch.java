 package com.happy.service.banner.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="BannerSearch",description="banner搜索信息封装类")
public class BannerSearch extends Page {

    @ApiModelProperty(name="useOn",value="是否开启")
    private Integer useOn;
    @ApiModelProperty(name="delOn",value="是否删除")
    private Integer delOn;
    @ApiModelProperty(name="state",value="过期状态1、有效，2、过期")
    private Integer state;
    @ApiModelProperty(name="curTime",value="当前时间（s）")
    private Long curTime;
    
    
    public Integer getUseOn() {
        return useOn;
    }
    public void setUseOn(Integer useOn) {
        this.useOn = useOn;
    }
    public Integer getDelOn() {
        return delOn;
    }
    public void setDelOn(Integer delOn) {
        this.delOn = delOn;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public Long getCurTime() {
        return curTime;
    }
    public void setCurTime(Long curTime) {
        this.curTime = curTime;
    }
}
