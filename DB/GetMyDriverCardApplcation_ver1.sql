-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema GetMyDriverCardApplcation
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema GetMyDriverCardApplcation
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GetMyDriverCardApplcation` DEFAULT CHARACTER SET latin1 ;
USE `GetMyDriverCardApplcation` ;

-- -----------------------------------------------------
-- Table `GetMyDriverCardApplcation`.`pictures`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GetMyDriverCardApplcation`.`pictures` (
  `PictureID` INT NOT NULL AUTO_INCREMENT,
  `Picture` BLOB NOT NULL,
  PRIMARY KEY (`PictureID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GetMyDriverCardApplcation`.`truckers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GetMyDriverCardApplcation`.`truckers` (
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
    REFERENCES `GetMyDriverCardApplcation`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `DrivingPicID`
    FOREIGN KEY (`DrivingPicID`)
    REFERENCES `GetMyDriverCardApplcation`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GetMyDriverCardApplcation`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GetMyDriverCardApplcation`.`users` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE INDEX `Username_UNIQUE` (`Username` ASC)  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `GetMyDriverCardApplcation`.`applications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GetMyDriverCardApplcation`.`applications` (
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
    REFERENCES `GetMyDriverCardApplcation`.`truckers` (`truckerID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `SignaturePicID`
    FOREIGN KEY (`SignaturePicID`)
    REFERENCES `GetMyDriverCardApplcation`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


ALTER TABLE `GetMyDriverCardApplcation`.`applications` 
DROP FOREIGN KEY `SignaturePicID`;
ALTER TABLE `GetMyDriverCardApplcation`.`applications` 
ADD COLUMN `PaymentInformation` VARCHAR(100) NOT NULL AFTER `SignaturePicID`,
CHANGE COLUMN `SignaturePicID` `SignaturePicID` INT(11) NOT NULL ;
ALTER TABLE `GetMyDriverCardApplcation`.`applications` 
ADD CONSTRAINT `SignaturePicID`
  FOREIGN KEY (`SignaturePicID`)
  REFERENCES `GetMyDriverCardApplcation`.`pictures` (`PictureID`);


ALTER TABLE `GetMyDriverCardApplcation`.`applications` 
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

ALTER TABLE `getmydrivercardapplcation`.`applications` 
DROP FOREIGN KEY `TruckerID`;
ALTER TABLE `getmydrivercardapplcation`.`applications` 
CHANGE COLUMN `TruckerID` `DriverID` INT(11) NOT NULL , RENAME TO  `getmydrivercardapplcation`.`cardapplicationform` ;
ALTER TABLE `getmydrivercardapplcation`.`applications` 
ADD CONSTRAINT `DriverID`
  FOREIGN KEY (`DriverID`)
  REFERENCES `getmydrivercardapplcation`.`truckers` (`truckerID`);
  
  ALTER TABLE `getmydrivercardapplcation`.`truckers` 
DROP FOREIGN KEY `DrivingPicID`;
ALTER TABLE `getmydrivercardapplcation`.`truckers` 
CHANGE COLUMN `DrivingPicID` `DrivingLicensePicID` INT(11) NOT NULL , RENAME TO  `getmydrivercardapplcation`.`drivers` ;
ALTER TABLE `getmydrivercardapplcation`.`truckers` 
ADD CONSTRAINT `DrivingPicID`
  FOREIGN KEY (`DrivingLicensePicID`)
  REFERENCES `getmydrivercardapplcation`.`pictures` (`PictureID`);
