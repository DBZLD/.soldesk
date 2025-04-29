create database employee_manage default character set utf8mb4;

use employee_manage;

create table employee(
	e_name char(20) not null,
    e_age int not null,
    e_gender char(10) not null,
    e_join_date date not null,
    e_position char(10) not null,
    e_annual_income int not null,
    e_evaluations text default null
);
select*from employee;
drop table employee;
delete from employee;
insert into employee(e_name, e_age, e_position, e_gender, e_annual_income, e_join_date) values
("조인수", 29, "주임", "남", 40000000, "2023-11-25"), ("손우혁", 26, "사원", "남", 35000000, "2024-11-20"), ("장혜지", 30, "대리", "여", 50000000, "2023-04-13"),
("오승태", 32, "대리", "남", 60000000, "2023-02-03"), ("임창환", 33, "과장", "남", 70000000, "2021-11-30"), ("조태희", 35, "과장", "여", 70000000, "2021-10-09"),
("황인정", 40, "부장", "남", 90000000, "2022-01-22"), ("임정원", 51, "사장", "남", 110000000, "2022-01-22"), ("조수정", 25, "사원", "여", 35000000, "2024-12-31"),
("양은주", 40, "차장", "여", 80000000, "2022-04-01"), ("손건희", 0, "사장", "남", 0, "2000-01-01");
