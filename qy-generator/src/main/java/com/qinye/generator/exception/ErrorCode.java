/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title ErrorCode
 * @Package com.qinye.generator.exception
 * @Description: (错误编码)
 * @Author qinye
 * @Date 2022年08月15天 17时56分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试");

    private final int code;
    private final String msg;
}
