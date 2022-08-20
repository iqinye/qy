/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.service.impl;

import com.qinye.generator.base.impl.BaseServiceImpl;
import com.qinye.generator.dao.TableFieldDao;
import com.qinye.generator.entity.TableFieldEntity;
import com.qinye.generator.service.TableFieldService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title TableFieldServiceImpl
 * @Package com.qinye.generator.service.impl
 * @Description: (表字段服务接口实现)
 * @Author qinye
 * @Date 2022年08月15天 21时45分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Service
public class TableFieldServiceImpl extends BaseServiceImpl<TableFieldDao, TableFieldEntity> implements TableFieldService {

    @Override
    public List<TableFieldEntity> getByTableName(String tableName) {
        return baseMapper.getByTableName(tableName);
    }

    @Override
    public void deleteByTableName(String tableName) {
        baseMapper.deleteByTableName(tableName);
    }

    @Override
    public void deleteBatchTableIds(Long[] tableIds) {
        baseMapper.deleteBatchTableIds(tableIds);
    }

}
