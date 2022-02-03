CREATE DATABASE `fsd`;

CREATE TABLE `coaches`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0,
`coach_level` INT NOT NULL DEFAULT 0
);

CREATE TABLE `countries`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL
);

CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`country_id` INT NOT NULL,
CONSTRAINT fk_towns_countries
FOREIGN KEY (`country_id`) REFERENCES `countries`(`id`)
);

CREATE TABLE `stadiums`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`capacity` INT NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_stadiums_towns
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `teams`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`established` DATE NOT NULL,
`fan_base` BIGINT NOT NULL,
`stadium_id` INT NOT NULL,
CONSTRAINT fk_teams_stadiums
FOREIGN KEY (`stadium_id`) REFERENCES `stadiums`(`id`)
);

CREATE TABLE `skills_data`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`dribbling` INT,
`pace` INT,
`passing` INT,
`shooting` INT,
`speed` INT,
`strength` INT
);

CREATE TABLE `players`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(10) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`age` INT NOT NULL,
`position` CHAR(1) NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`hire_date` DATETIME,
`skills_data_id` INT NOT NULL,
`team_id` INT,
CONSTRAINT fk_players_skills_data
FOREIGN KEY (`skills_data_id`) REFERENCES `skills_data`(`id`),
CONSTRAINT fk_players_teams
FOREIGN KEY (`team_id`) REFERENCES `teams`(`id`)
);

CREATE TABLE `players_coaches`(
`player_id` INT,
`coach_id` INT,
CONSTRAINT pk_players_coaches
PRIMARY KEY (`player_id`, `coach_id`),
CONSTRAINT fk_players_coaches_players
FOREIGN KEY (`player_id`) REFERENCES `players`(`id`),
CONSTRAINT fk_players_coaches_coaches
FOREIGN KEY (`coach_id`) REFERENCES `coaches`(`id`)
);

#2
INSERT INTO `coaches`(`first_name`,`last_name`,`salary`,`coach_level`)
SELECT `first_name`, `last_name`, `salary` * 2, CHAR_LENGTH(`first_name`)
FROM `players`
WHERE `age` >= 45;

#3
UPDATE `coaches` AS c
JOIN `players_coaches` AS pc
ON c.`id` = pc.`coach_id`
SET `coach_level` = `coach_level` + 1
WHERE pc.`coach_id` IS NOT NULL AND c.`first_name` LIKE 'A%';

#4
DELETE FROM `players` 
WHERE
    `age` >= 45;

#5
SELECT 
    `first_name`, `age`, `salary`
FROM
    `players`
ORDER BY `salary` DESC;


#6
SELECT 
    p.`id`,
    CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`,
    p.`age`,
    p.`position`,
    p.`hire_date`
FROM
    `players` AS p
        JOIN
    `skills_data` AS sd ON p.`skills_data_id` = sd.`id`
WHERE
    p.`age` < 23 AND p.`position` = 'A'
        AND p.`hire_date` IS NULL
        AND sd.`strength` > 50
ORDER BY p.`salary` , p.`age`;


#7
SELECT 
    t.`name` AS `team_name`,
    t.`established`,
    t.`fan_base`,
    COUNT(p.`id`) AS `player_count`
FROM
    `teams` AS t
        LEFT JOIN
    `players` AS p ON t.`id` = p.`team_id`
GROUP BY t.`name`, t.`established`, t.`fan_base`
ORDER BY `player_count` DESC , t.`fan_base` DESC;

#8
SELECT 
    MAX(sd.`speed`) AS `max_speed`, t.`name` AS `town_name`
FROM
    `skills_data` AS sd
        RIGHT JOIN
    `players` AS p ON sd.`id` = p.`skills_data_id`
        RIGHT JOIN
    `teams` AS te ON p.`team_id` = te.`id`
        RIGHT JOIN
    `stadiums` AS s ON te.`stadium_id` = s.`id`
        RIGHT JOIN
    `towns` AS t ON s.`town_id` = t.`id`
WHERE
    te.`name` != 'Devify'
GROUP BY t.`name`
ORDER BY `max_speed` DESC , `town_name`;


#9
SELECT 
    co.`name`,
    COUNT(p.`id`) AS `total_count_of_players`,
    IF(COUNT(p.`id`) <= 0,
        NULL,
        SUM(p.`salary`)) AS `total_sum_of_salaries`
FROM
    `countries` AS co
        LEFT JOIN
    `towns` AS t ON co.`id` = t.`country_id`
        LEFT JOIN
    `stadiums` AS s ON t.`id` = s.`town_id`
        LEFT JOIN
    `teams` AS te ON s.`id` = te.`stadium_id`
        LEFT JOIN
    `players` AS p ON te.`id` = p.`team_id`
GROUP BY co.`name`
ORDER BY `total_count_of_players` DESC , co.`name`;


 #10
 SELECT COUNT(p.`id`) AS `count` FROM `players` AS P
 JOIN `teams` AS t
 ON p.`team_id` = t.`id`
 JOIN `stadiums` AS s
 ON t.`stadium_id` = s.`id`
 WHERE s.`name` = 'Linklinks';
 
 SELECT udf_stadium_players_count('Jaxworks');
 
 #11
 SELECT 
    CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`,
    p.`age`,
    p.`salary`,
    sd.`dribbling`,
    sd.`speed`,
    t.`name` AS `team_name`
FROM
    `players` AS p
        JOIN
    `skills_data` AS sd ON p.`skills_data_id` = sd.`id`
        JOIN
    `teams` AS t ON p.`team_id` = t.`id`
WHERE
    sd.`dribbling` > 20
        AND t.`name` = 'Skyble'
        AND sd.`speed` > (SELECT 
            AVG(`speed`)
        FROM
            `skills_data`)
ORDER BY sd.`speed` DESC
LIMIT 1;

CALL udp_find_playmaker(20, 'Skyble');
 







