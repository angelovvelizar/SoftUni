#1

CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL
);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE drivers(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
age INT NOT NULL,
rating FLOAT
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(10) NOT NULL
);

CREATE TABLE cars(
id INT PRIMARY KEY AUTO_INCREMENT,
make VARCHAR(20) NOT NULL,
model VARCHAR(20),
year INT NOT NULL,
mileage INT,
`condition` CHAR(1) NOT NULL,
category_id INT NOT NULL,
CONSTRAINT fk_cars_categories
FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE cars_drivers(
car_id INT,
driver_id INT,
CONSTRAINT pk_cars_drivers
PRIMARY KEY (car_id,driver_id),
CONSTRAINT fk_cars_drivers_cars
FOREIGN KEY (car_id) REFERENCES cars(id),
CONSTRAINT fk_cars_drivers_drivers
FOREIGN KEY (driver_id) REFERENCES drivers(id)
);

CREATE TABLE courses(
id INT PRIMARY KEY AUTO_INCREMENT,
from_address_id INT NOT NULL,
`start` DATETIME NOT NULL,
car_id INT NOT NULL,
client_id INT NOT NULL,
bill DECIMAL(10,2),
CONSTRAINT fk_courses_addresses
FOREIGN KEY (from_address_id) REFERENCES addresses(id),
CONSTRAINT fk_courses_cars
FOREIGN KEY (car_id) REFERENCES cars(id),
CONSTRAINT fk_courses_clients
FOREIGN KEY (client_id) REFERENCES clients(id)
);

#2
INSERT INTO `clients`(`full_name`,`phone_number`)
SELECT CONCAT_WS(' ', d.`first_name`, d.`last_name`), CONCAT('(088) 9999', d.`id` * 2) FROM `drivers` AS d
WHERE d.`id` BETWEEN 10 AND 20;

#3
UPDATE `cars`
SET `condition` = 'C'
WHERE `mileage` >= 800000 OR `mileage` IS NULL AND `year` <= 2010 AND `make` != 'Mercedes-Benz';

#4
DELETE FROM `clients` AS c
WHERE `id` NOT IN ( SELECT `client_id` FROM `courses`) AND CHAR_LENGTH(`full_name`) > 3;

#5
SELECT 
    `make`, `model`, `condition`
FROM
    `cars`
ORDER BY `id`;

#6
SELECT 
    d.`first_name`,
    d.`last_name`,
    c.`make`,
    c.`model`,
    c.`mileage`
FROM
    `drivers` AS d
        JOIN
    `cars_drivers` AS cs ON d.`id` = cs.`driver_id`
        JOIN
    `cars` AS c ON cs.`car_id` = c.`id`
WHERE
    c.`mileage` IS NOT NULL
ORDER BY c.`mileage` DESC , d.`first_name`;

#7
SELECT 
    c.`id`,
    c.`make`,
    c.`mileage`,
    COUNT(co.`car_id`) AS `count_of_courses`,
    ROUND(AVG(co.`bill`), 2) AS `avg_bill`
FROM
    `cars` AS c
        LEFT JOIN
    `courses` AS co ON c.`id` = co.`car_id`
GROUP BY c.`id`
HAVING `count_of_courses` != 2
ORDER BY `count_of_courses` DESC , c.`id`;

#8
SELECT 
    cl.`full_name`,
    COUNT(co.`car_id`) AS `count_of_cars`,
    SUM(co.`bill`) AS `total_sum`
FROM
    `clients` AS cl
        JOIN
    `courses` AS co ON cl.`id` = co.`client_id`
WHERE
    LEFT(cl.`full_name`, 2) LIKE '%a'
GROUP BY cl.`full_name`
HAVING `count_of_cars` > 1
ORDER BY cl.`full_name`;

#9
SELECT 
    a.`name`,
    IF(HOUR(co.`start`) BETWEEN 6 AND 20,
        'Day',
        'Night') AS `day_time`,
    co.`bill`,
    cl.`full_name`,
    c.`make`,
    c.`model`,
    ca.`name`
FROM
    `addresses` AS a
        JOIN
    `courses` AS co ON a.`id` = co.`from_address_id`
        JOIN
    `clients` AS cl ON co.`client_id` = cl.`id`
        JOIN
    `cars` AS c ON co.`car_id` = c.`id`
        JOIN
    `categories` AS ca ON c.`category_id` = ca.`id`
ORDER BY co.`id`;

#10
SELECT COUNT(co.`id`) FROM `courses` AS co
JOIN `clients` AS cl
ON co.`client_id` = cl.`id`
WHERE cl.`phone_number` = '(831) 1391236'
GROUP BY cl.`phone_number`;

#11
SELECT a.`name`,cl.`full_name`,
(	
	CASE
		WHEN co.`bill` <= 20 THEN 'Low'
        WHEN co.`bill` <=30 THEN 'Medium'
        ELSE 'High'
	END
) AS `level_of_bill`, c.`make`, c.`condition` , ca.`name` FROM `cars` AS c
JOIN `categories` AS ca
ON c.`category_id` = ca.`id`
JOIN `courses` AS co
ON co.`car_id` = c.`id`
JOIN `addresses` AS a
ON co.`from_address_id` = a.`id`
JOIN `clients` AS cl
ON co.`client_id` = cl.`id`
WHERE a.`name` = '66 Thompson Drive'
ORDER BY c.`make`, cl.`full_name`;

