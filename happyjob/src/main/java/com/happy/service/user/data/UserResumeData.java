 package com.happy.service.user.data;

import java.util.List;

import com.happy.entity.HpUserExpEntity;
import com.happy.entity.HpUserResumeEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserResumeData对象",description="用户简历返回信息封装类")
public class UserResumeData {

    @ApiModelProperty(name="resumeBase",value="用户简历基本信息对象")
    private HpUserResumeEntity resumeBase;
    
    @ApiModelProperty(name="intentionList",value="用户简历求职意向集合")
    private List<UserIntentionData> intentionList ;
    
    @ApiModelProperty(name="intentionList",value="用户简历求职意向集合")
    private List<HpUserExpEntity> expList ;
    
    @ApiModelProperty(name="eduList",value="用户简历求职意向集合")
    private List<UserEduDate> eduList ;

    public HpUserResumeEntity getResumeBase() {
        return resumeBase;
    }

    public void setResumeBase(HpUserResumeEntity resumeBase) {
        this.resumeBase = resumeBase;
    }

    public List<UserIntentionData> getIntentionList() {
        return intentionList;
    }

    public void setIntentionList(List<UserIntentionData> intentionList) {
        this.intentionList = intentionList;
    }

    public List<HpUserExpEntity> getExpList() {
        return expList;
    }

    public void setExpList(List<HpUserExpEntity> expList) {
        this.expList = expList;
    }

    public List<UserEduDate> getEduList() {
        return eduList;
    }

    public void setEduList(List<UserEduDate> eduList) {
        this.eduList = eduList;
    }
    
}
