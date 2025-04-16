create database board default character set utf8mb4;
use board;

-- q31
create table post (
	_no int primary key auto_increment,
    _title char(20) not null,
    _writer char(10) not null,
    _date datetime not null,
    _view text,
    _content text,
    comments_count int,
    comments_post_no int,
    comments_content text
);