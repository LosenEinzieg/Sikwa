-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2023 at 02:07 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sikwa`
--

-- --------------------------------------------------------

--
-- Table structure for table `dft_berita`
--

CREATE TABLE `dft_berita` (
  `ID` int(11) NOT NULL,
  `Berita_Acara` varchar(100) NOT NULL,
  `Keterangan` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dft_berita`
--

INSERT INTO `dft_berita` (`ID`, `Berita_Acara`, `Keterangan`) VALUES
(1, 'Jadwal Ronda 25 Mei 2023', 'Besok Jadwalnya Ronda Pak Budi'),
(2, 'Peringatan Pembayaran Iuran', 'Bagi warga yang belum membayar iuran dan kas mohon segera di bayarkan'),
(3, 'Acara Lomba 17 Agustus 1945', 'Segera Bentuk Panitianya'),
(4, 'Jadwal Ronda 26 Mei 2023', 'Besok Jadwalnya Ronda Pak Ibnu');

-- --------------------------------------------------------

--
-- Table structure for table `dft_iuran`
--

CREATE TABLE `dft_iuran` (
  `id` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tanggal` date NOT NULL,
  `iuran_bulanan` int(20) NOT NULL,
  `iuran_tahunan` int(20) NOT NULL,
  `total_bayar` int(20) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dft_iuran`
--

INSERT INTO `dft_iuran` (`id`, `nama`, `tanggal`, `iuran_bulanan`, `iuran_tahunan`, `total_bayar`, `keterangan`) VALUES
(1, 'Ade Arif Ramadhan', '2023-05-10', 20000, 10000, 30000, 'Lunas'),
(2, 'Hendra Widyatama', '2023-05-22', 30000, 0, 30000, 'Lunas'),
(3, 'Galuh', '2023-05-01', 50000, 30000, 80000, 'Belum Lunas'),
(4, 'Al Dzaki', '2023-04-05', 10000, 20000, 30000, 'Lunas'),
(5, 'Ari', '2023-05-01', 50000, 100000, 150000, 'Lunas'),
(6, 'Sayyidi', '2023-01-11', 50000, 50000, 100000, 'Belum Lunas'),
(7, 'Khilmi', '2022-12-03', 50000, 20000, 70000, 'Lunas');

-- --------------------------------------------------------

--
-- Table structure for table `dft_kas`
--

CREATE TABLE `dft_kas` (
  `id` int(11) NOT NULL,
  `deskripsi` varchar(100) NOT NULL,
  `jenis` varchar(10) NOT NULL,
  `nominal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dft_kas`
--

INSERT INTO `dft_kas` (`id`, `deskripsi`, `jenis`, `nominal`) VALUES
(1, 'Kas April 2023', 'Masuk', 100000),
(2, 'Kebersihan', 'Keluar', 50000),
(3, 'Kas Mei 2023', 'Masuk', 2000000),
(4, 'Gaji Security', 'Keluar', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `dft_penduduk`
--

CREATE TABLE `dft_penduduk` (
  `id` int(10) NOT NULL,
  `nik` int(15) NOT NULL,
  `namapnd` varchar(20) NOT NULL,
  `unit` varchar(10) NOT NULL,
  `blok` varchar(10) NOT NULL,
  `tahunmasuk` int(10) NOT NULL,
  `CreateDate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dft_penduduk`
--

INSERT INTO `dft_penduduk` (`id`, `nik`, `namapnd`, `unit`, `blok`, `tahunmasuk`, `CreateDate`) VALUES
(1, 1231218, 'Fajar', 'C1', 'Anggrek', 2023, '2023-05-20 01:09:41'),
(2, 1231231, 'Ade Arif', 'A3', 'Edelweiss', 2010, '2023-05-20 01:10:13'),
(3, 2131313, 'Laras', 'B1', 'Tulip', 2001, '2023-05-20 01:28:54'),
(4, 8768687, 'Mona', 'B1', 'Mawar', 2004, '2023-05-20 09:43:04'),
(5, 3174010, 'Sora', 'A2', 'Anggrek', 2023, '2023-05-24 22:47:00'),
(6, 2174020, 'Shiro', 'A1', 'Teratai', 2023, '2023-05-24 23:00:12');

-- --------------------------------------------------------

--
-- Table structure for table `dft_tamu`
--

CREATE TABLE `dft_tamu` (
  `id` int(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` varchar(20) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `hp` varchar(20) NOT NULL,
  `keperluan` varchar(100) NOT NULL,
  `waktumasuk` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dft_tamu`
--

INSERT INTO `dft_tamu` (`id`, `nama`, `jk`, `alamat`, `hp`, `keperluan`, `waktumasuk`) VALUES
(1, 'Ade Arif Ramadhan', 'Perempuan', 'Jl. J Buntu RT/RW 005/012 No. 1', '081283035608', 'Mengantar Paket', '2023-05-18 16:00:00'),
(2, 'Febryan', 'Perempuan', 'Jl. Menteng Dalam 12', '123123141453', 'Main Kerumah Temen', '2023-05-19 23:09:04'),
(3, 'Aulia ', 'Perempuan', 'Jl. Aup Raya Pasar Minggu Jakarta Selatan', '021100025001', 'Kerja Kelompok', '2023-05-22 23:58:58'),
(4, 'Nabilah', 'Perempuan', 'Jl. Pegangsaan Timur No. 58', '012390819223', 'Main Kerumah Temen', '2023-05-24 23:02:42');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` int(10) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `user`, `pass`, `role`) VALUES
(1, 'ks', 'ks', 'Kepala Security'),
(2, 'sec1', 'sec1', 'Security'),
(3, 'sec2', 'sec2', 'Security'),
(4, 'rt', 'rt', 'RT/RW'),
(5, 'rw', 'rw', 'RT/RW'),
(6, 'war', 'war', 'Warga'),
(7, 'arif', 'arif', 'Warga');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dft_berita`
--
ALTER TABLE `dft_berita`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `dft_iuran`
--
ALTER TABLE `dft_iuran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dft_kas`
--
ALTER TABLE `dft_kas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dft_penduduk`
--
ALTER TABLE `dft_penduduk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dft_tamu`
--
ALTER TABLE `dft_tamu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dft_berita`
--
ALTER TABLE `dft_berita`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `dft_iuran`
--
ALTER TABLE `dft_iuran`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `dft_kas`
--
ALTER TABLE `dft_kas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `dft_penduduk`
--
ALTER TABLE `dft_penduduk`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `dft_tamu`
--
ALTER TABLE `dft_tamu`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
