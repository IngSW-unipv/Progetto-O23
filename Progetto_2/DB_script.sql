-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Hotel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Hotel` DEFAULT CHARACTER SET latin1 ;
USE `Hotel` ;

-- -----------------------------------------------------
-- Table `Hotel`.`COMFORT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`COMFORT` (
  `ID_COMFORT` CHAR(20) NOT NULL,
  `TIPO` TINYTEXT NOT NULL,
  `PREZZO` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`ID_COMFORT`),
  UNIQUE INDEX `ID_COMFORT_UNIQUE` (`ID_COMFORT` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`CAMERA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`CAMERA` (
  `NUMERO` INT(10) NOT NULL,
  `TIPO` VARCHAR(45) NOT NULL,
  `NLETTI` SMALLINT(6) NOT NULL,
  `PIANO` SMALLINT(6) NOT NULL,
  `PREZZO` DECIMAL(3,2) NOT NULL,
  `ID_COMFORT` VARCHAR(20) NOT NULL,
  `STATO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NUMERO`),
  UNIQUE INDEX `NUMERO_UNIQUE` (`NUMERO` ASC),
  INDEX `camera_ibfk_1` (`ID_COMFORT` ASC),
  CONSTRAINT `camera_ibfk_1`
    FOREIGN KEY (`ID_COMFORT`)
    REFERENCES `Hotel`.`COMFORT` (`ID_COMFORT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`PRENOTAZIONE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`PRENOTAZIONE` (
  `COD_PR` CHAR(5) NOT NULL,
  `CHECK_IN` DATE NOT NULL,
  `CHECK_OUT` DATE NOT NULL,
  `COSTO` DECIMAL(4,2) NOT NULL,
  `DATA_PR` DATETIME NOT NULL,
  PRIMARY KEY (`COD_PR`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`TIPOLOGIA_UTENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`TIPOLOGIA_UTENTE` (
  `ID_TIPO` INT(11) NOT NULL,
  `DESCR_TIPO` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_TIPO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`CITTA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`CITTA` (
  `ID_CITTA` INT(4) NOT NULL,
  `NOME_C` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_CITTA`),
  UNIQUE INDEX `ID_CITTA_UNIQUE` (`ID_CITTA` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`PROVINCIA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`PROVINCIA` (
  `ID_PROV` INT(4) NOT NULL,
  `NOME_P` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_PROV`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`NAZIONE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`NAZIONE` (
  `ID_NAZ` INT(4) NOT NULL,
  `NOME_N` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_NAZ`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`USER` (
  `ID_USER` INT(10) NOT NULL,
  `CF` CHAR(16) NOT NULL,
  `NOME` VARCHAR(20) NOT NULL,
  `COGNOME` VARCHAR(20) NOT NULL,
  `DATA_NASCITA` DATE NOT NULL,
  `CELL` VARCHAR(20) NOT NULL,
  `EMAIL` VARCHAR(40) NOT NULL,
  `ID_CITTA` INT(4) NOT NULL,
  `ID_PROV` INT(4) NOT NULL,
  `ID_NAZ` INT(4) NOT NULL,
  `ID_TIPO` INT(11) NOT NULL,
  `USERNAME` VARCHAR(20) NOT NULL,
  `PSW` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE INDEX `CF_UNIQUE` (`CF` ASC),
  UNIQUE INDEX `CELL_UNIQUE` (`CELL` ASC),
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC),
  INDEX `ID_T_idx` (`ID_TIPO` ASC),
  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC),
  UNIQUE INDEX `ID_USER_UNIQUE` (`ID_USER` ASC),
  INDEX `ID_C_idx` (`ID_CITTA` ASC),
  INDEX `ID_N_idx` (`ID_NAZ` ASC),
  CONSTRAINT `ID_T`
    FOREIGN KEY (`ID_TIPO`)
    REFERENCES `Hotel`.`TIPOLOGIA_UTENTE` (`ID_TIPO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ID_C`
    FOREIGN KEY (`ID_CITTA`)
    REFERENCES `Hotel`.`CITTA` (`ID_CITTA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ID_P`
    FOREIGN KEY (`ID_PROV`)
    REFERENCES `Hotel`.`PROVINCIA` (`ID_PROV`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ID_N`
    FOREIGN KEY (`ID_NAZ`)
    REFERENCES `Hotel`.`NAZIONE` (`ID_NAZ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`CLIENTE` (
  `ID_CLIENTE` INT(50) NOT NULL,
  `ID_USER` INT(10) NOT NULL,
  `COD_PR` CHAR(5) NOT NULL,
  `NUM_C` INT(10) NOT NULL,
  PRIMARY KEY (`ID_CLIENTE`),
  INDEX `COD_idx` (`COD_PR` ASC),
  INDEX `CF_idx` (`ID_USER` ASC),
  INDEX `NUMERO_C` (`NUM_C` ASC),
  CONSTRAINT `COD`
    FOREIGN KEY (`COD_PR`)
    REFERENCES `Hotel`.`PRENOTAZIONE` (`COD_PR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ID_U`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `Hotel`.`USER` (`ID_USER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NUMERO_C`
    FOREIGN KEY (`NUM_C`)
    REFERENCES `Hotel`.`CAMERA` (`NUMERO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`CONTRATTI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`CONTRATTI` (
  `ID_CONTR` INT(10) NOT NULL,
  `DESC_CONTR` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_CONTR`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`MANSIONE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`MANSIONE` (
  `ID_MANS` INT(10) NOT NULL,
  `DESC_MANS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_MANS`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`DIPENDENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`DIPENDENTE` (
  `ID_L` INT(11) NOT NULL,
  `ID_MANS` INT(10) NOT NULL,
  `ID_CONTR` INT(10) NOT NULL,
  `STIPENDIO` DECIMAL(6,3) NOT NULL,
  `ID_USER` INT(10) NOT NULL,
  PRIMARY KEY (`ID_L`),
  INDEX `ID_M_idx` (`ID_MANS` ASC),
  INDEX `ID_C_idx` (`ID_CONTR` ASC),
  INDEX `ID_US_idx` (`ID_USER` ASC),
  CONSTRAINT `ID_CO`
    FOREIGN KEY (`ID_CONTR`)
    REFERENCES `Hotel`.`CONTRATTI` (`ID_CONTR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ID_M`
    FOREIGN KEY (`ID_MANS`)
    REFERENCES `Hotel`.`MANSIONE` (`ID_MANS`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ID_US`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `Hotel`.`USER` (`ID_USER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Hotel`.`TURNI_LAVORO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotel`.`TURNI_LAVORO` (
  `ID_L` INT(11) NOT NULL,
  `GIORNO` DATE NOT NULL,
  `NUM_CT` INT(10) NOT NULL,
  `ORA_INIZIO` TIME NOT NULL,
  `ORA_FINE` TIME NOT NULL,
  PRIMARY KEY (`GIORNO`),
  INDEX `ID_idx` (`ID_L` ASC),
  INDEX `NUM_idx` (`NUM_CT` ASC),
  CONSTRAINT `ID_TR`
    FOREIGN KEY (`ID_L`)
    REFERENCES `Hotel`.`DIPENDENTE` (`ID_L`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `NUM_T`
    FOREIGN KEY (`NUM_CT`)
    REFERENCES `Hotel`.`CAMERA` (`NUMERO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
