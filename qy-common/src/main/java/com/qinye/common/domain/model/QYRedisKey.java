/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.common.domain.qy;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title QyRedisKey
 * @Package com.qinye.common.domain.redis
 * @Description: (qy_redis_key  redis的过期键信息实体)
 * @Author qinye
 * @Date 2022年08月13天 18时44分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
public class QyRedisKey implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * redis的延时任务key
     */
    private String redisKey;

    /**
     * 结束时间（到这个时间就需要业务处理）
     */
    private String endTime;
}
