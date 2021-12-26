--프로시저
create or replace procedure javatest(
    p1 in varchar2,
    p2 in out varchar2,
    p3 out varchar2
)
as
begin
    p2:=p1||p2;
    p3:=p1;
end;

--PLSQL
SET SERVEROUTPUT ON
declare
in_p1 varchar2(10):='a';
inout_p2 varchar2(10):='b';
out_p3 varchar2(10);
begin
javatest(in_p1,inout_p2,out_p3);
DBMS_OUTPUT.PUT_LINE('p2 :'||inout_p2);
DBMS_OUTPUT.PUT_LINE('p3 :'||out_p3);
end;