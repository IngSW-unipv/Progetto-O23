-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel2
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
INSERT INTO `MANSIONE` VALUES (1,'Segretario'),(2,'Contabile'),(3,'Programmatore'),(4,'Responsabile Acquisti'),(5,'Direttore Tecnico'),(6,'Addetto alla Sicurezza'),(7,'Responsabile Marketing'),(8,'Addetto alle Pulizie'),(9,'Dipendente ai Piani'),(10,'Responsabile Risorse Umane');
/*!40000 ALTER TABLE `MANSIONE` ENABLE KEYS */;
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
INSERT INTO `TIPOLOGIA_UTENTE` VALUES (1,'Utente'),(2,'Dipendente'),(3,'Direttore');
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
  `VIA` varchar(45) NOT NULL,
  `CITTA` varchar(45) NOT NULL,
  `CAP` varchar(45) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PSW` varchar(40) NOT NULL,
  `ID_TIPO` int(10) NOT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `CF_UNIQUE` (`CF`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `CELL_UNIQUE` (`CELL`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  UNIQUE KEY `ID_USER_UNIQUE` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (314641403,'1211112rt','Christian','Biuso','2000-05-24','3343025','sesia',10,'Milano','56484','ahdòh@jkdlf.it','uteue5','********',1),(364456785,'12310012rt','Christian','Biuso','2000-05-24','33433235','sesia',10,'Milano','56484','ahdkfòh@jkdflf.it','utete','password',1),(364456789,'12312312rt','Pippo','Biuso','2000-05-24','334332335','sesia',10,'Milano','56484','ahdkgfòh@jkdflf.it','utente','password',1),(832725315,'12311012rt','Christian','Biuso','2000-05-24','3343325','sesia',10,'Milano','56484','ahdkfòh@jkdlf.it','uteute','password',1),(981670304,'12111012rt','Christian','Biuso','2000-05-24','33433025','sesia',10,'Milano','56484','ahdkòh@jkdlf.it','uteute5','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',1);
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

-- Dump completed on 2023-07-24 17:41:11
