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

select * from tbl_board;