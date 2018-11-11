CREATE DATABASE  IF NOT EXISTS `getmydrivercardapplcation` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `getmydrivercardapplcation`;
-- MySQL dump 10.16  Distrib 10.3.9-MariaDB, for Win64 (AMD64)
--
-- Host: 127.0.0.1    Database: getmydrivercardapplcation
-- ------------------------------------------------------
-- Server version	10.3.9-MariaDB

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
-- Table structure for table `cardapplicationforms`
--

DROP TABLE IF EXISTS `cardapplicationforms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardapplicationforms` (
  `cardapplicationformID` int(11) NOT NULL,
  `driverID` int(11) NOT NULL,
  `DateOfSubmission` date NOT NULL,
  `Status` varchar(20) NOT NULL DEFAULT 'new',
  `Type` varchar(60) NOT NULL,
  `ReceivingOffice` varchar(100) NOT NULL,
  `SignaturePicID` int(11) NOT NULL,
  `DateOfEvent` date DEFAULT NULL,
  `PlaceOfEvent` varchar(200) DEFAULT NULL,
  `OldCardPicID` int(11) DEFAULT NULL,
  `OldCardCountry` varchar(50) DEFAULT NULL,
  `OldCardAuthority` varchar(50) DEFAULT NULL,
  `OldCardNumber` varchar(45) DEFAULT NULL,
  `OldCardDateOfExpiry` date DEFAULT NULL,
  `NewAddress` varchar(200) DEFAULT NULL,
  `NewFirstName` nvarchar(200) DEFAULT NULL,
  `NewLastName` nvarchar(100) DEFAULT NULL,
  `NewSelfieID` int(11) DEFAULT NULL,
  `RenewalReason` varchar(100) DEFAULT NULL,
  `DrivingLicenseNumber` varchar(50) DEFAULT NULL,
  `DrivingLicenseCountry` varchar(50) DEFAULT NULL,
  `StatusCheckCode` varchar(10) NOT NULL,
  `LastSetID` varchar(10) DEFAULT '',
  `Details` varchar(300) DEFAULT '',
  PRIMARY KEY (`cardapplicationformID`),
  KEY `driverID_idx` (`driverID`),
  KEY `SignaturePicID_idx` (`SignaturePicID`),
  KEY `OldCardPicID_idx` (`OldCardPicID`),
  KEY `NewSelfieID_idx` (`NewSelfieID`),
  CONSTRAINT `NewSelfieID` FOREIGN KEY (`NewSelfieID`) REFERENCES `pictures` (`PictureID`),
  CONSTRAINT `OldCardPicID` FOREIGN KEY (`OldCardPicID`) REFERENCES `pictures` (`PictureID`),
  CONSTRAINT `SignaturePicID` FOREIGN KEY (`SignaturePicID`) REFERENCES `pictures` (`PictureID`),
  CONSTRAINT `driverID` FOREIGN KEY (`driverID`) REFERENCES `drivers` (`driverID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardapplicationforms`
--

LOCK TABLES `cardapplicationforms` WRITE;
/*!40000 ALTER TABLE `cardapplicationforms` DISABLE KEYS */;
/*!40000 ALTER TABLE `cardapplicationforms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `drivers` (
  `driverID` int(11) NOT NULL,
  `PersonalNumber` varchar(45) NOT NULL,
  `FirstName` nvarchar(200) NOT NULL,
  `LastName` nvarchar(50) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `Address` varchar(500) NOT NULL,
  `PhoneNumber` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `SelfieID` int(11) NOT NULL,
  `DrivingPicID` int(11) NOT NULL,
  `LastSetID` varchar(10) DEFAULT '',
  PRIMARY KEY (`driverID`),
  KEY `SelfieID_idx` (`SelfieID`),
  KEY `DrivingPicID_idx` (`DrivingPicID`),
  CONSTRAINT `DrivingPicID` FOREIGN KEY (`DrivingPicID`) REFERENCES `pictures` (`PictureID`),
  CONSTRAINT `SelfieID` FOREIGN KEY (`SelfieID`) REFERENCES `pictures` (`PictureID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drivers`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pictures` (
  `PictureID` int(11) NOT NULL,
  `Picture` blob NOT NULL,
  `LastSetID` varchar(10)  DEFAULT '',
  PRIMARY KEY (`PictureID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'getmydrivercardapplcation'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-23 16:48:36
