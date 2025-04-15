create database q2 default character set utf8mb4;
use q2;

create table board_guest(
	primary_key int,
    content char(255),
    writer char(255)
);

select*from board_guest;

insert into board_guest value(1, "안녕", "안");
insert into board_guest value(2, "바이", "가");
insert into board_guest value(3, "하이", "니");

delete from board_guest;