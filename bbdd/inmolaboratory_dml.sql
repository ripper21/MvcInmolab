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
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin','ROLE_ADMIN'),('user1','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','$2y$04$dPiNvrHA/qzT0um0mIJxJeDK4oolZtXu18PAgQtksFDfeIVdrTLX6',1),('user1','$2y$04$Wa8i//c3zj7GFf3s.cGLluzIHd.6b..OGmPjYk1Jm7ABkov3Pqzai',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

USE inmolaboratory;

-- Inserciones para la tabla Departamentos
INSERT INTO Departamentos (nombre) VALUES ('Ventas');
INSERT INTO Departamentos (nombre) VALUES ('Marketing');
INSERT INTO Departamentos (nombre) VALUES ('Recursos Humanos');
INSERT INTO Departamentos (nombre) VALUES ('Finanzas');
INSERT INTO Departamentos (nombre) VALUES ('IT');
INSERT INTO Departamentos (nombre) VALUES ('Logística');
INSERT INTO Departamentos (nombre) VALUES ('Producción');
INSERT INTO Departamentos (nombre) VALUES ('Calidad');
INSERT INTO Departamentos (nombre) VALUES ('Compras');
INSERT INTO Departamentos (nombre) VALUES ('Investigación y Desarrollo');

-- Inserciones para la tabla Empleados
INSERT INTO Empleados (nombre, apellido, telefono, fech_nac, correo, nif, ss_num, id_departamento) VALUES
('Juan', 'Pérez', 600123456, '1985-01-15', 'juan.perez@example.com', '12345678A', '123456789012345', 1),
('Ana', 'García', 600234567, '1990-02-20', 'ana.garcia@example.com', '23456789B', '234567890123456', 2),
('Carlos', 'Rodríguez', 600345678, '1980-03-25', 'carlos.rodriguez@example.com', '34567890C', '345678901234567', 3),
('María', 'López', 600456789, '1992-04-30', 'maria.lopez@example.com', '45678901D', '456789012345678', 4),
('Pedro', 'Martínez', 600567890, '1988-05-15', 'pedro.martinez@example.com', '56789012E', '567890123456789', 5),
('Laura', 'González', 600678901, '1995-06-20', 'laura.gonzalez@example.com', '67890123F', '678901234567890', 6),
('David', 'Hernández', 600789012, '1983-07-25', 'david.hernandez@example.com', '78901234G', '789012345678901', 7),
('Sara', 'Fernández', 600890123, '1991-08-30', 'sara.fernandez@example.com', '89012345H', '890123456789012', 8),
('Luis', 'Sánchez', 600901234, '1986-09-15', 'luis.sanchez@example.com', '90123456I', '901234567890123', 9),
('Elena', 'Ramírez', 600012345, '1987-10-20', 'elena.ramirez@example.com', '01234567J', '123456789012345', 10),
('Elena', 'Ramírez', 600012345, '1987-10-20', 'elena.ramirez@example.com', '01234567J', '123456789012345', 10),
('Juan', 'Pérez', 600123456, '1985-01-15', 'juan.perez@example.com', '12345678A', '123456789012345', 1),
('Ana', 'García', 600234567, '1990-02-20', 'ana.garcia@example.com', '23456789B', '234567890123456', 2),
('Carlos', 'Rodríguez', 600345678, '1980-03-25', 'carlos.rodriguez@example.com', '34567890C', '345678901234567', 3),
('María', 'López', 600456789, '1992-04-30', 'maria.lopez@example.com', '45678901D', '456789012345678', 4),
('Pedro', 'Martínez', 600567890, '1988-05-15', 'pedro.martinez@example.com', '56789012E', '567890123456789', 5),
('Laura', 'González', 600678901, '1995-06-20', 'laura.gonzalez@example.com', '67890123F', '678901234567890', 6),
('David', 'Hernández', 600789012, '1983-07-25', 'david.hernandez@example.com', '78901234G', '789012345678901', 7),
('Sara', 'Fernández', 600890123, '1991-08-30', 'sara.fernandez@example.com', '89012345H', '890123456789012', 8),
('Luis', 'Sánchez', 600901234, '1986-09-15', 'luis.sanchez@example.com', '90123456I', '901234567890123', 9),
('Elena', 'Ramírez', 600012345, '1987-10-20', 'elena.ramirez@example.com', '01234567J', '123456789012345', 10),
('Pablo', 'Ortega', 601234567, '1984-11-10', 'pablo.ortega@example.com', '11234567K', '223456789012345', 10),
('Cristina', 'Ruiz', 602345678, '1993-12-22', 'cristina.ruiz@example.com', '22345678L', '334567890123456', 10),
('Miguel', 'Navarro', 603456789, '1979-01-18', 'miguel.navarro@example.com', '33456789M', '445678901234567', 10),
('Sandra', 'Molina', 604567890, '1996-02-28', 'sandra.molina@example.com', '44567890N', '556789012345678', 10),
('Javier', 'Suárez', 605678901, '1987-03-30', 'javier.suarez@example.com', '55678901O', '667890123456789', 10),
('Isabel', 'Romero', 606789012, '1982-04-15', 'isabel.romero@example.com', '66789012P', '778901234567890', 10),
('Alberto', 'Herrera', 607890123, '1991-05-21', 'alberto.herrera@example.com', '77890123Q', '889012345678901', 10),
('Marta', 'Lara', 608901234, '1994-06-25', 'marta.lara@example.com', '88901234R', '990123456789012', 10),
('Ricardo', 'Soto', 609012345, '1989-07-12', 'ricardo.soto@example.com', '99012345S', '101234567890123', 10),
('Patricia', 'Gil', 610123456, '1992-08-03', 'patricia.gil@example.com', '10123456T', '112345678901234', 10),
('Francisco', 'Iglesias', 611234567, '1983-09-16', 'francisco.iglesias@example.com', '11234567U', '123456789012345', 10),
('Rosa', 'Vargas', 612345678, '1995-10-29', 'rosa.vargas@example.com', '12345678V', '134567890123456', 10),
('Manuel', 'Marín', 613456789, '1986-11-11', 'manuel.marin@example.com', '13456789W', '145678901234567', 10),
('Carmen', 'Castro', 614567890, '1990-12-07', 'carmen.castro@example.com', '14567890X', '156789012345678', 10),
('Jose', 'Ramos', 615678901, '1978-01-09', 'jose.ramos@example.com', '15678901Y', '167890123456789', 10),
('Teresa', 'Reyes', 616789012, '1993-02-19', 'teresa.reyes@example.com', '16789012Z', '178901234567890', 10),
('Antonio', 'Giménez', 617890123, '1985-03-14', 'antonio.gimenez@example.com', '17890123A', '189012345678901', 10),
('Lucía', 'Santos', 618901234, '1997-04-18', 'lucia.santos@example.com', '18901234B', '190123456789012', 10),
('Felipe', 'Hidalgo', 619012345, '1991-05-27', 'felipe.hidalgo@example.com', '19012345C', '201234567890123', 10),
('Alicia', 'Cruz', 620123456, '1988-06-05', 'alicia.cruz@example.com', '20123456D', '212345678901234', 10),
('Jorge', 'Campos', 621234567, '1994-07-22', 'jorge.campos@example.com', '21234567E', '223456789012345', 10),
('Nuria', 'Aguilar', 622345678, '1989-08-31', 'nuria.aguilar@example.com', '22345678F', '234567890123456', 10),
('Raúl', 'Román', 623456789, '1982-09-10', 'raul.roman@example.com', '23456789G', '245678901234567', 10),
('Marina', 'Serrano', 624567890, '1996-10-12', 'marina.serrano@example.com', '24567890H', '256789012345678', 10),
('Hugo', 'Ortega', 625678901, '1987-11-14', 'hugo.ortega@example.com', '25678901I', '267890123456789', 10);

-- Inserciones para la tabla JefeDepartamento
INSERT INTO JefeDepartamento (id_departamento, id_empleado) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

