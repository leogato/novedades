-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-12-2013 a las 20:51:14
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `novedades`
--
CREATE DATABASE IF NOT EXISTS `novedades` DEFAULT CHARACTER SET utf32 COLLATE utf32_spanish_ci;
USE `novedades`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE IF NOT EXISTS `concepto` (
  `cod_con` int(3) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(13) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `cargaUser` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`cod_con`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `concepto`
--

INSERT INTO `concepto` (`cod_con`, `descripcion`, `tipo`, `estado`, `cargaUser`) VALUES
(0, 'Sin Novedad', 'CUALITATIVA', NULL, 1),
(1, 'falta sin aviso', 'CUALITATIVA', NULL, 0),
(2, 'tardanza', 'CUALITATIVA', NULL, 0),
(3, 'feriado', 'CUALITATIVA', NULL, 0),
(4, 'Adelanto Sueldo', 'CUANTITATIVA', NULL, 1),
(5, 'Perdida de Celular', 'CUANTITATIVA', NULL, 1),
(7, 'HS EXTRA', 'CUANTITATIVA', NULL, 0),
(8, 'ENFERMEDAD', 'CUALITATIVA', NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `LEGAJO` int(4) NOT NULL,
  `APELLIDO` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `CUIT` varchar(14) COLLATE utf8_spanish_ci NOT NULL,
  `COD_EMP` int(3) DEFAULT NULL,
  `COD_SUC` int(3) DEFAULT NULL,
  `convenio` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `tarea` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`LEGAJO`),
  KEY `COD_SUC` (`COD_SUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`LEGAJO`, `APELLIDO`, `NOMBRE`, `CUIT`, `COD_EMP`, `COD_SUC`, `convenio`, `tarea`, `estado`) VALUES
(123, 'Lopez', 'Sandra', '324234234', 2, 5, 'CEC', 'RRHH', NULL),
(157, 'Ainstein', 'Facundo', '232323232323', 1, 2, 'Ingeniero', 'Jefe de Sistemas', NULL),
(231, 'romero', 'jose', '12312344', 2, 12, 'profesional', 'contador', NULL),
(232, 'claure', 'ruben', '12312312', 1, 5, 'CEC', 'de todo', NULL),
(233, 'Flores', 'Guillermo', '123123123123', 2, 12, 'cec', 'auditor', NULL),
(237, 'Campos', 'Leonardo', '23-31463692-9', 1, 1, 'nada', 'TECNICO', NULL),
(240, 'Figueredo', 'Daniela', '3232323232323', 2, 12, 'Profesional', 'Abogada', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `COD_EMP` int(3) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `GERENTE` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `MAIL_GERENTE` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`COD_EMP`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`COD_EMP`, `NOMBRE`, `GERENTE`, `MAIL_GERENTE`, `estado`) VALUES
(1, 'Daniel Manzur', 'Sebastian Dellamea', 'sdellamea@manzur-admin.com', 1),
(2, 'Fernando Manzur', 'Sebastian Besin', 'sbesin@manzur-admin.com', 1),
(3, 'Don Pedro', 'Sebastian Besin', 'sbesin@manzur-admin.com', 1),
(4, 'SISTEMAS', 'LEO', 'LEO', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedad`
--

CREATE TABLE IF NOT EXISTS `novedad` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `legajo` int(4) NOT NULL,
  `cantidad` int(5) DEFAULT NULL,
  `observacion` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cod_con` int(3) NOT NULL,
  `fecha` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cod_emp` (`legajo`,`cod_con`),
  KEY `cod_con` (`cod_con`),
  KEY `legajo` (`legajo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=184 ;

--
-- Volcado de datos para la tabla `novedad`
--

INSERT INTO `novedad` (`id`, `legajo`, `cantidad`, `observacion`, `cod_con`, `fecha`, `estado`) VALUES
(152, 123, 0, '-', 0, '2013-11-20', NULL),
(153, 232, 0, '-', 0, '2013-11-20', NULL),
(157, 237, 0, '-', 2, '2013-11-20', NULL),
(158, 231, 0, '-', 0, '2013-11-20', NULL),
(159, 233, 0, '-', 4, '2013-11-20', NULL),
(160, 240, 0, '-', 5, '2013-11-20', NULL),
(165, 231, 300, 'Desc', 4, '2013-11-21', NULL),
(166, 233, 0, '-', 0, '2013-11-21', NULL),
(167, 240, 40, '-', 7, '2013-11-21', NULL),
(168, 231, 151, '-', 5, '2013-11-22', NULL),
(169, 233, 0, '-', 2, '2013-11-22', NULL),
(170, 240, 0, '-', 8, '2013-11-22', NULL),
(171, 123, 100, 'Descuento', 4, '2013-11-22', NULL),
(172, 232, 350, 'Se lo Robaron', 5, '2013-11-22', NULL),
(173, 123, 0, '-', 0, '2013-12-05', NULL),
(174, 232, 0, '-', 0, '2013-12-05', NULL),
(175, 237, 0, '-', 3, '2013-12-05', NULL),
(180, 237, 0, '-', 0, '2013-12-06', NULL),
(181, 237, 0, '-', 2, '2013-12-13', NULL),
(182, 123, 300, '-', 4, '2013-12-13', NULL),
(183, 232, 500, '-', 5, '2013-12-13', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE IF NOT EXISTS `sucursal` (
  `cod_suc` int(3) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `cod_emp` int(3) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`cod_suc`),
  KEY `foranea` (`cod_emp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`cod_suc`, `nombre`, `cod_emp`, `estado`) VALUES
(1, 'Jujuy', 3, 1),
(2, 'Maimará', 3, 0),
(3, 'Humahuaca', 3, 1),
(4, 'Abra Pampa', 3, 1),
(5, 'La Quiaca', 3, 1),
(6, 'Salta', 1, 0),
(7, 'Jujuy', 1, 0),
(8, 'Maimara', 1, 0),
(9, 'Humahuaca', 1, 0),
(10, 'Abra Pampa', 1, 0),
(11, 'La Quiaca', 1, 0),
(12, 'San Pedro', 2, 0),
(13, 'Maimara', 2, 0),
(14, 'Humahuaca', 2, 0),
(15, 'Abra Pampa', 2, 0),
(16, 'La Quiaca', 2, 0),
(17, 'Colonia Sta Rosa', 2, 0),
(18, 'TODAS', 3, 0),
(19, 'TODAS', 1, 0),
(20, 'TODAS', 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LEGAJO` int(4) DEFAULT NULL,
  `USUARIO` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `CLAVE` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPCION` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `ESTADO` tinyint(1) DEFAULT NULL,
  `cargo` tinyint(1) DEFAULT NULL,
  `ultimoIngreso` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `LEGAJO` (`LEGAJO`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `LEGAJO`, `USUARIO`, `CLAVE`, `DESCRIPCION`, `TIPO`, `ESTADO`, `cargo`, `ultimoIngreso`) VALUES
(2, 237, 'LCAMPOS', '123', 'TEC', 'ADMINISTRADOR', NULL, 1, '2013-12-19'),
(5, 233, 'GFlores', '123', 'auditoria', 'ADMINISTRADOR', NULL, 1, '2013-11-22'),
(8, 123, 'SLopez', '123', 'RRHH', 'COMUN', NULL, 1, '2013-12-13'),
(9, 232, 'rclaure', '123', 'ruben', 'COMUN', NULL, NULL, NULL),
(10, 231, 'jromero', '123', 'jose', 'COMUN', NULL, 1, '2013-11-20'),
(11, 157, 'FAinstein', '123', 'facu', 'ADMINISTRADOR', NULL, NULL, NULL);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`COD_SUC`) REFERENCES `sucursal` (`cod_suc`) ON DELETE CASCADE;

--
-- Filtros para la tabla `novedad`
--
ALTER TABLE `novedad`
  ADD CONSTRAINT `novedad_ibfk_3` FOREIGN KEY (`legajo`) REFERENCES `empleado` (`LEGAJO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `novedad_ibfk_4` FOREIGN KEY (`cod_con`) REFERENCES `concepto` (`cod_con`) ON DELETE CASCADE;

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`cod_emp`) REFERENCES `empresa` (`COD_EMP`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`LEGAJO`) REFERENCES `empleado` (`LEGAJO`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
