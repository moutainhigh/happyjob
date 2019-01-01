 package com.happy.service.user.data;


import com.happy.plugin.BaseMsg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *   TODO: 图片上传信息返回类
 *
 */
@ApiModel(value="UpImgMsg对象",description="图片上传信息返回类")
public class UpImgMsg extends BaseMsg {

    @ApiModelProperty(name="data",value="图片参数对象")
    private UpImgData data;

    public UpImgData getData() {
        return data;
    }

    public void setData(UpImgData data) {
        this.data = data;
    }
}
