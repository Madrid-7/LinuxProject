package com.zxf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author ：ZXF
 * @program: Mybatis-Study
 * @description:
 * @date ：2021-04-19 19:14
 */

@Alias("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String name;
    private String pwd;

}
