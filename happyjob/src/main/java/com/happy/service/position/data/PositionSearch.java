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
    @ApiModelProperty(name="groupOn",value="是否是拼团岗位")
    private Integer groupOn;
    @ApiModelProperty(name="curTime",value="当前时间秒")
    private Long curTime;
    @ApiModelProperty(name="hpPositionId",value="岗位ID")
    private Long hpPositionId;
    @ApiModelProperty(name="hpPositionGroupId",value="岗位拼团ID")
    private Long hpPositionGroupId;
    @ApiModelProperty(name="state",value="用户岗位申请状态0、所有，1、进行中，2、已成功入职，3、拼团成功，4、已过期,5、指定日期的拼团")
    private Integer state;
    @ApiModelProperty(name="sid",value="用户通行证")
    private String sid;
    @ApiModelProperty(name="keyWord",value="关键字，模糊匹配公司名称、职位")
    private String keyWord;
    @ApiModelProperty(name="partType",value="申请类型：1、非参团，2、参团")
    private Integer partType;
    @ApiModelProperty(name="posName",value="职位名称")
    private String posName;
    @ApiModelProperty(name="comName",value="公司名称")
    private String comName;
    @ApiModelProperty(name="creatStartTime",value="发布开始时间（s）")
    private Long creatStartTime;
    @ApiModelProperty(name="creatEndTime",value="发布结束时间（s）")
    private Long creatEndTime;

    
    
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
    public Long getHpPositionId() {
        return hpPositionId;
    }
    public void setHpPositionId(Long hpPositionId) {
        this.hpPositionId = hpPositionId;
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    public Integer getGroupOn() {
        return groupOn;
    }
    public void setGroupOn(Integer groupOn) {
        this.groupOn = groupOn;
    }
    public Integer getPartType() {
        return partType;
    }
    public void setPartType(Integer partType) {
        this.partType = partType;
    }
    public Long getHpPositionGroupId() {
        return hpPositionGroupId;
    }
    public void setHpPositionGroupId(Long hpPositionGroupId) {
        this.hpPositionGroupId = hpPositionGroupId;
    }
    public String getPosName() {
        return posName;
    }
    public void setPosName(String posName) {
        this.posName = posName;
    }
    public String getComName() {
        return comName;
    }
    public void setComName(String comName) {
        this.comName = comName;
    }
    public Long getCreatStartTime() {
        return creatStartTime;
    }
    public void setCreatStartTime(Long creatStartTime) {
        this.creatStartTime = creatStartTime;
    }
    public Long getCreatEndTime() {
        return creatEndTime;
    }
    public void setCreatEndTime(Long creatEndTime) {
        this.creatEndTime = creatEndTime;
    }
}
