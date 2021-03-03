-- 建库
CREATE DATABASE boke CHARSET utf8mb4;
use boke;

-- 建表
-- 用户表
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增 id',
    username VARCHAR(200) NOT NULL UNIQUE COMMENT '唯一的用户名',
    nickname VARCHAR(200) NOT NULL COMMENT '显示名称',
    password VARCHAR(200) NOT NULL COMMENT '登录密码'
);

-- 文章表
CREATE TABLE articles (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增 id',
    author_id INT NOT NULL COMMENT '作者 id',
    title VARCHAR(200) NOT NULL COMMENT '文章标题',
    published_at DATETIME NOT NULL COMMENT '文章发表时间',
    content TEXT NOT NULL COMMENT '文章正文'
);

-- 评论表
CREATE TABLE comments (
    id INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增 id',
    user_id INT NOT NULL COMMENT '评论者id',
    article_id INT NOT NULL COMMENT '文章id',
    published_at DATETIME NOT NULL COMMENT '评论发表时间',
    content VARCHAR(200) NOT NULL COMMENT '评论正文'
);

-- 点赞关系表
-- 使用复合主键的形式
CREATE TABLE like_relations (
    user_id INT NOT NULL COMMENT '评论者 id',
    article_id INT NOT NULL COMMENT '文章 id',
    PRIMARY KEY (user_id, article_id)
);