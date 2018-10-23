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
-- Table `GetMyDriverCardApplcation`.`drivers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GetMyDriverCardApplcation`.`drivers` (
  `driverID` INT NOT NULL AUTO_INCREMENT,
  `PersonalNumber` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(200) NOT NULL,
  `LastName` VARCHAR(50) NOT NULL,
  `DateOfBirth` DATE NOT NULL,
  `Address` VARCHAR(500) NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(30) NOT NULL,
  `SelfieID` INT NOT NULL,
  `DrivingPicID` INT NOT NULL,
  PRIMARY KEY (`driverID`),
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
-- Table `GetMyDriverCardApplcation`.`cardapplicationforms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GetMyDriverCardApplcation`.`cardapplicationforms` (
  `cardapplicationformID` INT NOT NULL AUTO_INCREMENT,
  `driverID` INT NOT NULL,
  `DateOfSubmission` DATE NOT NULL,
  `Status` VARCHAR(20) NOT NULL DEFAULT 'new',
  `Type` VARCHAR(20) NOT NULL,
  `PaymentInformation` VARCHAR(100) NOT NULL,
  `SignaturePicID` INT(11) NULL,
  `DateOfEvent` DATE NULL,
  `PlaceOfEvent` VARCHAR(200) NULL,
  `OldCardPicID` INT(11) NULL ,
  `OldCardCountry` VARCHAR(50) NULL,
  `OldCardAuthority` VARCHAR(50) NULL ,
  `OldCardNumber` VARCHAR(45) NULL,
  `OldCardDateOfExpiry` DATE NULL,
  `NewAddress` VARCHAR(200) NULL,
  `NewFirstName` VARCHAR(200) NULL,
  `NewLastName` VARCHAR(100) NULL,
  `NewSelfieID` INT(11) NULL,
  `RenewalReason` VARCHAR(100) NULL,
  `DrivingLicenceNumber` VARCHAR(50) NULL,
  `DrivingLicenceCountry` VARCHAR(50) NULL,
  PRIMARY KEY (`cardapplicationformID`),
  INDEX `driverID_idx` (`driverID` ASC)  ,
  INDEX `SignaturePicID_idx` (`SignaturePicID` ASC)  ,
  INDEX `OldCardPicID_idx` (`OldCardPicID` ASC)  ,
  INDEX `NewSelfieID_idx` (`NewSelfieID` ASC)  ,
  CONSTRAINT `driverID`
    FOREIGN KEY (`driverID`)
    REFERENCES `GetMyDriverCardApplcation`.`drivers` (`driverID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `SignaturePicID`
    FOREIGN KEY (`SignaturePicID`)
    REFERENCES `GetMyDriverCardApplcation`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `OldCardPicID`
    FOREIGN KEY (`OldCardPicID`)
    REFERENCES `GetMyDriverCardApplcation`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT, 
  CONSTRAINT `NewSelfieID`
    FOREIGN KEY (`NewSelfieID`)
    REFERENCES `GetMyDriverCardApplcation`.`pictures` (`PictureID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT  
    )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

  

