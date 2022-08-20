/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.config.template;

import lombok.Data;

import java.util.List;

/**
 * @Title GeneratorInfo
 * @Package com.qinye.generator.config.template
 * @Description: (这里用一句话描述这个类的作用)
 * @Author qinye
 * @Date 2022年08月15天 21时51分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
public class GeneratorInfo {

    private ProjectInfo project;

    private DeveloperInfo developer;

    private List<TemplateInfo> templates;
}
