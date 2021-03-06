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
 * @date ：2021-03-04 23:20
 */

public class ArticleFindListAction implements Action {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入标题相关内容:>");
        String str = sc.nextLine();
        str = "%" + str + "%";

        try (Connection connection = DBUtil.getConnection()) {
            List<String[]> articleList = new ArrayList<>();
            String sql = "select articles.id, nickname, title, published_at " +
                    "from boke.articles, boke.users " +
                    "where author_id=users.id and title like ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, str);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String[] article = new String[4];
                        article[0] = resultSet.getString("articles.id");
                        article[1] = resultSet.getString("nickname");
                        article[2] = resultSet.getString("title");
                        article[3] = resultSet.getString("published_at");

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
