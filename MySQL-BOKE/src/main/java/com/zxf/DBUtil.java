package com.zxf;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description: 数据库工具类
 * @date ：2021-02-22 10:26
 */

public class DBUtil {
    // 静态属性，只有一份
    private static DataSource dataSource = null;

    private static void initDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");
        mysqlDataSource.setDatabaseName("boke");

        dataSource = mysqlDataSource;
    }

    static {
        initDataSource();
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
