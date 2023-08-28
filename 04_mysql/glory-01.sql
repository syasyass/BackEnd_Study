use world;

select * from city
order by name
limit 30, 10; -- 추출 10개로 제한, 1개 이후 출력
-- 오라클은 인덱스 1부터 시작, mySQL은 0부터 시작 

select count(*) from city;

use glory_DB;

select * from travel
order by region, TITLE;

-- 페이지네이션
select * from travel
order by region, TITLE
limit 30, 10;

