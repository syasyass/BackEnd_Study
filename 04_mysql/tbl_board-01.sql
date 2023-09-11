use glory_db;

drop table if exists tbl_board;

create table tbl_board(
bno integer auto_increment,
title varchar(200) not null,
content text not null,
writer varchar(50) not null,
reg_date datetime default now(),
update_date datetime default now(),
constraint pk_board primary key(bno)
);

insert into tbl_board(title, content, writer)
values('테스트제목', '테스트내용', 'user00');

insert into tbl_board(title, content, writer)
values('테스트제목2', '테스트내용2', 'user02');

insert into tbl_board(title, content, writer)
values('테스트제목3', '테스트내용3', 'user03');

insert into tbl_board(title, content, writer)
values('테스트제목4', '테스트내용4', 'user04');

-- 전체 목록보기
select * from tbl_board
order by bno desc; -- order by reg_date desc (increment 때문)

-- 페이지 목록보기
select * from tbl_board
order by bno desc
limit 0, 10; -- offset, count

-- 전체 데이터 건수
select count(*) as total_count from tbl_board;

-- 상세보기
select * from tbl_board
where bno = 1;

-- 검색(title, content)
select * from tbl_board
where title like '%내용%' or	content like '%내용%'
order by bno desc
limit 0, 10;

-- 수정
update tbl_board
set 
	title = '수정한 타이틀',
	content = '수정한 내용',
	update_date = now()
where bno = 1;

select * from tbl_board;

-- 삭제
delete from tbl_board 
where bno = 1;