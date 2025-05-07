use employee_manage;

create table employee_account(
	e_id char(20) primary key,
    e_pw char(20) not null
);
select*from employee_account;
drop table employee_account;
delete from employee_account;