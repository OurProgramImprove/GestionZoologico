DROP DATABASE IF EXISTS `zoologico`;
CREATE DATABASE  IF NOT EXISTS `zoologico` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `zoologico`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: zoologico
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `billete`
--

DROP TABLE IF EXISTS `billete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billete` (
  `id_billete` int NOT NULL AUTO_INCREMENT,
  `fec_billete` date NOT NULL,
  `h_llegada` time NOT NULL,
  `importe` float NOT NULL,
  `id_cliente` int DEFAULT NULL,
  `id_zoo` int DEFAULT NULL,
  PRIMARY KEY (`id_billete`),
  KEY `FK_id_cliente` (`id_cliente`),
  KEY `FK_id_zoo_fact` (`id_zoo`),
  CONSTRAINT `FK_id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FK_id_zoo_fact` FOREIGN KEY (`id_zoo`) REFERENCES `zoo` (`id_zoo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billete`
--

LOCK TABLES `billete` WRITE;
/*!40000 ALTER TABLE `billete` DISABLE KEYS */;
/*!40000 ALTER TABLE `billete` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `id_ciudad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_pais` int DEFAULT NULL,
  PRIMARY KEY (`id_ciudad`),
  KEY `FK_pais` (`id_pais`),
  CONSTRAINT `FK_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Sigean',5),(2,'Belgrado',6),(3,'Asahikawa',7),(4,'Ciudad de Mexico',1),(5,'Penagos',3),(6,'Berlin',4),(7,'Norfolk',2);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido_uno` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido_dos` varchar(70) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `contraseña` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'11111111P','Javier','Baz',NULL,'javi'),(2,'22222222P','Aga','Mambu',NULL,'aga'),(3,'33333333P','Iñaki','Rioja',NULL,'iñaki'),(4,'44444444P','User4','User4',NULL,'user4'),(10,'09090909Ñ','Juan','Rodriguez','Basterretxea','1144'),(14,'12344321R','Lola','lola','lola','lola'),(15,'12345678D','qwerty','qwery','','1234');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `continente`
--

DROP TABLE IF EXISTS `continente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `continente` (
  `id_continente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id_continente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `continente`
--

LOCK TABLES `continente` WRITE;
/*!40000 ALTER TABLE `continente` DISABLE KEYS */;
INSERT INTO `continente` VALUES (1,'Europa'),(2,'America'),(3,'Asia'),(4,'Oceania'),(5,'Africa');
/*!40000 ALTER TABLE `continente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especie`
--

DROP TABLE IF EXISTS `especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especie` (
  `id_especie` int NOT NULL AUTO_INCREMENT,
  `nombre_vulgar` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre_cientifico` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `extincion` tinyint(1) DEFAULT '0',
  `animal` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_familia` int DEFAULT NULL,
  PRIMARY KEY (`id_especie`),
  KEY `FK_id_familia` (`id_familia`),
  CONSTRAINT `FK_id_familia` FOREIGN KEY (`id_familia`) REFERENCES `familia` (`id_familia`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especie`
--

LOCK TABLES `especie` WRITE;
/*!40000 ALTER TABLE `especie` DISABLE KEYS */;
INSERT INTO `especie` VALUES (1,'Ardilla Roja','Sciurus Vulgaris',0,'Ardillas',1),(2,'Ardilla voladora','Pteromyini',0,'Ardillas',1),(3,'Tigre de Bengala','Panthera tigris',1,'Tigres',2),(4,'Leon Africano','Panthera leo',1,'Leones',2),(5,'Jaguar','Panthera onca',0,'Jaguares',2),(6,'Zorro Rojo','Vulpes',0,'Zorros',3),(7,'Dingo','Canis lupus dingo',0,'Lobos',3),(8,'Lobo Gris','Canis lupus',0,'Lobos',3);
/*!40000 ALTER TABLE `especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familia`
--

DROP TABLE IF EXISTS `familia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `familia` (
  `id_familia` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`id_familia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familia`
--

LOCK TABLES `familia` WRITE;
/*!40000 ALTER TABLE `familia` DISABLE KEYS */;
INSERT INTO `familia` VALUES (1,'EsciÚridos'),(2,'Felidos'),(3,'Cánidos'),(4,'Úrsidos'),(5,'Bóvidos');
/*!40000 ALTER TABLE `familia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `id_pais` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_continente` int DEFAULT NULL,
  PRIMARY KEY (`id_pais`),
  KEY `FK_continente` (`id_continente`),
  CONSTRAINT `FK_continente` FOREIGN KEY (`id_continente`) REFERENCES `continente` (`id_continente`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Mexico',2),(2,'EEUU',2),(3,'España',1),(4,'Alemania',1),(5,'Francia',1),(6,'Serbia',1),(7,'Japon',3),(8,'India',3),(9,'Botsuana',5);
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais_has_especie`
--

DROP TABLE IF EXISTS `pais_has_especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais_has_especie` (
  `id_pais` int NOT NULL,
  `id_especie` int NOT NULL,
  PRIMARY KEY (`id_pais`,`id_especie`),
  KEY `FK_id_especie_originaria_de` (`id_especie`),
  CONSTRAINT `FK_id_especie_originaria_de` FOREIGN KEY (`id_especie`) REFERENCES `especie` (`id_especie`),
  CONSTRAINT `FK_id_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais_has_especie`
--

LOCK TABLES `pais_has_especie` WRITE;
/*!40000 ALTER TABLE `pais_has_especie` DISABLE KEYS */;
INSERT INTO `pais_has_especie` VALUES (3,1),(4,1),(5,1),(3,2),(4,2),(5,2);
/*!40000 ALTER TABLE `pais_has_especie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zoo`
--

DROP TABLE IF EXISTS `zoo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zoo` (
  `id_zoo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `tamaño` int NOT NULL,
  `presupuesto` float NOT NULL,
  `h_apertura` time NOT NULL,
  `h_cierre` time NOT NULL,
  `pvp_entrada` float NOT NULL,
  `ciudad_zoo` int DEFAULT NULL,
  PRIMARY KEY (`id_zoo`),
  KEY `FK_id_ciudad` (`ciudad_zoo`),
  CONSTRAINT `FK_id_ciudad` FOREIGN KEY (`ciudad_zoo`) REFERENCES `ciudad` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zoo`
--

LOCK TABLES `zoo` WRITE;
/*!40000 ALTER TABLE `zoo` DISABLE KEYS */;
INSERT INTO `zoo` VALUES (1,'Reserva africana de Sigean',3000000,700000,'10:00:00','18:00:00',20,1),(2,'Zoo de Belgrado',70000,150000,'11:00:00','17:00:00',15,2),(3,'Asahiyama',1700000,750000,'10:00:00','20:00:00',35,3),(4,'Chapultepec',170000,630000,'10:00:00','19:00:00',27.5,4),(5,'Cabarceno',7500000,1000000,'10:30:00','21:00:00',25,5),(6,'Zoo Berlin',350000,575500,'08:00:00','17:00:00',31,6),(7,'Virginia Zoo',450000,800000,'10:00:00','17:00:00',40,7);
/*!40000 ALTER TABLE `zoo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zoo_has_especie`
--

DROP TABLE IF EXISTS `zoo_has_especie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zoo_has_especie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_zoo` int NOT NULL,
  `id_especie` int NOT NULL,
  `sexo` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_id_zoo` (`id_zoo`),
  KEY `FK_id_especie` (`id_especie`),
  CONSTRAINT `FK_id_especie` FOREIGN KEY (`id_especie`) REFERENCES `especie` (`id_especie`),
  CONSTRAINT `FK_id_zoo` FOREIGN KEY (`id_zoo`) REFERENCES `zoo` (`id_zoo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zoo_has_especie`
--

LOCK TABLES `zoo_has_especie` WRITE;
/*!40000 ALTER TABLE `zoo_has_especie` DISABLE KEYS */;
INSERT INTO `zoo_has_especie` VALUES (1,1,1,'m',20),(2,1,1,'f',20),(3,2,1,'m',37);
/*!40000 ALTER TABLE `zoo_has_especie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-16 12:58:31
