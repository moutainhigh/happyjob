 package com.happy.service.position.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="PositionSearch",description="招聘岗位信息分页类")
public class PositionSearch extends Page {
 
    @ApiModelProperty(name="cityName",value="城市名称")
    private String cityName;
    @ApiModelProperty(name="posNature",value="职位性质（1、实习，2、兼职，3、全职）")
    private Integer posNature;
    @ApiModelProperty(name="retOn",value="是否入职返现")
    private Integer retOn;
    @ApiModelProperty(name="hotOn",value="是否热门")
    private Integer hotOn;
    @ApiModelProperty(name="welfareOn",value="是否福利岗位")
    private Integer welfareOn;
    @ApiModelProperty(name="urgentOn",value="是否高薪急聘")
    private Integer urgentOn;
    @ApiModelProperty(name="curTime",value="当前时间秒")
    private Long curTime;
    
    
    
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public Integer getPosNature() {
        return posNature;
    }
    public void setPosNature(Integer posNature) {
        this.posNature = posNature;
    }
    public Integer getRetOn() {
        return retOn;
    }
    public void setRetOn(Integer retOn) {
        this.retOn = retOn;
    }
    public Integer getHotOn() {
        return hotOn;
    }
    public void setHotOn(Integer hotOn) {
        this.hotOn = hotOn;
    }
    public Integer getWelfareOn() {
        return welfareOn;
    }
    public void setWelfareOn(Integer welfareOn) {
        this.welfareOn = welfareOn;
    }
    public Integer getUrgentOn() {
        return urgentOn;
    }
    public void setUrgentOn(Integer urgentOn) {
        this.urgentOn = urgentOn;
    }
    public Long getCurTime() {
        return curTime;
    }
    public void setCurTime(Long curTime) {
        this.curTime = curTime;
    }
}
