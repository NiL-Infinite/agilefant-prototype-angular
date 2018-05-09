
CREATE TABLE `PERSON` (
  `ID` int(11) NOT NULL,
  `BIRTHYEAR` varchar(20) DEFAULT NULL,
  `EYECOLOR` varchar(30) DEFAULT NULL,
  `GENDER` varchar(20) DEFAULT NULL,
  `label` varchar(30) DEFAULT NULL,
  `HEIGHT` int(11) DEFAULT NULL,
  `MASS` int(11) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `SKINCOLOR` varchar(30) DEFAULT NULL,
  `totalHours` bigint(10) DEFAULT '0',
  `rate` bigint(10) DEFAULT '0',
  `totalPay` bigint(10) DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Story` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `personId` int(11) NOT NULL,
  `hours` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;