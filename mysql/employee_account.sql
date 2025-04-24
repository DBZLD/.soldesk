use employee_manager;

create table employee_account(
	e_id char(20),
    e_pw char(20),
    e_admin bool default 0
);
select*from employee_account;
drop table employee_account;
delete from employee_account;
