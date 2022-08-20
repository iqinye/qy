/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.admin.service.auth.impl;

import com.qinye.admin.service.auth.IUserRedisService;
import com.qinye.common.config.security.SecurityProperties;
import com.qinye.common.utils.auth.TokenProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Title UserRedisServiceImpl
 * @Package com.qinye.admin.service.auth.impl
 * @Description: (这里用一句话描述这个类的作用)
 * @Author qinye
 * @Date 2022年08月16天 00时19分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Service
public class UserRedisServiceImpl implements IUserRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    public void saveUser(String token, Long buyerUserId) {
        if (!securityProperties.isMultiLogin()) {
            Object oldTokenKey = redisTemplate.opsForValue().get(securityProperties.getUserLoginKey() + buyerUserId);
            if (oldTokenKey != null) {
                redisTemplate.delete(oldTokenKey);
            }
        }
        redisTemplate.opsForValue().set(token, buyerUserId, securityProperties.getTokenValidityInSeconds(), TimeUnit.SECONDS);
        redisTemplate.opsForValue().set(securityProperties.getUserLoginKey() + buyerUserId, token);
    }

    @Override
    public Long getBuyerUserIdByToken(String token) {
        if (StringUtils.isNotBlank(token)) {
            Object obj = redisTemplate.opsForValue().get(token);
            if (obj != null) {
                return Long.valueOf(obj.toString());
            }
        }
        return null;
    }

    @Override
    public void refreshToken(String token) {
        redisTemplate.expire(token, securityProperties.getRenew(), TimeUnit.MILLISECONDS);
    }

    @Override
    public String createToken(String username, Long userId) {
        String token = tokenProvider.createToken(username);
        this.saveUser(token, userId);
        return token;
    }

}
