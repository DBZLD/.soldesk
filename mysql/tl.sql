create database tl default character set utf8mb4;

use tl;

CREATE TABLE IF NOT EXISTS performance (
  per_num       BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  per_id		VARCHAR(200) NOT NULL,
  per_genreC	VARCHAR(50) DEFAULT NULL,
  per_regionC	VARCHAR(50) DEFAULT NULL,
  per_requestT	VARCHAR(50) DEFAULT NULL,
  per_title     VARCHAR(200) NOT NULL,
  per_startD    VARCHAR(50) NOT NULL,
  per_endD      VARCHAR(50)	NOT NULL,
  per_place     VARCHAR(500) NOT NULL,
  per_runT      VARCHAR(50),
  per_sche      TEXT,
  per_price     VARCHAR(500),
  per_genre     VARCHAR(50),
  per_poster    VARCHAR(1000),
  per_address   VARCHAR(255),
  per_latitude  DECIMAL(11,8),
  per_longitude DECIMAL(11,8),
  per_region    VARCHAR(50),
  per_rank      INT DEFAULT NULL
);
select *from performance;
delete from performance;
drop table performance;

CREATE TABLE IF NOT EXISTS performance_ticket (
  ticket_num   BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  per_num      BIGINT UNSIGNED NOT NULL,
  ticket_name VARCHAR(200),
  ticket_url  VARCHAR(1000),
  FOREIGN KEY (per_num) REFERENCES performance(per_num) ON DELETE CASCADE
);
select *from performance_ticket;
delete from performance_ticket;
drop table performance_ticket;

-- insert into performance(per_id, per_title, per_startD, per_endD, per_place, per_updateD) value("P1234", "test", "2025", "2025.10.01", "test", "test");
-- select count(*)from performance where per_genreC = "GGGA" and per_requestT = "";
-- select* from performance where per_runT = "1시간";
