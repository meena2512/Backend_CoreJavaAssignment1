-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2023 at 07:16 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `TaskId` int(5) NOT NULL COMMENT 'Task ID',
  `TaskTitle` varchar(20) NOT NULL COMMENT 'Task Title',
  `TaskText` varchar(80) NOT NULL COMMENT 'Task Description',
  `AssignedUser` varchar(50) NOT NULL COMMENT 'Task Assigned User',
  `TaskStatus` tinyint(1) NOT NULL COMMENT 'Task Status'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Task Database';

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`TaskId`, `TaskTitle`, `TaskText`, `AssignedUser`, `TaskStatus`) VALUES
(1, 'Task1', 'Gather requirements for Project A. ', 'user4', 1),
(2, 'Task2', 'Handover the project details to research team', 'user3', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Email` varchar(60) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='User Database';

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Email`, `UserName`, `Password`) VALUES
('user1@g.com', 'User1', 'user1'),
('user2@g.com', 'User2', 'user2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`TaskId`),
  ADD UNIQUE KEY `TaskTitle` (`TaskTitle`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Email`),
  ADD UNIQUE KEY `Email` (`Email`,`UserName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `TaskId` int(5) NOT NULL AUTO_INCREMENT COMMENT 'Task ID', AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
