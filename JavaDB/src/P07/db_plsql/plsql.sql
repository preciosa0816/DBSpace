create table member3(
	id varchar2(12),
	passwd varchar2(12),
	name varchar2(12),
	age number,
	addr varchar2(50),
	email varchar2(30)
);

-------Stored Procedure(삽입: insert) : 오라클에서 실행----------------------
CREATE OR REPLACE PROCEDURE user_insert(  
    user_id in varchar2,
	user_passwd in varchar2,
	user_name in varchar2,
	user_age in number,
	user_addr in varchar2,
	user_email in varchar2
    )
IS
BEGIN
insert into member3 values(user_id,user_passwd,user_name,user_age,user_addr,user_email);
END;

