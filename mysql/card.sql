use my_cat;

show tables;

drop table card_my;
create table card_my(
	no int primary key auto_increment,
    job char(20) not null default '전사',
    grade char(20) not null default 'N',
    id char(20) not null default 'cat'
);
select * from card_my;
insert into card_my value();
    