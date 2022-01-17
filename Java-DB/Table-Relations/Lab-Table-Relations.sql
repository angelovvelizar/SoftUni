USE `camp`;

#1
CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(30) NOT NULL,
`mountain_id` INT NOT NULL,
CONSTRAINT fk_peaks_mountains
FOREIGN KEY (`mountain_id`) REFERENCES `mountains`(`id`)
ON DELETE CASCADE
);

#2
-- SELECT v.`driver_id`, v.`vehicle_type`, (
-- SELECT CONCAT_WS(' ',c.`first_name`,c.`last_name`) AS `driver_name`
-- FROM `campers` AS c
-- WHERE c.`id` = v.`driver_id`
-- ) AS `driver_name`
--  FROM `vehicles` AS v;

SELECT v.`driver_id`, v.`vehicle_type`, CONCAT_WS(' ',c.`first_name`,c.`last_name`)
AS `driver name` FROM `vehicles` AS v
JOIN campers AS c
ON v.`driver_id` = c.`id`;

#3
SELECT r.`starting_point` AS `route_starting_point`, r.`end_point` AS `route_ending_point`,
r.`leader_id`, CONCAT(c.`first_name`, ' ', c.`last_name`) AS `leader_name`
FROM `routes` AS r
JOIN campers AS c
ON r.`leader_id` = c.`id`;

#4
CREATE TABLE `mountains`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `peaks`(
`id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(30) NOT NULL,
`mountain_id` INT NOT NULL,
CONSTRAINT fk_peaks_mountains
FOREIGN KEY (`mountain_id`) REFERENCES `mountains`(`id`)
ON DELETE CASCADE
);

#5
CREATE TABLE `clients`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`client_name` VARCHAR(100)
);

CREATE TABLE `projects`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`client_id` INT,
`project_lead_id` INT,
CONSTRAINT fk_projects_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`project_id` INT,
CONSTRAINT fk_employees_projects
FOREIGN KEY (`project_id`)
REFERENCES `projects`(`id`)
);

ALTER TABLE `projects`
ADD CONSTRAINT fk_projects_employees
FOREIGN KEY (`project_lead_id`)
REFERENCES `employees`(`id`);
