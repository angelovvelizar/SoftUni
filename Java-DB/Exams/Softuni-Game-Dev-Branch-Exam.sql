#1
CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `offices`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`workspace_capacity` INT NOT NULL,
`website` VARCHAR(50),
`address_id` INT NOT NULL,
CONSTRAINT fk_offices_addresses
FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`)
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL,
`age` INT NOT NULL,
`salary` DECIMAL(10,2) NOT NULL,
`job_title` VARCHAR(20) NOT NULL,
`happiness_level` CHAR(1) NOT NULL
);

CREATE TABLE `teams`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`office_id` INT NOT NULL,
`leader_id` INT NOT NULL UNIQUE,
CONSTRAINT fk_teams_offices
FOREIGN KEY (`office_id`) REFERENCES `offices`(`id`),
CONSTRAINT fk_teams_employees
FOREIGN KEY (`leader_id`) REFERENCES `employees`(`id`)
);

CREATE TABLE `games`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL UNIQUE,
`description` TEXT,
`rating` FLOAT NOT NULL,
`budget` DECIMAL(10,2) NOT NULL,
`release_date` DATE,
`team_id` INT NOT NULL,
CONSTRAINT fk_games_teams
FOREIGN KEY (`team_id`) REFERENCES `teams`(`id`)
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE `games_categories`(
`game_id` INT,
`category_id` INT,
CONSTRAINT pk_games_categories
PRIMARY KEY (`game_id`, `category_id`),
CONSTRAINT fk_games_categories_games FOREIGN KEY (`game_id`) REFERENCES `games`(`id`),
CONSTRAINT fk_games_categories_categories FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

#2
INSERT INTO `games` (`name`, `rating`, `budget`, `team_id`)
SELECT LOWER(REVERSE(SUBSTR(t.`name`,2))), t.`id`, t.`leader_id` * 1000, t.`id` FROM `teams` AS t
WHERE t.`id` BETWEEN 1 AND 9;

#3
UPDATE `employees` AS e
SET e.`salary` = e.`salary` + 1000
WHERE e.`id` IN(SELECT t.`leader_id` FROM `teams` AS t) AND e.`age` < 40 AND e.`salary` <= 5000;

#4
DELETE FROM `games` AS g
WHERE g.`id` NOT IN(SELECT `game_id` FROM `games_categories`) AND g.`release_date` IS NULL;


#5
SELECT 
    `first_name`,
    `last_name`,
    `age`,
    `salary`,
    `happiness_level`
FROM
    `employees`
ORDER BY `salary` , `id`;

#6
SELECT 
    t.`name`,
    a.`name`,
    CHAR_LENGTH(a.`name`) AS `count_of_characters`
FROM
    `teams` AS t
        JOIN
    `offices` AS o ON t.`office_id` = o.`id`
        JOIN
    `addresses` AS a ON o.`address_id` = a.`id`
WHERE
    o.`website` IS NOT NULL
ORDER BY t.`name` , a.`name`;

#7
SELECT 
    c.`name`,
    COUNT(g.`id`) AS `games_count`,
    ROUND(AVG(g.`budget`), 2) AS `avg_budget`,
    MAX(g.`rating`) AS `max_rating`
FROM
    `games` AS g
        JOIN
    `games_categories` AS gc ON g.`id` = gc.`game_id`
        JOIN
    `categories` AS c ON gc.`category_id` = c.`id`
GROUP BY c.`name`
HAVING `max_rating` >= 9.5
ORDER BY `games_count` DESC , c.`name`;

#8
SELECT 
    g.`name`,
    g.`release_date`,
    CONCAT(LEFT(g.`description`, 10), '...') AS `summary`,
    (CASE
        WHEN MONTH(g.`release_date`) IN (1 , 2, 3) THEN 'Q1'
        WHEN MONTH(g.`release_date`) IN (4 , 5, 6) THEN 'Q2'
        WHEN MONTH(g.`release_date`) IN (7 , 8, 9) THEN 'Q3'
        ELSE 'Q4'
    END) AS `quarter`,
    t.`name`
FROM
    `games` AS g
        JOIN
    `teams` AS t ON g.`team_id` = t.`id`
WHERE
    g.`name` LIKE '%2'
        AND MONTH(g.`release_date`) IN (2 , 4, 6, 8, 10, 12)
        AND YEAR(g.`release_date`) = 2022
ORDER BY `quarter`;

#9
SELECT 
    g.`name`,
    IF(g.`budget` < 50000,
        'Normal budget',
        'Insufficient budget') AS `budget_level`,
    t.`name`,
    a.`name`
FROM
    `games` AS g
        JOIN
    `teams` AS t ON g.`team_id` = t.`id`
        JOIN
    `offices` AS o ON t.`office_id` = o.`id`
        JOIN
    `addresses` AS a ON o.`address_id` = a.`id`
WHERE
    g.`release_date` IS NULL
        AND g.`id` NOT IN (SELECT 
            `game_id`
        FROM
            `games_categories`)
ORDER BY g.`name`;

#10
SELECT 
    CONCAT_WS(' ',
            'The',
            g.`name`,
            'is developed by a',
            t.`name`,
            'in an office with an address',
            a.`name`)
FROM
    `games` AS g
        JOIN
    `teams` AS t ON g.`team_id` = t.`id`
        JOIN
    `offices` AS o ON t.`office_id` = o.`id`
        JOIN
    `addresses` AS a ON o.`address_id` = a.`id`
WHERE
    g.`name` = 'Fix San';
    
#11
UPDATE `games` AS g
SET g.`budget` = g.`budget` + 100000, g.`release_date` = DATE_ADD(g.`release_date`, INTERVAL 1 YEAR)
WHERE g.`id` NOT IN (SELECT `game_id` FROM `games_categories`) AND g.`rating` > 8 AND g.`release_date` IS NOT NULL;

UPDATE games AS g
SET g.budget = g.budget + 100000, g.release_date = DATE_ADD(g.release_date, INTERVAL 1 YEAR)
WHERE g.id NOT IN(SELECT game_id FROM games_categories)
AND g.rating > min_game_rating
AND g.release_date IS NOT NULL;


