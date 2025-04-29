use practice;

-- q1
insert into 항해사(항해사Id, 항해사명, 직급, 소속길드ID, 도시ID) value( 6, "강항해사", "항해사", 1, 2);

-- q2
insert into 선박(선박ID, 선박명, 선박종류, 도시ID, 현재선원수, 최소필요선원수) value(6, "오션스타호", "플루트", 3, 40, 20);

-- q3
insert into 교역품(교역품ID, 교역품명, 기준가격) value(5, "설탕", 800);

-- q4
insert into 도시(도시ID, 도시명) value(4, "암스테르담");

-- q5
insert into 항해일지(일지ID, 항해사ID, 출항일자, 귀환일자) value(1, 2, "2025-04-20", "2025-04-27");

-- q6
insert into 거래기록(거래ID, 항해사ID, 교역품ID, 수량, 거래가격, 거래일자) value (1, 1, 1, 100, 120000, "2025-04-26");

-- q7
insert into 무기(무기ID, 무기명, 공격력, 가격) value(1, "장검", 150, 3000);

-- q8
insert into 길드원(길드원ID, 길드ID, 항해사ID, 가입일자) value(1, 1, 6, "2025-04-28");

-- q9
insert into 도시건물(건물ID, 도시ID, 건물명, 기능) value(1, 1, "조선소", "선박 수리 및 제작");

-- q10
insert into 보물(보물ID, 보물명, 가치, 발견도시ID, 위도, 경도) value (1, "황금항아리", 50000, 2, 37.3886, -5.9823);