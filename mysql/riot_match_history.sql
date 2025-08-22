create database riot_match_history default character set utf8mb4;

use riot_match_history;

-- 검색어　포함　검색　결과　저장　ＤＢ 
create table search_DB(
	id char(20) not null,
    tag char(20) not null,
    icon char(255) not null,
	regalia char(20) not null
);
select *from search_DB;
delete from search_DB;
drop table search_DB;

-- 사이트　계정　ＤＢ 
create table account_DB(
	id char(50) not null,
    pw char(50) not null,
    email char(50) not null,
    riotAccount char(40) default null
);
select *from account_DB;
delete from account_DB;
drop table account_DB;