create database riot_match_history default character set utf8mb4;

use riot_match_history;

create table search_DB(
	id char(20) not null,
    tag char(20) not null
);
select *from search_DB;
delete from search_DB;
drop table search_DB;