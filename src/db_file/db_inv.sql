-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 13, 2019 at 09:11 PM
-- Server version: 5.7.26
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_inv`
--

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE IF NOT EXISTS `inventory` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `Category` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`product_id`, `product_name`, `Category`, `Description`, `status`) VALUES
(5, '100', '100', '100', 1);

-- --------------------------------------------------------

--
-- Table structure for table `receive`
--

DROP TABLE IF EXISTS `receive`;
CREATE TABLE IF NOT EXISTS `receive` (
  `receive_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `Date_in` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`receive_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `receive`
--

INSERT INTO `receive` (`receive_id`, `product_name`, `quantity`, `price`, `Date_in`, `category`, `location`) VALUES
(9, '100', 81, 100, '14-12-2019', '100', '100');

-- --------------------------------------------------------

--
-- Table structure for table `sales_report`
--

DROP TABLE IF EXISTS `sales_report`;
CREATE TABLE IF NOT EXISTS `sales_report` (
  `sales_id` int(11) NOT NULL AUTO_INCREMENT,
  `transact_id` varchar(255) NOT NULL,
  `product_id` varchar(255) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `category` varchar(255) NOT NULL,
  `date_in` varchar(255) NOT NULL,
  `date_out` varchar(255) NOT NULL,
  PRIMARY KEY (`sales_id`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_report`
--

INSERT INTO `sales_report` (`sales_id`, `transact_id`, `product_id`, `product_name`, `quantity`, `price`, `category`, `date_in`, `date_out`) VALUES
(10, '201964554', '9', '100', 93, 100, '100', '14-12-2019', '14-12-2019'),
(9, '201962071', '9', '100', 94, 100, '100', '14-12-2019', '14-12-2019'),
(8, '201962071', '9', '100', 95, 100, '100', '14-12-2019', '14-12-2019'),
(7, '201979178', '9', '100', 97, 100, '100', '14-12-2019', '14-12-2019'),
(6, '201911075', '9', '100', 99, 100, '100', '14-12-2019', '14-12-2019'),
(11, '201945097', '9', '100', 92, 100, '100', '14-12-2019', '14-12-2019'),
(12, '201982195', '9', '100', 91, 100, '100', '14-12-2019', '14-12-2019'),
(13, '201930161', '9', '100', 90, 100, '100', '14-12-2019', '14-12-2019'),
(14, '201930161', '9', '100', 89, 100, '100', '14-12-2019', '14-12-2019'),
(15, '201927059', '9', '100', 88, 100, '100', '14-12-2019', '14-12-2019'),
(16, '201927059', '9', '100', 87, 100, '100', '14-12-2019', '14-12-2019'),
(17, '201927059', '9', '100', 86, 100, '100', '14-12-2019', '14-12-2019'),
(18, '201927059', '9', '100', 85, 100, '100', '14-12-2019', '14-12-2019'),
(19, '2019966', '9', '100', 84, 100, '100', '14-12-2019', '14-12-2019'),
(20, '2019966', '9', '100', 83, 100, '100', '14-12-2019', '14-12-2019'),
(21, '201932272', '9', '100', 82, 100, '100', '14-12-2019', '14-12-2019'),
(22, '201932272', '9', '100', 81, 100, '100', '14-12-2019', '14-12-2019');

-- --------------------------------------------------------

--
-- Table structure for table `temp`
--

DROP TABLE IF EXISTS `temp`;
CREATE TABLE IF NOT EXISTS `temp` (
  `receive_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `Date_in` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  PRIMARY KEY (`receive_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `temp`
--

INSERT INTO `temp` (`receive_id`, `product_name`, `quantity`, `price`, `Date_in`, `category`, `location`) VALUES
(9, '100', 55, 100, '14-12-2019', '100', '100');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
