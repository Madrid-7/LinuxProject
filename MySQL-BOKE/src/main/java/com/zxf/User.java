package com.zxf;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description: 用户类
 * @date ：2021-02-24 15:27
 */

public class User {
    int id;
    String username;
    String nickname;

    public User() {

    }

    public User(int id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }

    private static User currentUser = null;

    public static void login(User user) {
        currentUser = user;
        System.out.println("当前登陆的用户信息是: " + currentUser);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggined() {
        if (currentUser == null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
