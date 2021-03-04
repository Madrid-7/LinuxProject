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
 * @date ：2021-03-03 20:41
 */

public class ArticlePublishAction implements Action {
    @Override
    public void run() {
        if (!User.isLogged()) {
            System.out.println("请先登录。。。");
            return;
        }

        System.out.println("发表文章->...");
        Scanner sc = new Scanner(System.in);
        System.out.println("输入标题>");
        String title = sc.nextLine();
        System.out.println("输入正文>");
        String content = sc.nextLine();
        int authorId = User.getCurrentUser().id;
        Date publishedAt = new Date();  // 对象本来就是当前时间
        // publishedAt 现在是 Date 对象 format 成 String 格式
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String publishedAtStr = format.format(publishedAt);

        try (Connection connection = DBUtil.getConnection()) {
            String sql = "insert into boke.articles (author_id, title, published_at, content) values (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, authorId);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, publishedAtStr);
                preparedStatement.setString(4, content);

                preparedStatement.executeUpdate();
                System.out.println("《" + title + "》发表成功。。。");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
