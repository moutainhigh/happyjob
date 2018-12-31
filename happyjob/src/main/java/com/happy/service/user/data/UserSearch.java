 package com.happy.service.user.data;

import com.happy.plugin.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UserSearch",description="用户搜索信息封装类")
public class UserSearch extends Page {

    @ApiModelProperty(name="sid",value="用户登录token")
    private String sid;
    @ApiModelProperty(name="oid",value="微信登录token")
    private String oid;
    @ApiModelProperty(name="delOn",value="是否删除")
    private Integer delOn;
    @ApiModelProperty(name="keyWord",value="搜索关键字")
    private String keyWord;
    
    public String getSid() {
        return sid;
    }
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }
    public Integer getDelOn() {
        return delOn;
    }
    public void setDelOn(Integer delOn) {
        this.delOn = delOn;
    }
    public String getKeyWord() {
        return keyWord;
    }
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    
}
