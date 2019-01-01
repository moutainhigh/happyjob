 package com.happy.service.user.data;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *   TODO: 图片上传信息返回类
 */
@ApiModel(value="UpImgData对象",description="图片上传信息返回类")
public class UpImgData {

    @ApiModelProperty(name="imgUrl",value="图片访问地址")
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
}
