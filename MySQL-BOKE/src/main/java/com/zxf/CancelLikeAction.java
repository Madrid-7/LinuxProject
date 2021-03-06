package com.zxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description:
 * @date ：2021-03-04 23:18
 */

public class CancelLikeAction implements Action {
    @Override
    public void run() {
        if (!User.isLogged()) {
            System.out.println("请先登录。。。");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("输入要取消点赞的文章id:>");
        String id = sc.nextLine();

        try (Connection connection = DBUtil.getConnection()) {
            String sql = "delete from boke.like_relations where user_id = ? and article_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, User.getCurrentUser().id);
                preparedStatement.setString(2, id);

                preparedStatement.executeUpdate();
                System.out.println("取消点赞成功。。。");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
