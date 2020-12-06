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
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pid` int DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL,
  `did` int DEFAULT NULL,
  `dname` varchar(45) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  `state` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pname_dname` (`pname`,`dname`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,1,'梁夏雨',5,'玛卡巴卡',1,5,1),(2,1,'梁夏雨',5069,'六味地黄丸',1,80,1),(3,1,'梁夏雨',4399,'板蓝根',1,40,1),(4,1,'梁夏雨',5,'玛卡巴卡',1,5,1),(5,1,'梁夏雨',5,'玛卡巴卡',1,5,1),(6,1,'梁夏雨',4399,'板蓝根',1,40,1),(7,1,'梁夏雨',5,'玛卡巴卡',1,5,1),(8,1,'梁夏雨',4399,'板蓝根',1,40,1),(9,1,'梁夏雨',5,'玛卡巴卡',1,5,1),(10,1,'梁夏雨',4399,'板蓝根',1,40,1),(11,3,'1',4399,'板蓝根',1,40,1),(12,3,'1',5,'玛卡巴卡',1,5,1),(16,3,'1',5,'玛卡巴卡',1,5,1),(17,3,'1',4399,'板蓝根',1,40,0),(18,3,'1',5069,'六味地黄丸',1,80,0),(19,1,'梁夏雨',5,'玛卡巴卡',1,5,1),(20,1,'梁夏雨',5069,'六味地黄丸',1,80,1),(21,1,'梁夏雨',5,'玛卡巴卡',1,5,1),(25,5,'patient',4399,'板蓝根',1,100,1),(37,5,'patient',12345,'金银花冲剂',4,100,1),(39,1,'梁夏雨',4399,'板蓝根',1,100,0),(41,5,'patient',12345,'金银花冲剂',1,100,0),(42,5,'patient',5,'玛卡巴卡',1,5,0);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
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
