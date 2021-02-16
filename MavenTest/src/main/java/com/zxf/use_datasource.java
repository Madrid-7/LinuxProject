package com.zxf;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.jdbc.Driver;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author ：ZXF
 * @program: MavenTest
 * @description: 数据库变式
 * @date ：2021-02-16 18:24
 */

public class use_datasource {

    public static void main(String[] args) {

    }

    public static void getConnectionUseDriverManger() throws ClassNotFoundException, SQLException {
        // 1.
        Class.forName("com.mysql.jdbc.Driver");
        String url = "";
        String user = "";
        String password = "";
        // 2.
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // 3.
            try (Statement statement = connection.createStatement()) {
                String sql = "";
                // 4.
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    String columnName = resultSet.getMetaData().getColumnName(1);
                }
            }
        }
    }

    public static void getConnectionUseDataSource() throws ClassNotFoundException, SQLException {
        DataSource dataSource;

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");
        mysqlDataSource.setDatabaseName("test");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        dataSource = mysqlDataSource;

        try (Connection connection = dataSource.getConnection()) {

        }
    }
}
