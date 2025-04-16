create database q3 default character set utf8mb4;
use q3;

create table member(
	_no int primary key auto_increment,
    id char(255) not null unique,
    _name char(255) not null,
    age int not null,
    gender char(255) not null,
    phone_number char(255) not null,
    hobby char(255) not null
);

insert into member(_no, id, _name, age, gender, phone_number, hobby) value(1, "A", "김", 29, "남", "010-1234-1111", "none");
insert into member(_no, id, _name, age, gender, phone_number, hobby) value(2, "B", "이", 21, "여", "010-5665-1223", "none");
insert into member(_no, id, _name, age, gender, phone_number, hobby) value(3, "C", "박", 27, "여", "010-7899-0011", "none");

select*from member;
delete from member;