-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2020 a las 20:52:25
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aivon`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajadeaivon`
--

CREATE TABLE `cajadeaivon` (
  `idCaja` int(11) NOT NULL,
  `idPedido` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidadProductos` int(11) NOT NULL,
  `estrellasCaja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `campaña`
--

CREATE TABLE `campaña` (
  `idCampaña` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `montoMinimo` double NOT NULL,
  `montoTope` double NOT NULL,
  `estrellasCampaña` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historico-campaña`
--

CREATE TABLE `historico-campaña` (
  `IdHistorico` int(11) NOT NULL,
  `idRevendedor/a` int(11) NOT NULL,
  `idCampaña` int(11) NOT NULL,
  `estrellasCampañaRevendedor` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `idPedido` int(11) NOT NULL,
  `idCampaña` int(11) NOT NULL,
  `idRevendedor` int(11) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `fechaDePago` date NOT NULL,
  `cantidadDeCajas` int(11) NOT NULL,
  `importePedido` double NOT NULL,
  `estrellasPedido` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `uso` varchar(40) NOT NULL,
  `tamañoEnCm3` int(11) NOT NULL,
  `precioVentaAlpublico` double NOT NULL,
  `precioCosto` double NOT NULL,
  `estrellas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revendedor/a`
--

CREATE TABLE `revendedor/a` (
  `idRevendedor/a` int(11) NOT NULL,
  `nombreCompleto` varchar(14) NOT NULL,
  `telefono` varchar(14) NOT NULL,
  `mail` varchar(14) NOT NULL,
  `activa` tinyint(1) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cajadeaivon`
--
ALTER TABLE `cajadeaivon`
  ADD PRIMARY KEY (`idCaja`),
  ADD KEY `idPedido` (`idPedido`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `campaña`
--
ALTER TABLE `campaña`
  ADD PRIMARY KEY (`idCampaña`);

--
-- Indices de la tabla `historico-campaña`
--
ALTER TABLE `historico-campaña`
  ADD PRIMARY KEY (`IdHistorico`),
  ADD KEY `idRevendedor/a` (`idRevendedor/a`),
  ADD KEY `idCampaña` (`idCampaña`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idCampaña` (`idCampaña`),
  ADD KEY `idRevendedor` (`idRevendedor`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `revendedor/a`
--
ALTER TABLE `revendedor/a`
  ADD PRIMARY KEY (`idRevendedor/a`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cajadeaivon`
--
ALTER TABLE `cajadeaivon`
  MODIFY `idCaja` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `campaña`
--
ALTER TABLE `campaña`
  MODIFY `idCampaña` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `historico-campaña`
--
ALTER TABLE `historico-campaña`
  MODIFY `IdHistorico` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `revendedor/a`
--
ALTER TABLE `revendedor/a`
  MODIFY `idRevendedor/a` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cajadeaivon`
--
ALTER TABLE `cajadeaivon`
  ADD CONSTRAINT `idPedido` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idPedido`),
  ADD CONSTRAINT `idProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `historico-campaña`
--
ALTER TABLE `historico-campaña`
  ADD CONSTRAINT `idDeCampaña` FOREIGN KEY (`idCampaña`) REFERENCES `campaña` (`idCampaña`),
  ADD CONSTRAINT `idRevendedor` FOREIGN KEY (`idRevendedor/a`) REFERENCES `revendedor/a` (`idRevendedor/a`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `idCampaña` FOREIGN KEY (`idCampaña`) REFERENCES `campaña` (`idCampaña`),
  ADD CONSTRAINT `idRevendedor/a` FOREIGN KEY (`idRevendedor`) REFERENCES `revendedor/a` (`idRevendedor/a`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
