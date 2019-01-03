 package com.happy.service.position.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GroupSearch",description="招聘岗位拼团搜索分页类")
public class GroupSearch extends Page {
 
    @ApiModelProperty(name="hpPositionId",value="公司招聘岗位表id")
    private Long hpPositionId;
    
    @ApiModelProperty(name="curTime",value="当前时间（单位s）")
    private Long curTime;
    
    @ApiModelProperty(name="sid",value="用户通行证")
    private String sid;
    
    
    public Long getHpPositionId() {
        return hpPositionId;
    }
    public void setHpPositionId(Long hpPositionId) {
        this.hpPositionId = hpPositionId;
    }
    public Long getCurTime() {
        return curTime;
    }
    public void setCurTime(Long curTime) {
        this.curTime = curTime;
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
   
}
