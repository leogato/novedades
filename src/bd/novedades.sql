-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-09-2013 a las 17:13:54
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cdcol`
--
CREATE DATABASE IF NOT EXISTS `cdcol` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `cdcol`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cds`
--

CREATE TABLE IF NOT EXISTS `cds` (
  `titel` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `interpret` varchar(200) COLLATE latin1_general_ci DEFAULT NULL,
  `jahr` int(11) DEFAULT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `cds`
--

INSERT INTO `cds` (`titel`, `interpret`, `jahr`, `id`) VALUES
('Beauty', 'Ryuichi Sakamoto', 1990, 1),
('Goodbye Country (Hello Nightclub)', 'Groove Armada', 2001, 4),
('Glee', 'Bran Van 3000', 1997, 5);
--
-- Base de datos: `novedades`
--
CREATE DATABASE IF NOT EXISTS `novedades` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `novedades`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE IF NOT EXISTS `concepto` (
  `cod_con` int(3) NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `carga_usuario` tinyint(1) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  PRIMARY KEY (`cod_con`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `LEGAJO` int(4) NOT NULL,
  `APELLIDO` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `NOMBRE` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `CUIT` varchar(13) COLLATE utf8_spanish_ci NOT NULL,
  `COD_EMP` int(3) DEFAULT NULL,
  `COD_SUC` int(3) DEFAULT NULL,
  `convenio` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `tarea` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`LEGAJO`),
  KEY `FORANEA` (`COD_EMP`),
  KEY `COD_SUC` (`COD_SUC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`LEGAJO`, `APELLIDO`, `NOMBRE`, `CUIT`, `COD_EMP`, `COD_SUC`, `convenio`, `tarea`) VALUES
(235, 'AINSTEIN', 'FACUNDO', '23-29000431-9', NULL, NULL, 'PROFESIONAL', 'INGENIERO'),
(237, 'CAMPOS', 'LEONARDO', '23-31463692-9', NULL, NULL, 'CEC', 'TECNICO EN SISTEMAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `COD_EMP` int(3) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `GERENTE` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `MAIL_GERENTE` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`COD_EMP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedad`
--

CREATE TABLE IF NOT EXISTS `novedad` (
  `fecha` date NOT NULL,
  `legajo` int(4) NOT NULL,
  `cantidad` int(5) NOT NULL,
  `observacion` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `cod_con` int(3) NOT NULL,
  PRIMARY KEY (`fecha`),
  KEY `cod_emp` (`legajo`,`cod_con`),
  KEY `cod_con` (`cod_con`),
  KEY `legajo` (`legajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE IF NOT EXISTS `sucursal` (
  `cod_suc` int(3) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `cod_emp` int(3) NOT NULL,
  `legajo` int(4) NOT NULL,
  PRIMARY KEY (`cod_suc`),
  KEY `foranea` (`cod_emp`),
  KEY `foranea2` (`legajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `ID` int(11) NOT NULL,
  `LEGAJO` int(4) NOT NULL,
  `USUARIO` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `CLAVE` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPCION` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `LEGAJO` (`LEGAJO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`COD_EMP`) REFERENCES `empresa` (`COD_EMP`) ON UPDATE CASCADE,
  ADD CONSTRAINT `empleado_ibfk_2` FOREIGN KEY (`COD_SUC`) REFERENCES `sucursal` (`cod_suc`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `novedad`
--
ALTER TABLE `novedad`
  ADD CONSTRAINT `novedad_ibfk_3` FOREIGN KEY (`legajo`) REFERENCES `empleado` (`LEGAJO`) ON UPDATE CASCADE,
  ADD CONSTRAINT `novedad_ibfk_4` FOREIGN KEY (`cod_con`) REFERENCES `concepto` (`cod_con`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_ibfk_1` FOREIGN KEY (`cod_emp`) REFERENCES `empresa` (`COD_EMP`) ON UPDATE CASCADE,
  ADD CONSTRAINT `sucursal_ibfk_2` FOREIGN KEY (`legajo`) REFERENCES `empleado` (`LEGAJO`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`LEGAJO`) REFERENCES `empleado` (`LEGAJO`) ON UPDATE CASCADE;
--
-- Base de datos: `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_bookmark`
--

CREATE TABLE IF NOT EXISTS `pma_bookmark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_column_info`
--

CREATE TABLE IF NOT EXISTS `pma_column_info` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin' AUTO_INCREMENT=45 ;

--
-- Volcado de datos para la tabla `pma_column_info`
--

INSERT INTO `pma_column_info` (`id`, `db_name`, `table_name`, `column_name`, `comment`, `mimetype`, `transformation`, `transformation_options`) VALUES
(44, 'novedades', 'empleado', 'LEGAJO', '', '', '_', ''),
(43, 'novedades', 'empleado', 'CUIT', '', '', '_', ''),
(42, 'novedades', 'empleado', 'COD_EMP', '', '', '_', ''),
(41, 'novedades', 'empleado', 'COD_SUC', '', '', '_', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_designer_coords`
--

CREATE TABLE IF NOT EXISTS `pma_designer_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `v` tinyint(4) DEFAULT NULL,
  `h` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for Designer';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_history`
--

CREATE TABLE IF NOT EXISTS `pma_history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`,`db`,`table`,`timevalue`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_pdf_pages`
--

CREATE TABLE IF NOT EXISTS `pma_pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  PRIMARY KEY (`page_nr`),
  KEY `db_name` (`db_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_recent`
--

CREATE TABLE IF NOT EXISTS `pma_recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Volcado de datos para la tabla `pma_recent`
--

INSERT INTO `pma_recent` (`username`, `tables`) VALUES
('root', '[{"db":"novedades","table":"empleado"},{"db":"toma_foto","table":"empleado"},{"db":"novedades","table":"empleados"},{"db":"novedades","table":"usuario"},{"db":"novedades","table":"sucursal"},{"db":"novedades","table":"empresa"},{"db":"novedades","table":"concepto"},{"db":"novedades","table":"novedad"},{"db":"novedades","table":"USUARIO"},{"db":"novedades","table":"EMPRESA"}]');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_relation`
--

CREATE TABLE IF NOT EXISTS `pma_relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  KEY `foreign_field` (`foreign_db`,`foreign_table`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_table_coords`
--

CREATE TABLE IF NOT EXISTS `pma_table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float unsigned NOT NULL DEFAULT '0',
  `y` float unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_table_info`
--

CREATE TABLE IF NOT EXISTS `pma_table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_table_uiprefs`
--

CREATE TABLE IF NOT EXISTS `pma_table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`,`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_tracking`
--

CREATE TABLE IF NOT EXISTS `pma_tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) unsigned NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`db_name`,`table_name`,`version`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pma_userconfig`
--

CREATE TABLE IF NOT EXISTS `pma_userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Volcado de datos para la tabla `pma_userconfig`
--

INSERT INTO `pma_userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2013-08-24 14:29:57', '{"lang":"es","ThemeDefault":"metro"}');
--
-- Base de datos: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_multi_sets`()
    DETERMINISTIC
begin
        select user() as first_col;
        select user() as first_col, now() as second_col;
        select user() as first_col, now() as second_col, now() as third_col;
        end$$

DELIMITER ;
--
-- Base de datos: `toma_foto`
--
CREATE DATABASE IF NOT EXISTS `toma_foto` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `toma_foto`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE IF NOT EXISTS `asistencia` (
  `ID_ASISTENCIA` int(11) NOT NULL AUTO_INCREMENT,
  `LEGAJO` int(11) DEFAULT NULL,
  `ESTADO` varchar(30) COLLATE utf16_spanish_ci DEFAULT NULL,
  `IMAGEN` longblob,
  `FECHA` date DEFAULT NULL,
  `HORA` time DEFAULT NULL,
  `MODIFICADO` tinyint(1) DEFAULT NULL,
  `FECHA_MODIFICADO` date DEFAULT NULL,
  `CORRECTO` tinyint(1) DEFAULT NULL,
  `OBSERVACION` varchar(200) COLLATE utf16_spanish_ci DEFAULT NULL,
  `REAJUSTE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_ASISTENCIA`),
  KEY `LEGAJO` (`LEGAJO`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`ID_ASISTENCIA`, `LEGAJO`, `ESTADO`, `IMAGEN`, `FECHA`, `HORA`, `MODIFICADO`, `FECHA_MODIFICADO`, `CORRECTO`, `OBSERVACION`, `REAJUSTE`) VALUES
(1, 123456, 'ENTRADA', 0xffd8ffe000104a46494600010200000100010000ffdb004300080606070605080707070909080a0c140d0c0b0b0c1912130f141d1a1f1e1d1a1c1c20242e2720222c231c1c2837292c30313434341f27393d38323c2e333432ffdb0043010909090c0b0c180d0d1832211c213232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232323232ffc000110800f0014003012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f009d1c6efc49a9d25c36d56f96a9efcb54b19a928be1c9a572aff2edaaa92629c6405837a5005c8e23b556a7489beeab5558a5fef55c4955be6a0072452ae36d5b124b1eda6adcaeca5f332d40685a8eec8dbb94d5c8b5289177367a1359e8e9b7e6a8e7b98a352adf860502659bed4222adf36588c5731a85c9910aaf09d2a2bcd4793b5471c7359725cf98bfd2a92b09bb803f36da950fcd5590e6ac21aa24bb14842d5d85eb351ea747c5006bc4fc55f824fbbf356340f57a17a016c6fc13815a96f725195b75735148455e827c7dea62675705d875f9aada3061b96b99b7b8c56bdbdde1452690ee68d2d411ce1ea6a9b5869dc5a28a281851451400514514005145140052521205559eec20dabef400e9ee562cfd2b2677699b76ea242ceccefd0f43517983eeafdda0058970a6a6b688ced49044666ff66b5a088468176d003a28fcb5db53520a5a00f02094e519a54a911015db5250a809a96341ba95100a1c1dbf2f6a00b002d4808aaf183b29db085dd409965314a65f294b3360019aa524e225f4acebed514c0f12b672319a2c0cba356777ddbb11f415565d596367dadbc927926b165b969542af082a2de3eed55845b92e0ccdf337ad3439350254a9540598cd58435512ac21f96824b2953a1cd5543f2fe15346f4c0d08395ab91b815991c98ab51be6901a68e4d5c81f076d6489005ab30c849a7d04b7376292ae473fcbb7d6b1629b0b56229fe6fbd4d34267456d2fcb56d2efe6db5851dc6054897396fd2a595d4e8c4a8476a532a85ddb85628ba2147b5125e615be94ac17b1b227523ef53f7aff787ad7362f8fdddd49f6ef9850901d3d15936daba3e125e0e71bb35a4f22a26edc2914494d2714c925022deb59f3ea413e556e693b85ae4b7377b3e5ef541e7dedf37e355ccfbdfe66cd465f2fb57bd0c099e40576ab532ce06965f6153dbd9e5959f1cf6ab36f1082e1d57a11814202f40802d4f9f9aaba11bb6ad588d314201f451d16b9ed67c4715a2982dfe697d47f0d303cfbfb250b8db9c0a7a69207cdbbad69673f95461f2ff00a566532b268e4fdd61ed4d6d22e117ee8dbea0d6d271ed53211f75beed02e8736da7cd1a6ed9f2fad579e09a34f9948aec121575ed593abcb1da5abcb2ec0801e0d17771dac71778cc77eee83b5633a7c9b95aac4fa934b33becf99bb551f30ee6f7ab49a26f71c242142af7a50496a8bafcd52260355937b130e36d4c95003f35480d0344e08a943e6aa0a990d022d446ac035490d4e87e5a2d702e447156a37359e870d5389695ae16b9a41eacc3262b3216fef5595936aad3ea24ac690978a9e296b24484d4f1c981431f5361a70054914e43563b4fc54b14ff00ed5006d9bafe1f4a259fe4fbd5902725a8794d09580b924ff3544d758f9aaa3cb9a81e4cb50868d98ae01f997ad5db4d60d9a959537a1ae684e517ef5412dd396fbc4fd4d2b5c11dddc6a02483721c03c8159d24e5dbb572e2e9c26f597a76cd6cd8b3ddc48edc13c52b58699786edc155735a96f6e517732f34db581624ec781ce2aee422d26029385a8fe6795197a679a7c11b4cdb7f87d6a71188e54db480b7147b1689ee22b588c92b0441dcd53d4b56b7d362f9d817eca2b8cd4b569f527f9988407851d29a02eeb1e279a773159fc91ff7bbb560244d236e6efcd4d1db3c8c36afb74ae9f4cf0e6f855e7629e8b8e68407282e17ff00ad4dde0fccbc555c00f53260286a828d24b81fc5e952c72a9fbb54136965ab522044dcb40f52ea4e8145725e2694cade5337c81c13fed0ad891b117ccd587a979370fb59b385f9a9adc9671b7604570eabf7474355c7ddfad4b778170eabd03102a027e515621e0d390fcd508fe1a9053449600fe2a7838a891f0bb69334c0b487f87f1a76454008a92339a048b086a7420355442054a1e81dac5b120a941aa80e57754d19f96802e447e5fbd52f9954b78fbb407a00d247cd4c24c0aa11bf1520928bdc5d0bde67cb4f8e4f96a809334ff3362d3632f24ff353a49eb3c4a0fdda532fcb4ba016fcd256a3793e6aa625a512fcc28b580b5e67cbb6a173f7a9864a8e47a068b36804b384eb5da5bdabdac29b93cb752322b818ae1e39576575ba46acf7c9e5cbcc8a474f4a4c11d3c79dabeb56238495dcd50c516c6dcf8391c1cd4ef711c116e95b08075acd8ed72c8c242ccb80c3d6b1356d71204f2a26064ee47f0d65ea9af3dc334506447eb58d1c65db75086892495ee1d99db249eb56ad2ce49db6a2e7a54b61a5cd7128f90ed2c0576ba7e9f1d927cbf7c8c1356220d3f45b7b48959d77c98e4d6ad14b401c89f044418b2ddb64fac7487c1f20fb97119faa575fc514582e716fe11ba46dc8d13fb0245452e817ff002a9b72541ecc2bb9e28a2c17b9e57adda5c69f6aed2c322f61915e7d2eaec25936e39c835ea3f1075fb75d1af2d7762e5240aa31cd78c146219ff3a6a2ac26ee0cf9fe7518eb45098db4c4480d4a08db55b205481e93025069c86a0069e94c68b29cad4d1902aaa1c53c1cd2622c6453d0d564352a1cd302ca1a983e16aa83f2d3f228026120a990ff0015521d6ac22e2802e07c2d287aae24a7a9a484cb087e6a577c557df86a52e29f511611e877f96a1069aef4d8d1207a37d421c534c837520459df484e56a0df4e06818e2ec8d5d4f874dbd9c46e6795016c29cff08ae6e3b47b85dcac07a66a7b3b679576cae4274db498d6e7a13eaf6e2dd2e5650e87eee0d605fea52df31666213b283547caf2a10abd074152416ad27cdfc3d3151d464d6b6ef3baac485c9c0e0575ba4f87762abdcae3fd9c533c3961e4dc09146576e6ba9a6808a2b748176a2803e9535145300a28a2800a28a2800a648e234676fbaa093f853ea39104913a76208a00f0cf179b7d435dbbbb793ac98f2c76c0ae4eea75747545c0e302b4fc408d1eb37b1eece2561f866b38227945bdb14e56b936ba33bf8a93386a47fbf4e080a16ddf30e314ca0feed38535395a750262f4a901a6528db408901cd393ef54638a703401303f2d4e9f76aba1a901a00b20e29739aae0e6a641fc5ba812244fbb5297a84c807e3499a064f9c35481f2b5541f9a9e0e2802c6fe697396a8411b6943fcd49099387c50e7e4f9aabefe695e438a60c7e405a697a87cca5df86a064c24c53849f3556dfcd390fcd401d36969f6889b67df8c80c3ea6b662d16e8cdb17193caf35cae9b7325accaf1292c3e6c01e95e93a2dd0d5e589d10085572587f7bfbb50c68c59748b8b4976cab97c64006b5349d35ee3e4651bf3935d24ba6a5e3867c8caf51ea0d5d82d22b750b1281818e94ac322b1b6fb3214db57692969a5600a28a29805145140094b58d6daf5b4bf2cb98d8f4c8e2b5c3065dc0e41e8451668a9c1c1d9a1d487eed2d437122c56d2c8ed85552493f4a093c175a823b8d4ae9957932bf3f8d607f664cf2f97ce39aef3421a4c97f3cfa9cae832766d071c9abfa99f0eba2b59df90ea320153fe158cabc632e563e4563c8674f2e52be848a87f86b5b5bb344be925b67f323662c0fd6b322077edad934d08514ea4c7cd463e6aa0b58703f2d1fc54014dc8dd4124c31b6a44a887dda91013f76930241f76a4a6a46c57eed4822229059a16219a949d8b488b85fbb4c7e5a81b561e0e6958fdda881c2d3d0afcb542ea489f769f9f956a1df96db4ea48079229539a8f23695f7a0494c09b22a22ff002d04fcd4ca480797e94a08350ff08a03e16981383f3500e6a34e1693349017e09de36dc8d83820e3d2bb7f08f89ed34d0961736e504ae312e78ae06dc9de17d6ba5b89ceaf6767a6416c8265901f947602959303d925936242e98d858038f43566b3ace16b7d12049fefc51ae7f0ad0520aee1d0f228287514514005145140051451401c949600fdda8e3bcb8d1df772d0e46e535a0eca9f36e031d73585a9ea6b76c96b1ae72c0b1f6a699e87337a48eed5c3c61d7a1191583e2917d73a5cd67676924865001753ef5bd1809122af4000155f50bfb6d32c9eeaea411c518c924d08f38f1e9fc39addba9ff8974e10725b6f1552d74a64be89355636d0c80b06c568ebff0015ae2e1de0d3a33043d371c12d5c6c9ae4f7d30f365279ee6a5c351f358ddd7349d2ade12d05e195cfdd02b88893fd2b6b7a9ab97f7f248e5158802aa5b91bb7fe74c49dcb6f6bfc551491614d6944eae83e9504e060d245b48a0ff73f4a8734f9cfcc156991825a9924d0a6ff0096b4a0b550b50da4386ad14c6da4d824208c0f978a718c0a4269be70a4531c40db559d3e6ab08e0d4823069a7606ae540985a360356cc22a2298a77b8ac47b0052ded51e7e6a7c80ed351608a04293f35008150938a70c1aa2498be5a984d47fc5484f5a06c334a0d340269fe510bb9b8f4a043c1fce9e833500ceea9e220b2af4e82803674bd345cbabb7dc5059abd1fe1fe8f14715cea2c80b3b98e32476155748f044cb6f0b8b989e29114b6e073ff01aeeec2ce1d3ed12da05c228fd6a4695d16080576f6e940002edf4a75140c28a28a0028a28a0028a28a00f362f797f8dcc769c10054812db4ddb3dd384e7bd695b88d224daa31815e4be3ed4e73e2396259c985557001e3342d4eaa93e5d8f6093e21787ade31bae9ce00ce10d792fc42f19ff00c249a8ac369237d822e138c6e26b8e92f1e45c7f0e2ab17cd52b2391eab5252e4d352428fb96a3cd19a0192bbe5cb7a9ab1138117e233544d488e766da4c45f4bb28df2f4a73dc992a8a1a703f37e34ad62af62500c8f57adedc05dd5040bf37ddabb1903e5a4c12b3278d715610e45411f35623152cd1218e995aa72928d5b09102b55af2dc15fbb42dc968ce05bef2d588ee4c7f7aa912d13ff4a944ab27cadc55925f4ba475f7a7673594411f779a7c772635f9a8b05ec5f3503fdda7c73ac8bf7b9f4a300d243653319dc69e8847f0d5a0a3753c28a771245411b53fecec56aded14fd802fdeed49b068af14077055ee40ad6f15594ba4fd8ec1d4a48b1976071d09ad1f05e949aaf88e047e638b32c831e95dd78c3c0abe24bb4bd8ae44570a9e5e0af04034d6c26788ff0016dad6d22df17b0bb2e57cc18cfae6aecfe1d6b3d467b599248dd0ed8c327dfaddd2f459a0d2edefdef22022632a41e5ef2d83fc545f5159d8f604508a15400a0000014faaba7cf2dce9f04f3c5e54ae81993fba4d5aa0a0a28a2800a28a2800a28a2800a28a2803e759fe235f08912d9426d18c9c66b8abcba92eee9e795b7bb1249a818f34ddd9a7a20949cb71e0fcd49fc351e714ecd3247e696994a2801f421f9a9b40e1a8025ce1a9f172ff008d455341c3548dee68c47a54f9f9aab466a5cd496b62dc0702ad467e6aa313e5aad21cd4948d046f9569ee82446aa68df2d4e92516b1650b8b4059b6f5159f242c8df76b7c853b9aa236e0b55a64385cc30aff007694c6fb7e65ada1020a718d0ad2b8b90c24560ddea5495c36df4ad17b55dd52c7688ebf32d36c9e466789c8a41778ab92da610eded59ff6760d42069a2c25e2ff0076b7341f0f6a9e259992d024712e37cb26702b0e0b42ecabb6bdd3c0da4c9a4787638e5501e563291df07a50ac20f09f8420f0d44ecd379f7320dad26dc0c7a57514514c492473baff0085e2d72ea19dae1e2f2c6d60abf785167e18821957cc62f020c2c59c827fdaae8a8a07612968a2800a28a4a005a29296800a2928a005a2928a00f8df3f35378a427e6a4feed5123a85385a4e33484d1d4093340a60e36d3a9201f47f769b9f969d4301e3f86a68ce2a0434f0690d97e373c5581d2a8c4e3755c47cd26522685ead47f76a8c670d5691fe55a4522ea1c54c98aaa08a7a49fc54916ad72e8fbb4d76c542251b6abcf3e1690368925b850d491480d518c999f755b48f186a6c136d9742efa98210b55a23f32d5d180b4ad61d8ad3e76edf7a8fca1524e7e51f5a407e5db401afe17d20eadadc16e3fd5eedf21c7455af72550a005e001802be7bb0d7eef47be67b19cc4f8c31001ddff7d5775a5fc4d94054d46d049d8bc4707fef9ad2da1cedab9e994565e93aee9fac421ed671bfbc6e4075fc2b5281851451400514525002d14525002502909a6138a0090d19c5337f14c3254dd3025c8a01a837e3ef53449f35501f1f13f351fe1519eb4efe215448a73ba90506933f2d0b6024eb480d267f952500494e15183f353c5260381c35283f3532905202e44ff355b439acc47c55b8e4140d1701f9aacc6f59c1ff0086acc6e3e5a4cd11795e9e24c2d5407e5a43281536ba13762d9949f95697ca254b375c5558ee107ddab11dc83b7a53b0fa157cd303ed6e957a0b90fb76b553bc789bd2a80731b6e56c516b93768e991c7dea904ff2d625b5ee5b6b55a138a0d5345c9a4c20fad406e0468cccdc55796e32de8a2b36eae3ce6dabf74516ba22522f8bc811f72e7713d48ab09a826dfbd5819a707c55191d4c57cc30f1390579520fddaeebc33f12268dd2df566f361e8260bf32ff00bd5e4514a51be5fc6acc77183b95bbf4a689b33ea3b5ba82f6dd27b790491b0cab0a9ebc27c1de309f46b911c8c5ed98fce84d7b6595edbea16a9716d28923600e41a56b169dcb341eab45324385dde86818fa43467e5a8cb8dd49bb00c909a609322992bfcb51093e555a4264e4fcb417f96ab993e5a42f40c91dff0095337e1aa3269a5fe5a00f923f8a9699fc54f06b42409a29a694118a3a80fa5a60c528c50018a7822986905004b914cfe2a507e6a4fef500480d48870d5074a7e454816a392a68e5c5510f52c7cb5034cbaf7076ed5a84c8e5a9c23256847d8df32d031aa4d4a8e47e14e52a6a6302483e5e1a805120cb3fe34c78cec152989a36f969e972d1c5b597340ec8aa329f354c9390aab5149701daa12734089e69cc876eef96a2cd368cf5a695891734a0fcb51e69c0d3027422a4ce2aba1c54a4d4813c770c8df2b5763e14f1c4fa25c2ab3bb4071ba33d2b850f4ece2a84d1f5168fae5a6b76827b56e31ca9232b57e571e4b7b62be69d03c4779a15da4f6d26307953d1857bd687adc5afe8e9789d48c38c771593ba291ba1f283e955cbfcedef51a483c955fce981fe6a16e309ce12a2c8dab4e9dfe465aa824f9a9899299016db46fc7e955c9c3d213fdda0659f333480e3f2a833f2d2d0267ca27ad2d34e3752d68216938a296800fe2a70a404520a00929b499a70c50028e683d69bd29452402d2d3452d0c07834f8df0d508a7838a405e8a7c7e3560f9727a56606c54be67cb45ac34ec3dcec6f95a9c970e2a227348180a01368b5f6b256a09a72ebed5016a3f8681ddb1c0d495127dea9338a6c914d266909a4cd201697f86a3cd3c7ddaa01e0d3ea118a70a009334e35167e6a7934981323d7ab7c29d5f7c175a6330e9e62579166babf016a06c7c516adbb0b237967f1a4d5d01eef1121996919f0d4c1ff001f0cabef4af81ee6a10d89e6654d54dfcd4c480d59b2dcc42628ae323a8cf34c65d2f46fe2aa249bda9ceffc340138929e0d5212671f4a9c1cad34247cb5fc5482948f9a900ab10bfe14bfc34d14a3ad003e8cd25033400a2945379a75002d267147f768233400b4b9a68e1a94500029ff00c348294fdda3a80678a7034cfe1a7516b80edf4bbf351ff0d3a9301694536947dda4038529a41f7690f5a04b70c8dd467e6a6e6969a043a9dfc34ca3f86860c7138a70fbb519a5a635b12834739a603499a00981ab9a75c7d96fa197fbac0f154054919c1dd493b313573e8bb3bc4b88609d1b22440727e956de4c3570de07d4deef455476e616da33e95d6b4ff35459a761dee859ee31f36ef5af36b6d505bf8a2e7e53fbc908c7e15dddc483f3af35d5a3f2bc4fb95bef30269a57607a35bca1eae67358f66f57c3fcd4376296c4e4fcd52249f756aa07f9aa507a5080ffd9, '2013-05-15', '21:54:29', 0, NULL, 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `LEGAJO` int(11) NOT NULL,
  `ID_EMPRESA` int(11) DEFAULT NULL,
  `APELLIDO` varchar(100) COLLATE utf16_spanish_ci NOT NULL,
  `NOMBRE` varchar(100) COLLATE utf16_spanish_ci NOT NULL,
  `DNI` int(11) DEFAULT NULL,
  `FECHA_INGRESO` date DEFAULT NULL,
  `DIRECCION` varchar(200) COLLATE utf16_spanish_ci DEFAULT NULL,
  `LOCALIDAD` varchar(100) COLLATE utf16_spanish_ci DEFAULT NULL,
  `CLAVE` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `ADMINISTRADOR` tinyint(1) DEFAULT NULL,
  `IMAGEN` blob,
  `TELEFONO` varchar(20) COLLATE utf16_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`LEGAJO`),
  KEY `ID_EMPRESA` (`ID_EMPRESA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`LEGAJO`, `ID_EMPRESA`, `APELLIDO`, `NOMBRE`, `DNI`, `FECHA_INGRESO`, `DIRECCION`, `LOCALIDAD`, `CLAVE`, `ADMINISTRADOR`, `IMAGEN`, `TELEFONO`) VALUES
(237, NULL, '', '', NULL, NULL, NULL, NULL, '123', 1, NULL, NULL),
(123456, NULL, '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', '\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0', 123456, NULL, NULL, NULL, '123', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `ID_EMPRESA` int(11) NOT NULL AUTO_INCREMENT,
  `CUIT` int(11) DEFAULT NULL,
  `DENOMINACION` varchar(100) COLLATE utf16_spanish_ci DEFAULT NULL,
  `DOMICILIO` varchar(100) COLLATE utf16_spanish_ci DEFAULT NULL,
  `FECHA_INICIO` date DEFAULT NULL,
  `INGRESO_BRUTO` varchar(100) COLLATE utf16_spanish_ci NOT NULL,
  `CATEGORIA` varchar(100) COLLATE utf16_spanish_ci NOT NULL,
  `IMAGEN` blob,
  PRIMARY KEY (`ID_EMPRESA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `asistencia_ibfk_1` FOREIGN KEY (`LEGAJO`) REFERENCES `empleado` (`LEGAJO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`ID_EMPRESA`) REFERENCES `empresa` (`ID_EMPRESA`) ON DELETE CASCADE ON UPDATE CASCADE;
--
-- Base de datos: `webauth`
--
CREATE DATABASE IF NOT EXISTS `webauth` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `webauth`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_pwd`
--

CREATE TABLE IF NOT EXISTS `user_pwd` (
  `name` char(30) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  `pass` char(32) COLLATE latin1_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcado de datos para la tabla `user_pwd`
--

INSERT INTO `user_pwd` (`name`, `pass`) VALUES
('xampp', 'wampp');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
