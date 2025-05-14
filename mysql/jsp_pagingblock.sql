create database board_paging default character set utf8mb4;

use board_paging;

create table board(
	b_no int primary key auto_increment,
    b_title char(20) not null default "",
    b_id char(20) not null default "",
    b_datetime date not null default now(),
    b_hit int not null default 0,
    b_text text not null default "",
    b_reply_count int,
    b_reply_ori int
);