package com.zxf.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-28 17:53
 */

@Getter
@Setter
@ToString
public class User {

    private String username;
    private String password;
    private Date birthday;
}
