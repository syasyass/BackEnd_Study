-- 기존 컬럼 no에 pk, auto_increment 배정
alter table travel
modify no int auto_increment primary key;

select * from travel;

update travel
set 	
	description = replace(description, ". ", ".<br>");

update travel
set 	
	description = replace(description, "<br>", "");
	
select * from travel
order by rand()
limit 5;

create table tbl_travel_heart (
	tno integer not null,
	username varchar(50) not null,
	constraint primary key(tno, username),
	constraint foreign key (tno) references travel(no),
	constraint foreign key (username) references tbl_member(username)
);

insert into tbl_travel_heart (tno, username)
values (96, 'admin'),
		(97, 'admin'),
		(94, 'admin'),
		(96, 'user00'),
		(97, 'newbie0'),
		(94, 'newbie1');
		
select * from tbl_travel_heart;

-- 여행지 별로 좋아요 수 계산하기
select count(*) hearts, tno
from tbl_travel_heart
group by tno;

-- view로 만들기
create or replace view view_travel_hearts
as
	select count(*) hearts, tno
	from tbl_travel_heart
	group by tno;
	
select * from view_travel_hearts;

-- 여행지 정보와 좋아요 수 결합하기(join)
select t.*, ifnull(hearts, 0) hearts
from travel t left outer join view_travel_hearts h
	on t.no = h.tno;
	
-- view로 만들기
create or replace view view_travel
as
	select t.*, ifnull(hearts, 0) hearts
	from travel t left outer join view_travel_hearts h
	on t.no = h.tno;

-- 확인하기
select * from view_travel;