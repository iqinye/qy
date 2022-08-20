/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qinye.generator.base.BaseDao;
import com.qinye.generator.entity.BaseClassEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title BaseClassDao
 * @Package com.qinye.generator.dao
 * @Description: (基类管理)
 * @Author qinye
 * @Date 2022年08月15天 19时02分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Mapper
public interface BaseClassDao extends BaseDao<BaseClassEntity> {
}
