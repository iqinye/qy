/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Title QYAdminApplication
 * @Package com.qinye.admin
 * @Description: (admin模块程序启动入口)
 * @Author qinye
 * @Date 2022年08月13天 17时46分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */

@EnableTransactionManagement
@EnableConfigurationProperties
@EnableAsync
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@ComponentScan("com.qinye.common")
@ComponentScan("com.qinye.admin.config")
@ComponentScan("com.qinye.admin.interceptor")
@SpringBootApplication
public class QYAdminApplication extends SpringBootServletInitializer {

    /**
     * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
     */
    @Override  //重写configure方法，把springboot的入口给它
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(QYAdminApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(QYAdminApplication.class, args);
        System.out.println("------   qinye-admin启动成功    ------\n");
    }

}
