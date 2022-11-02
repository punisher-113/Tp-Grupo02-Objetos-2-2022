CREATE DATABASE  IF NOT EXISTS `Grupo-02-BDD-OO2-2022` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Grupo-02-BDD-OO2-2022`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: grupo-02-bdd-oo2-2022
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `edificio_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1dktox2l21denb9gugmps5mxi` (`edificio_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,7,1),(2,6,1),(3,19,1),(4,21,1),(5,11,1),(6,1,2),(7,2,2),(8,7,3),(9,10,4),(10,19,2);
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `carrera` varchar(60) NOT NULL,
  `departamento_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlxfyjkntg9sy77n7m4m0p0lbe` (`departamento_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'Sistemas',1),(2,'Ferroviarias',1);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `cod_curso` varchar(60) NOT NULL,
  `proyector` bit(1) NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
insert into `curso` VALUES('Sistemas',1,2);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `departamento` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Desarrollo Productivo'),(2,'Humanidaes y arte'),(3,'Planificacion'),(4,'Salud Comunitaria');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `nro_legajo` int DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (12345,3),(12346,4),(12347,5),(12348,6);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edificio`
--

DROP TABLE IF EXISTS `edificio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edificio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `edificio` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edificio`
--

LOCK TABLES `edificio` WRITE;
/*!40000 ALTER TABLE `edificio` DISABLE KEYS */;
INSERT INTO `edificio` VALUES (1,'José Hernandez'),(2,'Scalabrini'),(3,'Ugarte'),(4,'Marechal'),(5,'Manzi'),(6,'Jaureche');
/*!40000 ALTER TABLE `edificio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `espacio`
--

DROP TABLE IF EXISTS `espacio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `espacio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `libre` bit(1) NOT NULL,
  `turno` char(1) NOT NULL,
  `aula_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm96cg51w2du489b2lf8nchx89` (`aula_id`)
) ENGINE=MyISAM AUTO_INCREMENT=716 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `espacio`
--

LOCK TABLES `espacio` WRITE;
/*!40000 ALTER TABLE `espacio` DISABLE KEYS */;
INSERT INTO `espacio` VALUES (715,'2022-08-31',_binary '','m',1),(714,'2022-08-30',_binary '','m',1),(713,'2022-08-29',_binary '','m',1),(712,'2022-08-28',_binary '','m',1),(711,'2022-08-27',_binary '','m',1),(710,'2022-08-26',_binary '','m',1),(709,'2022-08-25',_binary '','m',1),(708,'2022-08-24',_binary '','m',1),(707,'2022-08-23',_binary '','m',1),(706,'2022-08-22',_binary '','m',1),(705,'2022-08-21',_binary '','m',1),(704,'2022-08-20',_binary '','m',1),(703,'2022-08-19',_binary '','m',1),(702,'2022-08-18',_binary '','m',1),(701,'2022-08-17',_binary '','m',1),(700,'2022-08-16',_binary '','m',1),(699,'2022-08-15',_binary '','m',1),(698,'2022-08-14',_binary '','m',1),(697,'2022-08-13',_binary '','m',1),(696,'2022-08-12',_binary '','m',1),(695,'2022-08-11',_binary '','m',1),(694,'2022-08-10',_binary '','m',1),(693,'2022-08-09',_binary '','m',1),(692,'2022-08-08',_binary '','m',1),(691,'2022-08-07',_binary '','m',1),(690,'2022-08-06',_binary '','m',1),(689,'2022-08-05',_binary '','m',1),(688,'2022-08-04',_binary '','m',1),(687,'2022-08-03',_binary '','m',1),(686,'2022-08-02',_binary '','m',1),(685,'2022-08-01',_binary '','m',1),(684,'2022-07-31',_binary '','t',10),(683,'2022-07-30',_binary '','t',10),(682,'2022-07-29',_binary '','t',10),(681,'2022-07-28',_binary '','t',10),(680,'2022-07-27',_binary '','t',10),(679,'2022-07-26',_binary '','t',10),(678,'2022-07-25',_binary '','t',10),(677,'2022-07-24',_binary '','t',10),(676,'2022-07-23',_binary '','t',10),(675,'2022-07-22',_binary '','t',10),(674,'2022-07-21',_binary '','t',10),(673,'2022-07-20',_binary '','t',10),(672,'2022-07-19',_binary '','t',10),(671,'2022-07-18',_binary '','t',10),(670,'2022-07-17',_binary '','t',10),(669,'2022-07-16',_binary '','t',10),(668,'2022-07-15',_binary '','t',10),(667,'2022-07-14',_binary '','t',10),(666,'2022-07-13',_binary '','t',10),(665,'2022-07-12',_binary '','t',10),(664,'2022-07-11',_binary '','t',10),(663,'2022-07-10',_binary '','t',10),(662,'2022-07-09',_binary '','t',10),(661,'2022-07-08',_binary '','t',10),(660,'2022-07-07',_binary '','t',10),(659,'2022-07-06',_binary '','t',10),(658,'2022-07-05',_binary '','t',10),(657,'2022-07-04',_binary '','t',10),(656,'2022-07-03',_binary '','t',10),(655,'2022-07-02',_binary '','t',10),(654,'2022-07-01',_binary '','t',10),(653,'2022-06-30',_binary '','m',1),(652,'2022-06-29',_binary '','m',1),(651,'2022-06-28',_binary '','m',1),(650,'2022-06-27',_binary '','m',1),(649,'2022-06-26',_binary '','m',1),(648,'2022-06-25',_binary '','m',1),(647,'2022-06-24',_binary '','m',1),(646,'2022-06-23',_binary '','m',1),(645,'2022-06-22',_binary '','m',1),(644,'2022-06-21',_binary '','m',1),(643,'2022-06-20',_binary '','m',1),(642,'2022-06-19',_binary '','m',1),(641,'2022-06-18',_binary '','m',1),(640,'2022-06-17',_binary '','m',1),(639,'2022-06-16',_binary '','m',1),(638,'2022-06-15',_binary '','m',1),(637,'2022-06-14',_binary '','m',1),(636,'2022-06-13',_binary '','m',1),(635,'2022-06-12',_binary '','m',1),(634,'2022-06-11',_binary '','m',1),(633,'2022-06-10',_binary '','m',1),(632,'2022-06-09',_binary '','m',1),(631,'2022-06-08',_binary '','m',1),(630,'2022-06-07',_binary '','m',1),(629,'2022-06-06',_binary '','m',1),(628,'2022-06-05',_binary '','m',1),(627,'2022-06-04',_binary '','m',1),(626,'2022-06-03',_binary '','m',1),(625,'2022-06-02',_binary '','m',1),(624,'2022-06-01',_binary '','m',1);
/*!40000 ALTER TABLE `espacio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `final`
--

DROP TABLE IF EXISTS `final`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `final` (
  `fecha_examen` date NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `final`
--

LOCK TABLES `final` WRITE;
/*!40000 ALTER TABLE `final` DISABLE KEYS */;
insert into `final` VALUES('2022-06-10',1);
/*!40000 ALTER TABLE `final` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratorio` (
  `cantpc` int NOT NULL,
  `cant_sillas` int NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorio`
--

LOCK TABLES `laboratorio` WRITE;
/*!40000 ALTER TABLE `laboratorio` DISABLE KEYS */;
INSERT INTO `laboratorio` VALUES (10,70,7),(15,70,8),(10,50,9),(30,30,10);
/*!40000 ALTER TABLE `laboratorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cod_materia` int NOT NULL,
  `materia` varchar(45) NOT NULL,
  `carrera_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgo5fa3d1ofx15gh7px1y3du3e` (`carrera_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (5,8604,'Matematica 2 - Plaul',1),(6,86042,'Matematica 2 - Loidi',1),(1,8600,'Programacion de Computadoras',1),(2,8601,'Organizacion de Computadoras',1),(3,8602,'Arquitectura de computadoras',1),(4,8603,'Matematica 1',1);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiaxdocente`
--

DROP TABLE IF EXISTS `materiaxdocente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiaxdocente` (
  `materia_id` bigint NOT NULL,
  `docente_id` bigint NOT NULL,
  PRIMARY KEY (`materia_id`,`docente_id`),
  KEY `FKccp19cfea65g9s5isbts1nvj4` (`docente_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiaxdocente`
--

LOCK TABLES `materiaxdocente` WRITE;
/*!40000 ALTER TABLE `materiaxdocente` DISABLE KEYS */;
INSERT INTO `materiaxdocente` VALUES (1,5),(2,5),(3,5),(4,6),(5,3),(6,4);
/*!40000 ALTER TABLE `materiaxdocente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_pedido`
--

DROP TABLE IF EXISTS `nota_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota_pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `aula` varchar(60) NOT NULL,
  `cant_estudiantes` int NOT NULL,
  `fecha` date NOT NULL,
  `observaciones` varchar(120) DEFAULT NULL,
  `turno` char(1) NOT NULL,
  `espacio_id` bigint DEFAULT NULL,
  `materia_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhgk1v1a9nlybbqqlssjdytcng` (`espacio_id`),
  KEY `FKd5qj0dabmq3kjfqvy5app8mf3` (`materia_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_pedido`
--

LOCK TABLES `nota_pedido` WRITE;
/*!40000 ALTER TABLE `nota_pedido` DISABLE KEYS */;
insert into `nota_pedido` VALUES(1,'Tradicional',100,'2022-06-01','Sin observaciones','m',633,5),(2,'Laboratorio',67,'2022-06-01','Sin observaciones','m',635,4);
/*!40000 ALTER TABLE `nota_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(45) NOT NULL,
  `dni` bigint NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hlwyecu2r9wagqayhej1kt5wy` (`dni`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Leclerc',12345678,'Charles','dni'),(2,'Sainz',23456789,'Carlos','dni'),(3,'Plaul',21983746,'Vanesa','dni'),(4,'Loidi',93826155,'Laura','dni'),(5,'Perez',21345678,'Nicolas','dni'),(6,'Siciliano',84756352,'Gustavo','dni'),(7,'Herrera',92846573,'Juan Manuel','DNI'),(8,'Velez',48273658,'Matias','DNI');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN',1,'ADMIN'),(2,'ROLE_AUDITOR',1,'AUDITOR'),(3,'ROLE_ASISTENTE',1,'ASISTENTE'),(4,'ROLE_ADMIN_GENERAL',1,'ADMIN_GENERAL');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tradicional`
--

DROP TABLE IF EXISTS `tradicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tradicional` (
  `cant_bancos` int NOT NULL,
  `pizarron` varchar(255) NOT NULL,
  `tiene_proyector` int NOT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tradicional`
--

LOCK TABLES `tradicional` WRITE;
/*!40000 ALTER TABLE `tradicional` DISABLE KEYS */;
INSERT INTO `tradicional` VALUES (100,'Tiza',1,1),(50,'Tiza',1,2),(150,'Tiza',1,3),(50,'Fibron',0,4),(100,'Fibron',0,5),(150,'Fibron',0,6);
/*!40000 ALTER TABLE `tradicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('charles@gmail.com',1,'$2a$10$lpeTNBUGJfHxsJNOkAF5IuS5eLZUOuL8vlHMd/9O0rL5Cb3rp.uk6','admin',1,1),('carlos@gmail.com',1,'$2a$10$B9mfALrCwl7gNgksyajanuqhq2GpRAfcfTPN9iXrAAGN6BKB73hUy','auditor',2,2),('juanmanuel@gmail.com',1,'$2a$10$Yrh.4JtqoR78MTMo3i6Ome8/gsRcNHQ6gWOf37Zfu4GKgYJIwrd7m','Asistente',7,3),('matiasv@gmail.com',1,'$2a$10$H8tUMxXs1FOkEAguTbW8su3weDJcaqo1mcUrDUPlhFi2ZW/t21HrW','admingeneral',8,4);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-30 18:40:22
