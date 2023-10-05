-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel
-- ------------------------------------------------------
-- Server version	8.0.33

USE `hotel`;
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
-- Table structure for table `camera`
--

DROP TABLE IF EXISTS `camera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camera` (
  `NUMERO` int NOT NULL,
  `TIPO` varchar(45) NOT NULL,
  `NLETTI` smallint NOT NULL,
  `PIANO` smallint NOT NULL,
  `PREZZO` int NOT NULL,
  `STATO` varchar(45) NOT NULL,
  PRIMARY KEY (`NUMERO`),
  UNIQUE KEY `NUMERO_UNIQUE` (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camera`
--

LOCK TABLES `camera` WRITE;
/*!40000 ALTER TABLE `camera` DISABLE KEYS */;
INSERT INTO `camera` VALUES (1,'singola',1,1,60,'2'),(2,'doppia',2,2,80,'1'),(3,'tripla',3,3,120,'1'),(4,'doppia',2,1,80,'1'),(5,'singola',1,2,55,'2'),(6,'tripla',3,3,130,'1'),(7,'singola',1,1,65,'2'),(8,'doppia',2,2,75,'2');
/*!40000 ALTER TABLE `camera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID_CLIENTE` int NOT NULL,
  `ID_USER` int NOT NULL,
  `COD_PR` char(5) NOT NULL,
  `NUM_C` int NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  KEY `COD_idx` (`COD_PR`),
  KEY `CF_idx` (`ID_USER`),
  KEY `NUMERO_C` (`NUM_C`),
  CONSTRAINT `COD` FOREIGN KEY (`COD_PR`) REFERENCES `prenotazione` (`COD_PR`),
  CONSTRAINT `ID_U` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`),
  CONSTRAINT `NUMERO_C` FOREIGN KEY (`NUM_C`) REFERENCES `camera` (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contratti`
--

DROP TABLE IF EXISTS `contratti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contratti` (
  `ID_CONTR` int NOT NULL,
  `DESC_CONTR` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_CONTR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratti`
--

LOCK TABLES `contratti` WRITE;
/*!40000 ALTER TABLE `contratti` DISABLE KEYS */;
INSERT INTO `contratti` VALUES (1,'PART-TIME'),(2,'FULL-TIME'),(3,'A CHIAMATA');
/*!40000 ALTER TABLE `contratti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendente`
--

DROP TABLE IF EXISTS `dipendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dipendente` (
  `ID_L` int NOT NULL,
  `RUOLO` varchar(40) NOT NULL,
  `ID_CONTR` int DEFAULT NULL,
  `STIPENDIO` int NOT NULL,
  `ID_USER` int NOT NULL,
  PRIMARY KEY (`ID_L`),
  KEY `ID_C_idx` (`ID_CONTR`),
  KEY `ID_US_idx` (`ID_USER`),
  CONSTRAINT `ID_CO` FOREIGN KEY (`ID_CONTR`) REFERENCES `contratti` (`ID_CONTR`),
  CONSTRAINT `ID_US` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendente`
--

LOCK TABLES `dipendente` WRITE;
/*!40000 ALTER TABLE `dipendente` DISABLE KEYS */;
INSERT INTO `dipendente` VALUES (190,'PULIZIE',1,15000,789654),(234,'GUARDIA',NULL,20500,345098);
/*!40000 ALTER TABLE `dipendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `COD_PR` char(5) NOT NULL,
  `CHECK_IN` date NOT NULL,
  `CHECK_OUT` date NOT NULL,
  `COSTO` int NOT NULL,
  `DATA_PR` datetime NOT NULL,
  `NUMERO_CAMERA` int NOT NULL,
  `ID_USER` int NOT NULL,
  PRIMARY KEY (`COD_PR`),
  UNIQUE KEY `PRENOTAZIONEcol_UNIQUE` (`NUMERO_CAMERA`),
  KEY `PR_I_idx` (`ID_USER`),
  CONSTRAINT `PR_C` FOREIGN KEY (`NUMERO_CAMERA`) REFERENCES `camera` (`NUMERO`),
  CONSTRAINT `PR_I` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES ('1','2022-03-22','2022-03-26',400,'2022-03-20 00:00:00',2,123452),('2','2022-03-28','2022-04-02',780,'2022-03-15 00:00:00',6,432765);
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologia_utente`
--

DROP TABLE IF EXISTS `tipologia_utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipologia_utente` (
  `ID_TIPO` int NOT NULL,
  `DESCR_TIPO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologia_utente`
--

LOCK TABLES `tipologia_utente` WRITE;
/*!40000 ALTER TABLE `tipologia_utente` DISABLE KEYS */;
INSERT INTO `tipologia_utente` VALUES (1,'DIPENDENTE'),(2,'CLIENTE'),(3,'DIRETTORE');
/*!40000 ALTER TABLE `tipologia_utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turni_lavoro`
--

DROP TABLE IF EXISTS `turni_lavoro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turni_lavoro` (
  `ID_L` int NOT NULL,
  `GIORNO` date NOT NULL,
  `NUM_CT` int DEFAULT NULL,
  `ORA_INIZIO` time NOT NULL,
  `ORA_FINE` time NOT NULL,
  PRIMARY KEY (`GIORNO`),
  KEY `NUM_idx` (`NUM_CT`),
  KEY `ID_TR_idx` (`ID_L`),
  CONSTRAINT `ID_TR` FOREIGN KEY (`ID_L`) REFERENCES `dipendente` (`ID_L`),
  CONSTRAINT `NUM_T` FOREIGN KEY (`NUM_CT`) REFERENCES `camera` (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turni_lavoro`
--

LOCK TABLES `turni_lavoro` WRITE;
/*!40000 ALTER TABLE `turni_lavoro` DISABLE KEYS */;
INSERT INTO `turni_lavoro` VALUES (234,'2023-09-01',NULL,'08:00:00','12:00:00'),(190,'2023-09-09',NULL,'00:00:00','06:00:00');
/*!40000 ALTER TABLE `turni_lavoro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID_USER` int NOT NULL,
  `CF` char(16) NOT NULL,
  `NOME` varchar(20) NOT NULL,
  `COGNOME` varchar(20) NOT NULL,
  `DATA_NASCITA` date NOT NULL,
  `CELL` varchar(20) NOT NULL,
  `VIA` varchar(45) NOT NULL,
  `CITTA` varchar(45) NOT NULL,
  `PROVINCIA` varchar(45) NOT NULL,
  `CAP` varchar(45) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL,
  `ID_TIPO` int NOT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `CF_UNIQUE` (`CF`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `CELL_UNIQUE` (`CELL`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  UNIQUE KEY `ID_USER_UNIQUE` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (123452,'NREMRC80P15H501U','MARCO','NERI','1980-09-15','3490027531','SESIA','ROMA','ROMA','00100','MARCO.NERI@HOTMAIL.IT','MARCO.NERI','password1',2),(345098,'BNCCRL76M23L219X','CARLO','BIANCHI','1976-08-23','3479924375','PO','TORINO','TO','10121','C.BIANCHI@LIBERO.IT','C.BIANCHI','password',1),(432765,'VRDGLI91C42F205H','GIULIA','VERDI','1991-03-02','3717562592','TICINO','MILANO','MI','20100','VERDI.G@GMAIL.COM','VERDI.G','password1',2),(789654,'RSSSRA00A71F839R','SARA','ROSSI','2000-01-31','3202297899','SAURO','NAPOLI','NA','80126','SARIRED@GMAIL.COM','S.ROSSI','password3',1),(207888375,'dfiojgijo','igfiojbgf','iodsijodfijo','1980-01-01','235235235','ijo','ijo','ijo','28387','ijo','ijo','ijo',1),(793107801,'dlrmtt99r19l746w','paolo','petrulli','1999-03-19','3519801857','duchessa','stresa','vb','27737','email@mail.com','MATTEO.DILO','Password',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hotel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-05 10:22:06
