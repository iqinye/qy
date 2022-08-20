/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.service;

import com.qinye.generator.config.DataSourceInfo;
import com.qinye.generator.entity.TableFieldEntity;
import com.qinye.generator.entity.TableInfoEntity;

import java.util.List;

/**
 * @Title GeneratorService
 * @Package com.qinye.generator.service
 * @Description: (代码生成)
 * @Author qinye
 * @Date 2022年08月15天 19时34分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public interface GeneratorService {

    DataSourceInfo getDataSourceInfo(Long datasourceId);

    void datasourceTable(TableInfoEntity tableInfo);

    void updateTableField(Long tableId, List<TableFieldEntity> tableFieldList);

    void generatorCode(TableInfoEntity tableInfo) throws Exception;
}
