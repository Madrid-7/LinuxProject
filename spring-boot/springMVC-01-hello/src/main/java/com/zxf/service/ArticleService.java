package com.zxf.service;

import com.zxf.mapper.ArticleMapper;
import com.zxf.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-30 16:17
 */

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    public Article queryById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
