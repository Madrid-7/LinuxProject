package com.zxf;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：ZXF
 * @program: Servlet-BOKE
 * @description:
 * @date ：2021-03-23 20:59
 */

public class Test {
    public static void main(String[] args) throws SQLException {
        String username = "ZXF";
        String password = "123456";

        String out = User.encrypted(password);
        System.out.println(out);


        User.insert(username, password);
    }
}
