package com.zxf;

import java.sql.*;
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
        System.out.println("用户注册。。。");

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名称>");
        String username = scanner.nextLine();
        System.out.print("请输入用户昵称>");
        String nickname = scanner.nextLine();
        System.out.print("请输入用户密码>");
        String password = scanner.nextLine();

        try (Connection connection = DBUtil.getConnection()) {
            String sql = "insert into users (username, nickname, password) values (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                // Statement.RETURN_GENERATED_KEYS  -> 返回刚才插入数据的自增 id
                // 即返回生成的自增主键
                statement.setString(1, username);
                statement.setString(2, nickname);
                statement.setString(3, password);

                statement.executeUpdate();

                int id;
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    resultSet.next();
                    id = resultSet.getInt(1);
                }

                System.out.println("注册成功。。。->" + nickname);

                User user = new User(id, username, nickname);
                User.login(user);
            }

        } catch (SQLException throwables) {
            System.out.println("错误:" + throwables.getMessage());
        }

    }

}
