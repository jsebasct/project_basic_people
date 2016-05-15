-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `basic_people` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `basic_people` ;

-- -----------------------------------------------------
-- Table `mydb`.`PERSON`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basic_people`.`PERSON` ;

CREATE TABLE IF NOT EXISTS `basic_people`.`PERSON` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `document_type` VARCHAR(45) NULL,
  `document_number` VARCHAR(45) NULL,
  `birth_date` DATETIME NULL,
  PRIMARY KEY (`person_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BankAccount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `basic_people`.`BankAccount` ;

CREATE TABLE IF NOT EXISTS `basic_people`.`BankAccount` (
  `bank_account_id` INT NOT NULL,
  `account_number` VARCHAR(45) NULL,
  `bank_name` VARCHAR(45) NULL,
  `FK_person_id` INT NOT NULL,
  PRIMARY KEY (`bank_account_id`),
  INDEX `fk_BankAccount_PERSON_idx` (`FK_person_id` ASC),
  CONSTRAINT `fk_BankAccount_PERSON`
    FOREIGN KEY (`FK_person_id`)
    REFERENCES `basic_people`.`PERSON` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
