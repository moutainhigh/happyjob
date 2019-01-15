 package com.happy.service.user.data;

import com.happy.entity.HpUserResumeEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserResume对象",description="")
public class UserResume extends HpUserResumeEntity {
    
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name="eduName",value="学历名称")
    private String eduName;

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }
    
}
