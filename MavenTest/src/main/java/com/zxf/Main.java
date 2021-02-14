package com.zxf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author ：ZXF
 * @program: MavenTest
 * @description: MavenTest
 * @date ：2021-02-12 15:54
 */

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //建立数据库连接
            //写明 MySQL 服务端所在地
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8");
            System.out.println(connection);

            //要真正的执行 SQL 语句，并且获取数据库返回的结果
            statement = connection.createStatement();

            String sql = "select * from Student;";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String Sno = resultSet.getString(1);
                String Sname = resultSet.getString(2);
                String Sex = resultSet.getString(3);
                String Sage = resultSet.getString(4);
                String Sdept = resultSet.getString(5);
                System.out.println(Sno + " " + Sname + " " + Sex + " " + Sage + " " + Sdept);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
