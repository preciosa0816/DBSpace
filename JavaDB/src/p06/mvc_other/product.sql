create table product(
num number(4) primary key,
name varchar2 (30) not null,
price number(10)
);

CREATE SEQUENCE PRODUCT_NUM_SEQ
START WITH 0
INCREMENT BY 1
MINVALUE 0
MAXVALUE 1000;

drop SEQUENCE PRODUCT_NUM_SEQ;
