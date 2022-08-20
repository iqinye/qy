/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.service;

import com.qinye.generator.base.BaseService;
import com.qinye.generator.entity.FieldTypeEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;

import java.util.Map;
import java.util.Set;

/**
 * @Title FieldTypeService
 * @Package com.qinye.generator.service
 * @Description: (字段类型)
 * @Author qinye
 * @Date 2022年08月15天 19时33分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public interface FieldTypeService extends BaseService<FieldTypeEntity> {

    PageResult<FieldTypeEntity> page(Query query);

    Map<String, FieldTypeEntity> getMap();

    /**
     * 根据tableId，获取包列表
     */
    Set<String> getPackageListByTableId(Long tableId);

    Set<String> getList();
}
