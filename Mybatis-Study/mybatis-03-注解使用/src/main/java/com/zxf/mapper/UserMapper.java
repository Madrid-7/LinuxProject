package com.zxf.mapper;

import com.zxf.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author ：ZXF
 * @program: Mybatis-Study
 * @description:
 * @date ：2021-04-19 19:17
 */

public interface UserMapper {
    // 查询全部用户
    @Select("select * from user")
    List<User> getUserList();

    // 根据 ID 查询用户
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    // 增加用户
    int addUser(User user);

    // 万能的 Map
    int addUser2(Map<String, Object> map);

    // 修改
    void updateUser(User user);

    // 删除
    int deleteUser(int id);
}
