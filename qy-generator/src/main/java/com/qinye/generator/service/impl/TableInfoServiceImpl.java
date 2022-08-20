/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinye.generator.base.impl.BaseServiceImpl;
import com.qinye.generator.dao.TableInfoDao;
import com.qinye.generator.entity.TableInfoEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;
import com.qinye.generator.service.TableFieldService;
import com.qinye.generator.service.TableInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @Title TableInfoServiceImpl
 * @Package com.qinye.generator.service.impl
 * @Description: (表信息服务接口实现)
 * @Author qinye
 * @Date 2022年08月15天 21时45分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Service
@AllArgsConstructor
public class TableInfoServiceImpl extends BaseServiceImpl<TableInfoDao, TableInfoEntity> implements TableInfoService {

    private final TableFieldService tableFieldService;

    @Override
    public PageResult<TableInfoEntity> page(Query query) {
        IPage<TableInfoEntity> page = baseMapper.selectPage(
                getPage(query),
                getWrapper(query)
        );
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    @Override
    public TableInfoEntity getByTableName(String tableName) {
        return baseMapper.getByTableName(tableName);
    }

    @Override
    public void deleteByTableName(String tableName) {
        baseMapper.deleteByTableName(tableName);
    }

    @Override
    public void deleteBatchIds(Long[] ids) {
        //删除表
        baseMapper.deleteBatchIds(Arrays.asList(ids));

        //删除列
        tableFieldService.deleteBatchTableIds(ids);
    }
}
