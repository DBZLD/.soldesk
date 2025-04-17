create database board default character set utf8mb4;
use board;

-- q30
create table post (
	_no int primary key auto_increment,
    b_title char(20) not null,
    b_writer char(10) not null,
    b_date datetime not null,
    b_content text,
    b_view text
);

insert into post(_title, _writer, _date, _view, _content) value("제목1", "저자1", now(), 4, "내용1");
insert into post(_title, _writer, _date, _view, _content) value("제목2", "저자2", now(), 3, "내용2");
insert into post(_title, _writer, _date, _view, _content) value("제목3", "저자3", now(), 1, "내용3");

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
select*from post;
insert into post(_title, _writer, _date, _view, _content, comments_count, comments_post_no, comments_content) value("제목1", "저자1", now(), 4, "내용1", 3, 1, "댓글1");
insert into post(_title, _writer, _date, _view, _content, comments_count, comments_post_no, comments_content) value("제목2", "저자2", now(), 4, "내용2", 4, 2, "댓글2");
insert into post(_title, _writer, _date, _view, _content, comments_count, comments_post_no, comments_content) value("제목3", "저자3", now(), 4, "내용3", 2, 3, "댓글3");

-- q32
create table tottenham_squad(
	p_number int,
    p_name char(255)
);
select*from tottenham_squad;
drop table tottenham_squad;
insert into tottenham_squad(p_number, p_name) values(10, "가나다라"), (4, "마바사아");

-- q33
create table board(
	b_title char(10),
    b_id char(10),
    b_datetime datetime,
    b_text text,
    b_hit int
);
select*from board;
delete from board;