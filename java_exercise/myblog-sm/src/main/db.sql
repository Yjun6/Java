-- 编写sql 完成建库，建表

create database if not exists Java_blog_system;

use Java_blog_system;

drop table if exists user;
drop table if exists article;

create table article (
    id int primary key auto_increment, -- 自增主键
    title varchar(256), -- 博客的标题
    content varchar(4096), -- 博客内容
    createtime datetime, -- 创建时间
    updatetime datetime, -- 修改时间
    uid int, -- 博客的作者
    state int -- 状态
);

-- 用户表
create table user (
    id int primary key auto_increment,
    username varchar(64) unique, -- 用户名，要求不能重复
    password varchar(64), -- 密码
    photo varchar(1024), -- 照片
    createtime datetime, -- 创建时间
    updatetime datetime, -- 修改时间
    state int -- 状态
    -- github链接 ....
);

-- 修改user表表结构
alter table user add unique uq_username (username);

-- 构造一些初始数据，以便后续测试
insert into user values(1, 'zouyujie', '123'),(2, 'zhangsan', '123');

insert into article values(null, 'UDP和TCP的区别',
    '一、关于有连是：一个客户端可以连接多个服务器，一个服全双工：一个通道，可以双向通信。半双工：一个通道，只能单向通信。',
    '2023-10-15 20:58','2023-11-21 17:15',1,1);

insert into article values(null, 'UDP和TCP的区别',
    '以对应多个客户端的连接. 二、关于可靠传输和不可TCP和文件操据报只能单向通信。',
    '2023-10-15 20:58','2023-11-21 17:15',1,1);

