create database roster default character set utf8mb4;
use roster;

create table roster(
	back_number int,
    member_name char(255),
    postion char(255)
);
select*from roster;
delete from roster;
drop table roster;

insert into roster(back_number, member_name, postion) values(4, "데인 스칼렛", "공격수"),
(19, "도미닉 솔란케", "공격수"), (78, "루카 윌리엄스 바넷", "공격수"), (47, "마이키 무어", "공격수"),
(11, "마티스 텔", "공격수"), (22, "브레넌 존슨", "공격수"), (7, "손흥민", "공격수"),
(63, "오인다몰라 아자이", "공격수"), (28, "윌슨 오도베르", "공격수"), (16, "티모 베르너", "공격수"),
(9, "히샬리송", "공격수"), (21, "데얀 쿨루셰프스키", "미드필더"), (30, "로드리고 벤탄쿠르", "미드필더"),
(15, "루카스 베리발", "미드필더"), (57, "리오 키어레마텐", "미드필더"), (14, "아치 그레이", "미드필더"),
(8, "이브스 비수마", "미드필더"), (10, "제임스 매디슨", "미드필더"), (64, "칼럼 라티프 올루시", "미드필더"),
(49, "티레시 홀", "미드필더"), (29, "파페 마타르 사르", "미드필더"), (59, "단테 카스사노바", "수비수"),
(13, "데스티니 우도기", "수비수"), (6, "라두 드라구신", "수비수"), (79, "마라치 하디", "수비수"),
(74, "메이슨 킹", "수비수"), (37, "미키 판 더 펜", "수비수"), (33, "벤 데이비스", "수비수"),
(3, "세르히오 레길론", "수비수"), (24, "제드 스펜스", "수비수"), (4, "케빈 단소", "수비수"),
(17, "크리스티안 로메로", "수비수"), (23, "페드로 포로", "수비수"), (1, "굴리엘모 비카리오", "골키퍼"),
(40, "브랜든 오스틴", "골키퍼"), (56, "아론 마구레", "골키퍼"), (31, "안토닌 킨스키", "골키퍼"),
(41, "알피 화이트먼", "골키퍼"), (20, "프레이저 포스터", "골키퍼");

-- q5
select*from roster where postion = "공격수"; -- postion이 '공격수'인 행 출력

-- q6
delete from roster where back_number = 7; -- back_number가 7인 행 삭제

-- q7
update roster set member_name = '로드리고밴탄쿠르' where back_number = 30; -- back_number가 30인 행의 member_name을 '로드리고밴탄쿠르'로 변경

-- q8
select*from roster where back_number >= 7; -- back_number가 7보다 크거나 같은 행 출력

-- q9
select*from roster where back_number >= 6 and member_name like '%제%'; -- back_number가 6과 크거나 같고 member_name에 '제'를 포함한 행 출력

-- q10
alter table roster add weekly_pay int default 0 not null; -- weekly_pay필드 추가(int, 기본 값 0, null 불가)

-- q11
select*from roster order by back_number; -- back_number 오름차순 출력(default)
select*from roster order by back_number asc; -- back_number 오름차순 출력
select*from roster order by back_number desc; -- back_number 내림차순 출력

alter table roster add member_height int default 0; -- member_height 필드 생성(int, 기본값 0)
alter table roster add member_weight int default 0; -- member_weight 필드 생성(int, 기본값 0)
update roster set member_height = 180, member_weight = 76 where member_name = "데인 스칼렛";
update roster set member_height = 187, member_weight = 80 where member_name = "도미닉 솔란케";
update roster set member_height = 175, member_weight = 74 where member_name = "루카 윌리엄스 바넷";
update roster set member_height = 180, member_weight = 75 where member_name = "마이키 무어";
update roster set member_height = 183, member_weight = 77 where member_name = "마티스 텔";
update roster set member_height = 179, member_weight = 73 where member_name = "브레넌 존슨";
update roster set member_height = 183, member_weight = 78 where member_name = "손흥민";
update roster set member_height = 176, member_weight = 75 where member_name = "오인다몰라 아자이";
update roster set member_height = 182, member_weight = 77 where member_name = "윌슨 오도베르";
update roster set member_height = 180, member_weight = 75 where member_name = "티모 베르너";
update roster set member_height = 184, member_weight = 71 where member_name = "히샬리송";
update roster set member_height = 186, member_weight = 75 where member_name = "데얀 쿨루셰프스키";
update roster set member_height = 187, member_weight = 77 where member_name = "로드리고 벤탄쿠르";
update roster set member_height = 186, member_weight = 90 where member_name = "루카스 베리발";
update roster set member_height = 174, member_weight = 68 where member_name = "리오 키어레마텐";
update roster set member_height = 187, member_weight = 79 where member_name = "아치 그레이";
update roster set member_height = 182, member_weight = 72 where member_name = "이브스 비수마";
update roster set member_height = 175, member_weight = 73 where member_name = "제임스 매디슨";
update roster set member_height = 175, member_weight = 65 where member_name = "프레이저 포스터";
update roster set member_height = 185, member_weight = 70 where member_name = "파페 마타르 사르";
update roster set member_height = 179, member_weight = 66 where member_name = "단테 카스사노바";
update roster set member_height = 186, member_weight = 80 where member_name = "데스티니 우도기";
update roster set member_height = 190, member_weight = 84 where member_name = "라두 드라구신";
update roster set member_height = 188, member_weight = 79 where member_name = "마라치 하디";
update roster set member_height = 176, member_weight = 74 where member_name = "메이슨 킹";
update roster set member_height = 193, member_weight = 81 where member_name = "미키 판 더 펜";
update roster set member_height = 181, member_weight = 76 where member_name = "벤 데이비스";
update roster set member_height = 178, member_weight = 68 where member_name = "세르히오 레길론";
update roster set member_height = 184, member_weight = 79 where member_name = "제드 스펜스";
update roster set member_height = 190, member_weight = 85 where member_name = "케빈 단소";
update roster set member_height = 185, member_weight = 79 where member_name = "크리스티안 로메로";
update roster set member_height = 173, member_weight = 71 where member_name = "페드로 포로";
update roster set member_height = 188, member_weight = 83 where member_name = "굴리엘모 비카리오";
update roster set member_height = 188, member_weight = 82 where member_name = "브랜든 오스틴";
update roster set member_height = 190, member_weight = 84 where member_name = "안토닌 킨스키";
update roster set member_height = 189, member_weight = 84 where member_name = "알피 화이트먼";
update roster set member_height = 201, member_weight = 93 where member_name = "프레이저 포스터";

select*from roster order by member_height desc, member_weight; -- member_height 내림차순, 같으면 member_weight 오름차순으로 출력

-- q12
update roster set weekly_pay = 1000 where member_name = "데인 스칼렛";
update roster set weekly_pay = 1500 where member_name = "오인다몰라 아자이";
update roster set weekly_pay = 900 where member_name = "알피 화이트먼";
update roster set weekly_pay = 500 where member_name = "브랜든 오스틴";
update roster set weekly_pay = 3000 where member_name = "루카스 베리발";
update roster set weekly_pay = 2600 where member_name = "프레이저 포스터";
update roster set weekly_pay = 2000 where member_name = "알피 화이트먼";
update roster set weekly_pay = 300 where member_name = "페드로 포로";
update roster set weekly_pay = 4200 where member_name = "미키 판 더 펜";
update roster set weekly_pay = 1000 where member_name = "리오 키어레마텐";
update roster set weekly_pay = 2300 where member_name = "루카 윌리엄스 바넷";

select*from roster order by weekly_pay desc; -- weekly_pay 내림차순으로 출력

-- q13 ~ 15
alter table roster add _id int primary key auto_increment; -- _id 필드 추가

alter table roster add yearly_pay int default 0 not null; -- yearly_pay 필드 추가

-- q16
select back_number from roster; -- back_number 필드 출력
select back_number as 등번호, member_name as 선수명 from roster; -- 등번호(back_number), 선수명(member_name)필드 출력

-- q17
update roster set weekly_pay = 2600 where member_name = "마티스 텔";
update roster set weekly_pay = 2600 where member_name = "마라치 하디";

select weekly_pay as 주급 from roster; -- 주급(weekly_pay)필드 출력
select distinct weekly_pay as 주급 from roster; -- 주급(weekly_pay)필드 출력(중복 제거)

-- q18
select back_number as 등번호, member_name as 선수명, weekly_pay as 주급 from roster; -- 등번호(back_number), 선수명(member_name), 주급(weekly_pay)필드 출력

-- q19
select back_number as 등번호, member_name as 선수명, weekly_pay/7 as 일급 from roster; -- 등번호(back_number), 선수명(member_name), 일급(weekly_pay/7)필드 출력

-- q20
select back_number as 등번호, member_name as 선수명, round(weekly_pay/7) as 일급 from roster; -- 일급(weekly_pay/7) 반올림 후 출력
select back_number as 등번호, member_name as 선수명, floor(weekly_pay/7) as 일급 from roster; -- 일급(weekly_pay/7) 버림 후 출력

-- q21
select back_number, member_name from roster where weekly_pay > 1000 and weekly_pay/7 > 130; -- weekly_pay가 1000이상이고 weekly_pay/7이 130 이상인 행의 back_number, member_name 출력

-- q22
select back_number, member_name from roster where weekly_pay > 500; -- weekly_pay가 1000이상인 행의 back_number, member_name 출력

-- q23
alter table roster add _injury char(1) default "n"; -- _injury(char(1), 기본값 'n')필드 생성

update roster set _injury = "y" where member_name = "마이키 무어";
update roster set _injury = "y" where member_name = "윌슨 오도베르";
update roster set _injury = "y" where member_name = "메이슨 킹";
update roster set _injury = "y" where member_name = "케빈 단소";
update roster set _injury = "y" where member_name = "프레이저 포스터";

select*from roster where _injury = "y"; -- _injury가 "y"인 행 출력
select*from roster where _injury = "n"; -- _injury가 "n"인 행 출력

-- q24
select*from roster where member_name like '%손%' union select*from roster where member_name like '%케%'; -- member_name에 '손'이 포함된 행과 '케'가 포함된 행을 합쳐서 출력

-- q25
select now() from dual;
select curdate() from dual;
select curtime() from dual;
select date_format(now(), '%Y-%m-%d %H:%i:%s') as date_format from dual;

-- q26
alter table roster add _injury char(1);
alter table roster drop _injury;

select ifnull(_injury,'n') from roster; -- _injury가 null일 경우 'n'으로 바꿔 출력
select ifnull(_injury,'출전 가능') 부상여부 from roster; -- _injury가 null일 경우 '출전 가능'으로 바꿔 출력

-- q27
select sum(weekly_pay), count(weekly_pay), max(weekly_pay), min(weekly_pay), avg(weekly_pay) from roster;

-- q28
select sum(weekly_pay), count(weekly_pay), max(weekly_pay), min(weekly_pay), avg(weekly_pay) from roster where postion = "공격수";

-- q29
select sum(distinct weekly_pay), count(distinct weekly_pay), max(weekly_pay), min(weekly_pay), avg(distinct weekly_pay) from roster;