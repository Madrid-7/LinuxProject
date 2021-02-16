package com.zxf;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MavenTest
 * @description: prepareStatement
 * @date ：2021-02-16 19:42
 */

public class use_prepareStatement {
    private static DataSource dataSource = null;

    private static void initDataSource() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName("127.0.0.1");
        mysqlDataSource.setPort(3306);
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");
        mysqlDataSource.setDatabaseName("test");
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("utf8");

        dataSource = mysqlDataSource;
    }

    public static void main(String[] args) throws SQLException {
        // 初始化一次，多次使用
        initDataSource();
        Scanner sc = new Scanner(System.in);

        try (Connection c = dataSource.getConnection()) {

        }

        try (Connection c = dataSource.getConnection()) {
            // 输入查询值
            int age = sc.nextInt();
            // 提前写好 sql, 使用 ? 提前占位
            String sql = "select * from Student where Student.Sage > ?";

            // 使用 PreparedStatement 可以防止 sql 注入
            try (PreparedStatement preparedStatement = c.prepareStatement(sql)) {
                preparedStatement.setInt(1, age);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String Sno = resultSet.getString("Sno");
                        String Sname = resultSet.getString("Sname");
                        String Sage = resultSet.getString("Sage");
                        System.out.println(Sno+" "+Sname+" "+Sage);
                    }
                }
            }
        }

    }
}
