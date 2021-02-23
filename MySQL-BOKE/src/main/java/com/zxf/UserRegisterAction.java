package com.zxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description: 用户注册
 * @date ：2021-02-22 10:21
 */

public class UserRegisterAction implements Action{
    @Override
    public void run() {
        String sql = "insert into users (username, nickname, password) values (?, ?, ?)";

        System.out.println("用户注册。。。");

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名称>");
        String username = scanner.nextLine();
        System.out.print("请输入用户昵称>");
        String nickname = scanner.nextLine();
        System.out.print("请输入用户密码>");
        String password = scanner.nextLine();

        try (Connection connection = DBUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, nickname);
                statement.setString(3, password);

                statement.executeUpdate();
                System.out.println("注册成功。。。");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
