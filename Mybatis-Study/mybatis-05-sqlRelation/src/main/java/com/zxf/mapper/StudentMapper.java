package com.zxf.mapper;

import com.zxf.pojo.Student;
import com.zxf.pojo.Teacher;

import java.util.List;

/**
 * @author ：ZXF
 * @program: Mybatis-Study
 * @description:
 * @date ：2021-04-23 16:30
 */

public interface StudentMapper {

    List<Student> getStudent();

//    Teacher getTeacher(int id);

    List<Student> getStudent2();

}
