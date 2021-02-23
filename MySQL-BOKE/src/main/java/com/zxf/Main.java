package com.zxf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：ZXF
 * @program: MySQL-BOKE
 * @description: TestProject
 * @date ：2021-02-22 11:15
 */

public class Main {

    // 当前登录的用户信息，没有登录则为空
    //private static User user = null;

    private static List<String> featureList = new ArrayList<>();
    private static List<Action> actionList = new ArrayList<>();

    private static void initFeatureList() {
        featureList.add("用户注册");
        featureList.add("用户登录");
        featureList.add("查看文章列表-按照发表时间倒序排列");
        featureList.add("发表文章-需要先登录");
        featureList.add("查看指定文章内容");
        featureList.add("评论文章-需要先登录");
        featureList.add("点赞文章-需要先登录");

    }

    private static void initActionList() {
        actionList.add(new UserRegisterAction());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initFeatureList();
        initActionList();
        while (true) {
            showMenu();
            showPrompt();
            int select = sc.nextInt();
            doAction(select);


        }

    }

    private static void doAction(int select) {
        if (select == 0) {
            System.out.println("退出。。。");
            System.exit(0);
        }

        System.out.println("选择是：" + featureList.get(select - 1));
        if (select - 1 < actionList.size()) {
            Action action = actionList.get(select - 1);
            action.run();
        } else {
            System.out.println("该功能未实现，敬请期待。。。");
        }
    }

    private static void showPrompt() {
        System.out.println("请输入>");
    }

    private static void showMenu() {
        System.out.println("欢迎使用：>");
        for (int i = 0; i < featureList.size(); i++) {
            System.out.printf("  %d.  %s%n", i+1, featureList.get(i));
        }
        System.out.println("  0.  退出");
    }
}
