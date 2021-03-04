package com.zxf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description:
 * @date ：2021-03-03 20:45
 */

public class ArticleListAction implements Action {
    @Override
    public void run() {
        try (Connection connection = DBUtil.getConnection()) {
            List<String[]> articleList = new ArrayList<>();
            String sql = "select articles.id, nickname, title, published_at " +
                    "from boke.articles, boke.users " +
                    "where author_id = users.id " +
                    "order by published_at";
            try (PreparedStatement s = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = s.executeQuery()) {
                    while (resultSet.next()) {
                        String[] article = new String[4];
                        String id = resultSet.getString("articles.id");
                        String nickname = resultSet.getString("nickname");
                        String title = resultSet.getString("title");
                        String publishedAt = resultSet.getString("published_at");
                        article[0] = id;
                        article[1] = nickname;
                        article[2] = title;
                        article[3] = publishedAt;

                        articleList.add(article);
                    }
                }
            }
            System.out.println("#ID | 标题 | 作者 | 发表时间");
            for (String[] article : articleList) {
                System.out.printf("%-4s | %-40s | %-2s | %s%n", article[0], article[2], article[1], article[3]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
