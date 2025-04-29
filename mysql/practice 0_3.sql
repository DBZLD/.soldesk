use practice;

-- q1
INSERT INTO 항해사 (항해사ID, 항해사명, 직급, 소속길드ID, 도시ID) VALUES (99, '삭제대상항해사', '항해사', 1, 1);
delete from 항해사 where 항해사명 = "삭제대상항해사";

-- q2
INSERT INTO 선박 (선박ID, 선박명, 선박종류, 도시ID, 현재선원수, 최소필요선원수) VALUES (99, '삭제대상호', '갤리온', 1, 30, 15);
delete from 선박 where 선박명 = "삭제대상호";

-- q3
INSERT INTO 교역품 (교역품ID, 교역품명, 기준가격) VALUES (99, '삭제대상교역품', 999);
delete from 교역품 where 교역품명 = "삭제대상교역품";

-- q4
INSERT INTO 도시 (도시ID, 도시명) VALUES (99, '삭제대상도시');
delete from 도시 where 도시명 = "삭제대상도시";

-- q5
INSERT INTO 항해일지 (일지ID, 항해사ID, 출항일자, 귀환일자) VALUES (99, 1, '2019-12-30', '2020-01-02');
delete from 항해일지 where 출항일자 < "2020-01-01";

-- q6
INSERT INTO 무기 (무기ID, 무기명, 공격력, 가격) VALUES (99, '삭제대상무기', 50, 800);
delete from 무기 where 가격 < 1000;

-- q7
INSERT INTO 선박업그레이드 (업그레이드ID, 선박ID, 업그레이드명, 업그레이드날짜) VALUES (99, 1, '구형강화', '2019-12-01');
delete from 선박업그레이드 where 업그레이드날짜 < "2020-01-01";

-- q8
INSERT INTO 길드원 (길드원ID, 길드ID, 항해사ID, 가입일자) VALUES (99, 1, 1, '2019-11-30');
delete from 길드원 where 가입날짜 < "2020-01-01";

-- q9
INSERT INTO 도시건물 (건물ID, 도시ID, 건물명, 기능) VALUES (99, 1, '삭제대상건물', '없음');
delete from 도시건물 where 기능 = "없음";

-- q10
INSERT INTO 보물 (보물ID, 보물명, 가치, 발견도시ID, 위도, 경도) VALUES (99, '삭제대상보물', 10000, 1, 0.000000, -5.982300);
delete from 보물 where 위도 = 0 or 경도 = 0;