package com.zxf.pojo;

import lombok.Data;

/**
 * @author ：ZXF
 * @program: spring
 * @description:
 * @date ：2021-03-28 15:14
 */

@Data
public class User {
    private int id;
    private String username;
    private String nickname;
    private String password;
}
