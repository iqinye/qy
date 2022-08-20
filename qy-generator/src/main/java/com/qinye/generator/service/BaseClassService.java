/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.service;

import com.qinye.generator.base.BaseService;
import com.qinye.generator.entity.BaseClassEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;

import java.util.List;

/**
 * @Title BaseClassService
 * @Package com.qinye.generator.service
 * @Description: (基类管理)
 * @Author qinye
 * @Date 2022年08月15天 19时08分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public interface BaseClassService extends BaseService<BaseClassEntity> {

    PageResult<BaseClassEntity> page(Query query);

    List<BaseClassEntity> getList();
}
