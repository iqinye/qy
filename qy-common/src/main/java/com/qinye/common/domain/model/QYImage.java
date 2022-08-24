/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.domain.qy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Title QyImage
 * @Package com.qinye.common.domain.qy
 * @Description: (图片数据)
 * @Author qinye
 * @Date 2022年08月13天 18时49分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@ApiModel(value = "QyImageParam",description = "图片数据")
@Data
public class QyImage {

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    @NotBlank(message = "至少上传一张图片")
    private String imgPath;
}
