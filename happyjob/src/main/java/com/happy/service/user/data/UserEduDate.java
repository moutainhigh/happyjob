 package com.happy.service.user.data;

import com.happy.entity.HpUserEducationEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserEduDate对象",description="求职者学历")
public class UserEduDate extends HpUserEducationEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name="hpPositionSalaryId",value="学历选项表ID")
    private Long hpEducationId;
    
    @ApiModelProperty(name="hpPositionSalaryId",value="学历名称")
    private String eduName;

    public Long getHpEducationId() {
        return hpEducationId;
    }

    public void setHpEducationId(Long hpEducationId) {
        this.hpEducationId = hpEducationId;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }
    
}
