package com.zxf.mapper;

import com.zxf.pojo.User;
import com.zxf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：ZXF
 * @program: Mybatis-Study
 * @description:
 * @date ：2021-04-19 19:35
 */

public class UserMapperTest {

    @Test
    public void test() {

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

    @Test
    public void getUserById() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.getUserById(1);
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            int res = mapper.addUser(new User(4, "ZXF", "321"));
            if (res > 0) {
                System.out.println("OK");
            }
            sqlSession.commit();
        }
    }

    @Test
    public void addUser2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();

            map.put("userid", 5);
            map.put("userName", "张心飞");
            map.put("passWord", "654321");

            mapper.addUser2(map);
            sqlSession.commit();
        }
    }

    @Test
    public void updateUser() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(4, "ZXXF", "zxcasd"));
            sqlSession.commit();
        }
    }
}
