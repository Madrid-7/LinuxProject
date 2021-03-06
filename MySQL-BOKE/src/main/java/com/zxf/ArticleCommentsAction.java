package com.zxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description:
 * @date ：2021-03-04 23:14
 */

public class ArticleCommentsAction implements Action {
    @Override
    public void run() {
        if (!User.isLogged()) {
            System.out.println("请先登录。。。");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("输入要评论的文章id:>");
        String id = sc.nextLine();
        System.out.println("输入评论内容:>");
        String content = sc.nextLine();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String publishedAt = format.format(date);

        try (Connection connection = DBUtil.getConnection()) {
            String sql = "insert into boke.comments (user_id, article_id, published_at, content) values (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, User.getCurrentUser().id);
                preparedStatement.setString(2, id);
                preparedStatement.setString(3, publishedAt);
                preparedStatement.setString(4, content);

                preparedStatement.executeUpdate();
                System.out.println("评论发表成功。。。");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
