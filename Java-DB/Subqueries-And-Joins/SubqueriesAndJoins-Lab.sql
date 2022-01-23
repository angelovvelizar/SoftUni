#1
SELECT 
    e.`employee_id`,
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `full_name`,
    d.`department_id`,
    d.`name`
FROM
    `employees` AS e
        JOIN
    `departments` AS d ON e.`employee_id` = d.`manager_id`
ORDER BY `employee_id`
LIMIT 5;

#2
SELECT 
    t.`town_id`, t.`name` AS `town_name`, a.`address_text`
FROM
    `towns` AS t
        JOIN
    `addresses` AS a ON t.`town_id` = a.`town_id`
WHERE
    t.`name` IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY t.`town_id` , a.`address_id`;

#3
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, e.`department_id`, e.`salary` 
FROM `employees` AS e
WHERE e.`manager_id` IS NULL;

#4
SELECT COUNT(*) AS `count` FROM `employees`
WHERE `salary` > (SELECT AVG(`salary`) FROM `employees`);