/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.dao;

import com.qinye.generator.base.BaseDao;
import com.qinye.generator.entity.TableInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title TableInfoDao
 * @Package com.qinye.generator.dao
 * @Description: (表信息)
 * @Author qinye
 * @Date 2022年08月15天 19时07分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Mapper
public interface TableInfoDao extends BaseDao<TableInfoEntity> {

    TableInfoEntity getByTableName(String tableName);

    void deleteByTableName(String tableName);

}
