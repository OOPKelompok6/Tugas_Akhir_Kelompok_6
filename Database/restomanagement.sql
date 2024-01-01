-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2024 at 08:41 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restomanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu_bali`
--

CREATE TABLE `menu_bali` (
  `MenuID` char(5) NOT NULL,
  `NamaMenu` varchar(50) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  `Narasi` varchar(100) DEFAULT NULL,
  `Tipe` varchar(20) DEFAULT NULL,
  `HasBeenOrdered` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `menu_bandung`
--

CREATE TABLE `menu_bandung` (
  `MenuID` char(5) NOT NULL,
  `NamaMenu` varchar(50) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  `Narasi` varchar(100) DEFAULT NULL,
  `Tipe` varchar(20) DEFAULT NULL,
  `HasBeenOrdered` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `menu_jakarta`
--

CREATE TABLE `menu_jakarta` (
  `MenuID` char(5) NOT NULL,
  `NamaMenu` varchar(50) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  `Narasi` varchar(100) DEFAULT NULL,
  `Tipe` varchar(20) DEFAULT NULL,
  `HasBeenOrdered` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_jakarta`
--

INSERT INTO `menu_jakarta` (`MenuID`, `NamaMenu`, `Harga`, `Narasi`, `Tipe`, `HasBeenOrdered`) VALUES
('JT672', 'Kerak Telor Spesial', 15.22, 'Kerak Telor khas Betawi', 'Spesial', 0),
('JT682', 'Es Selendang Mayang', 18.25, 'Es Selendang Mayang Khas Betawi', 'Spesial', 0),
('JT726', 'Es Teh Manis', 17.88, '', 'Biasa', 0);

-- --------------------------------------------------------

--
-- Table structure for table `menu_padang`
--

CREATE TABLE `menu_padang` (
  `MenuID` char(5) NOT NULL,
  `NamaMenu` varchar(50) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  `Narasi` varchar(100) DEFAULT NULL,
  `Lokasi` varchar(50) DEFAULT NULL,
  `Tipe` varchar(20) DEFAULT NULL,
  `HasBeenOrdered` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_padang`
--

INSERT INTO `menu_padang` (`MenuID`, `NamaMenu`, `Harga`, `Narasi`, `Lokasi`, `Tipe`, `HasBeenOrdered`) VALUES
('PD827', 'Gulai Daging', 18.27, 'Gulai Daging Khas Lubuk Basung', 'Lubuk Basung', 'Lokal Spesial', 0),
('PD911', 'Ayam Pop', 25.22, 'Ayam Pop Khas Padang', 'Pulau Punjung', 'Lokal Spesial', 0),
('PD928', 'Es Mambo', 11.99, '', '', 'Biasa', 0);

-- --------------------------------------------------------

--
-- Table structure for table `menu_samarinda`
--

CREATE TABLE `menu_samarinda` (
  `MenuID` char(5) NOT NULL,
  `NamaMenu` varchar(50) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  `Narasi` varchar(100) DEFAULT NULL,
  `Lokasi` varchar(50) DEFAULT NULL,
  `Tipe` varchar(20) DEFAULT NULL,
  `HasBeenOrdered` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_samarinda`
--

INSERT INTO `menu_samarinda` (`MenuID`, `NamaMenu`, `Harga`, `Narasi`, `Lokasi`, `Tipe`, `HasBeenOrdered`) VALUES
('SM123', 'Ayam Pop', 29.82, '', '', 'Biasa', 0),
('SM129', 'Es Doger', 18.17, 'Es Doger dengan ketan hitam, campur dengan susu kental  manis dan ketan', 'Bogor', 'Lokal Spesial', 0),
('SM912', 'Nasi Uduk', 19.28, 'Nasi Uduk Khas Samarinda', 'Samarinda', 'Lokal Spesial', 0),
('SM914', 'Rendang', 16.99, 'Rendang asal Lubuk Basung padang', 'Lubuk Basung', 'Lokal Spesial', 0);

-- --------------------------------------------------------

--
-- Table structure for table `menu_surabaya`
--

CREATE TABLE `menu_surabaya` (
  `MenuID` char(5) NOT NULL,
  `NamaMenu` varchar(50) DEFAULT NULL,
  `Harga` double DEFAULT NULL,
  `Narasi` varchar(100) DEFAULT NULL,
  `Lokasi` varchar(50) DEFAULT NULL,
  `Tipe` varchar(20) DEFAULT NULL,
  `HasBeenOrdered` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu_surabaya`
--

INSERT INTO `menu_surabaya` (`MenuID`, `NamaMenu`, `Harga`, `Narasi`, `Lokasi`, `Tipe`, `HasBeenOrdered`) VALUES
('SB192', 'Rujak Cingur', 17.99, 'Rujak Cingur khas Jawa Timur', 'Jawa Timur', 'Lokal Spesial', 0),
('SB912', 'Tahu Campur', 19.33, 'Tahu Campur Khas Lamongan', 'Lamongan', 'Lokal Spesial', 0);

-- --------------------------------------------------------

--
-- Table structure for table `msemployee`
--

CREATE TABLE `msemployee` (
  `EmployeeID` char(5) NOT NULL,
  `EmployeeName` varchar(50) DEFAULT NULL,
  `Cabang` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `msemployee`
--

INSERT INTO `msemployee` (`EmployeeID`, `EmployeeName`, `Cabang`) VALUES
('BD910', 'Muhammad Aldo', 'Bandung'),
('BL124', 'Karyo Suparno', 'Bali'),
('BL981', 'Haryono Budiman', 'Bali'),
('JT021', 'Danni Muwardi', 'Jakarta'),
('JT123', 'Muaimin Harahap', 'Jakarta'),
('PD728', 'Dore Palinggo', 'Padang'),
('SB812', 'Ardiansyah Mulawarman', 'Surabaya'),
('SB871', 'Sumitro Sostroamijoyo', 'Surabaya'),
('SM138', 'Sulaiman Karim', 'Samarinda'),
('SM847', 'Ismail Munahar', 'Samarinda');

-- --------------------------------------------------------

--
-- Table structure for table `msmeja`
--

CREATE TABLE `msmeja` (
  `MejaID` char(5) NOT NULL,
  `OrderID` char(5) DEFAULT NULL,
  `TotalPesanan` int(11) DEFAULT NULL,
  `KapasitasMeja` int(11) DEFAULT NULL,
  `OrangPerMeja` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mspesanan`
--

CREATE TABLE `mspesanan` (
  `OrderID` char(5) NOT NULL,
  `EmployeeID` char(5) DEFAULT NULL,
  `NamaPemesan` varchar(50) DEFAULT NULL,
  `LokasiPemesan` varchar(30) DEFAULT NULL,
  `JumlahMeja` int(11) DEFAULT NULL,
  `StatusPesanan` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pesanandetailbali`
--

CREATE TABLE `pesanandetailbali` (
  `OrderID` char(5) DEFAULT NULL,
  `MejaID` char(5) DEFAULT NULL,
  `MenuID` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pesanandetailbandung`
--

CREATE TABLE `pesanandetailbandung` (
  `OrderID` char(5) DEFAULT NULL,
  `MejaID` char(5) DEFAULT NULL,
  `MenuID` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pesanandetailjakarta`
--

CREATE TABLE `pesanandetailjakarta` (
  `OrderID` char(5) DEFAULT NULL,
  `MejaID` char(5) DEFAULT NULL,
  `MenuID` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pesanandetailpadang`
--

CREATE TABLE `pesanandetailpadang` (
  `OrderID` char(5) DEFAULT NULL,
  `MejaID` char(5) DEFAULT NULL,
  `MenuID` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pesanandetailsamarinda`
--

CREATE TABLE `pesanandetailsamarinda` (
  `OrderID` char(5) DEFAULT NULL,
  `MejaID` char(5) DEFAULT NULL,
  `MenuID` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pesanandetailsurabaya`
--

CREATE TABLE `pesanandetailsurabaya` (
  `OrderID` char(5) DEFAULT NULL,
  `MejaID` char(5) DEFAULT NULL,
  `MenuID` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu_bali`
--
ALTER TABLE `menu_bali`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menu_bandung`
--
ALTER TABLE `menu_bandung`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menu_jakarta`
--
ALTER TABLE `menu_jakarta`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menu_padang`
--
ALTER TABLE `menu_padang`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menu_samarinda`
--
ALTER TABLE `menu_samarinda`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `menu_surabaya`
--
ALTER TABLE `menu_surabaya`
  ADD PRIMARY KEY (`MenuID`);

--
-- Indexes for table `msemployee`
--
ALTER TABLE `msemployee`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `msmeja`
--
ALTER TABLE `msmeja`
  ADD PRIMARY KEY (`MejaID`),
  ADD KEY `OrderID` (`OrderID`);

--
-- Indexes for table `mspesanan`
--
ALTER TABLE `mspesanan`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `EmployeeID` (`EmployeeID`);

--
-- Indexes for table `pesanandetailbali`
--
ALTER TABLE `pesanandetailbali`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `MejaID` (`MejaID`),
  ADD KEY `MenuID` (`MenuID`);

--
-- Indexes for table `pesanandetailbandung`
--
ALTER TABLE `pesanandetailbandung`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `MejaID` (`MejaID`),
  ADD KEY `MenuID` (`MenuID`);

--
-- Indexes for table `pesanandetailjakarta`
--
ALTER TABLE `pesanandetailjakarta`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `MejaID` (`MejaID`),
  ADD KEY `MenuID` (`MenuID`);

--
-- Indexes for table `pesanandetailpadang`
--
ALTER TABLE `pesanandetailpadang`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `MejaID` (`MejaID`),
  ADD KEY `MenuID` (`MenuID`);

--
-- Indexes for table `pesanandetailsamarinda`
--
ALTER TABLE `pesanandetailsamarinda`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `MejaID` (`MejaID`),
  ADD KEY `MenuID` (`MenuID`);

--
-- Indexes for table `pesanandetailsurabaya`
--
ALTER TABLE `pesanandetailsurabaya`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `MejaID` (`MejaID`),
  ADD KEY `MenuID` (`MenuID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `msmeja`
--
ALTER TABLE `msmeja`
  ADD CONSTRAINT `msmeja_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `mspesanan` (`OrderID`);

--
-- Constraints for table `mspesanan`
--
ALTER TABLE `mspesanan`
  ADD CONSTRAINT `mspesanan_ibfk_1` FOREIGN KEY (`EmployeeID`) REFERENCES `msemployee` (`EmployeeID`);

--
-- Constraints for table `pesanandetailbali`
--
ALTER TABLE `pesanandetailbali`
  ADD CONSTRAINT `pesanandetailbali_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `msmeja` (`OrderID`),
  ADD CONSTRAINT `pesanandetailbali_ibfk_2` FOREIGN KEY (`MejaID`) REFERENCES `msmeja` (`MejaID`),
  ADD CONSTRAINT `pesanandetailbali_ibfk_3` FOREIGN KEY (`MenuID`) REFERENCES `menu_bali` (`MenuID`);

--
-- Constraints for table `pesanandetailbandung`
--
ALTER TABLE `pesanandetailbandung`
  ADD CONSTRAINT `pesanandetailbandung_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `msmeja` (`OrderID`),
  ADD CONSTRAINT `pesanandetailbandung_ibfk_2` FOREIGN KEY (`MejaID`) REFERENCES `msmeja` (`MejaID`),
  ADD CONSTRAINT `pesanandetailbandung_ibfk_3` FOREIGN KEY (`MenuID`) REFERENCES `menu_bandung` (`MenuID`);

--
-- Constraints for table `pesanandetailjakarta`
--
ALTER TABLE `pesanandetailjakarta`
  ADD CONSTRAINT `pesanandetailjakarta_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `msmeja` (`OrderID`),
  ADD CONSTRAINT `pesanandetailjakarta_ibfk_2` FOREIGN KEY (`MejaID`) REFERENCES `msmeja` (`MejaID`),
  ADD CONSTRAINT `pesanandetailjakarta_ibfk_3` FOREIGN KEY (`MenuID`) REFERENCES `menu_jakarta` (`MenuID`);

--
-- Constraints for table `pesanandetailpadang`
--
ALTER TABLE `pesanandetailpadang`
  ADD CONSTRAINT `pesanandetailpadang_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `msmeja` (`OrderID`),
  ADD CONSTRAINT `pesanandetailpadang_ibfk_2` FOREIGN KEY (`MejaID`) REFERENCES `msmeja` (`MejaID`),
  ADD CONSTRAINT `pesanandetailpadang_ibfk_3` FOREIGN KEY (`MenuID`) REFERENCES `menu_padang` (`MenuID`);

--
-- Constraints for table `pesanandetailsamarinda`
--
ALTER TABLE `pesanandetailsamarinda`
  ADD CONSTRAINT `pesanandetailsamarinda_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `msmeja` (`OrderID`),
  ADD CONSTRAINT `pesanandetailsamarinda_ibfk_2` FOREIGN KEY (`MejaID`) REFERENCES `msmeja` (`MejaID`),
  ADD CONSTRAINT `pesanandetailsamarinda_ibfk_3` FOREIGN KEY (`MenuID`) REFERENCES `menu_samarinda` (`MenuID`);

--
-- Constraints for table `pesanandetailsurabaya`
--
ALTER TABLE `pesanandetailsurabaya`
  ADD CONSTRAINT `pesanandetailsurabaya_ibfk_1` FOREIGN KEY (`OrderID`) REFERENCES `msmeja` (`OrderID`),
  ADD CONSTRAINT `pesanandetailsurabaya_ibfk_2` FOREIGN KEY (`MejaID`) REFERENCES `msmeja` (`MejaID`),
  ADD CONSTRAINT `pesanandetailsurabaya_ibfk_3` FOREIGN KEY (`MenuID`) REFERENCES `menu_surabaya` (`MenuID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
