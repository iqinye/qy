/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.dao;

import com.qinye.generator.base.BaseDao;
import com.qinye.generator.entity.FieldTypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * @Title FieldTypeDao
 * @Package com.qinye.generator.dao
 * @Description: (字段类型管理)
 * @Author qinye
 * @Date 2022年08月15天 19时04分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Mapper
public interface FieldTypeDao extends BaseDao<FieldTypeEntity> {

    /**
     * 根据tableId，获取包列表
     */
    Set<String> getPackageListByTableId(Long tableId);

    /**
     * 获取全部字段类型
     */
    Set<String> list();
}
