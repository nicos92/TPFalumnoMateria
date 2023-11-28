CREATE DATABASE  IF NOT EXISTS `materiascorrelativas` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `materiascorrelativas`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: materiascorrelativas
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `alumno_materia_cursada`
--

DROP TABLE IF EXISTS `alumno_materia_cursada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno_materia_cursada` (
  `idCursada` int NOT NULL AUTO_INCREMENT,
  `Alumnos_idAlumno` int NOT NULL,
  `Materias_idMateria` int NOT NULL,
  `aprobada` tinyint NOT NULL,
  PRIMARY KEY (`idCursada`,`Alumnos_idAlumno`,`Materias_idMateria`),
  UNIQUE KEY `idCursada_UNIQUE` (`idCursada`),
  KEY `fk_Alumnos_has_Materias_Materias1_idx` (`Materias_idMateria`),
  KEY `fk_Alumnos_has_Materias_Alumnos_idx` (`Alumnos_idAlumno`),
  CONSTRAINT `fk_Alumnos_has_Materias_Alumnos` FOREIGN KEY (`Alumnos_idAlumno`) REFERENCES `alumnos` (`idAlumno`),
  CONSTRAINT `fk_Alumnos_has_Materias_Materias1` FOREIGN KEY (`Materias_idMateria`) REFERENCES `materias` (`idMateria`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_materia_cursada`
--

LOCK TABLES `alumno_materia_cursada` WRITE;
/*!40000 ALTER TABLE `alumno_materia_cursada` DISABLE KEYS */;
INSERT INTO `alumno_materia_cursada` VALUES (1,1,16,1),(2,1,17,1),(3,1,18,0),(4,1,21,1),(5,1,22,1),(6,1,23,1),(7,1,27,0),(8,2,16,1),(9,2,17,0),(10,2,27,1),(11,2,28,0),(12,3,27,1),(13,3,28,1),(14,3,29,0),(15,4,27,1),(16,4,28,1),(17,4,29,1),(18,4,16,1),(19,1,25,0),(20,1,24,0),(21,2,21,0),(24,2,25,0),(25,1,32,0),(29,3,16,0),(36,2,32,0),(37,3,21,0),(39,62,16,0),(40,62,21,0),(41,62,25,0);
/*!40000 ALTER TABLE `alumno_materia_cursada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `idAlumno` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idAlumno`),
  UNIQUE KEY `idAlumno_UNIQUE` (`idAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Nico'),(2,'Anto'),(3,'Angy'),(4,'Nico update'),(62,'Nico update');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materias` (
  `idMateria` int NOT NULL AUTO_INCREMENT,
  `Materia` varchar(45) NOT NULL,
  `idCorrelativa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMateria`),
  UNIQUE KEY `idMateria_UNIQUE` (`idMateria`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (16,'Fisica 1','0'),(17,'Fisica 2','16'),(18,'Fisica 3','17'),(19,'Fisica 4','18'),(20,'Fisica 5','19'),(21,'Informatica 1','0'),(22,'Informatica 2','21'),(23,'Informatica 3 ','22'),(24,'Informatica 4','23'),(25,'Matematicas 1','0'),(26,'Matematicas 2','25'),(27,'Algoritmos y Estructuras de Datos','0'),(28,' Paradigmas de Programación','27'),(29,'Diseño de Sistemas','28'),(32,'Enfermeria 2','0');
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 19:49:41
