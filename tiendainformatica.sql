-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: tiendainformatica
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `DNI` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `NombreC` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `Direccion` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('11588995P','Guillermo Rodriguez','Plaza Omar 4 2º B;'),('12927202Y','Luis Piqueras','Travesía Segura 2 1º D;'),('17548533Q','Leyre Marques','Paseo Leire 688 9º B;'),('22629601Q','José Caparros','Camiño Ariadna 66 78º B;'),('50230065C','David Claudio','Rúa Lidia 0 3º E;'),('51426740M','Sergio Gomez','Paseo Nerea 02 3º F;'),('65508648W','Luciana Yañez','Travesía Negrón 044 Bajos;'),('69084270K','Pilar Cantero','Ronda Joel 150'),('72696876V','Maximiliano Casal','Rúa Alicia 0 6º F;'),('74101877V','Cristina Hernandez','Plaça Álvaro 3 1º C;'),('75105614B','Manuel Robles','Passeig Silvia 903 2º E;'),('77376914S','Antonio Morales','Calle Palacios 7 9º D;'),('77805486M','Luis Aragonés','Praza Gastélum 34 7º A;'),('83505659L','Cristina Diaz','Camino Salcido 3 Ático 8º;'),('95824884F','Silvia Gonzalez','Travesía Alfaro 2 5º;'),('96265072K','Carlos Martinez','Paseo Badillo 62 8º B;'),('98683981C','Victor Nogales','Ronda Huerta 8 8º F;');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes`
--

DROP TABLE IF EXISTS `componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `componentes` (
  `IDC` int unsigned NOT NULL AUTO_INCREMENT,
  `NombreC` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `Marca` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `Precio` float unsigned NOT NULL,
  `Cantidad` int unsigned NOT NULL,
  `Tipo` enum('Procesador','Tarjeta gráfica','Placa base','Memoria RAM','Disco Duro','Fuente de alimentación') CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDC`),
  UNIQUE KEY `NombreC_UNIQUE` (`NombreC`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes`
--

LOCK TABLES `componentes` WRITE;
/*!40000 ALTER TABLE `componentes` DISABLE KEYS */;
INSERT INTO `componentes` VALUES (1,'I5-10400','Intel',199.9,35,'Procesador'),(2,'I3-10100','Intel',154.9,20,'Procesador'),(3,'I7-10700K','Intel',319.9,40,'Procesador'),(4,'I5-10600K','Intel',199.99,35,'Procesador'),(5,'Celeron G5925','Intel',54.99,15,'Procesador'),(6,'I5-11600','Intel',229.99,35,'Procesador'),(7,'I9-9900K','Intel',324.9,30,'Procesador'),(8,'Pentium G6500','Intel',82.99,15,'Procesador'),(9,'I3-9100F','Intel',146.15,20,'Procesador'),(10,'I5-7400','Intel',159.9,35,'Procesador'),(11,'Ryzen 5 3600','AMD',198.95,35,'Procesador'),(12,'Ryzen 5 5600','AMD',297.99,35,'Procesador'),(13,'Ryzen 9 5900X','AMD',547.99,30,'Procesador'),(14,'Ryzen 5 1600','AMD',129.91,35,'Procesador'),(15,'Ryzen 7 5800X','AMD',429.71,40,'Procesador'),(16,'Ryzen 3 3200G','AMD',196.27,20,'Procesador'),(17,'Athlon 3000G','AMD',109.04,15,'Procesador'),(18,'Ryzen 5 3500X','AMD',179.9,35,'Procesador'),(19,'Threadripper 3960X','AMD',1580.95,5,'Procesador'),(20,'Threadripper 3995WX','AMD',5751.95,5,'Procesador'),(21,'Vengance RGB Pro ','Corsair',69.95,30,'Memoria RAM'),(22,'Vengance LPX','Corsair',114.95,35,'Memoria RAM'),(23,'Ballistix Black','Crucial',48.94,40,'Memoria RAM'),(24,'Ballistix Red','Crucial',93.94,35,'Memoria RAM'),(25,'Fury Black','HyperX',30.95,25,'Memoria RAM'),(26,'Predator','HyperX',184.95,20,'Memoria RAM'),(27,'Elite','TeamGroup',155.94,15,'Memoria RAM'),(28,'Delta White RGB','TeamGroup',109.95,30,'Memoria RAM'),(29,'XPG Spectrix','Adata',100.95,20,'Memoria RAM'),(30,'Dominator Platinum','Corsair',139.95,50,'Memoria RAM'),(31,'Ripjaws 4','G.Skill',91.95,32,'Memoria RAM'),(32,'XLR8 Gaming','PNY',51.95,15,'Memoria RAM'),(33,'IRDM Blue','Goodram',26.95,10,'Memoria RAM'),(34,'Dark Z Red','TeamGroup',101.95,25,'Memoria RAM'),(35,'Trindet Z','G.Skill',198.95,20,'Memoria RAM'),(36,'Sniper X Urban','G.Skill',202.95,20,'Memoria RAM'),(37,'Anarchy-X','PNY',98.95,37,'Memoria RAM'),(38,'Sniper X Digital','G.Skill',187.95,20,'Memoria RAM'),(39,'Value Select','Corsair',62.94,23,'Memoria RAM'),(40,'Ripjaws V','G.Skill',155.94,45,'Memoria RAM'),(41,'XMS3 Series','Corsair',27.95,5,'Memoria RAM'),(42,'X470 Gaming Plus','MSI',94.95,16,'Placa base'),(43,'Z490-A Pro','MSI',159.9,12,'Placa base'),(44,'MPG Z490 Gaming Plus','MSI',176.9,8,'Placa base'),(45,'A320M-A PRO','MSI',47.02,20,'Placa base'),(46,'X570 Aorus Elite','Gigabyte',194.96,36,'Placa base'),(47,'B550M DS3H','Gigabyte',85.95,11,'Placa base'),(48,'B450 Aorus Elite V2','Gigabyte',89.99,36,'Placa base'),(49,'B450 Gaming X','Gigabyte',84.5,29,'Placa base'),(50,'PRIME H410M-D','Asus',85.64,24,'Placa base'),(51,'TUF Z490-PLUS','Asus',189.9,42,'Placa base'),(52,'ROG Strix X570-E','Asus',309.91,17,'Placa base'),(53,'PRIME X570-PRO','Asus',252.95,17,'Placa base'),(54,'H470M-HVS','Asrock',75.55,21,'Placa base'),(55,'H110 PRO BTC+','Asrock',216.46,11,'Placa base'),(56,'B450 Steel Legend','Asrock',92.95,36,'Placa base'),(57,'B460M Pro4','Asrock',99.99,28,'Placa base'),(58,'B450 Tomahawk MAX II','MSI',114.9,12,'Placa base'),(59,'N7 Z490','NZXT',229.12,49,'Placa base'),(60,'N7 Z390','NZXT',336.77,39,'Placa base'),(61,'H81MHV3','Biostar',65.5,38,'Placa base'),(62,'A320MH','Biostar',42.67,10,'Placa base'),(63,'1030 Aero','MSI',89.99,34,'Tarjeta gráfica'),(64,'RX5600 XT MECH','MSI',314.9,45,'Tarjeta gráfica'),(65,'GTX1660 Super Gaming X','MSI',479.9,38,'Tarjeta gráfica'),(66,'RTX3070 SUPRIM','Gigabyte',1099.9,11,'Tarjeta gráfica'),(67,'GT710','Gigabyte',59.99,29,'Tarjeta gráfica'),(68,'RX6800 XT Gaming OC','Gigabyte',1499,14,'Tarjeta gráfica'),(69,'GTX1650 Phoenix','Asus',428.38,5,'Tarjeta gráfica'),(70,'R7 240','Asus',74.95,45,'Tarjeta gráfica'),(71,'GTX 1650 TUF Gaming','Asus',499.99,47,'Tarjeta gráfica'),(72,'RTX2060 XC Gaming','EVGA',701.19,32,'Tarjeta gráfica'),(73,'RX6700 XT Dual','Asus',1561.83,22,'Tarjeta gráfica'),(74,'GTX1650 D6 VENTUS','MSI',199.9,33,'Tarjeta gráfica'),(75,'Quadro P2200','PNY',456.9,22,'Tarjeta gráfica'),(76,'RTX3090 XLR8 Revel Epic-x','PNY',2799.9,46,'Tarjeta gráfica'),(77,'Tesla A40','PNY',7171.98,1,'Tarjeta gráfica'),(78,'RTX3090 Trinity OC','Zotac',2499.9,24,'Tarjeta gráfica'),(79,'GTX1660 Twin Fan','Zotac',479.9,12,'Tarjeta gráfica'),(80,'RTX3090 AMP Corre HOLO','Zotac',2699.9,8,'Tarjeta gráfica'),(81,'RX6700 XT Red Devil','PowerColor',979.89,38,'Tarjeta gráfica'),(82,'RX6700 XR Helhound','PowerColor',959.91,43,'Tarjeta gráfica'),(83,'RX6900 XT MERC 319','XFX',1799.9,23,'Tarjeta gráfica'),(84,'Barracuda 1TB','Seagate',36.99,40,'Disco Duro'),(85,'IronWolf NAS 4TB','Seagate',118,33,'Disco Duro'),(86,'Expansion 4TB','Seagate',109.99,9,'Disco Duro'),(87,'Basic 1TB','Seagate',44.39,49,'Disco Duro'),(88,'RED Plus 8TB','Wester Digital',249.99,39,'Disco Duro'),(89,'BLUE 1TB','Wester Digital',40,48,'Disco Duro'),(90,'PURPLE 6TB','Wester Digital',196,24,'Disco Duro'),(91,'BLACK P10 5TB','Wester Digital',129,12,'Disco Duro'),(92,'N300 NAS 6TB','Toshiba',174.59,23,'Disco Duro'),(93,'P300 3TB','Toshiba',72.01,20,'Disco Duro'),(94,'A400 240GB','Kingston',29.5,45,'Disco Duro'),(95,'A400 480GB','Kingston',43.8,20,'Disco Duro'),(96,'870 EVO 1TB','Samsung',121.99,29,'Disco Duro'),(97,'860 EVO 250GB','Samsung',45.99,5,'Disco Duro'),(98,'SU630 960GB','Adata',103.21,42,'Disco Duro'),(99,'SU800 1TB','Adata',144.53,14,'Disco Duro'),(100,'Blue SN550 1TB','Wester Digital',113.59,13,'Disco Duro'),(101,'Black SN750 1TB','Wester Digital',169.99,18,'Disco Duro'),(102,'P2 500GB','Crucial',55.6,19,'Disco Duro'),(103,'MX500 500GB','Crucial',67,25,'Disco Duro'),(104,'BX500','Crucial',33.96,6,'Disco Duro'),(105,'CV550 CV Series','Corsair',39.98,22,'Fuente de alimentación'),(106,'TX850M','Corsair',124.9,50,'Fuente de alimentación'),(107,'RM850x','Corsair',129,48,'Fuente de alimentación'),(108,'RM750X V2','Corsair',136.16,49,'Fuente de alimentación'),(109,'W1 600W','EVGA',49.99,29,'Fuente de alimentación'),(110,'W2 600W','EVGA',33.98,45,'Fuente de alimentación'),(111,'BR 500W','EVGA',48,13,'Fuente de alimentación'),(112,'Supernova 550 GT','EVGA',103,26,'Fuente de alimentación'),(113,'Urano VX 650W','NOX',54.52,8,'Fuente de alimentación'),(114,'Hummer GD750','NOX',91.5,28,'Fuente de alimentación'),(115,'Core GC 500','Seasonic',62.99,19,'Fuente de alimentación'),(116,'Seasonic S12III-550','Seasonic',69.99,6,'Fuente de alimentación'),(117,'Core GM-650','Seasonic',99.99,33,'Fuente de alimentación'),(118,'P750GM','Gigabyte',88.33,5,'Fuente de alimentación'),(119,'MWE White V2','Cooler Master',56.02,16,'Fuente de alimentación'),(120,'C750','NZXT',114.89,39,'Fuente de alimentación'),(121,'Rog Strix 1000G','Asus',235,27,'Fuente de alimentación'),(122,'Lux 750','Aerocool',51.99,29,'Fuente de alimentación'),(123,'MPG A850GF','MSI',149.99,16,'Fuente de alimentación'),(124,'Hummer Alpha','NOX',39.75,39,'Fuente de alimentación'),(125,'MasterWatt 750','Cooler Master',84.98,30,'Fuente de alimentación');
/*!40000 ALTER TABLE `componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenidoped`
--

DROP TABLE IF EXISTS `contenidoped`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contenidoped` (
  `IDPed` int unsigned NOT NULL AUTO_INCREMENT,
  `IDC` int unsigned NOT NULL,
  `Cantidad` int unsigned NOT NULL,
  PRIMARY KEY (`IDPed`,`IDC`),
  KEY `idx_idc` (`IDC`) /*!80000 INVISIBLE */,
  KEY `idx_idped` (`IDPed`),
  CONSTRAINT `fk_idcPed` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`),
  CONSTRAINT `fk_idpedCont` FOREIGN KEY (`IDPed`) REFERENCES `pedidos` (`IDPed`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenidoped`
--

LOCK TABLES `contenidoped` WRITE;
/*!40000 ALTER TABLE `contenidoped` DISABLE KEYS */;
INSERT INTO `contenidoped` VALUES (1,1,2),(1,58,2),(1,71,1),(1,115,1),(2,11,1),(2,41,3),(3,102,3),(4,3,1),(4,25,4),(4,59,1),(4,66,2),(4,100,2),(4,117,1),(5,21,1),(6,21,1),(6,94,2);
/*!40000 ALTER TABLE `contenidoped` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discoduro`
--

DROP TABLE IF EXISTS `discoduro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discoduro` (
  `IDC` int unsigned NOT NULL AUTO_INCREMENT,
  `Tipo` enum('SSD','HDD','SSHD') CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `Capacidad` int unsigned NOT NULL,
  PRIMARY KEY (`IDC`),
  KEY `idx_idc` (`IDC`),
  CONSTRAINT `fk_idcD` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discoduro`
--

LOCK TABLES `discoduro` WRITE;
/*!40000 ALTER TABLE `discoduro` DISABLE KEYS */;
INSERT INTO `discoduro` VALUES (84,'HDD',1),(85,'HDD',4),(86,'HDD',4),(87,'HDD',1),(88,'HDD',8),(89,'HDD',1),(90,'HDD',6),(91,'HDD',5),(92,'HDD',6),(93,'HDD',3),(94,'SSD',240),(95,'SSD',480),(96,'SSD',1),(97,'SSD',250),(98,'SSD',960),(99,'SSD',1),(100,'SSD',1),(101,'SSD',1),(102,'SSD',500),(103,'SSD',500),(104,'SSD',500);
/*!40000 ALTER TABLE `discoduro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entregacomponentes`
--

DROP TABLE IF EXISTS `entregacomponentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entregacomponentes` (
  `IDC` int unsigned NOT NULL,
  `IDP` int unsigned NOT NULL,
  PRIMARY KEY (`IDC`,`IDP`),
  KEY `idx_idc` (`IDC`) /*!80000 INVISIBLE */,
  KEY `idx_idp` (`IDP`),
  CONSTRAINT `fk_idc` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_idp` FOREIGN KEY (`IDP`) REFERENCES `proveedores` (`IDP`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entregacomponentes`
--

LOCK TABLES `entregacomponentes` WRITE;
/*!40000 ALTER TABLE `entregacomponentes` DISABLE KEYS */;
INSERT INTO `entregacomponentes` VALUES (5,1),(8,1),(10,1),(11,1),(19,1),(21,1),(30,1),(31,1),(44,1),(46,1),(51,1),(53,1),(62,1),(66,1),(69,1),(70,1),(91,1),(93,1),(108,1),(113,1),(114,1),(116,1),(123,1),(1,2),(12,2),(14,2),(20,2),(28,2),(33,2),(41,2),(48,2),(56,2),(57,2),(58,2),(63,2),(64,2),(72,2),(73,2),(75,2),(81,2),(84,2),(89,2),(95,2),(101,2),(105,2),(111,2),(115,2),(3,3),(4,3),(18,3),(22,3),(23,3),(24,3),(26,3),(27,3),(35,3),(37,3),(52,3),(61,3),(68,3),(71,3),(77,3),(80,3),(87,3),(96,3),(97,3),(103,3),(117,3),(118,3),(120,3),(6,4),(9,4),(16,4),(17,4),(25,4),(38,4),(39,4),(42,4),(45,4),(55,4),(59,4),(74,4),(76,4),(79,4),(82,4),(92,4),(98,4),(100,4),(104,4),(112,4),(121,4),(125,4),(2,5),(7,5),(13,5),(15,5),(29,5),(32,5),(34,5),(36,5),(40,5),(43,5),(47,5),(49,5),(50,5),(54,5),(60,5),(65,5),(67,5),(78,5),(83,5),(85,5),(86,5),(88,5),(90,5),(94,5),(99,5),(102,5),(106,5),(107,5),(109,5),(110,5),(119,5),(122,5),(124,5);
/*!40000 ALTER TABLE `entregacomponentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuentes`
--

DROP TABLE IF EXISTS `fuentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fuentes` (
  `IDC` int unsigned NOT NULL AUTO_INCREMENT,
  `Potencia` int unsigned NOT NULL,
  `Certificado` enum('80+ Bronze','80+ Silver','80+ Gold','80+ Platinum') CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDC`),
  KEY `idx_idc` (`IDC`),
  CONSTRAINT `fk_idcF` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuentes`
--

LOCK TABLES `fuentes` WRITE;
/*!40000 ALTER TABLE `fuentes` DISABLE KEYS */;
INSERT INTO `fuentes` VALUES (105,550,'80+ Bronze'),(106,850,'80+ Gold'),(107,850,'80+ Gold'),(108,750,'80+ Gold'),(109,600,'80+ Bronze'),(110,600,'80+ Bronze'),(111,500,'80+ Bronze'),(112,550,'80+ Gold'),(113,650,'80+ Bronze'),(114,750,'80+ Gold'),(115,500,'80+ Gold'),(116,550,'80+ Bronze'),(117,650,'80+ Gold'),(118,750,'80+ Gold'),(119,700,'80+ Bronze'),(120,750,'80+ Gold'),(121,1000,'80+ Gold'),(122,750,'80+ Bronze'),(123,850,'80+ Gold'),(124,500,'80+ Bronze'),(125,750,'80+ Bronze');
/*!40000 ALTER TABLE `fuentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `IDPed` int unsigned NOT NULL AUTO_INCREMENT,
  `PTotal` float unsigned DEFAULT NULL,
  `DNI` varchar(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDPed`,`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,1244.59,'11588995P'),(2,282.8,'74101877V'),(3,166.8,'77805486M'),(4,3198.94,'96265072K'),(5,69.95,'72696876V'),(6,128.95,'98683981C');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `placabase`
--

DROP TABLE IF EXISTS `placabase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `placabase` (
  `IDC` int unsigned NOT NULL AUTO_INCREMENT,
  `Socket` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `Chipset` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDC`),
  KEY `idx_idc` (`IDC`),
  CONSTRAINT `fk_idcPB` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `placabase`
--

LOCK TABLES `placabase` WRITE;
/*!40000 ALTER TABLE `placabase` DISABLE KEYS */;
INSERT INTO `placabase` VALUES (42,'AM4','X470'),(43,'1200','Z490'),(44,'1200','Z490'),(45,'AM4','A320'),(46,'AM4','X570'),(47,'AM4','B550'),(48,'AM4','B450'),(49,'AM4','B450'),(50,'1200','H410'),(51,'1200','Z490'),(52,'AM4','X570'),(53,'AM4','X570'),(54,'1200','H470'),(55,'1155','H110'),(56,'AM4','B450'),(57,'1200','B460'),(58,'AM4','B450'),(59,'1200','Z490'),(60,'1155','Z390'),(61,'1150','h81'),(62,'AM4','A320');
/*!40000 ALTER TABLE `placabase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procesador`
--

DROP TABLE IF EXISTS `procesador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `procesador` (
  `IDC` int unsigned NOT NULL AUTO_INCREMENT,
  `Nucleos` int unsigned NOT NULL,
  `ConsumoP` int unsigned NOT NULL,
  PRIMARY KEY (`IDC`),
  KEY `idx_idc` (`IDC`),
  CONSTRAINT `fk_idcP` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procesador`
--

LOCK TABLES `procesador` WRITE;
/*!40000 ALTER TABLE `procesador` DISABLE KEYS */;
INSERT INTO `procesador` VALUES (1,6,150),(2,4,75),(3,8,190),(4,6,165),(5,2,70),(6,6,160),(7,8,235),(8,2,70),(9,4,78),(10,4,176),(11,6,140),(12,6,145),(13,12,210),(14,6,155),(15,8,186),(16,4,76),(17,2,55),(18,5,143),(19,24,420),(20,64,560);
/*!40000 ALTER TABLE `procesador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `IDP` int unsigned NOT NULL AUTO_INCREMENT,
  `NombreP` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `Tlfo` varchar(12) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `Direccion` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`IDP`),
  UNIQUE KEY `NombreP_UNIQUE` (`NombreP`),
  UNIQUE KEY `Tlfo_UNIQUE` (`Tlfo`),
  UNIQUE KEY `Direccion_UNIQUE` (`Direccion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Componentes S.L','947101946','Calle Sepulveda 5'),(2,'Dynos Informatica','941722491','Calle Huesca 8'),(3,'Megasur','956661904','Avenida de los Andes 20'),(4,'SoloStocks','986730456','Calle San Andres 24'),(5,'TekPoint','924057339','Calle Valladolid 5');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ram`
--

DROP TABLE IF EXISTS `ram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ram` (
  `IDC` int unsigned NOT NULL AUTO_INCREMENT,
  `Velocidad` int unsigned NOT NULL,
  `Capacidad` int unsigned NOT NULL,
  PRIMARY KEY (`IDC`),
  KEY `idx_idc` (`IDC`),
  CONSTRAINT `fk_idcR` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ram`
--

LOCK TABLES `ram` WRITE;
/*!40000 ALTER TABLE `ram` DISABLE KEYS */;
INSERT INTO `ram` VALUES (21,3200,8),(22,3200,16),(23,2400,8),(24,2400,16),(25,2400,4),(26,3200,32),(27,3600,16),(28,3200,16),(29,3200,16),(30,3200,16),(31,2400,16),(32,3200,8),(33,2133,4),(34,2400,16),(35,3200,32),(36,3600,32),(37,3200,16),(38,3200,16),(39,2400,8),(40,3200,16),(41,2133,4);
/*!40000 ALTER TABLE `ram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjetagrafica`
--

DROP TABLE IF EXISTS `tarjetagrafica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetagrafica` (
  `IDC` int unsigned NOT NULL AUTO_INCREMENT,
  `VRAM` int unsigned NOT NULL,
  `Consumo` int unsigned NOT NULL,
  PRIMARY KEY (`IDC`),
  KEY `idx_idc` (`IDC`),
  CONSTRAINT `fk_idcTG` FOREIGN KEY (`IDC`) REFERENCES `componentes` (`IDC`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetagrafica`
--

LOCK TABLES `tarjetagrafica` WRITE;
/*!40000 ALTER TABLE `tarjetagrafica` DISABLE KEYS */;
INSERT INTO `tarjetagrafica` VALUES (63,2,30),(64,6,150),(65,6,75),(66,8,220),(67,2,19),(68,16,350),(69,4,75),(70,2,30),(71,4,75),(72,6,175),(73,12,238),(74,4,75),(75,5,75),(76,24,350),(77,48,300),(78,24,350),(79,6,125),(80,24,350),(81,12,230),(82,12,235),(83,16,300);
/*!40000 ALTER TABLE `tarjetagrafica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tiendainformatica'
--
/*!50003 DROP FUNCTION IF EXISTS `pedidosCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `pedidosCliente`(NDni varchar(9)) RETURNS int
    DETERMINISTIC
BEGIN
	Declare cantidad int;
	if exists(Select * from clientes where dni=NDni) then
		Select count(IDPed) into cantidad from pedidos where DNI=NDni;
	else 
		Set cantidad=-1;
	end if;
RETURN cantidad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertarCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarCliente`(NDni varchar(9),nombre varchar(45),domicilio varchar(45))
BEGIN
	declare exit handler for 1062
	begin
		Select concat("El cliente ya está en la base de datos") AS Error;
	end;
   	Insert into clientes values(NDni, nombre, domicilio);
Select concat("El cliente ha sido agregado a la base de datos") AS Mensaje;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarPrecioPorTipo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarPrecioPorTipo`(tipoComponente varchar(20), porcentaje float)
BEGIN
	if exists(Select * from componentes where tipo=tipoComponente) then
		if porcentaje>=0 and porcentaje<=100 then
			update componentes set precio=precio+(precio*(porcentaje/100)) where tipo=tipoComponente;
		else 
			Select concat("El porcentaje indicado no es correcto") as Error;
		end if;
	else 
		Select concat("Esa tipo de componente no existe") as Error;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `modificarPrecioSegunCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `modificarPrecioSegunCategoria`()
BEGIN
	Declare fin bool default 0;
    Declare id int;
    Declare categoria varchar(30);
	Declare c cursor for Select idc,tipo from componentes;
    Declare continue handler for not found set fin=1;
    open c;
    fetch c into id, categoria;
    while fin=0 do
			case categoria
				when "Procesador" then update componentes set precio=precio-(precio*0.20) where idc=id;
				when "Tarjeta gráfica" then update componentes set precio=precio-(precio*0.05) where idc=id;
				when "Placa base" then update componentes set precio=precio+(precio*0.10) where idc=id;
				when "Memoria RAM" then update componentes set precio=precio-(precio*0.25) where idc=id;
				when "Disco Duro" then update componentes set precio=precio+(precio*0.01) where idc=id;
				when "Fuente de alimentación" then update componentes set precio=precio-(precio*0.20) where idc=id;
			end case;
			fetch c into id, categoria;
	end while;
	close c;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrarPedidoConDescuento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarPedidoConDescuento`(NDni varchar(9), total float)
BEGIN
	Declare cantidad int;
    	Declare descuento float;
	if exists(Select * from clientes where dni=NDni) then
		if total>0 then
			Select count(IDPed) into cantidad from pedidos where DNI=NDni;
			if cantidad>=2 and cantidad<5 then 
				Set descuento=0.02;
			elseif cantidad>=5 and cantidad<10 then
				Set descuento=0.05;
			elseif cantidad>=10 then
				Set descuento=0.1;
			end if;
			insert into pedidos (PTotal, DNI) values ((total-(total*descuento)), NDni);
		else 
			Select concat("El total debe ser mayor a 0");
		end if;
	else 
		Select concat("El cliente no existe");
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-05 16:13:01
