-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-11-2013 a las 02:44:14
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
(1, 'falta sin aviso', 'CUALITATIVA', NULL, 1),
(2, 'tardanza', 'CUALITATIVA', NULL, 1),
(3, 'feriado', 'CUALITATIVA', NULL, 1),
(4, 'Adelanto Sueldo', 'CUANTITATIVA', NULL, 1),
(5, 'Perdida de Celular', 'CUANTITATIVA', NULL, 0);

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
(157, 'AINSTEIN', 'FACUNDO', '3232323', 0, 0, 'PROFESIONAL', 'INGENIERO', NULL),
(233, 'Flores', 'Guillermo', '123123123123', 3, 1, 'cec', 'auditor', NULL),
(236, 'FIGUEREDO', 'DANIELA', '2323233', 0, 0, 'PROFESIONAL', 'ABOGADA', NULL),
(237, 'CAMPOS', 'LEONARDO', '23-31463692-9', 3, 1, 'nada', 'TECNICO', NULL),
(238, 'pelaez', 'joel', '123123123123', 1, 0, 'cec', 'tec', NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`COD_EMP`, `NOMBRE`, `GERENTE`, `MAIL_GERENTE`, `estado`) VALUES
(1, 'DM', 'Coco', 'coco', 1),
(2, 'FM', 'Seba', 'seba', 1),
(3, 'DP', 'Seba', 'seba', 1);

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
  `fecha` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cod_emp` (`legajo`,`cod_con`),
  KEY `cod_con` (`cod_con`),
  KEY `legajo` (`legajo`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=47 ;

--
-- Volcado de datos para la tabla `novedad`
--

INSERT INTO `novedad` (`id`, `legajo`, `cantidad`, `observacion`, `cod_con`, `fecha`, `estado`) VALUES
(32, 157, 1, 'a', 1, '10/10/2013', NULL);

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
(0, 'Daniel', 1, 0),
(1, 'DP Jujuy', 3, 1);

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
  PRIMARY KEY (`ID`),
  KEY `LEGAJO` (`LEGAJO`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `LEGAJO`, `USUARIO`, `CLAVE`, `DESCRIPCION`, `TIPO`, `ESTADO`) VALUES
(1, 157, 'FAINSTEIN', '123', 'ING', 'ADMINISTRADOR', NULL),
(2, 237, 'LCAMPOS', '123', 'TEC', 'ADMINISTRADOR', NULL),
(4, 236, 'DFIGUEREDO', '123', 'abo', 'ADMINISTRADOR', NULL),
(5, 233, 'GFlores', '123', 'auditoria', 'ADMINISTRADOR', NULL),
(7, 238, 'jpelaez', '123', 'ing', 'COMUN', NULL);

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
