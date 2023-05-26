-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: centroeducativo
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellido1` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellido2` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `fNacimiento` date DEFAULT NULL,
  `telefono` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `direccion` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `cp` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `poblacion` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `provincia` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (4,'77992708T','Paco','Ruiz','Hernandez','2002-08-08','666555444','paco@gmail.com','C/ plaza 6','18240','Pinos Puente','Granada'),(8,'12345678G','Juan','Gomez','Gomez','2002-06-02','666555999','juanillo@gmail.com','plaza moco','18230','Atarfe','Granada'),(9,'87654321T','Antonio','Lopez','Foche','2000-10-12','555666743','antonio@gmail.com','Calle 2','18230','Granada','Atarfe'),(10,'97865432T','Ana','Flores','Diaz','1995-09-27','685321546','maria@gmail.com','plaza 7','18230','Granada','Atarfe'),(11,'55342213J','Margarita','Perez ','Chinchilla','1995-04-05','673445661','margap95@gmail.com','c ave del paraiso','33231','Madrid','Madrid'),(12,'44659984R','Francisca','Sánchez','Andiz','1985-02-09','655478900','paquitasan855@gmail.com','c plaza 2','33214','Sevilla','Sevilla'),(13,'43325678H','Antonio ','Recio','Matamoros','1976-03-06','679666547','mayoristanolimpio944@gmail.com','ave del paraiso 7','44345','Madrid','Madrid'),(14,'33366623T','Omar','Moreno','Alvarez','1995-04-20','666777999','omar@gmail.com','Calle Puertas 2','18240','Granada','Pinos Puente');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `descripcion` varchar(80) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,'1º ASIR','Aula de CFGS'),(2,'2º ASIR','Aula de CFGS'),(4,'1º SMR','Aula de CFGM'),(5,'2º SMR','Aula de CFGM'),(6,'1º DAW','Aula de CFGS'),(7,'2º DAW','Aula de CFGS'),(8,'1º ESO','Aula de ESO');
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorizaciones`
--

DROP TABLE IF EXISTS `autorizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autorizaciones` (
  `idalumno` int NOT NULL,
  `idautorizado` int NOT NULL,
  PRIMARY KEY (`idalumno`,`idautorizado`),
  KEY `fk_autorizaciones_autorizado_idx` (`idautorizado`),
  CONSTRAINT `fk_autorizaciones_alumno` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_autorizaciones_autorizado` FOREIGN KEY (`idautorizado`) REFERENCES `autorizado` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorizaciones`
--

LOCK TABLES `autorizaciones` WRITE;
/*!40000 ALTER TABLE `autorizaciones` DISABLE KEYS */;
INSERT INTO `autorizaciones` VALUES (11,2),(8,3),(9,3),(10,3),(13,3);
/*!40000 ALTER TABLE `autorizaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorizado`
--

DROP TABLE IF EXISTS `autorizado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autorizado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `apellido1` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `apellido2` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `parentesto` enum('TUTOR1','TUTOR2','OTROS') CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorizado`
--

LOCK TABLES `autorizado` WRITE;
/*!40000 ALTER TABLE `autorizado` DISABLE KEYS */;
INSERT INTO `autorizado` VALUES (1,'13579486T','Carlos','Santos','Sainz','TUTOR2'),(2,'13579246G','Sergio','Garrido','Arroyo','TUTOR2'),(3,'14532676X','Maria','Fernandez','Jimenez','TUTOR1');
/*!40000 ALTER TABLE `autorizado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `Observaciones` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `idcursoacademico` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_curso_cursoacademico_idx` (`idcursoacademico`),
  CONSTRAINT `fk_curso_cursoacademico` FOREIGN KEY (`idcursoacademico`) REFERENCES `cursoacademico` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'1º DAW','1º Desarrollo de Aplicaciones WEB','CFGS',1),(3,'2ºDAW','2º Desarrollo de Aplicaciones Web','CFGS',1),(4,'1º SMR','1º Sistemas Microinformaticos y Redes','FP',1),(5,'2º SMR','2º Sistemas Microinformaticos y Redes','FP',11),(6,'1º ASIR','1º Administracion de Sistemas Informaticos y Redes','CFGS',1),(7,'2º ASIR','2º Administracion de Sistemas Informaticos y Redes','CFGS',1),(8,'1º DAW','1º Desarrollo de Aplicaciones Web','CFGS',4),(9,'1º ESO','1º Enseñanza Secundaria Obligatoria','ESO',10);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursoacademico`
--

DROP TABLE IF EXISTS `cursoacademico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursoacademico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `yearinicio` int NOT NULL,
  `yearfin` int NOT NULL,
  `descripcion` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `yearinicio_UNIQUE` (`yearinicio`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursoacademico`
--

LOCK TABLES `cursoacademico` WRITE;
/*!40000 ALTER TABLE `cursoacademico` DISABLE KEYS */;
INSERT INTO `cursoacademico` VALUES (1,2022,2023,'Curso 22-23'),(4,2023,2024,'Curso 23-24'),(6,2030,2031,'Curso 30-31'),(10,2026,2027,'Curso 26-27'),(11,2028,2029,'Curso 28-29');
/*!40000 ALTER TABLE `cursoacademico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `idmatricula` int NOT NULL AUTO_INCREMENT,
  `idalumno` int DEFAULT NULL,
  `idunidad` int DEFAULT NULL,
  `descripcion` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `fMatricula` date DEFAULT NULL,
  `fBaja` date DEFAULT NULL,
  PRIMARY KEY (`idmatricula`),
  KEY `fk_matricula_alumno_idx` (`idalumno`),
  KEY `fk_matricula_unidad_idx` (`idunidad`),
  CONSTRAINT `fk_matricula_alumno` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_matricula_unidad` FOREIGN KEY (`idunidad`) REFERENCES `unidad` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,10,1,'1 DAW','2023-05-22',NULL),(5,4,1,'1 DAW','2023-05-25',NULL),(6,8,1,'1 DAW','2023-05-25','2023-05-26'),(7,14,1,'1 DAW','2023-05-25',NULL),(10,12,1,'1 DAW','2023-05-25',NULL),(11,13,1,'1 DAW','2023-05-25',NULL),(13,11,1,'1 DAW','2023-05-25','2023-05-26'),(14,11,8,'1 daw a','2023-05-26',NULL);
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `matriculaciones`
--

DROP TABLE IF EXISTS `matriculaciones`;
/*!50001 DROP VIEW IF EXISTS `matriculaciones`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `matriculaciones` AS SELECT 
 1 AS `idcursoacademico`,
 1 AS `yearinicio`,
 1 AS `yearfin`,
 1 AS `idcurso`,
 1 AS `codigocurso`,
 1 AS `idunidad`,
 1 AS `codigounidad`,
 1 AS `fmatricula`,
 1 AS `idalumno`,
 1 AS `dni`,
 1 AS `nombre`,
 1 AS `apellido1`,
 1 AS `apellido2`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `apellido1` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `apellido2` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `direccion` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `cp` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `poblacion` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `provincia` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `telefono` varchar(9) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `tipo` smallint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES (1,'111111111','Juan','Gómez','Gómez','Calle real 23','18220','Granada','Granada','681456721','juanillococunero@gmail.com',1),(2,'77553813K','Antonio María','Muñoz','Fernandez','Calle ratón 6','18240','Pinos Puente','Granada','671342123','antonio@gmail.com',1),(4,'22222222G','Paco','Sanchez','Molero','Calle cañada','18230','Atarfe','Granada','676767676','paco@gmail.com',1),(5,'33333333T','Pepe','Rufian','Perez','Calle trebol 4','18240','Pinos Puente','Granada','888999777','pepe@gmail.com',1);
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `Observaciones` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci DEFAULT NULL,
  `idcurso` int DEFAULT NULL,
  `idtutor` int DEFAULT NULL,
  `idaula` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_unidad_curso_idx` (`idcurso`),
  KEY `fk_unidad_personal_idx` (`idtutor`),
  KEY `fk_unidad_aula_idx` (`idaula`),
  CONSTRAINT `fk_unidad_aula` FOREIGN KEY (`idaula`) REFERENCES `aula` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_unidad_curso` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_unidad_personal` FOREIGN KEY (`idtutor`) REFERENCES `personal` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci COMMENT='1ºA\n1ºB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad`
--

LOCK TABLES `unidad` WRITE;
/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
INSERT INTO `unidad` VALUES (1,'1º DAW A','1 DAW A','1 DAW Mañana',9,5,8),(8,'1 daw','1 daw a','mañana',1,4,6);
/*!40000 ALTER TABLE `unidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  `password` varchar(40) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'sergio','sergio'),(2,'demo','1234'),(4,'raul','raul');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `matriculaciones`
--

/*!50001 DROP VIEW IF EXISTS `matriculaciones`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `matriculaciones` AS select `cursoacademico`.`id` AS `idcursoacademico`,`cursoacademico`.`yearinicio` AS `yearinicio`,`cursoacademico`.`yearfin` AS `yearfin`,`curso`.`id` AS `idcurso`,`curso`.`codigo` AS `codigocurso`,`unidad`.`id` AS `idunidad`,`unidad`.`codigo` AS `codigounidad`,`matricula`.`fMatricula` AS `fmatricula`,`alumno`.`id` AS `idalumno`,`alumno`.`dni` AS `dni`,`alumno`.`nombre` AS `nombre`,`alumno`.`apellido1` AS `apellido1`,`alumno`.`apellido2` AS `apellido2` from ((((`cursoacademico` left join `curso` on((`cursoacademico`.`id` = `curso`.`idcursoacademico`))) left join `unidad` on((`curso`.`id` = `unidad`.`idcurso`))) left join `matricula` on((`unidad`.`id` = `matricula`.`idunidad`))) left join `alumno` on((`matricula`.`idalumno` = `alumno`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-26 10:46:41
