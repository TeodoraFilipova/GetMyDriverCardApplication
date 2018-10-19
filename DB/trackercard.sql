-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema trackercard
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trackercard
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `trackercard` DEFAULT CHARACTER SET latin1 ;
USE `trackercard` ;

-- -----------------------------------------------------
-- Table `trackercard`.`pictures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackercard`.`pictures` (
  `PictureID` INT NOT NULL AUTO_INCREMENT,
  `Picture` BLOB NOT NULL,
  PRIMARY KEY (`PictureID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trackercard`.`truckers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackercard`.`truckers` (
  `truckerID` INT NOT NULL AUTO_INCREMENT,
  `PersonalNumber` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(200) NOT NULL,
  `LastName` VARCHAR(50) NOT NULL,
  `DateOfBirth` DATE NOT NULL,
  `Address` VARCHAR(500) NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(30) NOT NULL,
  `SelfieID` INT NOT NULL,
  `DrivingPicID` INT NOT NULL,
  PRIMARY KEY (`truckerID`),
  INDEX `SelfieID_idx` (`SelfieID` ASC)  ,
  INDEX `DrivingPicID_idx` (`DrivingPicID` ASC)  ,
  CONSTRAINT `SelfieID`
    FOREIGN KEY (`SelfieID`)
    REFERENCES `trackercard`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `DrivingPicID`
    FOREIGN KEY (`DrivingPicID`)
    REFERENCES `trackercard`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trackercard`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackercard`.`users` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC)  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trackercard`.`applications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackercard`.`applications` (
  `ApplicationID` INT NOT NULL AUTO_INCREMENT,
  `TruckerID` INT NOT NULL,
  `DateOfSubmission` DATE NOT NULL,
  `Status` VARCHAR(20) NOT NULL DEFAULT 'new',
  `Type` VARCHAR(20) NOT NULL,
  `PaymentInformation` VARCHAR(100) NOT NULL,
  `SignaturePicID` INT NULL,
  PRIMARY KEY (`ApplicationID`),
  INDEX `TruckerID_idx` (`TruckerID` ASC)  ,
  INDEX `SignaturePicID_idx` (`SignaturePicID` ASC)  ,
  CONSTRAINT `TruckerID`
    FOREIGN KEY (`TruckerID`)
    REFERENCES `trackercard`.`truckers` (`truckerID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `SignaturePicID`
    FOREIGN KEY (`SignaturePicID`)
    REFERENCES `trackercard`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trackercard`.`applicationdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trackercard`.`applicationdetails` (
  `DetailsID` INT NOT NULL AUTO_INCREMENT,
  `ApplicationID` INT NOT NULL,
  `DateOfEvent` DATE NULL,
  `PlaceOfEvent` VARCHAR(100) NULL,
  `OldCardPicID` INT NULL,
  `OldCardCountry` VARCHAR(50) NULL,
  `OldCardAuthority` VARCHAR(100) NULL,
  `OldCardNumber` VARCHAR(45) NULL,
  `OldCardDateOfExpiry` DATE NULL,
  `NewAddress` VARCHAR(200) NULL,
  `NewFirstName` VARCHAR(200) NULL,
  `NewLastName` VARCHAR(50) NULL,
  `NewSelfieID` INT NULL,
  `RenewalReason` VARCHAR(50) NULL,
  PRIMARY KEY (`DetailsID`),
  INDEX `ApplicationID_idx` (`ApplicationID` ASC)  ,
  INDEX `NewSelfieID_idx` (`NewSelfieID` ASC)  ,
  INDEX `OldCardPicID_idx` (`OldCardPicID` ASC)  ,
  CONSTRAINT `ApplicationID`
    FOREIGN KEY (`ApplicationID`)
    REFERENCES `trackercard`.`applications` (`ApplicationID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `NewSelfieID`applicationsapplications
    FOREIGN KEY (`NewSelfieID`)
    REFERENCES `trackercard`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `OldCardPicID`
    FOREIGN KEY (`OldCardPicID`)
    REFERENCES `trackercard`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


ALTER TABLE `trackercard`.`applications` 
DROP FOREIGN KEY `SignaturePicID`;
ALTER TABLE `trackercard`.`applications` 
ADD COLUMN `PaymentInformation` VARCHAR(100) NOT NULL AFTER `SignaturePicID`,
CHANGE COLUMN `SignaturePicID` `SignaturePicID` INT(11) NOT NULL ;
ALTER TABLE `trackercard`.`applications` 
ADD CONSTRAINT `SignaturePicID`
  FOREIGN KEY (`SignaturePicID`)
  REFERENCES `trackercard`.`pictures` (`PictureID`);


ALTER TABLE `trackercard`.`applications` 
ADD COLUMN `DateOfEvent` DATE NULL AFTER `PaymentInformation`,
ADD COLUMN `PlaceOfEvent` VARCHAR(200) NULL AFTER `DateOfEvent`,
ADD COLUMN `OldCardPicID` BLOB NULL AFTER `PlaceOfEvent`,
ADD COLUMN `OldCardCountry` VARCHAR(50) NULL AFTER `OldCardPicID`,
ADD COLUMN `OldCardAuthority` VARCHAR(50) NULL AFTER `OldCardCountry`,
ADD COLUMN `OldCardNumber` VARCHAR(45) NULL AFTER `OldCardAuthority`,
ADD COLUMN `OldCardDateOfExpiry` DATE NULL AFTER `OldCardNumber`,
ADD COLUMN `NewAddress` VARCHAR(200) NULL AFTER `OldCardDateOfExpiry`,
ADD COLUMN `NewFirstName` VARCHAR(200) NULL AFTER `NewAddress`,
ADD COLUMN `NewLastName` VARCHAR(100) NULL AFTER `NewFirstName`,
ADD COLUMN `NewSelfieID` INT NULL AFTER `NewLastName`,
ADD COLUMN `RenewalReason` VARCHAR(100) NULL AFTER `NewSelfieID`;
