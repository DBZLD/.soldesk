use q1;

create table visit_info(
	count int,
    lastname char,
    firstname char,
    money int
);

show tables; 
desc visit_info;  
select * from visit_info;
  
insert into visit_info values(1, "u", "s", 0);
insert into visit_info values(1, "u", "s", 0, "m");
insert into visit_info values(1, "u", "s", 0, 0);
alter table visit_info add gender char;
alter table visit_info rename column gender to age;
alter table visit_info modify age int;
alter table visit_info drop column age;
update visit_info set age = 20;

drop table visit_info;
delete from visit_info;