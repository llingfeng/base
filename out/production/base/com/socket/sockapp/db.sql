create database socketdb CHARACTER set uft8;

create table user(
  user_id int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  user_name VARCHAR(30) NOT NULL COMMENT '用户名',
  user_password VARCHAR(30) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (user_id)
)ENGINE = InnoDB AUTO_INCREMENT 10000 DEFAULT CHARSET = utf8 COMMENT '用户表';

create table tran_file(
  id int NOT NULL AUTO_INCREMENT COMMENT '文件id',
  name VARCHAR(30) NOT NULL COMMENT '文件名',
  content BLOB NOT NULL COMMENT '文件内容',
  PRIMARY KEY (id)
)ENGINE = InnoDB AUTO_INCREMENT 10000 DEFAULT CHARSET = utf8 COMMENT '传输文件表';