package com.zxf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：ZXF
 * @program: Spring-MVC
 * @description:
 * @date ：2021-04-13 17:07
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private int age;
    private String sex;

}
