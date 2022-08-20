/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Title TableFieldEntity
 * @Package com.qinye.generator.entity
 * @Description: (表字段信息)
 * @Author qinye
 * @Date 2022年08月15天 18时52分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
@TableName("gen_table_field")
public class TableFieldEntity {
    @TableId
    private Long id;
    /**
     * 表ID
     */
    private Long tableId;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 列名
     */
    private String columnName;
    /**
     * 类型
     */
    private String columnType;
    /**
     * 列说明
     */
    private String columnComment;
    /**
     * 列说明
     */
    @TableField(exist = false)
    private String comment;
    /**
     * 属性名
     */
    private String attrName;
    /**
     * 属性类型
     */
    private String attrType;
    /**
     * 属性包名
     */
    private String packageName;
    /**
     * 是否主键 0：否  1：是
     */
    private boolean isPk;
    /**
     * 是否必填 0：否  1：是
     */
    private boolean isRequired;
    /**
     * 是否表单字段 0：否  1：是
     */
    private boolean isForm;
    /**
     * 是否列表字段 0：否  1：是
     */
    private boolean isList;
    /**
     * 是否查询字段 0：否  1：是
     */
    private boolean isQuery;
    /**
     * 查询方式
     */
    private String queryType;
    /**
     * 表单类型
     */
    private String formType;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 效验方式
     */
    private String validatorType;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}

