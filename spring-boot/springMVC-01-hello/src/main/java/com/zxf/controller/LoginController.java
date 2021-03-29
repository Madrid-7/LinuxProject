package com.zxf.controller;

import com.zxf.model.User;
import com.zxf.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-28 16:54
 */

@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @Autowired
    @Qualifier("user1")
    private User user1;

    @Resource(name = "user2")
    private User user2;

    @RequestMapping("/login")
    public String login(Integer i) {
        if (i == 1)
            return "redirect:/index.html";    // 重定向   默认路径改变
        else
            return "forward:/index.html";    // 转发  默认相对路径不变
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ResponseBody
    public Object login2(@RequestParam("username") String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login3", method = RequestMethod.POST)
    @ResponseBody
    public Object login3(User user) {
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping(value = "/login4", method = RequestMethod.POST)
    @ResponseBody
    public Object login4(@RequestBody User user) {

        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/login5", method = RequestMethod.POST)
    @ResponseBody
    public Object login5(HttpServletRequest request, HttpServletResponse response, User u) {

        User user = new User();
        user.setUsername("ZXF");
        user.setPassword("123456");

        if (user.getUsername().equals(u.getUsername()) && user.getPassword().equals(u.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            return u;
        }

        throw new RuntimeException("登录失败");
    }

    @RequestMapping(value = "/{type}/login6", method = RequestMethod.POST)
    @ResponseBody
    public Object login5(@PathVariable("type") String type) {
        System.out.println(type);

        System.out.println(loginService);
        System.out.println(user1);
        System.out.println(user2);

        User user = new User();
        user.setUsername("ZXF");
        user.setPassword("123456");

        return user;
    }
}
