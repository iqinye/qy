/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.service;

import com.qinye.generator.base.BaseService;
import com.qinye.generator.entity.TableInfoEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;

/**
 * @Title TableInfoService
 * @Package com.qinye.generator.service
 * @Description: (表信息)
 * @Author qinye
 * @Date 2022年08月15天 19时35分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public interface TableInfoService extends BaseService<TableInfoEntity> {

    PageResult<TableInfoEntity> page(Query query);

    TableInfoEntity getByTableName(String tableName);

    void deleteByTableName(String tableName);

    void deleteBatchIds(Long[] ids);
}
