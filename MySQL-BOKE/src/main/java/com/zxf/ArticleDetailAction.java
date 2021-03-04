package com.zxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description:
 * @date ：2021-03-04 16:31
 */

public class ArticleDetailAction implements Action {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要查看的文章的id>");
        String id = sc.nextLine();
        String nickname, title, content, published_at;
        int likeCount;

        try (Connection connection = DBUtil.getConnection()) {

            //查询文章信息
            String articleSql = "select + articles.id, nickname, title, content, published_at " +
                    "from boke.articles, boke.users " +
                    "where users.id=author_id and articles.id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(articleSql)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (!resultSet.next()) {
                        System.out.println("并未查到此文章。。。");
                        return;
                    }
                    nickname = resultSet.getString("nickname");
                    title = resultSet.getString("title");
                    content = resultSet.getString("content");
                    published_at = resultSet.getString("published_at");

                }
            }

            //查询文章点赞数
            String likeCountSql = "select count(*) from boke.like_relations where article_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(likeCountSql)) {
                preparedStatement.setString(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    resultSet.next();
                    likeCount = resultSet.getInt(1);
                }
            }

            //查询评论信息
            List<String[]> commentList = new ArrayList<>();
            String queryCommentSql = "select nickname, content, published_at " +
                    "from boke.comments, boke.users " +
                    "where users.id=comments.user_id and article_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(queryCommentSql)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String[] comment = new String[3];
                        comment[0] = resultSet.getString("nickname");
                        comment[1] = resultSet.getString("content");
                        comment[2] = resultSet.getString("published_at");

                        commentList.add(comment);
                    }
                }
            }

            //显示所有信息
            System.out.println(title);
            System.out.println(nickname);
            System.out.println(published_at);
            System.out.println("点赞数—> " + likeCount);
            System.out.println("-----------------------------------");
            System.out.println(content);
            System.out.println("-----------------------------------");
            for (String[] comment: commentList) {
                System.out.println(comment[0] + "|" + comment[1] + "|" + comment[2]);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
