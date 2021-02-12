CREATE DATABASE  IF NOT EXISTS `IbmPrueba` 
USE `IbmPrueba`;


DROP TABLE IF EXISTS `proveedores`;

CREATE TABLE proveedores (
  `id_proveedor` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) DEFAULT NULL,
  `fecha_alta` varchar(35) DEFAULT NULL,
  `id_cliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



LOCK TABLES `proveedores` WRITE;


INSERT INTO `proveedores` (nombre,fecha_alta,id_cliente) VALUES 
	('Coca-cola','16/10/2019','5'),
	('Pepsi','11/12/2020','5'),
	('RedBull','19/08/2021','6'),
	('Tinto de Verano','12/10/1968','6'),
	('Soda Sugar','12/02/1978','1');


UNLOCK TABLES;