package com.zxf.mapper;

import com.zxf.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeachers();

    Teacher getTeacher(@Param("id") int id);

    Teacher getTeacher2(@Param("id") int id);

}
