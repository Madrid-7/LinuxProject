-- 建库
CREATE DATABASE TestProject CHARSET utf8mb4;
use TestProject;

-- 建表
-- 用户表
CREATE TABLE users
(
    id       INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增 id',
    username VARCHAR(200) NOT NULL UNIQUE COMMENT '唯一的用户名',
    nickname VARCHAR(200) NOT NULL COMMENT '昵称',
    address  VARCHAR(200) NOT NULL COMMENT '收货地址',
    image_path VARCHAR(200) NOT NULL COMMENT '头像储存路径'
);

-- 收藏表
CREATE TABLE favorite
(
    user_id  INT NOT NULL COMMENT '用户 id',
    good_id  INT NOT NULL COMMENT '商品 id',
    PRIMARY KEY (user_id, good_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- 商品表
CREATE TABLE goods
(
    id       INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增 id',
    user_id  INT NOT NULL COMMENT '用户 id',
    goodsname VARCHAR(200) NOT NULL COMMENT '商品名称',
    image_path VARCHAR(200) NOT NULL COMMENT '商品图片路径',
    description VARCHAR(200) NOT NULL COMMENT '商品描述'
)




