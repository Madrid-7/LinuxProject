package org.example.controller;

import org.example.model.Setting;
import org.example.model.User;
import org.example.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author ：ZXF
 * @program: lucky-draw
 * @description:
 * @date ：2021-06-02 23:43
 */

@RestController
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping("/query")
    public Object query(HttpSession session){
        // 返回 setting 对象，缺少的属性先构造
        // 需要 setting 对象，通过 user_id 从数据库查询
        User user = (User) session.getAttribute("user");
        Setting setting = settingService.query(user.getId());
        setting.setUser(user);

        return setting;
    }

    @GetMapping("/update")
    public Object update(HttpSession session, Integer batchNumber) {
        User user = (User) session.getAttribute("user");
        Setting setting = new Setting();
        setting.setId(user.getSettingId());
        setting.setBatchNumber(batchNumber);
        int n = settingService.update(setting);

        return null;
    }

}
