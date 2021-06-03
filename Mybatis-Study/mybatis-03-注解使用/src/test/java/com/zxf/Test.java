package com.zxf;

import com.zxf.mapper.UserMapper;
import com.zxf.pojo.User;
import com.zxf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author ：ZXF
 * @program: Mybatis-Study
 * @description:
 * @date ：2021-04-21 21:28
 */

public class Test {

    @org.junit.Test
    public void getUserList() {
        // 获取 SqlSession 对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            // 执行 SQL
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            for (User u : userList) {
                System.out.println(u);
            }
        }
    }

    @org.junit.Test
    public void getUserById() {
        // 获取 SqlSession 对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            // 执行 SQL
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);

            System.out.println(user);
        }
    }
}
