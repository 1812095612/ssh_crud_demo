/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.51 : Database - ssh0315
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssh0315` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ssh0315`;

/*Table structure for table `depts` */

DROP TABLE IF EXISTS `depts`;

CREATE TABLE `depts` (
  `DEPT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `depts` */

insert  into `depts`(`DEPT_ID`,`DEPT_NAME`) values (1,'市场部'),(2,'后勤部'),(3,'研发部');

/*Table structure for table `emps` */

DROP TABLE IF EXISTS `emps`;

CREATE TABLE `emps` (
  `EMP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMP_NAME` varchar(255) DEFAULT NULL,
  `DEPT_ID_FK` int(11) DEFAULT NULL,
  PRIMARY KEY (`EMP_ID`),
  KEY `FK_f8fop294ka3lee1d863p481eu` (`DEPT_ID_FK`),
  CONSTRAINT `FK_f8fop294ka3lee1d863p481eu` FOREIGN KEY (`DEPT_ID_FK`) REFERENCES `depts` (`DEPT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `emps` */

insert  into `emps`(`EMP_ID`,`EMP_NAME`,`DEPT_ID_FK`) values (1,'张三',1),(2,'李四',2),(3,'王五五',3),(4,'王八',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
