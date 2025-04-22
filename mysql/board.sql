-- create database board default character set utf8mb4;
use board;

create table board(
	b_no int primary key auto_increment,
	b_title char(10) not null,
    b_id char(10) not null,
    b_datetime datetime not null,
    b_text text not null
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

create table market(
	b_no int primary key auto_increment,
	b_title char(10) not null,
    b_id char(10) not null,
    b_datetime datetime not null,
    b_text text not null
);