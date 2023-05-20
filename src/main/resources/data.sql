DROP TABLE IF EXISTS users;

CREATE TABLE `users` (
`id` int AUTO_INCREMENT PRIMARY KEY,
`email` varchar(100) NOT NULL,
`first_name` varchar(100) NOT NULL,
`last_name` varchar(100) NOT NULL,
`password` varchar(100) NOT NULL,
`location_id` int
);

CREATE TABLE `locations` (
`id` int AUTO_INCREMENT PRIMARY KEY,
`place` varchar(100) NOT NULL,
`description` varchar(100) NOT NULL,
`longitude` double NOT NULL,
`latitude` double
);

INSERT INTO `users` (`email`, `first_name`, `last_name`, `password`, location_id)
VALUES ('f.amiri@gmail.com', 'farzaneh', 'amiri', 'f123', 1);

INSERT INTO `users` (`email`, `first_name`, `last_name`, `password`, location_id)
VALUES ('r@gmail.com', 'ryan', 'daneshmandian', 'r123', 1);

INSERT INTO `locations` (`place`, `description`, `longitude`, `latitude`)
VALUES ('Pune', 'Pune is great place to live', 40.5, 30.6);