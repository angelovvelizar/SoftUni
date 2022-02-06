CREATE DATABASE `softuni_stores_system`;

#1
CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (`town_id`) REFERENCES `towns`(`id`)
);

CREATE TABLE `stores`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`rating` FLOAT NOT NULL,
`has_parking` TINYINT,
`address_id` INT NOT NULL,
CONSTRAINT fk_stores_addresses
FOREIGN KEY (`address_id`) REFERENCES `addresses`(`id`)
);

CREATE TABLE `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(15) NOT NULL,
`middle_name` CHAR(1),
`last_name` VARCHAR(20) NOT NULL,
`salary` DECIMAL(19,2) NOT NULL,
`hire_date` DATE NOT NULL,
`manager_id` INT,
`store_id` INT NOT NULL,
CONSTRAINT fk_employees_employees
FOREIGN KEY (`manager_id`) REFERENCES `employees`(`id`),
CONSTRAINT fk_employees_stores
FOREIGN KEY (`store_id`) REFERENCES `stores`(`id`)
);

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL
);

CREATE TABLE `pictures`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`url` VARCHAR(100) NOT NULL,
`added_on` DATETIME NOT NULL
);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`best_before` DATE,
`price` DECIMAL(10,2) NOT NULL,
`description` TEXT,
`category_id` INT NOT NULL,
`picture_id` INT NOT NULL,
CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`),
CONSTRAINT fk_products_pictures
FOREIGN KEY (`picture_id`) REFERENCES `pictures`(`id`)
);

CREATE TABLE `products_stores`(
`product_id` INT,
`store_id` INT,
CONSTRAINT pk_products_stores
PRIMARY KEY (`product_id`, `store_id`),
CONSTRAINT fk_products_stores_products
FOREIGN KEY (`product_id`) REFERENCES products(id),
CONSTRAINT fk_products_stores_stores
FOREIGN KEY (store_id) REFERENCES stores(id)
);

#2
INSERT INTO `products_stores`
SELECT `id`, 1 FROM `products`
WHERE `id` NOT IN (SELECT `product_id` FROM `products_stores`);

#3
UPDATE `employees` AS e
SET e.`manager_id` = 3, e.`salary` = e.`salary` - 500
WHERE YEAR(e.`hire_date`) > 2003 AND e.`store_id` NOT IN(SELECT s.`id` FROM `stores` AS s WHERE s.`name` = 'Cardguard' OR s.`name` = 'Veribet');

#4
DELETE FROM `employees`
WHERE `manager_id` IS NOT NULL AND `salary` >= 6000;

#5
SELECT `first_name`, `middle_name`, `last_name`, `salary`, `hire_date` FROM `employees`
ORDER BY `hire_date` DESC;

#6
SELECT 
    pr.`name` AS `product_name`,
    pr.`price`,
    pr.`best_before`,
    CONCAT(LEFT(pr.`description`, 10), '...') AS `short_description`,
    pi.`url`
FROM
    `products` AS pr
        JOIN
    `pictures` AS pi ON pr.`picture_id` = pi.`id`
WHERE
    CHAR_LENGTH(pr.`description`) > 100
        AND YEAR(pi.`added_on`) < 2019
        AND pr.`price` > 20
ORDER BY pr.`price` DESC; 


#7
SELECT 
    s.`name`,
    COUNT(ps.`product_id`) AS `product_count`,
    ROUND(AVG(p.`price`), 2) AS `avg`
FROM
    `stores` AS s
        LEFT JOIN
    `products_stores` AS ps ON s.`id` = ps.`store_id`
        LEFT JOIN
    `products` AS p ON ps.`product_id` = p.`id`
GROUP BY s.`name`
ORDER BY `product_count` DESC , `avg` DESC , s.`id`;


#8
SELECT 
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `full_name`,
    s.`name` AS `store_name`,
    a.`name`,
    e.`salary`
FROM
    `employees` AS e
        JOIN
    `stores` AS s ON e.`store_id` = s.`id`
        JOIN
    `addresses` AS a ON s.`address_id` = a.`id`
WHERE
    e.`salary` < 4000
        AND a.`name` LIKE '%5%'
        AND CHAR_LENGTH(s.`name`) > 8
        AND e.`last_name` LIKE '%n';
        
#9
SELECT 
    REVERSE(s.`name`) AS `reversed_name`,
    CONCAT(UPPER(t.`name`), '-', a.`name`) AS `full_address`,
    COUNT(e.`id`) AS `employees_count`
FROM
    `stores` AS s
        JOIN
    `addresses` AS a ON s.`address_id` = a.`id`
        JOIN
    `towns` AS t ON a.`town_id` = t.`id`
        JOIN
    `employees` AS e ON s.`id` = e.`store_id`
GROUP BY s.`name`
HAVING `employees_count` >= 1
ORDER BY `full_address`;

#10
DELIMITER $$
CREATE FUNCTION `udf_top_paid_employee_by_store` (store_name VARCHAR(50))
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN

RETURN (SELECT CONCAT_WS(' ', e.`first_name`, CONCAT(e.`middle_name`, '.'), e.`last_name`,'works in store for', 2020 - YEAR(e.`hire_date`),'years') AS `full_info` FROM `employees` AS e
JOIN `stores` AS s
ON e.`store_id` = s.`id`
WHERE s.`name` = store_name
ORDER BY e.`salary` DESC
LIMIT 1);
END $$

DELIMITER ;

#11
UPDATE `products` AS p
JOIN `products_stores` AS ps
ON p.`id` = ps.`product_id`
JOIN `stores` AS s
ON ps.`store_id` = s.`id`
JOIN `addresses` AS a
ON s.`address_id` = a.`id`
SET p.`price` = IF(LEFT('Cody Pass',1) = '0', p.`price` + 100, p.`price` + 200);








