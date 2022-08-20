/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Title PageResult
 * @Package com.qinye.generator.page
 * @Description: (分页返回数据结构)
 * @Author qinye
 * @Date 2022年08月15天 18时02分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 总记录数
    private int total;

    // 列表数据
    private List<T> list;

    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = (int)total;
    }
}
