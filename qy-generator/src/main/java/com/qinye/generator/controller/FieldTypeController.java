/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.controller;

import com.qinye.generator.entity.FieldTypeEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;
import com.qinye.generator.response.Result;
import com.qinye.generator.service.FieldTypeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;

/**
 * @Title FieldTypeController
 * @Package com.qinye.generator.controller
 * @Description: (字段类型控制器)
 * @Author qinye
 * @Date 2022年08月15天 22时02分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@RestController
@RequestMapping("gen/fieldtype")
@AllArgsConstructor
public class FieldTypeController {

    private final FieldTypeService fieldTypeService;

    @GetMapping("page")
    public Result<PageResult<FieldTypeEntity>> page(Query query){
        PageResult<FieldTypeEntity> page = fieldTypeService.page(query);
        return Result.ok(page);
    }

    @GetMapping("{id}")
    public Result<FieldTypeEntity> get(@PathVariable("id") Long id){
        FieldTypeEntity data = fieldTypeService.getById(id);
        return Result.ok(data);
    }

    @GetMapping("list")
    public Result<Set<String>> list(){
        Set<String> set = fieldTypeService.getList();
        return Result.ok(set);
    }

    @PostMapping
    public Result<String> save(@RequestBody FieldTypeEntity entity){
        fieldTypeService.save(entity);
        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody FieldTypeEntity entity){
        fieldTypeService.updateById(entity);
        return Result.ok();
    }

    @DeleteMapping
    public Result<String> delete(@RequestBody Long[] ids){
        fieldTypeService.removeBatchByIds(Arrays.asList(ids));
        return Result.ok();
    }
}
