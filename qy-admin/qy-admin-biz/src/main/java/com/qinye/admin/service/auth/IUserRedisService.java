/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.admin.service.auth;

/**
 * @Title IUserRedisService
 * @Package com.qinye.admin.service.auth
 * @Description: (user的redis操作相关service)
 * @Author qinye
 * @Date 2022年08月16天 00时15分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
public interface IUserRedisService {

    /**
     * 保存用户id到redis中
     * @param token /
     * @param sysUserId 系统用户编号
     */
    void saveUser(String token, Long sysUserId);

    /**
     * 根据token获取用户id
     * @param token /
     * @return
     */
    Long getBuyerUserIdByToken(String token);

    /**
     * 重置token
     * @param token /
     */
    void refreshToken(String token);

    /**
     * 生成token并且保存到缓存
     * @param username /
     * @param sysUserId /
     */
    String createToken(String username, Long sysUserId);

}
