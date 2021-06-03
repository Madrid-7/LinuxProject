package org.example.service;

import org.example.exception.AppException;
import org.example.mapper.SettingMapper;
import org.example.mapper.UserMapper;
import org.example.model.Setting;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SettingMapper settingMapper;

    @Value("${user.head.local-path}")
    private String headLocalPath;

    @Value("${user.head.remote-path}")
    private String headRemotePath;

    public User query(String username) {
        return userMapper.query(username);
    }

    @Transactional   //绑定事务
    public void register(User user, MultipartFile headFile) {
        try {
            // 上传的用户头像，需要保存在服务器本地，部署好，通过url访问
            // 保证并发情况下  localPath 后的相对路径是唯一的
            if (headFile != null) {
                String uuid = UUID.randomUUID().toString();
                String uri = "/" + uuid + "/" + headFile.getOriginalFilename(); //上传时的名称

                String localPath = headLocalPath + uri;
                // 本地保存在 headLocalPath + uri ;  http 访问 headRemotePath + uri

                // 不能直接保存，父文件夹可能没有创建
                File head = new File(localPath);
                File parent = head.getParentFile();
                if (!parent.exists()) {
                    parent.mkdirs();
                }
                headFile.transferTo(head);

                // 用户头像的url, 设置到 user 对象的 head 属性
                user.setHead(headRemotePath + uri);

            }

            // 用户注册，插入用户数据到数据库
            userMapper.insertSelective(user);

            // 用户注册并登录后，跳转到设置页面，页面初始化就查询设置表数据绑定的奖项和人员信息
            // 所以注册时，再插入一条和用户绑定的设置数据
            Setting setting = new Setting();
            setting.setUserId(user.getId());
            setting.setBatchNumber(8);
            setting.setCreateTime(new Timestamp(new Date().getTime()));
            settingMapper.insert(setting);
        } catch (IOException e) {
            throw new AppException("USR003", "保存用户头像出错", e);
        }
    }
}
