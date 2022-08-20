/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.admin.interceptor;

import com.qinye.admin.service.auth.IUserRedisService;
import com.qinye.common.config.security.SecurityProperties;
import com.qinye.common.response.Response;
import com.qinye.common.utils.EmptyUtils;
import com.qinye.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Title: AuthorizationInterceptor
 * @Package com.qinye.interceptor
 * @Description: (鉴权拦截器配置类)
 * @Author qinye
 * @Date 2022年07月15日, 0015 17:00
 * @Version V1.0
 * 公司网址：https://www.iqinye.com/
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Component
@Slf4j(topic = "AuthorizationInterceptor")
public class AuthorizationInterceptor implements HandlerInterceptor {

    public static final String USER = "user";

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private IUserRedisService userRedisService;


    /**
     * 添加自定义拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Response result;
        //设置跨域
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        setHeader(httpRequest, httpResponse);

        //从header中获取内部token
        String token = request.getHeader(securityProperties.getHeader());
        if (!EmptyUtils.isEmpty(token) && token.equals("undefined")) {
            token = "";
        }
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(securityProperties.getHeader());
        }

        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        //判断当前请求是否需要认证
        String path = request.getServletPath();
        log.info("uri: {}", path);
        boolean needAuth = securityProperties.isNeedAuth(path);
        if (!needAuth) {
            return true;
        }
        return false;
    }

    /**
     * 为response设置header，实现跨域
     */
    private void setHeader(HttpServletRequest request, HttpServletResponse response) {
        //跨域的header设置
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        //防止乱码，适用于传输JSON数据
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
    }

}
