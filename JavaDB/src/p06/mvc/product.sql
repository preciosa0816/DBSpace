create table product(
num number(10) primary key,
name varchar2(30),
price number(20)
);

select * from product;

delete from product where num=2;

drop table product;
drop sequence pro_seq;

create sequence pro_seq
start with 1
increment by 1;
