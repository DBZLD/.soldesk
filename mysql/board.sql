-- create database board default character set utf8mb4;
use board;

create table board(
	b_no int primary key auto_increment,
	b_title char(10),
    b_id char(10),
    b_datetime datetime,
    b_text text
);
select*from board;
delete from board;
drop table board;

create table comments(
	b_board_no int(10),
    b_id char(10),
    b_text text
);

select*from comments;
delete from comments;
drop table comments;

create table users(
	b_id text,
    b_pw text
);
select*from users;
delete from users;
drop table users;

insert into comments(b_board_no, b_id, b_text) value(2, 'qq', 'asdfgh');
insert into comments(b_board_no, b_id, b_text) value(2, 'ee', 'aassss');
insert into comments(b_board_no, b_id, b_text) value(3, 'ww', '1323123');

select count(1) from board;