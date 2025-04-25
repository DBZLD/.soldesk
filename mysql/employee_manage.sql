create database employee_manage default character set utf8mb4;

use employee_manage;

create table employee(
	e_no int primary key auto_increment,
	e_name char(20),
    e_age int,
    e_position char(10),
    e_annual_income int,
    e_gender char(2),
    e_evaluations text,
    e_evaluations_count int 
);
select*from employee;
drop table employee;
delete from employee;
insert into employee(e_name) value("가나다");
