
CREATE table book(
    id varchar2(30) primary key,
name varchar2(30),
price number(10)
);


insert into book values('aaaa','hong',1000);
insert into book values('bbbb','alphago',2000);
insert into book values('cccc','beta',3600);
commit;

select * from book;