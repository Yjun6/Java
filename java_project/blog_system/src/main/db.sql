-- 编写sql 完成建库，建表

create database if not exists Java_blog_system;

use Java_blog_system;

drop table if exists user;
drop table if exists blog;

create table blog (
    blogId int primary key auto_increment, -- 自增主键
    title varchar(256), -- 博客的标题
    content varchar(4096), -- 博客内容
    userId int, -- 博客的作者
    postTime datetime -- 博客的发布时间
);

-- 用户表
create table user (
    userId int primary key auto_increment,
    username varchar(64) unique, -- 用户名，要求不能重复
    password varchar(64) -- 密码
    -- github链接 头像链接....
);

-- 构造一些初始数据，以便后续测试
insert into user values(1, 'zouyujie', '123'),(2, 'zhangsan', '123');

insert into blog values(1, 'UDP和TCP的区别',
    '一、关于有连接和无连接TCP进行编程时，会进行JDBC的Connection类似的连接过程，区别就是：一个客户端可以连接多个服务器，一个服务器也可以对应多个客户端的连接. 二、关于可靠传输和不可靠传输可靠传输就是A把消息发给B，无论传输是否成功还是失败，A都知道传输结果。TCP是可靠传输，传输效率低。UDP是不可靠传输，传输效率高。三、关于面向数据报和面向字节流TCP和文件操作类似，传输单位是字节，称为字节流。UDP面向数据报，读写的基本单位是一个UDP数据报。四、关于全双工和半双工全双工：一个通道，可以双向通信。半双工：一个通道，只能单向通信。',
    1,'2023-10-15 20:58');

insert into blog values(2, 'UDP和TCP的区别',
    '一、关于有连接和无连接TCP进行编程时，会进行JDBC的Connection类似的连接过程，区别就是：一个客户端可以连接多个服务器，一个服务器也可以对应多个客户端的连接. 二、关于可靠传输和不可靠传输可靠传输就是A把消息发给B，无论传输是否成功还是失败，A都知道传输结果。TCP是可靠传输，传输效率低。UDP是不可靠传输，传输效率高。三、关于面向数据报和面向字节流TCP和文件操作类似，传输单位是字节，称为字节流。UDP面向数据报，读写的基本单位是一个UDP数据报。四、关于全双工和半双工全双工：一个通道，可以双向通信。半双工：一个通道，只能单向通信。',
    1,'2023-10-15 20:58');
insert into blog values(3, 'UDP和TCP的区别',
    '一、关于有连接和无连接TCP进行编程时，会进行JDBC的Connection类似的连接过程，区别就是：一个客户端可以连接多个服务器，一个服务器也可以对应多个客户端的连接. 二、关于可靠传输和不可靠传输可靠传输就是A把消息发给B，无论传输是否成功还是失败，A都知道传输结果。TCP是可靠传输，传输效率低。UDP是不可靠传输，传输效率高。三、关于面向数据报和面向字节流TCP和文件操作类似，传输单位是字节，称为字节流。UDP面向数据报，读写的基本单位是一个UDP数据报。四、关于全双工和半双工全双工：一个通道，可以双向通信。半双工：一个通道，只能单向通信。',
    1,'2023-10-15 20:58');
