package com.zxf;

import javax.servlet.ServletException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Arrays;

/**
 * @author ：ZXF
 * @program: Servlet-BOKE
 * @description:
 * @date ：2021-03-24 20:10
 */

public class User {
    int id;
    String username;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public static User insert(String username, String password) {
        //      永远不要在数据库保存明文密码
        // 1. 首先把 password 进行 hash 处理（这里使用 sha256 算法）
        password = encrypted(password);

        // 2. 利用 JDBC 保存 MySQL
        try (Connection connection = DB.getConnection()) {
            String sql = "INSERT INTO servlet_boke.users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();

                // 3. id 是自增主键，所以，利用 JDBC 的方法取出 id
                try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                    keys.next();
                    int id = keys.getInt(1);

                    // 4. 返回构建好的用户对象
                    return new User(id, username);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 如果插入过程发生问题 返回 null
        return null;
    }

    // 利用 SHA-256 ,进行哈希处理   (MD5)
    public static String encrypted(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] input = password.getBytes(StandardCharsets.UTF_8);
            byte[] output = messageDigest.digest(input);
            StringBuilder sb = new StringBuilder();
            for (byte b : output) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return password;
        }
    }

    public static User getByUsernameAndPassword(String username, String password) throws ServletException {
        password = encrypted(password);

        try (Connection connection = DB.getConnection()) {
            String sql = "SELECT id FROM servlet_boke.users WHERE username = ? and password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        return new User(id, username);
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new ServletException();
        }
    }
}
