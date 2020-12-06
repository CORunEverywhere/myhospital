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
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record` (
  `no` int NOT NULL AUTO_INCREMENT,
  `drugSno` varchar(20) DEFAULT NULL,
  `drugSname` varchar(20) DEFAULT NULL,
  `personSno` varchar(20) DEFAULT NULL,
  `personSname` varchar(20) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `stime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`no`),
  KEY `drug_person` (`drugSname`,`personSname`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,'23','华佗',NULL,NULL,2,'23:03'),(2,'4399','板蓝根',NULL,NULL,-50,'18-10-2020 23:28:20'),(3,'4399','板蓝根',NULL,NULL,-50,'18-10-2020 23:28:20'),(4,'5','玛卡巴卡',NULL,NULL,900,'18-10-2020 23:54:24'),(5,'5','玛卡巴卡',NULL,NULL,-200,'18-10-2020 23:56:43'),(6,'5069','六味地黄丸',NULL,NULL,90,'19-10-2020 09:31:08'),(7,'5','玛卡巴卡',NULL,NULL,-20,'19-10-2020 19:50:23'),(8,'4399','板蓝根',NULL,NULL,10,'19-10-2020 22:13:46'),(9,'4399','板蓝根',NULL,NULL,-1000,'19-10-2020 22:21:00'),(10,'5069','六味地黄丸',NULL,NULL,20,'19-10-2020 22:23:51'),(11,'4399','板蓝根',NULL,NULL,1000,'19-10-2020 22:29:25'),(12,'5','玛卡巴卡',NULL,NULL,2000,'20-10-2020 10:28:37'),(13,'5069','六味地黄丸',NULL,NULL,1000,'20-10-2020 10:28:45'),(14,'4399','板蓝根',NULL,NULL,1000,'21-10-2020 10:09:54'),(15,'666','999感冒灵','3','张三',666,'10-11-2020 20:17:06'),(16,'4399','板蓝根','3','张三',-60,'10-11-2020 20:35:37'),(17,'4399','板蓝根','1','李华',900,'02-12-2020 19:38:48'),(18,'4399','板蓝根','1','李华',-2222,'02-12-2020 20:18:29'),(19,'4399','板蓝根','1','李华',2222,'02-12-2020 20:18:46'),(20,'12345','金银花冲剂','1','李华',10000,'02-12-2020 20:22:44'),(21,'12345','金银花冲剂','1','李华',-5000,'02-12-2020 20:26:56'),(22,'12345','金银花冲剂','1','李华',-5000,'02-12-2020 20:26:58'),(23,'12345','金银花冲剂','1','李华',-5000,'02-12-2020 20:27:00'),(24,'12345','金银花冲剂','1','李华',-5000,'02-12-2020 20:27:02'),(25,'12345','金银花冲剂','1','李华',-5000,'02-12-2020 20:27:03'),(26,'12345','金银花冲剂','1','李华',20000,'02-12-2020 20:27:52'),(27,'12345','金银花冲剂','1','李华',-5000,'02-12-2020 22:54:43'),(28,'12345','金银花冲剂','1','李华',5000,'02-12-2020 22:57:48'),(29,'12345','金银花冲剂','1','李华',-1000,'04-12-2020 12:56:58'),(30,'5069','六味地黄丸','1','李华',-100,'05-12-2020 16:42:03'),(31,'5069','六味地黄丸','1','李华',500,'05-12-2020 16:42:19'),(32,'5069','六味地黄丸','1','李华',0,'05-12-2020 16:45:04'),(33,'12345','金银花冲剂','1','李华',0,'05-12-2020 16:47:30'),(34,'12345','金银花冲剂','1','李华',5,'06-12-2020 00:44:05'),(35,'12345','金银花冲剂','1','李华',-4005,'06-12-2020 15:52:51'),(36,'12345','金银花冲剂','1','李华',5000,'06-12-2020 15:53:01');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
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
