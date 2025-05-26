create database board_paging default character set utf8mb4;

use board_paging;

create table board(
	b_no int primary key auto_increment,
    b_title char(20) not null default "",
    b_id char(20) not null default "",
    b_datetime date,
    b_text text not null
);
 
delete from board;
select*from board;
drop table board;

insert into board(b_title, b_id, b_text) value("1", "1", "1");
