use employee_manage;

create table employee_account(
	e_id char(20),
    e_pw char(20),
    e_admin bool default 0
);
select*from employee_account;
drop table employee_account;
delete from employee_account;
insert into employee_account(e_id, e_pw) value("1", "1");
select*from employee_account where e_id = "2";