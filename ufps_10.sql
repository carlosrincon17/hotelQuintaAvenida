-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 10-08-2012 a las 23:24:16
-- Versión del servidor: 5.1.61
-- Versión de PHP: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ufps_10`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE IF NOT EXISTS `articulo` (
  `id_articulo` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_articulo`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id_articulo`, `nombre`, `precio`, `cantidad`) VALUES
(1, 'papas', 1200, 19),
(2, 'agua', 600, 555),
(3, '444', 444, 444),
(17, 'joselin', 1234, 1222),
(26, '3', 3, 70),
(27, '5', 5, 5),
(28, 'de todito', 1200, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo_minibar`
--

CREATE TABLE IF NOT EXISTS `articulo_minibar` (
  `id_articulo_minibar` int(11) NOT NULL AUTO_INCREMENT,
  `id_articulo` int(3) NOT NULL,
  `id_minibar` varchar(10) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`id_articulo_minibar`),
  KEY `id_minibar` (`id_minibar`),
  KEY `id_articulo` (`id_articulo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `articulo_minibar`
--

INSERT INTO `articulo_minibar` (`id_articulo_minibar`, `id_articulo`, `id_minibar`, `cantidad`) VALUES
(1, 1, 'mn01', 0),
(2, 1, '009009', 1),
(3, 17, '009009', 6),
(4, 17, '009009', 3),
(5, 17, '009009', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` varchar(20) NOT NULL,
  `nombre_empresa` varchar(20) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre_empresa`) VALUES
('0', '5694'),
('1090', 'Ninguna'),
('4', '44');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comportamiento`
--

CREATE TABLE IF NOT EXISTS `comportamiento` (
  `id_comportamiento` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) CHARACTER SET ascii NOT NULL,
  `enlace` varchar(75) CHARACTER SET ascii NOT NULL,
  `id_modulo` int(11) NOT NULL,
  PRIMARY KEY (`id_comportamiento`),
  KEY `id_modulo` (`id_modulo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Volcado de datos para la tabla `comportamiento`
--

INSERT INTO `comportamiento` (`id_comportamiento`, `nombre`, `enlace`, `id_modulo`) VALUES
(1, 'Crear Rol', '../gestionarUsuarios/form_crear_rol.jsp', 1),
(2, 'Editar Rol', '../gestionarUsuarios/form_editar_rol.jsp', 1),
(3, 'Crear habitacion', '../gestionarHabitaciones/form_crear_habitacion.jsp', 8),
(4, 'Consultar habitaciones', '../gestionarHabitaciones/form_listar_habitaciones.jsp', 8),
(5, 'Registrar Articulo', '../gestionarServicios/form_registrar_articulo.jsp', 3),
(6, 'Listar Articulos', '../gestionarServicios/form_listar_articulos.jsp', 3),
(7, 'Registrar Minibar', '../gestionarMinibares/form_registrar_minibar.jsp', 4),
(8, 'Listar minibares', '../gestionarMinibares/form_listar_minibares.jsp', 4),
(9, 'Registrar Servicio', '../gestionarServicios/form_registrar_servicio.jsp', 3),
(10, 'Listar Servicios', '../gestionarServicios/form_listar_servicios.jsp', 3),
(11, 'Crear salon', '../gestionarSalones/form_registrar_salon.jsp', 7),
(12, 'Listar Salones', '../gestionarSalones/form_listar_salones.jsp', 7),
(13, 'Crear Empleado', '../gestionarEmpleados/form_registrar_empleado.jsp', 2),
(14, 'Consultar Empleados', '../gestionarEmpleados/form_listar_empleados.jsp', 2),
(15, 'Registrar Cliente', '../gestionarClientes/form_registrar_cliente.jsp', 6),
(16, 'Cerrar Sesion', '../../logout.jsp', 10),
(17, 'Reservar Salon', '../gestionarReservas/reservas.jsp', 5),
(18, 'Reservar Habitacion', '../gestionarReservas/form_crear_reserva_habitacion.jsp', 5),
(19, 'Consultar Reservas', '../gestionarReservas/form_consultar_reservas_habitacion.jsp', 5),
(21, 'Listar Hospedajes', '../gestionarHospedajes/listarHospedajes.jsp', 9),
(22, 'Registrar Hospedaje', '../gestionarHospedajes/form_crear_hospedaje.jsp', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumo_restaurante`
--

CREATE TABLE IF NOT EXISTS `consumo_restaurante` (
  `id_consumo` int(4) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_consumo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `id_empleado` varchar(20) NOT NULL,
  `NumeroSS` varchar(15) NOT NULL,
  `id_funcion` int(2) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `id_funcion` (`id_funcion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id_empleado`, `NumeroSS`, `id_funcion`, `estado`) VALUES
('007', '645-3651', 1, 1),
('1011', '55', 1, 1),
('1012', '6748', 3, 1),
('10922211', '1102', 4, 1),
('111', '1223', 3, 1),
('121', '10', 5, 1),
('1991', '221', 2, 1),
('3', '3', 1, 1),
('900', '1231', 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_habitacion`
--

CREATE TABLE IF NOT EXISTS `estado_habitacion` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id_estado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `estado_habitacion`
--

INSERT INTO `estado_habitacion` (`id_estado`, `nombre`) VALUES
(1, 'libre'),
(2, 'ocupada'),
(3, 'reservada'),
(4, 'en reparacion'),
(5, 'deshabilitada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` int(4) NOT NULL AUTO_INCREMENT,
  `fecha_factura` date NOT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`id_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_hospedaje`
--

CREATE TABLE IF NOT EXISTS `factura_hospedaje` (
  `id_factura_hospedaje` int(4) NOT NULL,
  `id_hospedaje` int(4) NOT NULL,
  PRIMARY KEY (`id_factura_hospedaje`),
  KEY `id_hospedaje` (`id_hospedaje`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_salon`
--

CREATE TABLE IF NOT EXISTS `factura_salon` (
  `id_factura_salon` int(4) NOT NULL,
  `id_reserva` int(3) NOT NULL,
  PRIMARY KEY (`id_factura_salon`),
  KEY `id_reserva` (`id_reserva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion_empleado`
--

CREATE TABLE IF NOT EXISTS `funcion_empleado` (
  `id_funcion` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`id_funcion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `funcion_empleado`
--

INSERT INTO `funcion_empleado` (`id_funcion`, `nombre`) VALUES
(1, 'administrador'),
(2, 'gerente'),
(3, 'recepcionista'),
(4, 'jojija'),
(5, 'Botones'),
(6, 'cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE IF NOT EXISTS `habitacion` (
  `id_habitacion` int(3) NOT NULL,
  `id_tipo` int(2) NOT NULL,
  `id_minibar` varchar(10) DEFAULT NULL,
  `estado` varchar(10) NOT NULL,
  PRIMARY KEY (`id_habitacion`),
  KEY `id_tipo` (`id_tipo`),
  KEY `id_minibar` (`id_minibar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`id_habitacion`, `id_tipo`, `id_minibar`, `estado`) VALUES
(201, 2, NULL, '2'),
(202, 2, NULL, '2'),
(203, 3, NULL, '1'),
(204, 2, NULL, '1'),
(304, 4, NULL, '1'),
(404, 2, NULL, '1'),
(501, 2, NULL, '1'),
(510, 4, NULL, '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hospedaje`
--

CREATE TABLE IF NOT EXISTS `hospedaje` (
  `id_hospedaje` int(4) NOT NULL AUTO_INCREMENT,
  `id_habitacion` int(3) NOT NULL,
  `id_cliente` varchar(20) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `id_reserva` int(3) DEFAULT NULL,
  PRIMARY KEY (`id_hospedaje`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_habitacion` (`id_habitacion`),
  KEY `id_reserva` (`id_reserva`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `hospedaje`
--

INSERT INTO `hospedaje` (`id_hospedaje`, `id_habitacion`, `id_cliente`, `fecha_inicio`, `fecha_fin`, `id_reserva`) VALUES
(1, 202, '1090', '2012-08-15', NULL, NULL),
(2, 201, '1090', '2012-08-16', NULL, NULL),
(3, 304, '1090', '2012-08-16', '2012-08-30', NULL),
(4, 201, '1090', '2012-08-09', NULL, NULL),
(5, 201, '1090', '2012-08-09', NULL, NULL),
(6, 202, '1090', '2012-08-09', NULL, NULL),
(7, 510, '1090', '2012-08-10', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `item_factura`
--

CREATE TABLE IF NOT EXISTS `item_factura` (
  `id_item_factura` int(4) NOT NULL AUTO_INCREMENT,
  `id_factura` int(4) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `subtotal` float NOT NULL,
  PRIMARY KEY (`id_item_factura`),
  KEY `id_factura` (`id_factura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `llamada`
--

CREATE TABLE IF NOT EXISTS `llamada` (
  `id_llamada` int(4) NOT NULL,
  `duracion` int(11) NOT NULL,
  `destino` varchar(20) NOT NULL,
  PRIMARY KEY (`id_llamada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `minibar`
--

CREATE TABLE IF NOT EXISTS `minibar` (
  `id_minibar` varchar(20) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `modelo` varchar(20) NOT NULL,
  PRIMARY KEY (`id_minibar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `minibar`
--

INSERT INTO `minibar` (`id_minibar`, `marca`, `modelo`) VALUES
('009009', 'Stark Industries', 'Mark I'),
('2', '2', '2'),
('3', '3', '3'),
('431', 'samsung', 'max'),
('444', '1234', '1234'),
('mn01', 'neverita', 'feisima'),
('mn10', 'nevera', 'muyfeo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE IF NOT EXISTS `modulo` (
  `id_modulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id_modulo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`id_modulo`, `nombre`) VALUES
(1, 'Usuarios'),
(2, 'Empleados'),
(3, 'Servicios'),
(4, 'Minibares'),
(5, 'Reservas'),
(6, 'Clientes'),
(7, 'Salones'),
(8, 'Habitaciones'),
(9, 'Hospedajes'),
(10, 'Mi cuenta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(30) CHARACTER SET ascii NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `correo` varchar(50) CHARACTER SET ascii NOT NULL,
  `direccion` varchar(50) CHARACTER SET ascii NOT NULL,
  `telefono` varchar(15) CHARACTER SET ascii NOT NULL,
  `fecha_nto` date NOT NULL,
  `fecha_inscripcion` date NOT NULL,
  PRIMARY KEY (`cedula`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`cedula`, `nombre`, `apellido`, `correo`, `direccion`, `telefono`, `fecha_nto`, `fecha_inscripcion`) VALUES
('0', 'Hulk', 'The Incredible', 'green', 'algonose', '555', '0112-07-10', '1990-11-11'),
('000', 'algo', 'algo', 'algo', 'algo', 'algo', '0112-07-10', '1990-11-11'),
('007', 'superman', 'castañeda', 'muajaja@muajaja.com', 'Av. No existe', '6655', '2003-07-20', '2012-08-06'),
('1011', 'Bruce', 'Wayne', '12@1.com', 'Calle10 ', '1234', '0112-07-10', '1990-11-12'),
('1012', 'Carlos', 'Rincon', 'negrio@hotmail.com', 'Los Patios', '6823', '0112-07-06', '1990-11-12'),
('1090', 'Francisco', 'Bastos', 'frankz.182@gmail.com', 'Calle10 # 20.35', '5674312', '0112-07-06', '1990-11-11'),
('10922211', 'can', 'can', 'xd', '1102', '023', '0112-07-08', '1990-11-11'),
('111', 'pilar', 'rodriguez', '123', 'tatata', 'tatata', '0112-07-08', '1990-11-11'),
('121', 'Jahn', 'suarez', 'js.gmail.com', 'fra', 'sl10', '0112-07-10', '1990-11-11'),
('1991', 'Falcao', 'Garcia', '12kfrn', '234', '45542', '0112-07-06', '1990-11-11'),
('3', '3', '3', '3', '3', '3', '0112-07-08', '1990-11-11'),
('4', '4', '4', '4', '4', '4', '0112-07-08', '1990-11-11'),
('67548', 'Iron Man', 'Stark', 'mark@s.com', 'djdjal', '1241', '0112-07-10', '1990-11-11'),
('675483f', 'Iron Man', 'Stark', 'mark@s.coma', 'djdjal', '1241', '0112-07-10', '1990-11-11'),
('900', 'jaimito', 'yatusabe', 'fraksn@gmali.com', 'Calle10 # 20.35', '66584', '0112-07-10', '1990-11-12'),
('958848', 'jaja', 'jaja', 'jeje', 'jeje', 'jeje', '0112-07-08', '1990-11-11'),
('9876', 'algo', '1120', 'frasf', 'kdfkjr', 'rer', '0112-07-10', '1990-11-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `privilegio`
--

CREATE TABLE IF NOT EXISTS `privilegio` (
  `id_rol` int(2) NOT NULL,
  `id_comportamiento` int(3) NOT NULL,
  `id_privilegio` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_privilegio`),
  UNIQUE KEY `id_rol` (`id_rol`,`id_comportamiento`),
  KEY `id_comportamiento` (`id_comportamiento`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=227 ;

--
-- Volcado de datos para la tabla `privilegio`
--

INSERT INTO `privilegio` (`id_rol`, `id_comportamiento`, `id_privilegio`) VALUES
(1, 1, 194),
(1, 2, 195),
(1, 3, 196),
(1, 4, 197),
(1, 5, 198),
(1, 6, 199),
(1, 7, 200),
(1, 8, 201),
(1, 9, 202),
(1, 10, 203),
(1, 11, 204),
(1, 12, 205),
(1, 13, 206),
(1, 14, 207),
(1, 15, 208),
(1, 16, 209),
(1, 17, 210),
(1, 18, 211),
(1, 19, 212),
(1, 21, 213),
(1, 22, 214),
(3, 4, 180),
(3, 5, 181),
(3, 6, 182),
(3, 7, 183),
(3, 8, 184),
(3, 9, 185),
(3, 10, 186),
(3, 11, 187),
(3, 12, 188),
(3, 15, 189),
(3, 16, 190),
(4, 3, 143),
(6, 13, 218),
(6, 18, 219),
(7, 16, 223),
(7, 17, 224),
(7, 18, 225),
(7, 19, 226);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `id_reserva` int(3) NOT NULL AUTO_INCREMENT,
  `id_cliente` varchar(20) NOT NULL,
  `fecha_solicitud` date NOT NULL,
  `fecha_reserva` date NOT NULL,
  `activa` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_reserva`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `id_cliente`, `fecha_solicitud`, `fecha_reserva`, `activa`) VALUES
(1, '1090', '2012-08-08', '2012-08-23', 1),
(4, '1090', '2012-08-05', '2012-08-01', 1),
(5, '1090', '2012-08-05', '2012-08-01', 1),
(6, '1090', '2012-08-05', '2012-08-02', 1),
(7, '1090', '2012-08-05', '2012-08-02', 0),
(8, '1090', '2012-08-05', '2012-08-06', 0),
(9, '1090', '2012-08-05', '2012-08-05', 1),
(10, '1090', '2012-08-05', '2012-08-01', 1),
(11, '1090', '2012-08-05', '2012-08-01', 1),
(12, '1090', '2012-08-05', '2012-08-01', 1),
(14, '1090', '2012-08-05', '2012-08-00', 1),
(15, '1090', '2012-08-05', '2012-08-22', 1),
(16, '1090', '2012-08-05', '2012-08-16', 1),
(17, '1090', '2012-08-05', '2012-08-16', 1),
(18, '1090', '2012-08-05', '2012-08-16', 1),
(19, '1090', '2012-08-05', '2012-08-22', 1),
(21, '1090', '2012-08-05', '2012-08-27', 1),
(22, '1090', '2012-08-05', '2012-09-01', 1),
(23, '1090', '2012-08-05', '2012-09-01', 0),
(25, '1090', '2012-08-05', '2012-08-29', 1),
(26, '1090', '2012-08-05', '2012-08-29', 1),
(27, '1090', '2012-08-05', '2012-08-21', 1),
(28, '1090', '2012-08-05', '2012-08-21', 1),
(29, '1090', '2012-08-05', '2012-08-24', 0),
(41, '1090', '2012-08-05', '2012-08-09', 1),
(43, '1090', '2012-08-05', '2012-10-03', 1),
(49, '1090', '2012-08-05', '2012-08-16', 1),
(52, '1090', '2012-08-05', '2012-08-08', 1),
(55, '1090', '2012-08-05', '2012-08-30', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_habitacion`
--

CREATE TABLE IF NOT EXISTS `reserva_habitacion` (
  `id_reserva_habitacion` int(3) NOT NULL,
  `id_habitacion` int(3) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`id_reserva_habitacion`),
  KEY `id_habitacion` (`id_habitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva_habitacion`
--

INSERT INTO `reserva_habitacion` (`id_reserva_habitacion`, `id_habitacion`, `descripcion`) VALUES
(22, 201, 'henry es gay'),
(23, 204, 'henry es gay'),
(29, 304, 'El cliente es gay'),
(49, 304, 'algo9'),
(55, 304, 'ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_salon`
--

CREATE TABLE IF NOT EXISTS `reserva_salon` (
  `id_reserva_salon` int(3) NOT NULL AUTO_INCREMENT,
  `id_salon` int(2) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `abono` int(11) NOT NULL,
  `hora_inicio` int(11) NOT NULL,
  `hora_fin` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `id_empleado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_reserva_salon`),
  KEY `id_salon` (`id_salon`),
  KEY `id_empleado` (`id_empleado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=53 ;

--
-- Volcado de datos para la tabla `reserva_salon`
--

INSERT INTO `reserva_salon` (`id_reserva_salon`, `id_salon`, `descripcion`, `abono`, `hora_inicio`, `hora_fin`, `total`, `id_empleado`) VALUES
(7, 1, 'null', 5000, 6, 13, 7, '007'),
(8, 1, 'null', 50000, 6, 9, 3, '007'),
(9, 1, 'null', 40000, 6, 8, 2, '007'),
(10, 1, 'null', 878, 6, 7, 1, '007'),
(11, 1, 'null', 2342, 6, 7, 1, '007'),
(12, 1, 'null', 2321, 6, 7, 1, '007'),
(14, 1, 'null', 32131, 6, 7, 1, '007'),
(15, 1, 'null', 190, 6, 7, 1, '007'),
(16, 1, 'null', 3242, 6, 7, 1, '007'),
(17, 1, 'null', 232131, 6, 7, 1, '007'),
(18, 1, 'null', 232131, 6, 7, 1, '007'),
(19, 1, 'null', 324, 6, 7, 1, '007'),
(25, 1, 'ninguna', 5000, 6, 8, 2, '007'),
(26, 1, 'ninguna', 5000, 7, 8, 1, '007'),
(27, 1, 'alg', 2, 6, 7, 1, '007'),
(28, 1, 'alg', 2, 6, 7, 1, '007'),
(41, 1, 'null', 10000, 6, 7, 1, '007'),
(43, 1, 'null', 565656, 6, 7, 1, '007'),
(52, 1, 'null', 10000, 6, 9, 3, '007');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) CHARACTER SET ascii NOT NULL,
  `descripcion` varchar(50) CHARACTER SET ascii NOT NULL,
  PRIMARY KEY (`id_rol`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `nombre`, `descripcion`) VALUES
(1, 'administrador', 'EL QUE TODO LO PUEDE'),
(2, 'gerente', 'el que menos trabaja'),
(3, 'recepcionista', 'la que mas trabaja'),
(4, 'jojija', 'jojija'),
(6, 'Botones', 'Revisor de todo'),
(7, 'cliente', 'algo no se XD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salon`
--

CREATE TABLE IF NOT EXISTS `salon` (
  `id_salon` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `precio_hora` float NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_salon`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `salon`
--

INSERT INTO `salon` (`id_salon`, `nombre`, `capacidad`, `precio_hora`, `estado`) VALUES
(1, 'hola', 4, 1, 'Habilitado'),
(2, 'salon de la fama', 55, 500, 'Habilitado'),
(3, '4', 4, 4, 'Habilitado'),
(4, '4', 4, 4, 'Habilitado'),
(5, '4', 4, 4, 'Habilitado'),
(6, 'diamente', 200, 100000, 'Habilitado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE IF NOT EXISTS `servicio` (
  `id_servicio` int(4) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(20) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id_servicio`),
  UNIQUE KEY `tipo` (`tipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id_servicio`, `tipo`, `precio`) VALUES
(1, 'qwrm', 1234),
(3, 'llamadas', 102),
(11, '3', 3),
(12, 'algo', 1500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio_hospedaje`
--

CREATE TABLE IF NOT EXISTS `servicio_hospedaje` (
  `id_servicio_hospedaje` int(3) NOT NULL AUTO_INCREMENT,
  `id_servicio` int(4) NOT NULL,
  `id_hospedaje` int(3) NOT NULL,
  `cantidad` int(2) NOT NULL,
  PRIMARY KEY (`id_servicio_hospedaje`),
  KEY `id_servicio` (`id_servicio`),
  KEY `id_hospedaje` (`id_hospedaje`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_habitacion`
--

CREATE TABLE IF NOT EXISTS `tipo_habitacion` (
  `id_tipo` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id_tipo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `tipo_habitacion`
--

INSERT INTO `tipo_habitacion` (`id_tipo`, `nombre`, `precio`) VALUES
(1, 'Estandar', 10),
(2, 'Doble', 20),
(3, 'Minisuite', 30),
(4, 'Suite', 40);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` varchar(20) NOT NULL,
  `id_rol` int(2) NOT NULL,
  `password` varchar(15) CHARACTER SET ascii NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_rol` (`id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `id_rol`, `password`) VALUES
('0', 7, 'hotel0'),
('007', 1, 'hotel'),
('1011', 1, 'hotel1011'),
('1012', 3, 'hotel1012'),
('10922211', 4, 'hotel10922211'),
('111', 3, 'hotel111'),
('121', 6, 'hotel121'),
('1991', 2, 'hotel1991'),
('3', 1, 'hotel3'),
('900', 6, 'hotel900');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo_minibar`
--
ALTER TABLE `articulo_minibar`
  ADD CONSTRAINT `articulo_minibar_ibfk_1` FOREIGN KEY (`id_articulo`) REFERENCES `articulo` (`id_articulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `articulo_minibar_ibfk_2` FOREIGN KEY (`id_minibar`) REFERENCES `minibar` (`id_minibar`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `comportamiento`
--
ALTER TABLE `comportamiento`
  ADD CONSTRAINT `comportamiento_ibfk_1` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `consumo_restaurante`
--
ALTER TABLE `consumo_restaurante`
  ADD CONSTRAINT `consumo_restaurante_ibfk_1` FOREIGN KEY (`id_consumo`) REFERENCES `servicio` (`id_servicio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`id_funcion`) REFERENCES `funcion_empleado` (`id_funcion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura_hospedaje`
--
ALTER TABLE `factura_hospedaje`
  ADD CONSTRAINT `factura_hospedaje_ibfk_1` FOREIGN KEY (`id_factura_hospedaje`) REFERENCES `factura` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_hospedaje_ibfk_2` FOREIGN KEY (`id_hospedaje`) REFERENCES `hospedaje` (`id_hospedaje`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura_salon`
--
ALTER TABLE `factura_salon`
  ADD CONSTRAINT `factura_salon_ibfk_1` FOREIGN KEY (`id_factura_salon`) REFERENCES `factura` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_salon_ibfk_2` FOREIGN KEY (`id_reserva`) REFERENCES `reserva_salon` (`id_reserva_salon`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_habitacion` (`id_tipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `habitacion_ibfk_2` FOREIGN KEY (`id_minibar`) REFERENCES `minibar` (`id_minibar`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `hospedaje`
--
ALTER TABLE `hospedaje`
  ADD CONSTRAINT `hospedaje_ibfk_1` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id_habitacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hospedaje_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `hospedaje_ibfk_4` FOREIGN KEY (`id_reserva`) REFERENCES `reserva_habitacion` (`id_reserva_habitacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `item_factura`
--
ALTER TABLE `item_factura`
  ADD CONSTRAINT `item_factura_ibfk_1` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `llamada`
--
ALTER TABLE `llamada`
  ADD CONSTRAINT `llamada_ibfk_1` FOREIGN KEY (`id_llamada`) REFERENCES `servicio` (`id_servicio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `privilegio`
--
ALTER TABLE `privilegio`
  ADD CONSTRAINT `privilegio_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `privilegio_ibfk_2` FOREIGN KEY (`id_comportamiento`) REFERENCES `comportamiento` (`id_comportamiento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva_habitacion`
--
ALTER TABLE `reserva_habitacion`
  ADD CONSTRAINT `reserva_habitacion_ibfk_1` FOREIGN KEY (`id_reserva_habitacion`) REFERENCES `reserva` (`id_reserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_habitacion_ibfk_2` FOREIGN KEY (`id_habitacion`) REFERENCES `habitacion` (`id_habitacion`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva_salon`
--
ALTER TABLE `reserva_salon`
  ADD CONSTRAINT `reserva_salon_ibfk_3` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id_empleado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_salon_ibfk_1` FOREIGN KEY (`id_reserva_salon`) REFERENCES `reserva` (`id_reserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_salon_ibfk_2` FOREIGN KEY (`id_salon`) REFERENCES `salon` (`id_salon`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `servicio_hospedaje`
--
ALTER TABLE `servicio_hospedaje`
  ADD CONSTRAINT `servicio_hospedaje_ibfk_1` FOREIGN KEY (`id_servicio`) REFERENCES `servicio` (`id_servicio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `servicio_hospedaje_ibfk_2` FOREIGN KEY (`id_hospedaje`) REFERENCES `hospedaje` (`id_hospedaje`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `persona` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
