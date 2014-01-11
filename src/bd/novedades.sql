-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-01-2014 a las 13:33:19
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
(0, 'Sin Novedad', 'CUALITATIVA', 1, 1),
(1, 'falta sin aviso', 'CUALITATIVA', 1, 0),
(2, 'tardanza', 'CUALITATIVA', 1, 0),
(3, 'feriado', 'CUALITATIVA', 1, 0),
(4, 'Adelanto Sueldo', 'CUANTITATIVA', 1, 1),
(5, 'Perdida de Celular', 'CUANTITATIVA', 1, 1),
(7, 'HS EXTRA', 'CUANTITATIVA', 1, 0),
(8, 'ENFERMEDAD', 'CUALITATIVA', 1, 0),
(9, 'Prueba Sis1', 'CUALITATIVA', 1, 0),
(10, 'Pruba Sis2', 'CUALITATIVA', 0, 0),
(11, 'Prueba Sis3', 'CUALITATIVA', 1, 0);

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
  `nom_emp` varchar(35) COLLATE utf8_spanish_ci DEFAULT NULL,
  `COD_SUC` int(3) DEFAULT NULL,
  `nom_suc` varchar(35) COLLATE utf8_spanish_ci DEFAULT NULL,
  `convenio` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `tarea` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`LEGAJO`),
  KEY `COD_SUC` (`COD_SUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`LEGAJO`, `APELLIDO`, `NOMBRE`, `CUIT`, `COD_EMP`, `nom_emp`, `COD_SUC`, `nom_suc`, `convenio`, `tarea`, `estado`) VALUES
(237, 'Campos', 'Leonardo', '23-31463692-9', 3, '3-Don Pedro', 1, '1-Jujuy', 'nada', 'TECNICO', 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=192 ;

--
-- Volcado de datos para la tabla `novedad`
--

INSERT INTO `novedad` (`id`, `legajo`, `cantidad`, `observacion`, `cod_con`, `fecha`, `estado`) VALUES
(157, 237, 0, '-', 2, '2013-11-20', 1),
(185, 237, 0, '-', 2, '2013-12-24', 1),
(186, 237, 200, '-', 4, '2013-12-25', 1),
(187, 237, 300, '-', 4, '2013-12-27', 1),
(188, 237, 200, '-', 4, '2013-12-26', 1);

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
(2, 237, 'LCAMPOS', '123', 'TEC', 'ADMINISTRADOR', NULL, 1, '2014-01-08');

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
  ADD CONSTRAINT `novedad_ibfk_3` FOREIGN KEY (`legajo`) REFERENCES `empleado` (`LEGAJO`) ON DELETE CASCADE,
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
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`LEGAJO`) REFERENCES `empleado` (`LEGAJO`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
