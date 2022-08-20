/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Title In
 * @Package com.qinye.constant.enums
 * @Description: (http内部方式)
 * @Author qinye
 * @Date 2022年08月07天 16时54分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public enum In {
    HEADER, QUERY;

    private static Map<String, In> names = new LinkedHashMap<String, In>();

    @JsonCreator
    public static In forValue(String value) {
        return names.get(value.toLowerCase());
    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, In> entry : names.entrySet()) {
            if (entry.getValue() == this) {
                return entry.getKey();
            }
        }

        return null; // or fail
    }

    static {
        names.put("header", HEADER);
        names.put("query", QUERY);
    }
}
