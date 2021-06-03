USE mybatis;

CREATE TABLE teacher (
    id INT(10) NOT NULL ,
    name VARCHAR(30) DEFAULT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=utf8;

INSERT INTO teacher(id, name) VALUES (1, '苍老师');

CREATE TABLE student (
    id INT(10) NOT NULL ,
    name VARCHAR(30) DEFAULT NULL,
    tid INT(10) DEFAULT NULL,
    PRIMARY KEY (id),
    KEY fktid (tid),
    CONSTRAINT fktid FOREIGN KEY (tid) REFERENCES teacher(id)
)DEFAULT CHARSET=utf8;

INSERT INTO student(id, name, tid) VALUES
('1', 'AAA', '1'),
('2', 'BBB', '1'),
('3', 'CCC', '1'),
('4', 'DDD', '1'),
('5', 'EEE', '1');
