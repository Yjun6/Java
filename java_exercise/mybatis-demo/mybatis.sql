-- 创建数据库
DROP DATABASE IF EXISTS mybatis_test;
CREATE DATABASE mybatis_test DEFAULT CHARACTER SET utf8mb4;
-- 使⽤数据数据
USE mybatis_test;
-- 创建表[⽤⼾表]
DROP TABLE IF EXISTS userinfo;
CREATE TABLE `userinfo` (
`id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
`username` VARCHAR ( 127 ) NOT NULL,
`password` VARCHAR ( 127 ) NOT NULL,
`age` TINYINT ( 4 ) NOT NULL,
`gender` TINYINT ( 4 ) DEFAULT '0' COMMENT '1-男 2-⼥ 0-默认',
`phone` VARCHAR ( 15 ) DEFAULT NULL,
`delete_flag` TINYINT ( 4 ) DEFAULT 0 COMMENT '0-正常, 1-删除',
`create_time` DATETIME DEFAULT now(),
`update_time` DATETIME DEFAULT now(),
PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
-- 添加⽤⼾信息
INSERT INTO mybatis_test.userinfo ( username, `password`, age, gender, phone )
VALUES ( 'admin', 'admin', 18, 1, '18612340001' );
INSERT INTO mybatis_test.userinfo ( username, `password`, age, gender, phone )
VALUES ( 'zhangsan', 'zhangsan', 18, 1, '18612340002' );
INSERT INTO mybatis_test.userinfo ( username, `password`, age, gender, phone )
VALUES ( 'lisi', 'lisi', 18, 1, '18612340003' );
INSERT INTO mybatis_test.userinfo ( username, `password`, age, gender, phone )
VALUES ( 'wangwu', 'wangwu', 18, 1, '18612340004' );