create table member2(
	id varchar2(12),
    passwd varchar2(12),
    name varchar2(12),
    age number,
    addr varchar2(50),
    email varchar2(30)
);
drop table member2;

Insert into member2 values('aaa','aaa','홍길동',22,'서울시','a@a.com');
Insert into member2 values('bbb','bbb','알파고',21,'제주시','b@b.com');
Insert into member2 values('ccc','ccc','베타고',22,'광주시3','c@c.com');
Insert into member2 values('ddd','ddd','감마고',22,'울산시4','d@d.com');
Insert into member2 values('eee','eee','세타고',22,'이리시5','e@e.com');
commit;

select * from MEMBER2;