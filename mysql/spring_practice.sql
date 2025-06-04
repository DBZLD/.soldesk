use my_cat;

create table tbl_test (		
	no int,	
	str_data varchar(50)	
);

insert into tbl_test values(1,'1');		
insert into tbl_test values(2,'2');		
insert into tbl_test values(3,'100');		
insert into tbl_test values(4,'HELLO WORLD');
select*from tbl_test;

create table tbl_visitant_count (				
	count int			
);
insert into tbl_visitant_count values(0);				
select * from tbl_visitant_count;

create table tbl_doodle (
	str varchar(500)	
);		
		
select * from tbl_doodle;

create table tbl_test_del (				
	no int,			
	str varchar(500)			
);				
insert into tbl_test_del values(1, '개');				
insert into tbl_test_del values(2, '고양이');				
insert into tbl_test_del values(3, '너굴맨');				
				
select * from tbl_test_del;

create table tbl_guest(
	bno int auto_increment primary key,
	btext text
);

insert into tbl_guest(btext) value('개');
insert into tbl_guest(btext) value('고양이');