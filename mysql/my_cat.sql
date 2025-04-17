create database my_cat default character set utf8mb4;
use my_cat;

-- q32
create table tottenham_squad(
	p_number int,
    p_name char(255)
);
select*from tottenham_squad;
drop table tottenham_squad;
insert into tottenham_squad(p_number, p_name) values(10, "가나다라"), (4, "마바사아");

-- q32.5
create table board(
	b_title char(10),
    b_id char(10),
    b_datetime datetime,
    b_text text,
    b_hit int
);
select*from board
