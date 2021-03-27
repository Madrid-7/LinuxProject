package com.zxf;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：ZXF
 * @program: Servlet-BOKE
 * @description:
 * @date ：2021-03-24 20:52
 */

public class DB {
    private static DataSource dataSource;

    static {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");
        mysqlDataSource.setDatabaseName("servlet_boke");
        try {
            mysqlDataSource.setUseSSL(false);
            mysqlDataSource.setCharacterEncoding("utf8");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dataSource = mysqlDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
