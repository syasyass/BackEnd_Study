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

drop table if exists tbl_member;
create table tbl_member(
	username varchar(50) primary key,
	password varchar(128) not null,
	email varchar(50) not null,
	reg_date datetime default now(),
	update_date datetime default now()
);

drop table if exists tbl_member_auth;
create table tbl_member_auth(
	username varchar(50) not null,
	auth varchar(50) not null,
	primary key(username, auth),
	constraint fk_authorities_users foreign key (username)
			references tbl_member(username)
);

select distinct writer from tbl_board
order by writer;

insert into tbl_member(username, password, email)
values
	('admin', '1234', 'admin@galapagos.org'),
	('user00', '1234', 'user00@galapagos.org'),
	('newbie', '1234', 'newbie@galapagos.org'),
	('newbie0', '1234', 'newbie0@galapagos.org'),
	('newbie1', '1234', 'newbie1@galapagos.org'),
	('newbie2', '1234', 'newbie2@galapagos.org'),
	('newbie3', '1234', 'newbie3@galapagos.org'),
	('newbie4', '1234', 'newbie4@galapagos.org');
	
select * from tbl_member;

update tbl_member
set password = '$2a$10$YpK24Ik1JCkZUCSMM5rEI.1lRLVdiamjr.Fp0SIqD7b3KFVr7yqx6';

insert into tbl_member_auth(username, auth)
values
	('admin', 'ROLE_ADMIN'),
	('admin', 'ROLE_MANAGER'),
	('admin', 'ROLE_USER'),
	('user00', 'ROLE_MANAGER'),
	('user00', 'ROLE_USER'),
	('newbie', 'ROLE_USER'),
	('newbie0', 'ROLE_USER'),
	('newbie1', 'ROLE_USER'),
	('newbie2', 'ROLE_USER'),
	('newbie3', 'ROLE_USER'),
	('newbie4', 'ROLE_USER');
	
select * from tbl_member_auth order by username;

select * from
	tbl_member m left outer join tbl_member_auth a
	on m.username = a.username
where m.username = 'admin';

create table persistent_logins(
	series varchar(64) primary key,
	username varchar(64) not null,
	token varchar(64) not null,
	last_used timestamp not null
);

