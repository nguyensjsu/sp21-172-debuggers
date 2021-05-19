-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: starbucks
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (45);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL,
  `drink` varchar(255) NOT NULL,
  `milk` varchar(255) NOT NULL,
  `size` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_model`
--

DROP TABLE IF EXISTS `payment_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_model` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `auth_id` varchar(255) DEFAULT NULL,
  `auth_status` varchar(255) DEFAULT NULL,
  `capture_id` varchar(255) DEFAULT NULL,
  `capture_status` varchar(255) DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `cvv` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `exp_month` varchar(255) DEFAULT NULL,
  `exp_year` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `order_number` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `transaction_amount` varchar(255) DEFAULT NULL,
  `transaction_currency` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_model`
--

LOCK TABLES `payment_model` WRITE;
/*!40000 ALTER TABLE `payment_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payments`
--

DROP TABLE IF EXISTS `payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payments` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `auth_id` varchar(255) DEFAULT NULL,
  `auth_status` varchar(255) DEFAULT NULL,
  `capture_id` varchar(255) DEFAULT NULL,
  `capture_status` varchar(255) DEFAULT NULL,
  `cardcvv` varchar(255) DEFAULT NULL,
  `cardexpmon` varchar(255) DEFAULT NULL,
  `cardexpyear` varchar(255) DEFAULT NULL,
  `cardnum` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `order_number` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `transaction_amount` varchar(255) DEFAULT NULL,
  `transaction_currency` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `starbucks_card` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payments`
--

LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (16,'2926 Vista Creek Drive','6212325931346723503006','AUTHORIZED','6212325935536716103003','PENDING','043','12','2022','4622 9431 2701 3713','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'2450130','6692637203','CA','30.00','USD','95133',NULL),(17,'2926 Vista Creek Drive','6212328233506717803003','AUTHORIZED','6212328238136724803004','PENDING','043','12','2022','4622 9431 2701 3713','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'3392272','6692637203','CA','30.00','USD','95133',NULL),(18,'2926 Vista Creek Drive','6212328649866725103004','AUTHORIZED','6212328654316718103003','PENDING','370','12','2022','4622 9431 2701 3747','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'7473157','6692637203','CA','30.00','USD','95133',NULL),(19,'2926 Vista Creek Drive','6212343473846738803004','AUTHORIZED','6212343478266813903001','PENDING','370','12','2022','4622 9431 2701 3747','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'5778946','6692637203','CA','20','USD','95133',NULL),(20,'2926 Vista Creek Drive','6212343673276739403005','AUTHORIZED','6212343679086739303006','PENDING','370','12','2022','4622 9431 2701 3747','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'5039286','6692637203','CA','100','USD','95133',NULL),(21,'2926 Vista Creek Drive','6212344183416750703002','AUTHORIZED','6212344188576740203004','PENDING','370','12','2022','4622 9431 2701 3747','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'3053604','6692637203','CA','30','USD','95133',NULL),(22,'2926 Vista Creek Drive','6212344193536740103005','AUTHORIZED','6212344200646740303006','PENDING','370','12','2022','4622 9431 2701 3747','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'3088937','6692637203','CA','30','USD','95133',NULL),(23,'2926 Vista Creek Drive','6212344209086815003001','AUTHORIZED','6212344213316750803002','PENDING','370','12','2022','4622 9431 2701 3747','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'3582045','6692637203','CA','20','USD','95133',NULL),(24,'2926 Vista Creek Drive','6212344216596731803003','AUTHORIZED','6212344222056740303004','PENDING','370','12','2022','4622 9431 2701 3747','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'9252035','6692637203','CA','20','USD','95133',NULL),(29,'2926 Vista Creek Drive','6213731002016753903004','AUTHORIZED','6213731006446752403006','PENDING','043','12','2022','4622 9431 2701 3713','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'1894610','6692637203','CA','20','USD','95133','251940017'),(30,'2926 Vista Creek Drive','6213731424246752903006','AUTHORIZED','6213731428836851103001','PENDING','043','12','2022','4622 9431 2701 3713','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'8357760','6692637203','CA','20','USD','95133','251940017'),(31,'2926 Vista Creek Drive','6213731482806851203001','AUTHORIZED','6213731487216755503003','PENDING','043','12','2022','4622 9431 2701 3713','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'2788038','6692637203','CA','20','USD','95133','251940017'),(32,'2926 Vista Creek Drive','6213736751326782803002','AUTHORIZED','6213736757606776003004','PENDING','838','12','2022','4622 9431 2701 3705','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'8922907','6692637203','CA','30','USD','95133','251940017'),(33,'2926 Vista Creek Drive','6213747922676837503006','AUTHORIZED','6213747928136837603006','PENDING','838','12','2022','4622 9431 2701 3705','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'1455138','6692637203','CA','20','USD','95133','251940017'),(34,'2926 Vista Creek Drive','6213749842056848503006','AUTHORIZED','6213749847456857103002','PENDING','838','12','2022','4622 9431 2701 3705','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'7444088','6692637203','CA','20','USD','95133','521297525'),(35,'2926 Vista Creek Drive','6213756963796892403004','AUTHORIZED','6213756970366884403005','PENDING','838','12','2022','4622 9431 2701 3705','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'3141861','6692637203','CA','20','USD','95133','251940017'),(36,'2926 Vista Creek Drive','6213758277436900903003','AUTHORIZED','6213758292906892303005','PENDING','838','12','2022','4622 9431 2701 3705','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'5006984','6692637203','CA','20','USD','95133','251940017'),(37,'2926 Vista Creek Drive','6213773712616000503003','AUTHORIZED','6213773718226995103006','PENDING','838','12','2022','4622 9431 2701 3705','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'5390506','6692637203','CA','20','USD','95133','190922769'),(43,'2926 Vista Creek Drive','6213831436816392103001','AUTHORIZED','6213831441606293403004','PENDING','043','12','2022','4622 9431 2701 3713','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'8457018','6692637203','CA','30','USD','95133','235941197'),(44,'2926 Vista Creek Drive','6213836412636331503004','AUTHORIZED','6213836417326331803003','PENDING','838','12','2022','4622 9431 2701 3705','San Jose','augustczy@gmail.com','zeyu','Cheng',NULL,'4157045','6692637203','CA','20','USD','95133','235941197');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `starbucks_card`
--

DROP TABLE IF EXISTS `starbucks_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `starbucks_card` (
  `id` bigint NOT NULL,
  `activated` bit(1) NOT NULL,
  `balance` double NOT NULL,
  `card_code` varchar(255) NOT NULL,
  `card_number` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `altIndex` (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `starbucks_card`
--

LOCK TABLES `starbucks_card` WRITE;
/*!40000 ALTER TABLE `starbucks_card` DISABLE KEYS */;
INSERT INTO `starbucks_card` VALUES (5,_binary '',170,'118','521297525','New Card'),(7,_binary '',150,'779','251940017','New Card'),(11,_binary '',20,'642','515185156','New Card'),(14,_binary '',80,'683','190922769','New Card'),(15,_binary '',60,'278','235941197','New Card'),(25,_binary '\0',20,'267','469500481','New Card'),(26,_binary '\0',20,'590','669993195','New Card'),(27,_binary '\0',20,'807','152556154','New Card'),(28,_binary '\0',20,'512','856508807','New Card'),(38,_binary '\0',20,'604','345661880','New Card'),(39,_binary '\0',20,'762','602274970','New Card'),(40,_binary '\0',20,'349','181005012','New Card'),(41,_binary '\0',20,'154','481394471','New Card'),(42,_binary '\0',20,'381','926823709','New Card');
/*!40000 ALTER TABLE `starbucks_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'starbucks'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-18 17:35:48
