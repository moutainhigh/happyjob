 package com.happy.service.user.data;


import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *   TODO: 图片上传信息返回类
 *
 */
@ApiModel(value="图片上传信息返回类")
public class UpImgMsg extends BaseMsg {

    @ApiModelProperty(name="imgUrl",value="图片访问地址")
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
}
