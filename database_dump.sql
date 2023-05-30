/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.33 : Database - collage_admission
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`collage_admission` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `collage_admission`;

/*Table structure for table `departments` */

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `departments` */

insert  into `departments`(`id`,`name`) values 
(1,'CSE'),
(4,'ECE'),
(3,'EEE'),
(5,'IT'),
(2,'MECH');

/*Table structure for table `student_class` */

DROP TABLE IF EXISTS `student_class`;

CREATE TABLE `student_class` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `department_id` int NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `student_class_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `student_class_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student_class` */

insert  into `student_class`(`id`,`student_id`,`department_id`,`active`) values 
(1,1,3,1),
(2,2,2,1),
(3,3,3,1),
(4,4,4,1),
(5,5,5,1),
(7,2,1,1);

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_no` bigint NOT NULL,
  `password` varchar(100) NOT NULL,
  `gender` char(1) NOT NULL,
  `dob` date DEFAULT NULL,
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  CONSTRAINT `students_chk_1` CHECK ((`gender` in (_utf8mb3'M',_utf8mb3'F')))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `students` */

insert  into `students`(`id`,`name`,`email`,`mobile_no`,`password`,`gender`,`dob`,`created_date`) values 
(1,'John Doe','john@example.com',1234567890,'password123','M','2000-01-01','2023-05-26 09:32:31'),
(2,'Jane Smith','jane@example.com',1234567891,'password456','F','1999-02-02','2023-05-26 09:32:31'),
(3,'Bob Johnson','bob@example.com',1234567892,'password789','M','1998-03-03','2023-05-26 09:32:31'),
(4,'Alice Williams','alice@example.com',1234567893,'password012','F','2001-04-04','2023-05-26 09:32:31'),
(5,'Charlie Brown','charlie@example.com',1234567894,'password345','M','2002-05-05','2023-05-26 09:32:31');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
