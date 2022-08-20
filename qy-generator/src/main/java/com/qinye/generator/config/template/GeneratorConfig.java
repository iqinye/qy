/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.config.template;

import com.qinye.common.utils.json.JsonUtils;
import com.qinye.generator.exception.FastException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Title GeneratorConfig
 * @Package com.qinye.generator.config.template
 * @Description: (这里用一句话描述这个类的作用)
 * @Author qinye
 * @Date 2022年08月15天 21时50分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Configuration
public class GeneratorConfig {

    @Value("${fast.template}")
    private String template;

    public GeneratorInfo getGeneratorConfig(){
        if(StringUtils.isBlank(template)){
            throw new FastException("模板不存在，需指定模板");
        }

        // 模板所在路径
        String templatePath = "/template/" + template + "/";

        // 模板配置文件
        InputStream isConfig = this.getClass().getResourceAsStream(templatePath + "config.json");
        if(isConfig == null){
            throw new FastException("模板配置文件，config.json不存在");
        }

        try {
            // 读取模板配置文件
            String configContent = StreamUtils.copyToString(isConfig, StandardCharsets.UTF_8);
            GeneratorInfo info = JsonUtils.parseObject(configContent, GeneratorInfo.class);
            assert info != null;
            for(TemplateInfo templateInfo : info.getTemplates()){
                // 模板文件
                InputStream isTemplate = this.getClass().getResourceAsStream(templatePath + templateInfo.getTemplateName());
                if(isTemplate == null){
                    throw new FastException("模板文件 " + templateInfo.getTemplateName() + " 不存在");
                }
                // 读取模板内容
                String templateContent = StreamUtils.copyToString(isTemplate, StandardCharsets.UTF_8);

                templateInfo.setTemplateContent(templateContent);
            }
            return info;
        } catch (IOException e) {
            throw new FastException("读取config.json配置文件失败");
        }
    }
}

