-- Query to create database for Hotel Management System App!!!


CREATE DATABASE IF NOT EXISTS hotel;

-- USE DATABASE hotel;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerId` varchar(16) NOT NULL,
  `Name` varchar(16) NOT NULL,
  `RoomNumber` int(3) NOT NULL,
  `CheckInTime` varchar(10) NOT NULL,
  `CheckOutTime` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EmployeeId` varchar(16) NOT NULL,
  `Name` varchar(16) NOT NULL,
  `JobCategory` varchar(16) NOT NULL,
  `Salary` int(8) NOT NULL,
  `Phone` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EmployeeId`, `Name`, `JobCategory`, `Salary`, `Phone`) VALUES
('m1', 'Nguyen Van A', 'Manager', 10000000, 0926754318),
('m2', 'Le Van B', 'Manager', 9500000, 0987625678),
('r1', 'Bui Thi C', 'Receptionist', 6000000, 0111222119),
('r2', 'Hoang Van D', 'Cashier', 4000000, 0987655431),
('rc1', 'Ngo Thi E', 'Room Cleaner', 3500000, 0981010109);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `RoomNumber` int(3) NOT NULL,
  `Availability` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`RoomNumber`, `Availability`) VALUES
(101, 0),
(102, 1),
(103, 2),
(104, 1),
(105, 0),
(106, 1),
(107, 2),
(108, 1),
(109, 1),
(110, 0),
(201, 1),
(202, 1),
(203, 1),
(204, 1),
(205, 1),
(206, 1),
(207, 1),
(208, 1),
(209, 1),
(210, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uId` varchar(16) NOT NULL,
  `uPassword` varchar(16) NOT NULL,
  `uStatus` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uId`, `uPassword`, `uStatus`) VALUES
('m1', '1234', 1),
('m2', '15054254', 1),
('r1', '9999', 2),
('r2', '13826539', 3),
('rc1', '9191', 3);

-- --------------------------------------------------------

--
-- Table structure for table `cusOrder`
--

CREATE TABLE `cusOrder` (
    `roomID` int(10) NOT NULL,
    `laundry` int(10) NOT NULL,
    `cleaning` int(10) NOT NULL,
    `juice` int(10) NOT NULL,
    `milk` int(10) NOT NULL,
    `food` varchar(50)
);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerId`),
  ADD UNIQUE KEY `UNIQUE` (`RoomNumber`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EmployeeId`),
  ADD UNIQUE KEY `UNIQUE` (`Phone`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`RoomNumber`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uId`);
COMMIT;

-- --------------------------------------------------------
