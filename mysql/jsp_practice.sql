create database my_cat default character set utf8mb4;

use my_cat;

create table cat_board(
	num int primary key auto_increment,
	title char(20),
    content text,
    id char(20)
);

select*from cat_board;
drop table cat_board;
delete from cat_board;

create table cat_board_dao(
	b_no int primary key auto_increment,
    b_title char(20) not null,
    b_id char(20) not null,
    b_datetime date,
    b_hit char(20),
    b_text text,
    b_reply_count int,
    b_reply_ori char(20)
);
insert into cat_board_dao(b_title, b_id, b_text) value("1", "1", "1");
select*from cat_board_dao;
drop table cat_board_dao;
delete from cat_board_dao;

create table tbl_test (		
	no int,	
	str_data varchar(50)	
);		