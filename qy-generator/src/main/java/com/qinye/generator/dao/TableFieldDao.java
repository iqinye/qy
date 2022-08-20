/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.dao;

import com.qinye.generator.base.BaseDao;
import com.qinye.generator.entity.TableFieldEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Title TableFieldDao
 * @Package com.qinye.generator.dao
 * @Description: (表字段)
 * @Author qinye
 * @Date 2022年08月15天 19时05分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Mapper
public interface TableFieldDao extends BaseDao<TableFieldEntity> {

    List<TableFieldEntity> getByTableName(String tableName);

    void deleteByTableName(String tableName);

    void deleteBatchTableIds(Long[] tableIds);
}
