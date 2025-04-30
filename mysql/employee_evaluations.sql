use employee_manage;

create table evaluations(
	e_name char(10),
    e_writer char(10),
    e_writer_position char(10),
	e_text text,
    e_positive boolean
);

select*from evaluations;
drop table evaluations;
delete from evaluations;