/*
 * Copyright (C) 2021-2022
 * All rights reserved, Designed By 泉州沁叶智能科技有限公司
 * Copyright authorization contact 15850802486
 */
package com.qinye.generator.config;

import com.qinye.generator.config.query.*;
import com.qinye.generator.entity.DataSourceEntity;
import com.qinye.generator.utils.DbType;
import com.qinye.generator.utils.DbUtils;
import lombok.Data;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Title DataSourceInfo
 * @Package com.qinye.generator.config.query
 * @Description: (这里用一句话描述这个类的作用)
 * @Author qinye
 * @Date 2022年08月15天 18时44分
 * 公司网址：https://www.iqinye.com
 * 联系电话：15850802486
 * 企业邮箱：iqinye@163.com
 */
@Data
public class DataSourceInfo {

    /**
     * 数据源ID
     */
    private Long id;
    /**
     * 数据库类型
     */
    private DbType dbType;
    /**
     * 数据库URL
     */
    private String connUrl;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    private AbstractQuery dbQuery;

    private Connection connection;

    public DataSourceInfo(DataSourceEntity entity) {
        this.id = entity.getId();
        this.dbType = DbType.valueOf(entity.getDbType());
        this.connUrl = entity.getConnUrl();
        this.username = entity.getUsername();
        this.password = entity.getPassword();

        if(dbType == DbType.MySQL) {
            this.dbQuery = new MySqlQuery();
        }else if(dbType == DbType.Oracle) {
            this.dbQuery = new OracleQuery();
        }else if(dbType == DbType.PostgreSQL) {
            this.dbQuery = new PostgreSqlQuery();
        }else if(dbType == DbType.SQLServer) {
            this.dbQuery = new SQLServerQuery();
        }

        try {
            this.connection = DbUtils.getConnection(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DataSourceInfo(Connection connection) throws SQLException {
        this.id = 0L;
        this.dbType = DbType.valueOf(connection.getMetaData().getDatabaseProductName());

        if(dbType == DbType.MySQL) {
            this.dbQuery = new MySqlQuery();
        }else if(dbType == DbType.Oracle) {
            this.dbQuery = new OracleQuery();
        }else if(dbType == DbType.PostgreSQL) {
            this.dbQuery = new PostgreSqlQuery();
        }else if(dbType == DbType.SQLServer) {
            this.dbQuery = new SQLServerQuery();
        }

        this.connection = connection;
    }
}
