package org.example.controller;

import org.example.model.User;
import org.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：ZXF
 * @program: lucky-draw
 * @description:
 * @date ：2021-06-02 23:53
 */

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/add/{id}")
    public Object add(@PathVariable Integer id, @RequestBody List<Integer> memberIds) {
        int n = recordService.add(id, memberIds);
        return null;
    }

    @GetMapping("/delete/member")
    public Object deleteByMemberId(Integer id) {
        int n = recordService.deleteByMemberId(id);
        return null;
    }

    @GetMapping("/delete/award")
    public Object deleteByAwardId(Integer id) {
        int n = recordService.deleteByAwardId(id);
        return null;
    }

    @GetMapping("/delete/setting")
    public Object deleteBySettingId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        int n = recordService.deleteBySettingId(user.getSettingId());
        return null;
    }
}
