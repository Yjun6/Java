-- 编写sql 完成建库，建表

create database if not exists toy_hire_system;

use toy_hire_system;

drop table if exists user;
drop table if exists manager;
drop table if exists toy;
drop table if exists captcha;

-- 用户表
--用户：编号  姓名  密码 邮箱  电话  地址  租金  会员点数
create table user (
    id int primary key auto_increment,
    username varchar(64) unique, -- 用户名，要求不能重复
    password varchar(65) not null, -- 密码 为了使用加密算法
    email varchar(20), -- 邮箱
    phone varchar(20), -- 电话
    address varchar(50), -- 地址
    cash int  DEFAULT  200, -- 租金
    points INT  DEFAULT  500, -- 会员点数
    createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 创建时间
    updatetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 修改时间
    state int -- 状态
);

-- 管理员表
--管理员：编号 姓名 密码
create table manager (
    id int primary key auto_increment,
    username varchar(64) unique, -- 用户名，要求不能重复
    password varchar(65) not null, -- 密码 为了使用加密算法
    createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 创建时间
    updatetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 修改时间
    state int -- 状态
);

-- 玩具信息录入
--玩具： 编号  姓名 类型 价格 库存
CREATE TABLE toy (
	id	int primary key auto_increment,
	name VARCHAR(255) unique,
	situation	CHAR(255),
	price	INT,
	inventory int,
	createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 创建时间
    updatetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 修改时间
    state int -- 状态
);

-- 租聘表
create table hireuser (
    userid int not null,
    toyid int not null,
    createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 创建时间
    updatetime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 修改时间
    state int -- 状态
);

--验证码：验证码captcha (12023)
CREATE TABLE captcha (
	captcha varchar(65)
);
