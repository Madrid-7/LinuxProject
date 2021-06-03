package org.example.controller;


import org.example.exception.AppException;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest req) {
        // 在数据库查询用户信息
        User exist = userService.query(user.getUsername());
        if (exist == null) throw new AppException("USR001", "用户不存在");

        // 验证密码
        if (!exist.getPassword().equals(user.getPassword()))
            throw new AppException("USR002", "用户名或密码错误");

        // 用户名，密码，验证通过，创建session保存用户信息
        HttpSession session = req.getSession();
        // 保存数据库查询结果的用户信息
        session.setAttribute("user", exist);

        return null;
    }

    @PostMapping("/register")
    public Object register(User user, MultipartFile headFile) {

        userService.register(user, headFile);

        return null;
    }

    @GetMapping("/logout")
    public Object logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }
}
