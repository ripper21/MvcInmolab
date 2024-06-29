CREATE DATABASE  IF NOT EXISTS `inmolaboratory` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `inmolaboratory`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: inmolaboratory
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;



-- Crear la tabla Departamentos
CREATE TABLE Departamentos (
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL
);

-- Crear la tabla Empleados
CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono BIGINT NOT NULL,
    fech_nac DATETIME,
    correo VARCHAR(100) NOT NULL,
    nif VARCHAR(50) NOT NULL,
    ss_num BIGINT,
    id_departamento INT,
    FOREIGN KEY (id_departamento) REFERENCES Departamentos(id_departamento)
);

-- Crear la tabla JefeDepartamento
CREATE TABLE JefeDepartamento (
    id_departamento INT,
    id_empleado INT,
    PRIMARY KEY (id_departamento, id_empleado),
    FOREIGN KEY (id_departamento) REFERENCES Departamentos(id_departamento),
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado)
);
-- Creación de la tabla 'tipo_cliente'
  CREATE TABLE tipo_cliente (
  id_registro INT (3) NOT NULL auto_increment ,
  descripcion VARCHAR(150) NOT NULL,
  PRIMARY KEY (id_registro)
);
-- Creación de la tabla 'cliente'
  CREATE TABLE cliente (
  id_cliente INT (3) NOT NULL auto_increment ,
  nombre VARCHAR (100) NOT NULL ,
  apellido VARCHAR (100)NOT NULL,
  direccion VARCHAR (250)NOT NULL,
  correo VARCHAR (100)NOT NULL,
  telefono int (11)NOT NULL,
  fech_nac DATE,
  nif VARCHAR (50) NOT NULL,
  tipo_cliente INT (3) NOT NULL,
  PRIMARY KEY (id_cliente),
  FOREIGN KEY (tipo_cliente) REFERENCES Empleados(id_registro)

);

-- Creación de la tabla 'propiedades'
CREATE TABLE propiedades (
    id_propiedad INT AUTO_INCREMENT PRIMARY KEY,
    fech_captacion DATE,
    cod_postal INT,
	num_calle VARCHAR(10),
    calle VARCHAR(255),
    planta INT(2),
    portal VARCHAR(5),
    id_empleado INT,  -- Asumiendo que tienes una tabla de empleados
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado)  -- Ajusta según tu diseño
);

-- Creación de la tabla 'caracteristicas_de_la_propiedad'
CREATE TABLE caracteristicas_de_la_propiedad (
    id_caracteristica INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Creación de la tabla de unión 'propiedades_caracteristicas' para la relación muchos a muchos
CREATE TABLE propiedades_caracteristicas (
    id_propiedad INT,
    id_caracteristica INT,
    cantidad INT DEFAULT 1,
    PRIMARY KEY (id_propiedad, id_caracteristica),
    FOREIGN KEY (id_propiedad) REFERENCES propiedades(id_propiedad),
    FOREIGN KEY (id_caracteristica) REFERENCES caracteristicas_de_la_propiedad(id_caracteristica)
);








