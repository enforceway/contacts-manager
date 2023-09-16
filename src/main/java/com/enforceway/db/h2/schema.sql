DROP TABLE IF EXISTS `db_phonebook`;
CREATE DATABASE `db_phonebook`;
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
   `id` int NOT NULL,
   `userName` varchar(20) DEFAULT NULL COMMENT '姓名',
   `password` varchar(20) DEFAULT NULL COMMENT '密码',
   PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `t_phonebook`;
CREATE TABLE `t_phonebook` (
   `id` int NOT NULL,
   `name` varchar(50) DEFAULT NULL COMMENT '姓名',
   `phoneNumber` varchar(50) DEFAULT NULL COMMENT '手机号码',
   `teleNumber` varchar(50) DEFAULT NULL COMMENT '座机电话号码',
   `workAddress` varchar(200) DEFAULT NULL COMMENT '工作单位地址',
   `homeAddress` varchar(200) DEFAULT NULL COMMENT '家庭地址',
   `image` varchar(100) DEFAULT NULL COMMENT '头像',
   `remark` varchar(1000) DEFAULT NULL COMMENT '备注其他',
   `initial` varchar(1) DEFAULT NULL COMMENT '姓名首字母',
   PRIMARY KEY (`id`)
);
