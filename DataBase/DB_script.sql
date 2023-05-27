CREATE DATABASE  IF NOT EXISTS `Hotel` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Hotel`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: Hotel
-- ------------------------------------------------------
-- Server version	8.0.0-dmr

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
-- Table structure for table `CAMERA`
--

DROP TABLE IF EXISTS `CAMERA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAMERA` (
  `NUMERO` int(10) NOT NULL,
  `TIPO` varchar(45) NOT NULL,
  `NLETTI` smallint(6) NOT NULL,
  `PIANO` smallint(6) NOT NULL,
  `PREZZO` decimal(3,2) NOT NULL,
  `ID_COMFORT` varchar(20) NOT NULL,
  `STATO` varchar(45) NOT NULL,
  PRIMARY KEY (`NUMERO`),
  UNIQUE KEY `NUMERO_UNIQUE` (`NUMERO`),
  KEY `camera_ibfk_1` (`ID_COMFORT`),
  CONSTRAINT `camera_ibfk_1` FOREIGN KEY (`ID_COMFORT`) REFERENCES `COMFORT` (`ID_COMFORT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAMERA`
--

LOCK TABLES `CAMERA` WRITE;
/*!40000 ALTER TABLE `CAMERA` DISABLE KEYS */;
/*!40000 ALTER TABLE `CAMERA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CITTA`
--

DROP TABLE IF EXISTS `CITTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CITTA` (
  `ID_CITTA` int(4) NOT NULL,
  `NOME_C` varchar(45) NOT NULL,
  `ID_NAZ` int(4) NOT NULL,
  `ID_PROV` int(4) NOT NULL,
  PRIMARY KEY (`ID_CITTA`),
  UNIQUE KEY `ID_CITTA_UNIQUE` (`ID_CITTA`),
  KEY `ID_N_idx` (`ID_NAZ`),
  KEY `PROV_idx` (`ID_PROV`),
  CONSTRAINT `PROV` FOREIGN KEY (`ID_PROV`) REFERENCES `PROVINCIA` (`ID_PROV`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CITTA`
--

LOCK TABLES `CITTA` WRITE;
/*!40000 ALTER TABLE `CITTA` DISABLE KEYS */;
INSERT INTO `CITTA` VALUES (1,'Roma',0,0),(2,'Milano',0,0),(3,'Napoli',0,0),(4,'Torino',0,0),(5,'Palermo',0,0),(6,'Genova',0,0),(7,'Bologna',0,0),(8,'Firenze',0,0),(9,'Bari',0,0),(10,'Catania',0,0),(11,'Venezia',0,0),(12,'Verona',0,0),(13,'Messina',0,0),(14,'Padova',0,0),(15,'Trieste',0,0),(16,'Taranto',0,0),(17,'Brescia',0,0),(18,'Reggio di Calabria',0,0),(19,'Modena',0,0),(20,'Cagliari',0,0),(21,'Prato',0,0),(22,'Parma',0,0),(23,'Livorno',0,0),(24,'Foggia',0,0),(25,'Perugia',0,0),(26,'Ravenna',0,0),(27,'Rimini',0,0),(28,'Salerno',0,0),(29,'Ferrara',0,0),(30,'Sassari',0,0),(31,'La Spezia',0,0),(32,'Lucca',0,0),(33,'Pisa',0,0),(34,'Benevento',0,0),(35,'Andria',0,0),(36,'Brindisi',0,0),(37,'Novara',0,0),(38,'Pescara',0,0),(39,'Asti',0,0),(40,'Arezzo',0,0),(41,'Cremona',0,0),(42,'Cuneo',0,0),(43,'Como',0,0),(44,'Lodi',0,0),(45,'Varese',0,0),(46,'Mantova',0,0),(47,'Piacenza',0,0),(48,'Trento',0,0),(49,'Pistoia',0,0),(50,'Ancona',0,0),(51,'Pavia',0,0),(52,'Rovigo',0,0),(53,'Forlì',0,0),(54,'Siena',0,0),(55,'Massa',0,0),(56,'Aosta',0,0),(57,'Vercelli',0,0),(58,'Biella',0,0),(59,'Civitavecchia',0,0),(60,'Crotone',0,0),(61,'Imperia',0,0),(62,'Viterbo',0,0),(63,'Lucca',0,0),(64,'Barletta',0,0),(65,'Sondrio',0,0),(66,'Frosinone',0,0),(67,'Nuoro',0,0),(68,'Oristano',0,0),(69,'Valle d\'Aosta',0,0);
/*!40000 ALTER TABLE `CITTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CLIENTE` (
  `ID_CLIENTE` int(50) NOT NULL,
  `ID_USER` int(10) NOT NULL,
  `COD_PR` char(5) NOT NULL,
  `NUM_C` int(10) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  KEY `COD_idx` (`COD_PR`),
  KEY `CF_idx` (`ID_USER`),
  KEY `NUMERO_C` (`NUM_C`),
  CONSTRAINT `COD` FOREIGN KEY (`COD_PR`) REFERENCES `PRENOTAZIONE` (`COD_PR`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_U` FOREIGN KEY (`ID_USER`) REFERENCES `USER` (`ID_USER`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `NUMERO_C` FOREIGN KEY (`NUM_C`) REFERENCES `CAMERA` (`NUMERO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COMFORT`
--

DROP TABLE IF EXISTS `COMFORT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMFORT` (
  `ID_COMFORT` char(20) NOT NULL,
  `TIPO` tinytext NOT NULL,
  `PREZZO` decimal(3,2) NOT NULL,
  PRIMARY KEY (`ID_COMFORT`),
  UNIQUE KEY `ID_COMFORT_UNIQUE` (`ID_COMFORT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMFORT`
--

LOCK TABLES `COMFORT` WRITE;
/*!40000 ALTER TABLE `COMFORT` DISABLE KEYS */;
/*!40000 ALTER TABLE `COMFORT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CONTRATTI`
--

DROP TABLE IF EXISTS `CONTRATTI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CONTRATTI` (
  `ID_CONTR` int(10) NOT NULL,
  `DESC_CONTR` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_CONTR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CONTRATTI`
--

LOCK TABLES `CONTRATTI` WRITE;
/*!40000 ALTER TABLE `CONTRATTI` DISABLE KEYS */;
/*!40000 ALTER TABLE `CONTRATTI` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DIPENDENTE`
--

DROP TABLE IF EXISTS `DIPENDENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DIPENDENTE` (
  `ID_L` int(11) NOT NULL,
  `ID_MANS` int(10) NOT NULL,
  `ID_CONTR` int(10) NOT NULL,
  `STIPENDIO` decimal(6,3) NOT NULL,
  `ID_USER` int(10) NOT NULL,
  PRIMARY KEY (`ID_L`),
  KEY `ID_M_idx` (`ID_MANS`),
  KEY `ID_C_idx` (`ID_CONTR`),
  KEY `ID_US_idx` (`ID_USER`),
  CONSTRAINT `ID_CO` FOREIGN KEY (`ID_CONTR`) REFERENCES `CONTRATTI` (`ID_CONTR`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_M` FOREIGN KEY (`ID_MANS`) REFERENCES `MANSIONE` (`ID_MANS`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_US` FOREIGN KEY (`ID_USER`) REFERENCES `USER` (`ID_USER`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DIPENDENTE`
--

LOCK TABLES `DIPENDENTE` WRITE;
/*!40000 ALTER TABLE `DIPENDENTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `DIPENDENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MANSIONE`
--

DROP TABLE IF EXISTS `MANSIONE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MANSIONE` (
  `ID_MANS` int(10) NOT NULL,
  `DESC_MANS` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_MANS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MANSIONE`
--

LOCK TABLES `MANSIONE` WRITE;
/*!40000 ALTER TABLE `MANSIONE` DISABLE KEYS */;
/*!40000 ALTER TABLE `MANSIONE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `NAZIONE`
--

DROP TABLE IF EXISTS `NAZIONE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `NAZIONE` (
  `ID_NAZ` int(4) NOT NULL,
  `NOME_N` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_NAZ`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `NAZIONE`
--

LOCK TABLES `NAZIONE` WRITE;
/*!40000 ALTER TABLE `NAZIONE` DISABLE KEYS */;
/*!40000 ALTER TABLE `NAZIONE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRENOTAZIONE`
--

DROP TABLE IF EXISTS `PRENOTAZIONE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRENOTAZIONE` (
  `COD_PR` char(5) NOT NULL,
  `CHECK_IN` date NOT NULL,
  `CHECK_OUT` date NOT NULL,
  `COSTO` decimal(4,2) NOT NULL,
  `DATA_PR` datetime NOT NULL,
  PRIMARY KEY (`COD_PR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRENOTAZIONE`
--

LOCK TABLES `PRENOTAZIONE` WRITE;
/*!40000 ALTER TABLE `PRENOTAZIONE` DISABLE KEYS */;
/*!40000 ALTER TABLE `PRENOTAZIONE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROVINCIA`
--

DROP TABLE IF EXISTS `PROVINCIA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROVINCIA` (
  `ID_PROV` int(4) NOT NULL,
  `NOME_P` varchar(45) NOT NULL,
  `ID_NAZ` int(4) NOT NULL,
  PRIMARY KEY (`ID_PROV`),
  KEY `NAZ_P_idx` (`ID_NAZ`),
  CONSTRAINT `NAZ_P` FOREIGN KEY (`ID_NAZ`) REFERENCES `NAZIONE` (`ID_NAZ`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROVINCIA`
--

LOCK TABLES `PROVINCIA` WRITE;
/*!40000 ALTER TABLE `PROVINCIA` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROVINCIA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPOLOGIA_UTENTE`
--

DROP TABLE IF EXISTS `TIPOLOGIA_UTENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TIPOLOGIA_UTENTE` (
  `ID_TIPO` int(11) NOT NULL,
  `DESCR_TIPO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPOLOGIA_UTENTE`
--

LOCK TABLES `TIPOLOGIA_UTENTE` WRITE;
/*!40000 ALTER TABLE `TIPOLOGIA_UTENTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `TIPOLOGIA_UTENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TURNI_LAVORO`
--

DROP TABLE IF EXISTS `TURNI_LAVORO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TURNI_LAVORO` (
  `ID_L` int(11) NOT NULL,
  `GIORNO` date NOT NULL,
  `NUM_CT` int(10) NOT NULL,
  `ORA_INIZIO` time NOT NULL,
  `ORA_FINE` time NOT NULL,
  PRIMARY KEY (`GIORNO`),
  KEY `ID_idx` (`ID_L`),
  KEY `NUM_idx` (`NUM_CT`),
  CONSTRAINT `ID_TR` FOREIGN KEY (`ID_L`) REFERENCES `DIPENDENTE` (`ID_L`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `NUM_T` FOREIGN KEY (`NUM_CT`) REFERENCES `CAMERA` (`NUMERO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TURNI_LAVORO`
--

LOCK TABLES `TURNI_LAVORO` WRITE;
/*!40000 ALTER TABLE `TURNI_LAVORO` DISABLE KEYS */;
/*!40000 ALTER TABLE `TURNI_LAVORO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `ID_USER` int(10) NOT NULL,
  `CF` char(16) NOT NULL,
  `NOME` varchar(20) NOT NULL,
  `COGNOME` varchar(20) NOT NULL,
  `DATA_NASCITA` date NOT NULL,
  `CELL` varchar(20) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `ID_CITTA` int(4) NOT NULL,
  `ID_PROV` int(4) NOT NULL,
  `ID_NAZ` int(4) NOT NULL,
  `ID_TIPO` int(11) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PSW` varchar(40) NOT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `CF_UNIQUE` (`CF`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `CELL_UNIQUE` (`CELL`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  UNIQUE KEY `ID_USER_UNIQUE` (`ID_USER`),
  KEY `ID_T_idx` (`ID_TIPO`),
  KEY `ID_C_idx` (`ID_CITTA`),
  KEY `ID_N_idx` (`ID_NAZ`),
  KEY `ID_P` (`ID_PROV`),
  CONSTRAINT `ID_C` FOREIGN KEY (`ID_CITTA`) REFERENCES `CITTA` (`ID_CITTA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_N` FOREIGN KEY (`ID_NAZ`) REFERENCES `NAZIONE` (`ID_NAZ`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_P` FOREIGN KEY (`ID_PROV`) REFERENCES `PROVINCIA` (`ID_PROV`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_T` FOREIGN KEY (`ID_TIPO`) REFERENCES `TIPOLOGIA_UTENTE` (`ID_TIPO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-27 11:31:44
