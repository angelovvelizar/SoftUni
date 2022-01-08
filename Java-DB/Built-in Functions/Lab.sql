#1
SELECT `title` FROM `books`
WHERE `title` LIKE 'The%';

SELECT `title` FROM `books`
WHERE substring(`title`,1,3) = 'The';

#2
SELECT replace(`title`,'The','***') AS `title`
FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;

#3
SELECT round(sum(`cost`), 2) FROM `books`;

#4
SELECT concat_ws(' ',`first_name`, `last_name`) AS `Full Name`,
 timestampdiff(DAY,`born`,`died`)
 FROM `authors`;
 
 #5
 SELECT `title` FROM `books`
 WHERE `title` LIKE 'Harry%';