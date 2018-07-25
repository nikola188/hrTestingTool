-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: first
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.34-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(256) NOT NULL,
  `id_question` int(11) NOT NULL,
  `is_correct` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_question` (`id_question`),
  CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`id_question`) REFERENCES `question` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,'answer1',1,1),(2,'answer 2',1,1),(3,'answer3',1,0),(4,'answer 4',1,0),(5,'answer1',2,0),(6,'answer2',2,1),(7,'answer3',2,1),(8,'answer4',2,0),(9,'answer1',3,1),(10,'answer2',3,0),(11,'answer1',4,0),(12,'answer1',5,0),(13,'answer2',5,1),(14,'answer2',4,1),(15,'answer1',6,1),(16,'answer2',6,1),(17,'answer3',6,0),(18,'answer4',6,0),(19,'answer1',7,1),(20,'answer2',7,1),(21,'answer3',7,0),(22,'answer4',7,0),(23,'answer1',8,1),(24,'answer2',8,0),(25,'answer1',9,0),(26,'answer2',9,0),(27,'answer1',10,1),(28,'answer2',10,0),(29,'answer1',11,1),(30,'answer2',11,1),(31,'answer3',11,0),(32,'answer4',11,0),(33,'answer1',12,1),(34,'answer2',12,1),(35,'answer3',12,0),(36,'answer4',12,0),(37,'answer1',13,0),(38,'answer2',13,1),(39,'answer1',14,1),(40,'answer2',14,0),(41,'answer1',15,1),(42,'answer2',15,0),(43,'answer1',16,1),(44,'answer2',16,1),(45,'answer3',16,0),(46,'answer4',16,0),(47,'answer1',17,0),(48,'answer2',17,0),(49,'answer3',17,1),(50,'answer4',17,1),(51,'answer1',18,1),(52,'answer2',18,0),(53,'answer1',19,1),(54,'answer2',19,0),(55,'answer1',20,1),(56,'answer2',20,0),(57,'answer1',21,1),(58,'answer2',21,1),(59,'answer3',21,0),(60,'answer4',21,0),(61,'answer1',22,1),(62,'answer2',22,1),(63,'answer3',22,0),(64,'answer4',22,0),(65,'answer1',23,1),(66,'answer2',23,0),(67,'answer1',24,0),(68,'answer2',24,1),(69,'answer1',25,1),(70,'answer2',25,0),(71,'answer1',26,0),(72,'answer2',26,0),(73,'answer3',26,1),(74,'answer4',26,1),(75,'answer1',27,1),(76,'answer2',27,1),(77,'answer3',27,0),(78,'answer4',27,0),(79,'answer1',28,1),(80,'answer2',28,0),(81,'answer1',29,1),(82,'answer2',29,0),(83,'answer1',30,0),(84,'answer2',30,1);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (1),(2),(3),(4),(5);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_technology`
--

DROP TABLE IF EXISTS `candidate_technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate_technology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_candidate` int(11) DEFAULT NULL,
  `id_technology` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_candidate` (`id_candidate`),
  KEY `id_technology` (`id_technology`),
  CONSTRAINT `candidate_technology_ibfk_1` FOREIGN KEY (`id_candidate`) REFERENCES `candidate` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `candidate_technology_ibfk_2` FOREIGN KEY (`id_technology`) REFERENCES `technology` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_technology`
--

LOCK TABLES `candidate_technology` WRITE;
/*!40000 ALTER TABLE `candidate_technology` DISABLE KEYS */;
INSERT INTO `candidate_technology` VALUES (2,1,3),(3,2,5),(4,1,6),(5,2,3),(6,3,7),(7,3,8),(8,4,9),(9,4,10),(10,5,10),(11,5,11),(12,4,11),(13,5,3),(14,3,2),(15,2,10),(16,2,6),(17,4,3);
/*!40000 ALTER TABLE `candidate_technology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(128) NOT NULL,
  `id_technology` int(11) NOT NULL,
  `multi_answer` tinyint(1) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_technology` (`id_technology`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`id_technology`) REFERENCES `technology` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'first question for java',1,1,4),(2,'secound question for java',1,1,4),(3,'third question java',1,0,3),(4,'fourth question java',1,0,3),(5,'fifth question java',1,0,3),(6,'first question angular',6,1,4),(7,'Secound question angular',6,1,4),(8,'third question Angular',6,0,3),(9,'fourth question Angular',6,0,3),(10,'fifth question Angular',6,0,3),(11,'first question php',3,1,4),(12,'secound question php',3,1,4),(13,'third question php',3,0,3),(14,'fourth question php',3,0,3),(15,'fifth question php',3,0,3),(16,'First question C++',8,1,4),(17,'Secound question C++',8,1,4),(18,'third question C++',8,0,3),(19,'Fourth question C++',8,0,3),(20,'Fifth question C++',8,0,3),(21,'First Question SQL',2,1,4),(22,'Secound question SQL',2,1,4),(23,'Third question SQL',2,0,3),(24,'Fourth Question SQL',2,0,3),(25,'Fifth question SQL',2,0,3),(26,'First question Javascript',5,1,4),(27,'Secound Question Javascript',5,1,4),(28,'Third Question Javascript',5,0,3),(29,'Fourth question Javascript',5,0,3),(30,'Fifth question Javascript',5,0,3);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_candidate` int(11) NOT NULL,
  `id_technology` int(11) NOT NULL,
  `result` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_candidate` (`id_candidate`),
  KEY `id_technology` (`id_technology`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`id_candidate`) REFERENCES `candidate` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`id_technology`) REFERENCES `technology` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technology`
--

DROP TABLE IF EXISTS `technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `technology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technology`
--

LOCK TABLES `technology` WRITE;
/*!40000 ALTER TABLE `technology` DISABLE KEYS */;
INSERT INTO `technology` VALUES (1,'JAVA'),(2,'SQL'),(3,'PHP'),(4,'PYTHON'),(5,'JAVASCRIPT'),(6,'ANGULAR'),(7,'REACT'),(8,'C++'),(9,'C#'),(10,'SPRING'),(11,'MONGO');
/*!40000 ALTER TABLE `technology` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-25 16:13:43
