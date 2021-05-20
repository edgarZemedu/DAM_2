-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2021 a las 20:35:44
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inmobiliaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosbancarios`
--

CREATE TABLE `datosbancarios` (
  `id` int(11) NOT NULL,
  `numCuenta` varchar(24) NOT NULL,
  `nombreBanco` varchar(100) NOT NULL,
  `idPropietario` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `datosbancarios`
--

INSERT INTO `datosbancarios` (`id`, `numCuenta`, `nombreBanco`, `idPropietario`) VALUES
(1, '9876543210', 'Americano', 3),
(2, '1234', 'La Caixa', 5),
(3, '123456789', 'ING', 6),
(5, '559988', 'Santander', 8),
(6, '567893', 'Abanca', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmuebles`
--

CREATE TABLE `inmuebles` (
  `id` char(5) NOT NULL,
  `inDireccion` varchar(50) DEFAULT NULL,
  `inCodZona` char(5) DEFAULT NULL,
  `inEstado` char(1) DEFAULT NULL,
  `inPropietario` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `inmuebles`
--

INSERT INTO `inmuebles` (`id`, `inDireccion`, `inCodZona`, `inEstado`, `inPropietario`) VALUES
('1', 'O Rosal', '1', '1', 3),
('2', 'Mi Casa', '1', '1', 3),
('3', 'Vigo', '1', '1', 3),
('4', 'Vigo n? 1', '1', '1', 6),
('5', 'Redondela', '5', '1', 3),
('6', 'Gondomar', '7', '2', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `id` int(5) NOT NULL,
  `prDNI` char(9) NOT NULL,
  `prNombre` varchar(30) NOT NULL,
  `prApellidos` varchar(40) NOT NULL,
  `prDireccion` varchar(50) NOT NULL,
  `prTelefono` char(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`id`, `prDNI`, `prNombre`, `prApellidos`, `prDireccion`, `prTelefono`) VALUES
(3, '35570828V', 'Francisco', 'Bouzada Conde', 'O Rosal', '666666666'),
(5, '11111111A', 'Paquito', 'Chocolatero', 'Mi casa', '777777777'),
(6, '36358928M', 'Paco', 'Lan', 'Tomi?o', '626626626'),
(8, '55443269M', 'Roberto', 'Diz', 'A guarda', '456789123'),
(9, '12345678Z', 'Gus', 'Lomba', 'A guarda', '623654987');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `datosbancarios`
--
ALTER TABLE `datosbancarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPropietario` (`idPropietario`);

--
-- Indices de la tabla `inmuebles`
--
ALTER TABLE `inmuebles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKPropietario` (`inPropietario`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `datosbancarios`
--
ALTER TABLE `datosbancarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `datosbancarios`
--
ALTER TABLE `datosbancarios`
  ADD CONSTRAINT `datosbancarios_ibfk_1` FOREIGN KEY (`idPropietario`) REFERENCES `propietarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `inmuebles`
--
ALTER TABLE `inmuebles`
  ADD CONSTRAINT `FKPropietario` FOREIGN KEY (`inPropietario`) REFERENCES `propietarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
