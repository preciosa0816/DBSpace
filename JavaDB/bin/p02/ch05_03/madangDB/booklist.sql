--Ch03_01 : SQL학습을 위한 준비

-------------------시스템계정에서 작성/실행 내용-----------------------
--계정(DB)만들기
CREATE USER madang 
IDENTIFIED BY madang 
DEFAULT TABLESPACE users 
TEMPORARY TABLESPACE temp 
PROFILE DEFAULT;
--시스템 계정에서 마당DB에 연결과 자원사용에 대한 권한 부여
GRANT CONNECT, RESOURCE TO madang;
--DB안에 있는 VIEW 와 SYNONYM에 대한 사용권한 부여
GRANT CREATE VIEW, CREATE SYNONYM TO madang;

ALTER USER madang ACCOUNT UNLOCK;
----------------------------------------------------------------------
--------------------------이후 MADANG계정에 작성-------------------------
--서점관리 프로젝트
--도서테이블
CREATE TABLE Book(
bookid  NUMBER(2)PRIMARY KEY,
bookname VARCHAR2(40),
publisher VARCHAR2(40),
price NUMBER(8)
);
--고객테이블
CREATE TABLE Customer(
custid  NUMBER(2) PRIMARY KEY,
name    VARCHAR2(40),
address VARCHAR2(50),
phone VARCHAR2(20)
);
--주문테이블
CREATE TABLE Orders(
orderid NUMBER(2) PRIMARY KEY,
custid  NUMBER(2) REFERENCES Customer(custid),
bookid  NUMBER(2) REFERENCES Book(bookid),
saleprice   NUMBER(8),
orderdate   DATE
);
--테이블 속성 변경시 삭제후 해야함--
drop TABLE book;
drop TABLE customer;
drop TABLE orders;

/*3개의 테이블에 데이터 넣기*/
INSERT INTO Book VALUES(1, '축구의 역사','굿스포츠',7000);
INSERT INTO Book VALUES(2, '축구하는 여자','나무수',13000);
INSERT INTO Book VALUES(3, '축구의 이해','대한미디어',22000);
INSERT INTO Book VALUES(4, '골프 바이블','대한미디어',35000);
INSERT INTO Book VALUES(5, '피겨 교본','굿스포츠',8000);
INSERT INTO Book VALUES(6, '역도 단계별 기술','굿스포츠',6000);
INSERT INTO Book VALUES(7, '야구의 추억','이상미디어',20000);
INSERT INTO Book VALUES(8, '야구를 부탁해','이상미디어',20000);
INSERT INTO Book VALUES(9, '올림픽 이야기','삼성당',7500);
INSERT INTO Book VALUES(10, 'Olympic Champions','Pearson',13000);

INSERT INTO Customer VALUES(1, '박지성','영국 맨체스터','000-5000-0001');
INSERT INTO Customer VALUES(2, '김연아','대한민국 서울','000-6000-0001');
INSERT INTO Customer VALUES(3, '장미란','대한민국 강원도','000-7000-0001');
INSERT INTO Customer VALUES(4, '추신수','미국 클리블랜드','000-8000-0001');
INSERT INTO Customer VALUES(5, '박세리','대한민국 대전',NULL);

INSERT INTO Orders VALUES(1, 1, 1, 6000, TO_DATE('2014-07-01','yyyy-mm-dd'));
INSERT INTO Orders VALUES(2, 1, 3, 21000, TO_DATE('2014-07-03','yyyy-mm-dd'));
INSERT INTO Orders VALUES(3, 2, 5, 8000, TO_DATE('2014-07-03','yyyy-mm-dd'));
INSERT INTO Orders VALUES(4, 3, 6, 6000, TO_DATE('2014-07-04','yyyy-mm-dd'));
INSERT INTO Orders VALUES(5, 4, 7, 20000, TO_DATE('2014-07-05','yyyy-mm-dd'));
INSERT INTO Orders VALUES(6, 1, 2, 12000, TO_DATE('2014-07-07','yyyy-mm-dd'));
INSERT INTO Orders VALUES(7, 4, 8, 13000, TO_DATE('2014-07-07','yyyy-mm-dd'));
INSERT INTO Orders VALUES(8, 3, 10, 12000, TO_DATE('2014-07-08','yyyy-mm-dd'));
INSERT INTO Orders VALUES(9, 2, 10, 7000, TO_DATE('2014-07-09','yyyy-mm-dd'));
INSERT INTO Orders VALUES(10, 3, 8, 13000, TO_DATE('2014-07-10','yyyy-mm-dd'));
commit;

drop TABLE imported_book;

select * from imported_book;

Create table imported_book(
bookid number,
bookname varchar2(40),
publisher varchar2(40),
price number(8)
);

insert into imported_book values(21,'Zen Golf','Pearson',12000);
insert into imported_book values(22,'Soccer Skills','Human Kinetics',15000);




/*SQL(Structured Query Language:질의어 - DB언어*/ 
/*ANSI SQL : Oracle, my SQL 공통으로 사용하는 sql(query)
            Oracle SQL 만 사용: PL/SQL
            MS-SQL 만 사용 : T-SQL*/

select * from book;
select * from orders;

--Ch03_2_SQL개요
SELECT bookname, publisher ,price
FROM book
where bookname LIKE'축구의 역사';

--상품 정보 테이블
/*not null : 반드시 입력해야하는 값*/
/*primary key : 유일성, 식별성*/
CREATE TABLE Goodsinfo(
code  CHAR(5) not null PRIMARY KEY,
name VARCHAR2(30)not null ,
price NUMBER(8)not null,
maker VARCHAR2(20)
);


INSERT INTO Goodsinfo VALUES(10001, '디지털 TV',350000,'LG');
INSERT INTO Goodsinfo VALUES(10002, 'DVD 플레이어',250000,'LG');
INSERT INTO Goodsinfo VALUES(10003, '디지털 카메라',210000,'삼성');
INSERT INTO Goodsinfo VALUES(10004, '전자사전',180000,'아이리버');
INSERT INTO Goodsinfo VALUES(10005, '벽걸이 에어컨',400000,'삼성');

/*완전 저장을 한 상태여야 다른 곳에서 가져다 쓸 수 있음 - 문제가 없기때문에 완전히 DB에 저장하겠다는 의미*/
COMMIT;






