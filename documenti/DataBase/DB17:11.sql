CREATE DATABASE  IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `hotel`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel
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
-- Table structure for table `camera`
--

DROP TABLE IF EXISTS `camera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camera` (
  `NUMERO` int(11) NOT NULL,
  `TIPO` varchar(45) NOT NULL,
  `NLETTI` smallint(6) NOT NULL,
  `PIANO` smallint(6) NOT NULL,
  `PREZZO` int(11) NOT NULL,
  PRIMARY KEY (`NUMERO`),
  UNIQUE KEY `NUMERO_UNIQUE` (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camera`
--

LOCK TABLES `camera` WRITE;
/*!40000 ALTER TABLE `camera` DISABLE KEYS */;
INSERT INTO `camera` VALUES (1,'singola',1,1,60),(2,'doppia',2,2,80),(3,'tripla',3,3,120),(4,'doppia',2,1,80),(5,'singola',1,2,55),(6,'tripla',3,3,130),(7,'singola',1,1,65),(8,'doppia',2,2,75);
/*!40000 ALTER TABLE `camera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendente`
--

DROP TABLE IF EXISTS `dipendente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dipendente` (
  `ID_L` int(11) NOT NULL,
  `NOME` varchar(20) NOT NULL,
  `COGNOME` varchar(20) NOT NULL,
  `RUOLO` varchar(40) NOT NULL,
  `STIPENDIO` int(11) NOT NULL,
  `ID_USER` int(11) NOT NULL,
  PRIMARY KEY (`ID_L`),
  KEY `ID_US_idx` (`ID_USER`),
  KEY `nome_d_idx` (`NOME`),
  KEY `cognome_d_idx` (`COGNOME`),
  CONSTRAINT `ID_US` FOREIGN KEY (`ID_USER`) REFERENCES `user` (`ID_USER`),
  CONSTRAINT `cognome_d` FOREIGN KEY (`COGNOME`) REFERENCES `user` (`COGNOME`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `nome_d` FOREIGN KEY (`NOME`) REFERENCES `user` (`NOME`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendente`
--

LOCK TABLES `dipendente` WRITE;
/*!40000 ALTER TABLE `dipendente` DISABLE KEYS */;
INSERT INTO `dipendente` VALUES (190,'SARA','ROSSI','PULIZIE',15120,789654),(999,'CARLO','BIANCHI','DIRETTORE',200000,999999);
/*!40000 ALTER TABLE `dipendente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prenotazione` (
  `COD_PR` char(5) NOT NULL,
  `CHECK_IN` date NOT NULL,
  `CHECK_OUT` date NOT NULL,
  `COSTO` int(11) NOT NULL,
  `DATA_PR` datetime NOT NULL,
  `NUMERO_CAMERA` int(11) NOT NULL,
  `ID_USER` int(11) NOT NULL,
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipologia_utente` (
  `ID_TIPO` int(11) NOT NULL,
  `DESCR_TIPO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO`),
  KEY `tipo` (`ID_TIPO`)
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turni_lavoro` (
  `ID_L` int(11) NOT NULL,
  `GIORNO` date NOT NULL,
  `ORA_INIZIO` time NOT NULL,
  `ORA_FINE` time NOT NULL,
  `ID_T` int(11) NOT NULL,
  PRIMARY KEY (`ID_T`),
  KEY `id_tl_idx` (`ID_L`),
  CONSTRAINT `id_tl` FOREIGN KEY (`ID_L`) REFERENCES `dipendente` (`ID_L`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turni_lavoro`
--

LOCK TABLES `turni_lavoro` WRITE;
/*!40000 ALTER TABLE `turni_lavoro` DISABLE KEYS */;
INSERT INTO `turni_lavoro` VALUES (190,'2023-10-22','10:00:00','14:00:00',1),(190,'2023-10-25','10:00:00','16:40:00',4),(190,'2023-12-12','12:00:00','16:00:00',10);
/*!40000 ALTER TABLE `turni_lavoro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID_USER` int(11) NOT NULL,
  `CF` char(16) NOT NULL,
  `NOME` varchar(20) NOT NULL,
  `COGNOME` varchar(20) NOT NULL,
  `DATA_NASCITA` date NOT NULL,
  `CELL` int(20) unsigned NOT NULL,
  `VIA` varchar(45) NOT NULL,
  `CITTA` varchar(45) NOT NULL,
  `PROVINCIA` varchar(45) NOT NULL,
  `CAP` int(11) NOT NULL,
  `EMAIL` varchar(40) NOT NULL,
  `USERNAME` varchar(20) NOT NULL,
  `PASSWORD` varchar(40) NOT NULL,
  `ID_TIPO` int(11) NOT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `CF_UNIQUE` (`CF`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `CELL_UNIQUE` (`CELL`),
  UNIQUE KEY `USERNAME_UNIQUE` (`USERNAME`),
  UNIQUE KEY `ID_USER_UNIQUE` (`ID_USER`),
  KEY `nome` (`NOME`),
  KEY `cognome` (`COGNOME`),
  KEY `tipo_u_idx` (`ID_TIPO`),
  CONSTRAINT `tipo_u` FOREIGN KEY (`ID_TIPO`) REFERENCES `tipologia_utente` (`ID_TIPO`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (123452,'NREMRC80P15H501U','MARCO','NERI','1980-09-15',3490027531,'SESIA','ROMA','ROMA',100,'MARCO.NERI@HOTMAIL.IT','MARCO.NERI','password1',2),(432765,'VRDGLI91C42F205H','GIULIA','VERDI','1991-03-02',3717562592,'TICINO','MILANO','MI',20100,'VERDI.G@GMAIL.COM','VERDI.G','password1',2),(789654,'RSSSRA00A71F839R','SARA','ROSSI','2000-01-31',3202297899,'SAURO','NAPOLI','NA',80126,'SARIRED@GMAIL.COM','S.ROSSI','password3',1),(999999,'BNCCRL76M23L219X','CARLO','BIANCHI','1976-08-23',3479924375,'PO','TORINO','TO',10121,'C.BIANCHI@LIBERO.IT','C.BIANCHI','password',3);
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

-- Dump completed on 2023-11-17 15:55:19
