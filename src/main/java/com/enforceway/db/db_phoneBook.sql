/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.18-log : Database - db_phonebook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_phonebook` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_phonebook`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`userName`,`password`) values (1,'java1234','123456');

/*Table structure for table `t_phonebook` */

DROP TABLE IF EXISTS `t_phonebook`;

CREATE TABLE `t_phonebook` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phoneNumber` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `teleNumber` varchar(50) DEFAULT NULL COMMENT '座机电话号码',
  `workAddress` varchar(200) DEFAULT NULL COMMENT '工作单位地址',
  `homeAddress` varchar(200) DEFAULT NULL COMMENT '家庭地址',
  `image` varchar(100) DEFAULT NULL COMMENT '头像',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注其他',
  `initial` varchar(1) DEFAULT NULL COMMENT '姓名首字母',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_phonebook` */

insert  into `t_phonebook`(`id`,`name`,`phoneNumber`,`teleNumber`,`workAddress`,`homeAddress`,`image`,`remark`,`initial`) values (1,'牛22dfsd2121fgg','32243241158','0512-86965431','北京市丰台区牛逼大厦A座2','北京市通州区牛逼小区2号楼1012','20190905093006.jpg','qq:2213213121','N'),(2,'aaaa222','13977777722','0512-86965432','北京市丰台区牛逼大厦A座','北京市通州区牛逼小区2号楼101','20190906024037.jpg','qq:221321312','A'),(3,'哔哔娃娃2233','13977777723','0512-869654323','北京市丰台区牛逼大厦A座3','北京市通州区牛逼小区2号楼1013','20190906102014.jpg','qq:2213213123','B'),(4,'别克销售2','13977777723','0512-86965433','北京市丰台区牛逼大厦A座','北京市通州区牛逼小区2号楼101','004.png','qq:221321312','B'),(5,'曹锋2','15526585412','453586655',NULL,NULL,'20190905092414.jpeg',NULL,'C'),(7,'曹仁2','19989056456','0812-90909123',NULL,NULL,'20190906101013.jpg',NULL,'C'),(8,'操一2','222',NULL,NULL,NULL,'004.png',NULL,'C'),(9,'插插苏','12575655556',NULL,NULL,NULL,'20190904083546.jpeg',NULL,'C'),(10,'C罗',NULL,NULL,NULL,NULL,'006.png',NULL,'C'),(11,'狄仁杰',NULL,NULL,NULL,NULL,'007.png',NULL,'D'),(12,'的哥',NULL,NULL,NULL,NULL,'008.png',NULL,'D'),(13,'低人一等',NULL,NULL,NULL,NULL,'009.png',NULL,'D'),(14,'抖抖',NULL,NULL,NULL,NULL,'010.png',NULL,'D'),(15,'EE',NULL,NULL,NULL,NULL,'010.png',NULL,'E'),(17,'GG',NULL,NULL,NULL,NULL,'010.png',NULL,'G'),(18,'HH',NULL,NULL,NULL,NULL,'010.png',NULL,'H'),(20,'JJ',NULL,NULL,NULL,NULL,'010.png',NULL,'J'),(21,'KK',NULL,NULL,NULL,NULL,'010.png',NULL,'K'),(22,'LL',NULL,NULL,NULL,NULL,'010.png',NULL,'L'),(23,'MM',NULL,NULL,NULL,NULL,'010.png',NULL,'M'),(24,'NN',NULL,NULL,NULL,NULL,'010.png',NULL,'N'),(25,'OO',NULL,NULL,NULL,NULL,'010.png',NULL,'O'),(26,'PP',NULL,NULL,NULL,NULL,'010.png',NULL,'P'),(27,'QQ',NULL,NULL,NULL,NULL,'010.png',NULL,'Q'),(28,'RR',NULL,NULL,NULL,NULL,'010.png',NULL,'R'),(29,'SS',NULL,NULL,NULL,NULL,'010.png',NULL,'S'),(30,'TT',NULL,NULL,NULL,NULL,'010.png',NULL,'T'),(31,'UU',NULL,NULL,NULL,NULL,'010.png',NULL,'U'),(32,'VV',NULL,NULL,NULL,NULL,'010.png',NULL,'V'),(33,'WW',NULL,NULL,NULL,NULL,'010.png',NULL,'W'),(34,'XX',NULL,NULL,NULL,NULL,'010.png',NULL,'X'),(35,'YY',NULL,NULL,NULL,NULL,'010.png',NULL,'Y'),(36,'ZZ',NULL,NULL,NULL,NULL,'010.png',NULL,'Z'),(37,'撒旦法','18862859852','1234-34565434','南通','金色','default.jpg','111','S'),(38,'曹姐','18863957204','0513-58625832',NULL,NULL,'default.jpg',NULL,'C'),(39,'呵呵','13968554562',NULL,'试试',NULL,'20190906100951.jpg',NULL,'H');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
