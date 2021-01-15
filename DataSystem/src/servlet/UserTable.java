package servlet;

import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User(
                "783798088@qq.com", "张心飞", "111", 500
        ));
        userList.add(new User(
                "qwe", "请问", "222", 1000
        ));
        userList.add(new User(
                "asd", "阿萨德", "333", 2000
        ));
        userList.add(new User(
                "zxc", "自行车", "444", 10
        ));
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
