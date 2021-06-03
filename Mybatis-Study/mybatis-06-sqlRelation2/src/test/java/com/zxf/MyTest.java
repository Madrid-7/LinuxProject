package com.zxf;

import com.zxf.mapper.StudentMapper;
import com.zxf.mapper.TeacherMapper;
import com.zxf.pojo.Student;
import com.zxf.pojo.Teacher;
import com.zxf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ：ZXF
 * @program: Mybatis-Study
 * @description:
 * @date ：2021-04-23 16:43
 */

public class MyTest {

    @Test
    public void getTeachers() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teacher = mapper.getTeachers();
            for (Teacher t : teacher) {
                System.out.println(t);
            }
        }
    }

    @Test
    public void getTeacher() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacher(1);
            System.out.println(teacher);
        }
    }

    @Test
    public void getTeacher2() {
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = mapper.getTeacher2(1);
            System.out.println(teacher);
        }
    }
}
