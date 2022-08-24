/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.exception.base;

import com.qinye.common.constant.BusinessCode;
import lombok.Data;
import org.redisson.api.RLock;

/**
 * @Title BaseBusinessException
 * @Package com.qinye.exception.base
 * @Description: (基础业务异常类)
 * @Author qinye
 * @Date 2022年07月20天 18时12分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@1163.com
 */
@Data
public class BaseBusinessException extends Exception{

    /**
     */
    private static final long serialVersionUID = 7814122870859813741L;

    /**
     * 错误代码
     */
    protected Integer code = BusinessCode.SYS_ERROR;

    /**
     * 错误信息（可以是包装的业务异常）
     */
    protected String message = "系统异常，请联系系统管理员!";

    /**
     * 错误数据返回
     */
    protected Object errorData;

    /**
     * 错误详细信息
     */
    protected String detail;

    /**
     * 分布式锁对象
     */
    private RLock redissonLock;

    protected BaseBusinessException(String errorMessage) {
        super(errorMessage);
        this.message = errorMessage;
    }

    protected BaseBusinessException(Integer errorCode, String errorMessage) {
        super(errorMessage);
        this.code = errorCode;
        this.message = errorMessage;
    }

    protected BaseBusinessException(Integer errorCode, String errorMessage, Object errorData) {
        super(errorMessage);
        this.code = errorCode;
        this.message = errorMessage;
        this.errorData= errorData;
    }

    protected BaseBusinessException(Integer errorCode, String errorMessage, RLock redissonLock) {
        super(errorMessage);
        this.code = errorCode;
        this.message = errorMessage;
        this.redissonLock=redissonLock;
    }

    protected BaseBusinessException(Integer errorCode, String errorMessage, Throwable t) {
        super(errorMessage, t);
        this.code = errorCode;
        this.message = errorMessage;
        this.detail = t.getMessage();
    }

    /**
     * 异常堆栈增加错误代码和绑定变量
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("系统异常，异常代码[").append(this.code).append("]\n");
        sb.append("异常信息:[").append(this.message).append("]\n");
        sb.append("异常详情:[").append(this.message).append("]\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
