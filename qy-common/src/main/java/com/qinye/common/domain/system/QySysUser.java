/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.domain.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Title SysUser
 * @Package com.qinye.common.domain.system
 * @Description: (这里用一句话描述这个类的作用)
 * @Author qinye
 * @Date 2022年08月16天 20时48分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
@ApiModel(value = "QySysUser", description = "平台账户实体类")
public class QySysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账户id")
    @TableId(value = "sys_user_id", type = IdType.AUTO)
    private Long sysUserId;

    @ApiModelProperty(value = "平台登录账号")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "账户手机号")
    private String phone;

    @ApiModelProperty(value = "账户登录密码")
    @JsonIgnore
    private String password;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "账户token")
    private String token;

    @ApiModelProperty(value = "是否启用   1-是 0-否")
    private Integer state;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "更新时间")
    private String updateTime;
}
