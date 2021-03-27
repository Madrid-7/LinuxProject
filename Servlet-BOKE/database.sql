CREATE DATABASE IF NOT EXISTS servlet_boke CHARSET utf8mb4;
USE servlet_boke;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password CHAR(64) NOT NULL
);

CREATE TABLE images (
    id INT PRIMARY KEY AUTO_INCREMENT,
    image BLOB NOT NULL
);

CREATE TABLE articles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    author_id INT NOT NULL ,
    image_id INT NOT NULL ,
    title VARCHAR(200) NOT NULL ,
    body TEXT NOT NULL
);