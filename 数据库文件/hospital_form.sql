-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pid` int NOT NULL,
  `pname` varchar(45) DEFAULT NULL,
  `did` int NOT NULL,
  `dname` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `state` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`,`did`),
  KEY `pid_did` (`pid`,`did`),
  KEY `pname_dname` (`pname`,`dname`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES (1,1,'梁夏雨',2,'李时珍','07-11-2020 22:54:21',1),(2,1,'梁夏雨',2,'李时珍','09-11-2020 21:23:44',1),(3,3,'1',8,'张三','10-11-2020 22:01:17',1),(4,3,'1',2,'李时珍','11-11-2020 10:58:57',1),(5,3,'1',2,'李时珍','12-11-2020 17:10:11',1),(6,3,'1',2,'李时珍','12-11-2020 17:10:40',1),(7,1,'梁夏雨',8,'张三','23-11-2020 22:08:42',1),(8,1,'梁夏雨',8,'张三','23-11-2020 22:09:37',1),(9,1,'梁夏雨',8,'张三','23-11-2020 22:09:40',1),(10,5,'patient',2,'李时珍','02-12-2020 22:32:22',1),(11,5,'patient',2,'李时珍','04-12-2020 13:27:09',1),(12,1,'梁夏雨',2,'李时珍','05-12-2020 23:12:06',0),(13,5,'patient',2,'李时珍','06-12-2020 15:56:58',0),(14,5,'patient',2,'李时珍','06-12-2020 15:58:12',0);
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-06 19:43:59
