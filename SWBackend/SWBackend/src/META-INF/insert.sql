INSERT INTO `PERSON`
(`ID`,
`BIRTHYEAR`,
`EYECOLOR`,
`GENDER`,
`label`,
`HEIGHT`,
`MASS`,
`NAME`,
`SKINCOLOR`,
`totalHours`,
`rate`,
`totalPay`)
VALUES
(1, "19BBY", "blue", "male", "Senior Developer", 172, 77, "Luke Skywalker", "fair", 37, 10, 370),
(2, "112BBY", "yellow", "n/a", "UI developer", 167, 75, "C-3PO", "gold", 37, 10, 370),
(3, "33BBY", "red", "n/a", "Team Lead", 96, 32, "R2-D2", "white, blue", 22, 20, 440),
(4, "41.9BBY", "yellow", "male", "Intern", 202, 136, "Darth Vader", "white", 24, 5, 120),
(5, "19BBY", "brown", "female", "Intern", 150, 49, "Leia Organa", "light", 27, 5, 135);


INSERT INTO `STARWARS`.`Story`
(`id`,
`name`,
`personId`,
`hours`)
VALUES
(21, "Create Login Page", 1, 28),
(22, "Handle session management", 1, 10),
(32, "Create Student Home page", 2, 21),
(432, "Add/Edit Student page", 2, 0),
(54, "Integrate Backend", 3, 14),
(63, "Resolve UI defects", 4, 14),
(73, "Resolve data corrections", 5, 19);