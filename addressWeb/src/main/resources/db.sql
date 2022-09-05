-- 删除数据库
drop database if exists addressweb;

-- 创建一个数据库
create database if not exists addressweb character set utf8;

-- 选中数据库
use addressweb;

-- 创建一个表
create table if not exists duser(
    pk_id int primary key auto_increment,
    name varchar(32),
    pwd varchar(64),
    email varchar(32),
    d_create timestamp default now(),
    d_modified timestamp default now()
);