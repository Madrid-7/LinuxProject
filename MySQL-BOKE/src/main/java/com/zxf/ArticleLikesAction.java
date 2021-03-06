package com.zxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description:
 * @date ：2021-03-04 23:15
 */

public class ArticleLikesAction implements Action {
    @Override
    public void run() {
        if (!User.isLogged()) {
            System.out.println("请先登录。。。");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("输入要点赞的文章id:>");
        String id = sc.nextLine();

        try (Connection connection = DBUtil.getConnection()) {
            String sql = "insert into boke.like_relations (user_id, article_id) values (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, User.getCurrentUser().id);
                preparedStatement.setString(2, id);

                preparedStatement.executeUpdate();
                System.out.println("点赞成功。。。");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("您以点赞过了。。。");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
