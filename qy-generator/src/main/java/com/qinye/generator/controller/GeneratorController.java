/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.controller;

import com.qinye.generator.config.DataSourceInfo;
import com.qinye.generator.entity.TableFieldEntity;
import com.qinye.generator.entity.TableInfoEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;
import com.qinye.generator.response.Result;
import com.qinye.generator.service.GeneratorService;
import com.qinye.generator.service.TableFieldService;
import com.qinye.generator.service.TableInfoService;
import com.qinye.generator.utils.DbUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Title GeneratorController
 * @Package com.qinye.generator.controller
 * @Description: (代码生成)
 * @Author qinye
 * @Date 2022年08月15天 22时03分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@RestController
@RequestMapping("gen")
@AllArgsConstructor
public class GeneratorController {

    private final GeneratorService generatorService;
    private final TableInfoService tableInfoService;
    private final TableFieldService tableFieldService;

    @GetMapping("table/page")
    public Result<PageResult<TableInfoEntity>> pageTable(Query query){
        PageResult<TableInfoEntity> page = tableInfoService.page(query);

        return Result.ok(page);
    }

    @GetMapping("table/{id}")
    public Result<TableInfoEntity> getTable(@PathVariable("id") Long id){
        TableInfoEntity table = tableInfoService.getById(id);

        List<TableFieldEntity> fieldList = tableFieldService.getByTableName(table.getTableName());
        table.setFields(fieldList);

        return Result.ok(table);
    }

    @PutMapping("table")
    public Result<String> updateTable(@RequestBody TableInfoEntity tableInfo){
        tableInfoService.updateById(tableInfo);

        return Result.ok();
    }

    @DeleteMapping("table")
    public Result<String> deleteTable(@RequestBody Long[] ids){
        tableInfoService.deleteBatchIds(ids);

        return Result.ok();
    }

    /**
     * 获取数据源中所有表
     */
    @GetMapping("datasource/table/list/{id}")
    public Result<List<TableInfoEntity>> getDataSourceTableList(@PathVariable("id") Long id){
        try {
            //初始化配置信息
            DataSourceInfo info = generatorService.getDataSourceInfo(id);
            List<TableInfoEntity> tableInfoList = DbUtils.getTablesInfoList(info);

            return Result.ok(tableInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("数据源配置错误，请检查数据源配置！");
        }
    }

    /**
     * 导入数据源中的表
     */
    @PostMapping("datasource/table")
    public Result<String> datasourceTable(@RequestBody TableInfoEntity tableInfo) {
        generatorService.datasourceTable(tableInfo);

        return Result.ok();
    }

    /**
     * 更新列数据
     */
    @PutMapping("table/field/{tableId}")
    public Result<String> updateTableField(@PathVariable("tableId") Long tableId, @RequestBody List<TableFieldEntity> tableFieldList) {
        generatorService.updateTableField(tableId, tableFieldList);

        return Result.ok();
    }

    /**
     * 生成代码
     */
    @PostMapping("generator")
    public Result<String> generator(@RequestBody TableInfoEntity tableInfo) throws Exception {
        //保存表信息
        tableInfoService.updateById(tableInfo);

        //生成代码
        generatorService.generatorCode(tableInfo);

        return Result.ok();
    }
}
