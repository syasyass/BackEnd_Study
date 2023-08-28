-- 계정 만들기

use mysql;

select host, user from user; -- 계정 보여주기

create user 'glory'@'%' identified by 'glory'; -- %는 모든 DB 부여라는 뜻

grant all privileges on world.* to 'glory'@'%';

commit;



-- 데이터베이스 만들기
create database glory_DB;

-- glory 계정에게 glory_DB 사용 권한 부여
grant all privileges on glory_DB.* to 'glory'@'%';

commit;