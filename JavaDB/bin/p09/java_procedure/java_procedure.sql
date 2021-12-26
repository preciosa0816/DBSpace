--[과제] 자바에서 오라클DB에서 프로시저 실행 결과를 출력하기
--이클립스 :p09.plsql_procedure.ProcedureTest2

--(예)사원번호(7788)를 통해서 고객 조회(이름,급여,직급)?
-------첫번째 실행
create or replace procedure sel_empno(
    vempno IN emp.empno%TYPE,--사원번호
    vename OUT emp.ename%TYPE,
    vsal OUT emp.sal%TYPE,
    vjob OUT emp.job%TYPE
    )
IS
BEGIN
   select  ename,sal,job  into vename,vsal,vjob
   from emp
   where empno = vempno; 
END;

--=>Procedure SEL_EMPNO이(가) 컴파일되었습니다.
----------두번째 실행
  variable  var_ename varchar2(15);
  variable  var_sal number;
  variable  var_job varchar2(9);

EXEC sel_empno(7788,:var_ename,:var_sal,:var_job)
print var_ename