use practice;

-- q1
update 항해사 set 직급 = "선장" where 항해사명 = "김항해사";

-- q2
update 선박 set 현재선원수 = 60 where 선박명 = "블루오션호";

-- q3
update 교역품 set 기준가격 = 1100 where 교역품명 = "향신료";

-- q4
update 도시 set 도시명 = "신리스본" where 도시명 = "리스본";

-- q5
update 항해일지 set 귀환일자 = "2025-05-01" where 항해사ID = 2;

-- q6
update 무기 set 가격 = 가격 * 0.9 where 무기명 = "장검";

-- q7
update 선박업그레이드 set 업그레이드명 = "신형강화" where 업그레이드명 = "구형강화";

-- q8
update 길드원 set 가입일자 = "2025-05-01" where 항해사ID = 6;

-- q9
update 도시건물 set 기능 = "최신 선박 제작" where 건물명 = "조선소";

-- q10
update 보물 set 위도 = -9.1399, 경도 = 38.7169 where 보물명 = "황금항아리";