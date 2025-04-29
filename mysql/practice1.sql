create database practice default character set utf8mb4;
use practice;

-- q1
select 도시명 from 도시;

-- q2
select 항해사명, 직급 from 항해사;

-- q3
select 선박명, 선박종류 from 선박;

-- q4
select 교역품명, 기준가격 from 교역품;

-- q5
select*from 항해사 where 직급 = "선장";

-- q6
select*from 선박 where 현재선원수 >= 50;

-- q7
select 교역품명 from 교역품 where 기준가격 >= 1000;

-- q8
select 항해사명 from 항해사 where 도시ID = (select 도시ID from 도시 where 도시명 = "리스본");

-- q9
select 항해사명 from 항해사 where 소속길드ID = (select 길드ID from 길드 where 길드명 = "고양이길드");