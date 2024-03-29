-- MySQL Script generated by MySQL Workbench
-- Sat Oct  2 21:00:45 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

use 

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema itproject
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema itproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `itproject` DEFAULT CHARACTER SET utf8 ;
USE `itproject` ;

-- -----------------------------------------------------
-- Table `itproject`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itproject`.`User` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(45) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itproject`.`Contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itproject`.`Contact` (
  `contactid` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(45) NOT NULL,
  `Team` VARCHAR(45) NULL,
  `Name` VARCHAR(45) NOT NULL,
  `status` ENUM('general', 'star', 'emergency') NOT NULL,
  `Description` VARCHAR(45) NULL,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`contactid`),
  INDEX `fk_Contact_User1_idx` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Contact_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `itproject`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itproject`.`Task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itproject`.`Task` (
  `Taskid` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Contactid` VARCHAR(45) NULL,
  `Description` VARCHAR(45) NULL,
  `time` DATETIME NULL,
  `Completed` TINYINT NOT NULL DEFAULT 0,
  `User_ID` INT NOT NULL,
  PRIMARY KEY (`Taskid`),
  INDEX `fk_Task_User1_idx` (`User_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Task_User1`
    FOREIGN KEY (`User_ID`)
    REFERENCES `itproject`.`User` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itproject`.`table1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itproject`.`table1` (
  `Task_Taskid` INT NOT NULL,
  `Contact_contactid` INT NOT NULL,
  INDEX `fk_table1_Task1_idx` (`Task_Taskid` ASC) VISIBLE,
  INDEX `fk_table1_Contact1_idx` (`Contact_contactid` ASC) VISIBLE,
  CONSTRAINT `fk_table1_Task1`
    FOREIGN KEY (`Task_Taskid`)
    REFERENCES `itproject`.`Task` (`Taskid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_Contact1`
    FOREIGN KEY (`Contact_contactid`)
    REFERENCES `itproject`.`Contact` (`contactid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
