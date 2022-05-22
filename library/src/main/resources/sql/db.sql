# jdbc:mariadb://192.168.20.5:3306
drop database if exists Spring;
create database if not exists Spring;

use Spring;
create table if not exists SprUser
(
    id     int auto_increment primary key,
    `name` varchar(10),
    age    int
);


insert into SprUser(name, age)
values ('a', 0);
insert into SprUser(name, age)
values ('b', 1);
insert into SprUser(name, age)
values ('c', 3);

SELECT t.*
FROM Spring.SprUser t;

SELECT t.*
FROM Spring.SprUser t
where id = 1;


SELECT t.*
FROM Spring.SprUser t
where name = 'a';
