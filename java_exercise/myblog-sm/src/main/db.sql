-- 编写sql 完成建库，建表

create database if not exists Java_blog_system;

use Java_blog_system;

drop table if exists user;
drop table if exists article;

create table article (
    id int primary key auto_increment, -- 自增主键
    title varchar(256) NOT NULL, -- 博客的标题
    content varchar(5120) NOT NULL, -- 博客内容
    createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 创建时间
    updatetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 修改时间
    uid int NOT NULL, -- 博客的作者
    state int, -- 状态
    rcount INT DEFAULT 0-- 访问量
);

-- 用户表
create table user (
    id int primary key auto_increment,
    username varchar(64) unique, -- 用户名，要求不能重复
    password varchar(65) not null, -- 密码 为了使用加密算法
    photo varchar(1024), -- 照片
    nickname varchar(20), -- 昵称
    gender varchar(10), -- 性别
    github varchar(50), -- github链接 https://github.com/Yjun6
    createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 创建时间
    updatetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 修改时间
    state int -- 状态
);

--  不能直接插入user，会和加盐算法冲突
-- 构造一些初始数据，以便后续测试
--insert into article values(null, 'UDP和TCP的区别',
--    '以对应多个客户端的连接. 二、关于可靠传输和不可TCP和文件操据报只能单向通信。',
--    '2023-10-15 20:58','2023-11-21 17:15',1,1,0);

