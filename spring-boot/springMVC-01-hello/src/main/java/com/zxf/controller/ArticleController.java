package com.zxf.controller;

import com.zxf.model.Article;
import com.zxf.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ZXF
 * @program: spring-boot
 * @description:
 * @date ：2021-03-30 16:16
 */

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/query/{id}")
    @ResponseBody
    public Object queryById(@PathVariable("id") Integer id) {
        Article article = articleService.queryById(id);

        return article;
    }
}
