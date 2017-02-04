CREATE DATABASE `Library` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `Library`.`Book` (
  `isbn` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `Library`.`Book`
(`isbn`,
`title`,
`price`)
VALUES
(14302, 'Pro JPA 2: Second Edition (Anglais)', 40.27),
(22057, 'Le dernier jour d\'un condamné', 4.3),
(84671, 'Germinal', 19);
