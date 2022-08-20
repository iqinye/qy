/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.controller;

import com.qinye.generator.config.DataSourceInfo;
import com.qinye.generator.entity.DataSourceEntity;
import com.qinye.generator.page.PageResult;
import com.qinye.generator.query.Query;
import com.qinye.generator.response.Result;
import com.qinye.generator.service.DataSourceService;
import com.qinye.generator.utils.DbUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Title DataSourceController
 * @Package com.qinye.generator.controller
 * @Description: (数据源管理控制器)
 * @Author qinye
 * @Date 2022年08月15天 21时59分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@RestController
@RequestMapping("gen/datasource")
@AllArgsConstructor
public class DataSourceController {

    private final DataSourceService datasourceService;

    @GetMapping("page")
    public Result<PageResult<DataSourceEntity>> page(Query query){
        PageResult<DataSourceEntity> page = datasourceService.page(query);

        return Result.ok(page);
    }

    @GetMapping("list")
    public Result<List<DataSourceEntity>> list(){
        List<DataSourceEntity> list = datasourceService.getList();

        return Result.ok(list);
    }

    @GetMapping("{id}")
    public Result<DataSourceEntity> get(@PathVariable("id") Long id){
        DataSourceEntity data = datasourceService.getById(id);

        return Result.ok(data);
    }

    @GetMapping("test/{id}")
    public Result<String> test(@PathVariable("id") Long id){
        try {
            DataSourceEntity entity = datasourceService.getById(id);

            DbUtils.getConnection(new DataSourceInfo(entity));
            return Result.ok("连接成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("连接失败，请检查配置信息");
        }
    }

    @PostMapping
    public Result<String> save(@RequestBody DataSourceEntity entity){
        datasourceService.save(entity);

        return Result.ok();
    }

    @PutMapping
    public Result<String> update(@RequestBody DataSourceEntity entity){
        datasourceService.updateById(entity);

        return Result.ok();
    }

    @DeleteMapping
    public Result<String> delete(@RequestBody Long[] ids){
        datasourceService.removeBatchByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
