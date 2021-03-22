package com.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：ZXF
 * @program: Servlet-2
 * @description:
 * @date ：2021-03-22 22:53
 */

public class UserTable {
    static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("ZXF", "qwe", "111", 200));
        userList.add(new User("QWE", "asd", "222", 2000));
        userList.add(new User("ZXC", "wsx", "333", 20000));
        userList.add(new User("QAZ", "edc", "444", 200000));
    }

    public static User select(String username, String password) {
        for (User user : userList) {
            if (username.equals(user.username) && password.equals(user.password)) {
                return user;
            }
        }
        return null;
    }
}
