/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinye.generator.base.impl.BaseServiceImpl;
import com.qinye.generator.dao.FieldTypeDao;
import com.qinye.generator.entity.FieldTypeEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;
import com.qinye.generator.service.FieldTypeService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Title FieldTypeServiceImpl
 * @Package com.qinye.generator.service.impl
 * @Description: (字符类型管理)
 * @Author qinye
 * @Date 2022年08月15天 21时43分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Service
public class FieldTypeServiceImpl extends BaseServiceImpl<FieldTypeDao, FieldTypeEntity> implements FieldTypeService {

    @Override
    public PageResult<FieldTypeEntity> page(Query query) {
        IPage<FieldTypeEntity> page = baseMapper.selectPage(
                getPage(query),
                getWrapper(query)
        );
        return new PageResult<>(page.getRecords(), page.getTotal());
    }

    @Override
    public Map<String, FieldTypeEntity> getMap() {
        List<FieldTypeEntity> list = baseMapper.selectList(null);
        Map<String, FieldTypeEntity> map = new LinkedHashMap<>(list.size());
        for(FieldTypeEntity entity : list){
            map.put(entity.getColumnType().toLowerCase(), entity);
        }
        return map;
    }

    @Override
    public Set<String> getPackageListByTableId(Long tableId) {
        return baseMapper.getPackageListByTableId(tableId);
    }

    @Override
    public Set<String> getList() {
        return baseMapper.list();
    }

}
