--이름 JavaDB로 바꾸기

--java계정(DB)만들기 - system 계정

CREATE USER javaDB 
IDENTIFIED BY javadb 
DEFAULT TABLESPACE users 
TEMPORARY TABLESPACE temp 
PROFILE DEFAULT;
--시스템 계정에서 마당DB에 연결과 자원사용에 대한 권한 부여
GRANT CONNECT, RESOURCE TO javaDB;
--DB안에 있는 VIEW 와 SYNONYM에 대한 사용권한 부여
GRANT CREATE VIEW, CREATE SYNONYM TO javaDB;
ALTER USER javaDB ACCOUNT UNLOCK;



drop table member;
--member table 만들기  -JavaDB계정
CREATE table member(
    id varchar2(12),
    passwd varchar2(12),
    name varchar2(12),
    age number,
    addr varchar2(50),
    email varchar2(30)
);

--데이터 입력하기

Insert into member values('bbb','aaa2','홍길동2',22,'서울시2','a@a.com');
Insert into member values('ccc','aaa3','홍길동3',23,'서울시3','a@a.com');
Insert into member values('ddd','aaa4','홍길동4',24,'서울시4','a@a.com');
Insert into member values('eee','aaa5','홍길동5',25,'서울시5','a@a.com');
commit;
select * from member;

delete from member where id='aaa';
----------------------------------------
--테이블:book

CREATE table book(
    id varchar2(30) primary key,
name varchar2(30),
price number(10)
);


Insert into book values('aaaa','hong',1000);
Insert into book values('bbbb','alphago',2000);
Insert into book values('cccc','beta',3600);
commit;



















