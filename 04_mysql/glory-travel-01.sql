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