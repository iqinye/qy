/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.exception;

import com.qinye.common.constant.BusinessCode;
import com.qinye.common.exception.base.BaseBusinessException;
import org.redisson.api.RLock;

/**
 * @Title BusinessException
 * @Package com.qinye.exception
 * @Description: (业务异常类)
 * @Author qinye
 * @Date 2022年07月20天 17时52分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public class BusinessException extends BaseBusinessException {

    public BusinessException(Integer errorCode) {
        super(errorCode, BusinessCode.getMessage(errorCode));
    }

    public BusinessException(Integer errorCode, RLock redissonLock) {
        super(errorCode, BusinessCode.getMessage(errorCode),redissonLock);
    }

    public BusinessException(Integer errorCode, Object[] errorData) {
        super(errorCode, BusinessCode.getMessage(errorCode),errorData);
    }

    public BusinessException(Integer errorCode, Throwable t) {
        super(errorCode, BusinessCode.getMessage(errorCode), t);
    }

    /**
     * 异常堆栈增加错误代码和绑定变量
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("业务异常，异常代码[").append(this.code).append("]\n");
        sb.append("异常信息:[").append(this.message).append("]\n");
        return sb.toString();
    }
}
