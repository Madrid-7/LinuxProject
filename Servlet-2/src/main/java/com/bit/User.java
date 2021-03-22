package com.bit;

/**
 * @author ：ZXF
 * @program: Servlet-2
 * @description:
 * @date ：2021-03-22 20:51
 */

public class User {
    String username;
    String nickname;
    String password;
    long balance;

    public User(String username, String nickname, String password, long balance) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.balance = balance;
    }


}
