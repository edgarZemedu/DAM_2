-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Xerado en: 08 de Xuño de 2021 ás 21:54
-- Versión do servidor: 10.1.36-MariaDB
-- Versión do PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `miempresa`
--

-- --------------------------------------------------------

--
-- Estrutura da táboa `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `NIF` varchar(40) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A extraer os datos da táboa `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `NIF`, `correo`) VALUES
(2, 'as', 'sa', 'ds');

-- --------------------------------------------------------

--
-- Estrutura da táboa `pedidos`
--

CREATE TABLE `pedidos` (
  `codigoPedido` int(11) NOT NULL,
  `unidades` int(5) DEFAULT NULL,
  `direccion` varchar(40) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `estado` int(5) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da táboa `productos`
--

CREATE TABLE `productos` (
  `codigoProducto` int(11) NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `stock` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`codigoPedido`),
  ADD KEY `FKCliente` (`idCliente`),
  ADD KEY `FKProducto` (`idProducto`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigoProducto`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `codigoPedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `codigoProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricións para os envorcados das táboas
--

--
-- Restricións para a táboa `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `FKCliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKProducto` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`codigoProducto`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
