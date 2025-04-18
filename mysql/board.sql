create database board default character set utf8mb4;
use board;

create table board(
	b_no int primary key auto_increment,
	b_title char(10),
    b_id char(10),
    b_datetime datetime,
    b_text text
);
create table comments(
	b_post_no int(10),
    b_text text
);
select count(1) from board;
select*from board;
delete from board;
drop table board;

select*from comments;
delete from comments;
drop table comments;