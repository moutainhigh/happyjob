 package com.happy.service.user.data;

import com.happy.entity.HpUserIntentionEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserIntentionData对象",description="求职者求职意向表")
public class UserIntentionData extends HpUserIntentionEntity {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(name="hpPositionSalaryId",value="公司招聘岗位月薪表ID")
    private Long hpPositionSalaryId;
    
    @ApiModelProperty(name="lowerNum",value="月薪下限值（为0显示上限值元/月以下）")
    private int lowerNum;
    
    @ApiModelProperty(name="hightNum",value="月薪上限值（为0显示下限值元/月以上）")
    private int hightNum;

    public Long getHpPositionSalaryId() {
        return hpPositionSalaryId;
    }

    public void setHpPositionSalaryId(Long hpPositionSalaryId) {
        this.hpPositionSalaryId = hpPositionSalaryId;
    }

    public int getLowerNum() {
        return lowerNum;
    }

    public void setLowerNum(int lowerNum) {
        this.lowerNum = lowerNum;
    }

    public int getHightNum() {
        return hightNum;
    }

    public void setHightNum(int hightNum) {
        this.hightNum = hightNum;
    }
    
}
