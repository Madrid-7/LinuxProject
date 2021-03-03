package com.zxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description: 用户登录
 * @date ：2021-02-24 16:16
 */

public class UserLoginAction implements Action{
    @Override
    public void run() {
        System.out.println("用户登录。。。");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名称>");
        String username = sc.nextLine();
        System.out.println("请输入用户密码>");
        String password = sc.nextLine();

        try (Connection connection = DBUtil.getConnection()) {
            String sql = "select id, nickname from users where username = ? and password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String nickname = resultSet.getString(2);

                        User user = new User(id, username, nickname);
                        User.login(user);
                    } else {
                        System.out.println("Error->用户名或密码错误，请重新输入！！");
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
