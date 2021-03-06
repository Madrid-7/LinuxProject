package com.zxf.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author ：ZXF
 * @program: Mybatis-Study
 * @description:
 * @date ：2021-04-23 16:28
 */

@Data
public class Teacher {

    private int id;
    private String name;

    private List<Student> students;
}
