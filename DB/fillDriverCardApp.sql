

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
-- Dumping data for table `accommodations`
--

LOCK TABLES `drivers` WRITE;
/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` (PersonalNumber, FirstName, LastName, DateOfBirth, Address, PhoneNumber, Email, SelfieID, DrivingPicID)
VALUES ('12828282', 'Kolio', 'Fichev', '1830-11-10', 'Gabrovo, BG', '088888888', 'ficheto@abv.bg', 6, 7);
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (Username, Password)
VALUES ('chocho', '12345677');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
INSERT INTO `pictures` (Picture)
VALUES (LOAD_FILE ('C:\Users\R&T\Desktop\Other\DEUTSCH\cv\pipi.jpg')),
(LOAD_FILE ('C:\Users\R&T\Desktop\Other\DEUTSCH\cv\pipi.jpg')),
(LOAD_FILE ('C:\Users\R&T\Desktop\Other\DEUTSCH\cv\pipi.jpg')),
(LOAD_FILE ('C:\Users\R&T\Desktop\Other\DEUTSCH\cv\pipi.jpg')),
(LOAD_FILE ('C:\Users\R&T\Desktop\Other\DEUTSCH\cv\pipi.jpg')),
(LOAD_FILE ('C:\Users\R&T\Desktop\Other\DEUTSCH\cv\pipi.jpg')),
(LOAD_FILE ('C:\Users\R&T\Desktop\Other\DEUTSCH\cv\pipi.jpg'));
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;


UPDATE pictures SET Picture = LOAD_FILE ('C:\\Users\\R&T\\Desktop\\Other\\DEUTSCH\\cv\\pipi.jpg') WHERE pictureId = 19;
UNLOCK TABLES;

LOCK TABLES `cardapplicationforms` WRITE;
/*!40000 ALTER TABLE `cardapplicationforms` DISABLE KEYS */;
INSERT INTO `cardapplicationforms` (driverID, DateOfSubmission, Status, Type, PaymentInformation, SignaturePicID, DrivingLicenseNumber, DrivingLicenseCountry, StatusCheckCode)
VALUES (1,'2018-10-01','new','first','12345 ABank',1,'lkjaskflakslf111','UK','123456789'),
(1,'2018-10-02','new','first','12345 BBank',2,'ksksksksksk111','FR','123456789'),
(1,'2018-10-03','new','first','99292 cBank',3,'sllslslsss','IT','123456789');
/*!40000 ALTER TABLE `cardapplicationforms` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `cardapplicationforms` WRITE;
/*!40000 ALTER TABLE `cardapplicationforms` DISABLE KEYS */;
INSERT INTO `cardapplicationforms` (driverID, DateOfSubmission, Status, Type, PaymentInformation, SignaturePicID, DrivingLicenseNumber, DrivingLicenseCountry,
OldCardCountry, OldCardNumber, OldCardAuthority, OldCardDateOfExpiry, OldCardPicID, StatusCheckCode)
VALUES (1,'2018-09-01','new','first','12345 ABank',1,'lkjaskflakslf111','UK', 'UK', '12345', 'Police', '2020-01-10', 4,'123456789'),
(1,'2018-09-05','new','name','818181 dBank',4,'llllslls','BG', 'GR', '54321', 'Police', '2010-01-10', 5,'123456789');
/*!40000 ALTER TABLE `cardapplicationforms` ENABLE KEYS */;
UNLOCK TABLES;