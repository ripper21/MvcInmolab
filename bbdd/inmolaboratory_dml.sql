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


INSERT INTO cliente (nombre, apellido, direccion, correo, telefono, fech_nac, nif, tipo_cliente) VALUES
('Juan', 'Pérez', 'Calle 123', 'juan.perez@example.com', 1234567890, '1990-01-01', 'X1234567A', 1),
('Ana', 'García', 'Avenida Siempreviva 742', 'ana.garcia@example.com', 1234567891, '1985-02-02', 'Y2345678B', 2),
('Luis', 'Martínez', 'Boulevard de los Sueños Rotos 10', 'luis.martinez@example.com', 1234567892, '1978-03-03', 'Z3456789C', 3),
('María', 'López', 'Calle Falsa 123', 'maria.lopez@example.com', 1234567893, '1982-04-04', 'A4567890D', 1),
('Carlos', 'Sánchez', 'Avenida Libertad 55', 'carlos.sanchez@example.com', 1234567894, '1991-05-05', 'B5678901E', 2),
('Laura', 'Fernández', 'Calle Mayor 1', 'laura.fernandez@example.com', 1234567895, '1983-06-06', 'C6789012F', 3),
('Jorge', 'Gómez', 'Avenida de la Constitución 78', 'jorge.gomez@example.com', 1234567896, '1979-07-07', 'D7890123G', 1),
('Sofía', 'Morales', 'Calle del Prado 11', 'sofia.morales@example.com', 1234567897, '1992-08-08', 'E8901234H', 2),
('Miguel', 'Hernández', 'Paseo de la Castellana 101', 'miguel.hernandez@example.com', 1234567898, '1986-09-09', 'F9012345I', 3),
('Lucía', 'Díaz', 'Callejón del Beso 3', 'lucia.diaz@example.com', 1234567899, '1993-10-10', 'G0123456J', 1),
('David', 'Ruiz', 'Avenida América 56', 'david.ruiz@example.com', 1234567800, '1981-11-11', 'H1234567K', 2),
('Isabel', 'Torres', 'Callejón del Gato 13', 'isabel.torres@example.com', 1234567801, '1987-12-12', 'I2345678L', 3),
('Fernando', 'Ramírez', 'Plaza Mayor 6', 'fernando.ramirez@example.com', 1234567802, '1990-01-13', 'J3456789M', 1),
('Patricia', 'Flores', 'Avenida del Mar 21', 'patricia.flores@example.com', 1234567803, '1984-02-14', 'K4567890N', 2),
('Sergio', 'Jiménez', 'Calle de la Luna 7', 'sergio.jimenez@example.com', 1234567804, '1989-03-15', 'L5678901O', 3),
('Marta', 'Ortega', 'Paseo del Río 9', 'marta.ortega@example.com', 1234567805, '1994-04-16', 'M6789012P', 1),
('Álvaro', 'Navarro', 'Avenida del Sol 12', 'alvaro.navarro@example.com', 1234567806, '1980-05-17', 'N7890123Q', 2),
('Elena', 'Castro', 'Calle del Olmo 18', 'elena.castro@example.com', 1234567807, '1991-06-18', 'O8901234R', 3),
('Andrés', 'Vega', 'Avenida de los Pinos 23', 'andres.vega@example.com', 1234567808, '1983-07-19', 'P9012345S', 1),
('Clara', 'Molina', 'Calle del Sauce 24', 'clara.molina@example.com', 1234567809, '1992-08-20', 'Q0123456T', 2);

INSERT INTO caracteristicas_de_la_propiedad (nombre) VALUES
('Planta'),
('Metros Usables'),
('Metros de construcción'),
('Año de construcción'),
('Salón'),
('Cocina'),
('Baños'),
('Habitaciones'),
('Garajes'),
('Oficina'),
('Área de servicio'),
('Patios'),
('Muebles'),
('ConsumoKW'),
('EmisionCO2');

INSERT INTO empleados (nombre, apellido, telefono, fechNac, correo, nif, ssNum) VALUES
('Juan', 'Pérez', 1234567890, '1980-05-15', 'juan.perez@example.com', '12345678P', 987654321),
('Laura', 'García', 2345678901, '1985-08-25', 'laura.garcia@example.com', '87654321L', 876543210),
('Carlos', 'Martínez', 3456789012, '1990-01-30', 'carlos.martinez@example.com', '76543210C', 765432109),
('Elena', 'Nito', 4567890123, '1975-12-10', 'elena.nito@example.com', '65432109E', 654321098),
('Marcos', 'Gómez', 5678901234, '1982-07-24', 'marcos.gomez@example.com', '54321098M', 543210987),
('Ana', 'López', 6789012345, '1992-11-19', 'ana.lopez@example.com', '43210987A', 432109876),
('David', 'Jiménez', 7890123456, '1978-02-17', 'david.jimenez@example.com', '32109876D', 321098765),
('Sara', 'Morales', 8901234567, '1989-09-09', 'sara.morales@example.com', '21098765S', 210987654),
('Oscar', 'Ruiz', 9012345678, '1995-03-28', 'oscar.ruiz@example.com', '10987654O', 109876543),
('Marta', 'Hernández', 1234567890, '1986-06-18', 'marta.hernandez@example.com', '09876543M', 987654321);

INSERT INTO propiedades (fech_captacion, cod_postal, calle, num_calle, id_empleado, planta, portal)
VALUES 
('2023-06-01', 28013, 'Gran Via', '42', 1, 1, 'A'),
('2023-06-02', 28014, 'Calle Mayor', '85', 2, 2, 'B'),
('2023-06-03', 28015, 'Paseo del Prado', '59', 3, 3, 'C'),
('2023-06-04', 28016, 'Calle de Alcalá', '134', 4, 4, 'D'),
('2023-06-05', 28017, 'Avenida de América', '21', 5, 5, 'E'),
('2023-06-06', 28018, 'Calle de Serrano', '3', 6, 6, 'F'),
('2023-06-07', 28019, 'Calle de Bravo Murillo', '291', 7, 7, 'G'),
('2023-06-08', 28020, 'Calle de Fuencarral', '47', 8, 8, 'H'),
('2023-06-09', 28021, 'Calle de Goya', '9', 9, 1, 'I'),
('2023-06-10', 28022, 'Calle de Atocha', '125', 10, 2, 'J');


-- Suponiendo que la primera propiedad tiene dos baños, tres habitaciones y un garaje
INSERT INTO propiedades_caracteristicas (id_propiedad, id_caracteristica, cantidad) VALUES
(1, 7, 2), -- Baños
(1, 8, 3), -- Habitaciones
(1, 9, 1); -- Garaje

-- La segunda propiedad tiene cocina, patio y muebles
INSERT INTO propiedades_caracteristicas (id_propiedad, id_caracteristica, cantidad) VALUES
(2, 6, 1), -- Cocina
(2, 12, 1), -- Patio
(2, 13, 5); -- Muebles

-- La tercera propiedad tiene oficina y área de servicio
INSERT INTO propiedades_caracteristicas (id_propiedad, id_caracteristica, cantidad) VALUES
(3, 10, 1), -- Oficina
(3, 11, 1); -- Área de servicio

-- Confirma que puedes obtener una propiedad y sus caracteristicas 
SELECT 
    p.calle,
    p.num_calle,
    p.planta,
    p.portal,
    cp.nombre AS Caracteristica,
    pc.cantidad AS Cantidad
FROM 
    propiedades p
JOIN 
    propiedades_caracteristicas pc ON p.id_propiedad = pc.id_propiedad
JOIN 
    caracteristicas_de_la_propiedad cp ON pc.id_caracteristica = cp.id_caracteristica
WHERE 
    p.calle = 'Gran Vía' AND 
    p.num_calle = '42' AND 
    p.planta = 2 AND 
    p.portal = 'A'
ORDER BY 
    p.calle, p.num_calle, p.planta, p.portal, cp.nombre;
    
    -- Inserciones en la tabla tipo_contrato
INSERT INTO tipo_contrato (nombre) VALUES ('Alquiler');
INSERT INTO tipo_contrato (nombre) VALUES ('Venta');
INSERT INTO tipo_contrato (nombre) VALUES ('Arrendamiento');
INSERT INTO tipo_contrato (nombre) VALUES ('Arras');
INSERT INTO tipo_contrato (nombre) VALUES ('Prestación de Servicios');
-- Inserciones en la tabla contrato
INSERT INTO contrato (fech_creacion, fech_entrada, fech_salida, precio_neto, id_tipo_operacion, documento) VALUES 
('2024-01-01 12:00:00', '2024-02-01 12:00:00', '2024-12-01 12:00:00', 1200.00, 1, NULL),
('2024-02-01 13:00:00', '2024-03-01 13:00:00', '2024-11-01 13:00:00', 1500.00, 2, NULL),
('2024-03-01 14:00:00', '2024-04-01 14:00:00', '2024-10-01 14:00:00', 1100.00, 3, NULL),
('2024-04-01 15:00:00', '2024-05-01 15:00:00', '2024-09-01 15:00:00', 1300.00, 4, NULL),
('2024-05-01 16:00:00', '2024-06-01 16:00:00', '2024-08-01 16:00:00', 1400.00, 5, NULL),
('2024-06-01 17:00:00', '2024-07-01 17:00:00', '2024-07-01 17:00:00', 1600.00, 1, NULL),
('2024-07-01 18:00:00', '2024-08-01 18:00:00', '2024-06-01 18:00:00', 1700.00, 2, NULL),
('2024-08-01 19:00:00', '2024-09-01 19:00:00', '2024-05-01 19:00:00', 1800.00, 3, NULL),
('2024-09-01 20:00:00', '2024-10-01 20:00:00', '2024-04-01 20:00:00', 1900.00, 4, NULL),
('2024-10-01 21:00:00', '2024-11-01 21:00:00', '2024-03-01 21:00:00', 2000.00, 5, NULL);





