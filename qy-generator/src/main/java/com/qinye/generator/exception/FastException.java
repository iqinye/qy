/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title FastException
 * @Package com.qinye.generator.exception
 * @Description: (自定义异常)
 * @Author qinye
 * @Date 2022年08月15天 17时56分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class FastException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;

    public FastException(String msg) {
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }

    public FastException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public FastException(String msg, Throwable e) {
        super(msg, e);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }
}
