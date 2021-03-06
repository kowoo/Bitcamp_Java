SQL(Structed Query Language)
 :DBMS를 통해서 데이터 베이스에 데이터를 조회,수정,삭제,변경을 하기위한 언어
 
 sqlplus / as sysdba  : 관리자 권한 접속
 
 유저생성
 CREATE USER kwh IDENTIFIED BY "1"; 
 
 유저권한
 모든권한주기
 GRANT connect,dba,resource to kwh;

 ALTER user 아이디 identified "비밀번호";
 
 관리자 권한에서 들어간 상태에서 유저로 접속하기 
 conn 아이디/비번; 이거 안되는데?...
 
 테이블: 실제 데이터가 저장되는 공간
 테이블 생성하기
 
 CREATE TABLE [테이블명](
 	[컬럼명] [자료형] [옵션..],
 	[컬럼명] [자료형] [옵션..],
 	[컬럼명] [자료형] [옵션..],
 	[컬럼명] [자료형] [옵션..],
 	[컬럼명] [자료형] [옵션..] 
 );
 
 자료형 : 문자, 숫자, 날짜, 이진데이터
   varchar2,number,date, blob 
 
 학생정보를 저장하는 테이블을 만들어 봅시다.
 (학생번호-숫자,이름-문자열, 학년 - 숫자)
 
 CREATE TABLE student_ex(
 	snum number(7),
 	sname varchar2(20),
 	sgrade number
 );
 
 만들어진 테이블 정보확인 
 desc student_ex;
 
 테이블삭제
 DROP TABLE [테이블명];
 drop table student_ex;
 
 테이블에 데이터를 활용해서 할 수 있는 일 : 조회,삽입,수정,삭제
 CRUD
 Create,Read,Update,Delete
 
 
 학생
 [번호] [이름] [학년]  
 snum  sname  sgrade
 
 삽입(insert)
 테이블에 데이터넣어주기 
 
 insert into [테이블명]
             ([칼럼명1],[칼럼명2],...)
       values ([value1],[value2],...);     
 
ex)insert into student_ex
 				(snum,sname,sgrade)
 	       values (1,'홍길동',3);
 
 모든 칼럼에 모두 데이터를 집어넣고자 할때는  칼럼명을 생략해도 된다. 
 단, 데이터의 순서는 칼럼명 순서와 같아야 한다.  
 
 ex ) insert into student_ex values (1,'홍길동',3);  
 
 commit; 을 하면 작성한 것들이 확정됨.
 즉, CURD를 하고나서 그냥 cmd창을 꺼버리면 아무것도 저장이 안됨 ~_~
 
 
 
 조회(select)
 테이블에 저장되어 있는 데이터를 조회
 
 
 select [칼럼명],[칼럼명],[칼럼명]
   from [테이블명];
 ------------------
  where [조건]  특정 Row를 조회하고자 할 때 사용 
 
 ex) select snum,sname,sgrade
       from student_ex;
 
 모든 칼럼을 조회할 때는 칼럼명을 쓰지 않고, *을 대신 사용해도 된다. 
 select * from student_ex;
 
 (데이터베이스 오브젝트(테이블,유저,뷰,프로시져 등등) 삭제는 drop, 데이터 삭제는 delete)
 삭제(delete) 
 삭제는 로우 전체를 삭제해야 한다.>> 특정 칼럼을 지칭할 필요 X
 where 절이 없으면, 모든 row 삭제
 특정한 row만 지우기 위해서 where 사용
 delete 
   from [테이블명]
  where [조건];
  
 delete
   from student_ex
   ----------------
  where snum = 1;
  
 
수정(update)
존재하는 로우의 데이터를 변경하기 위해서 사용

update [테이블명]
   set [칼럼명] = [값],
       [칼럼명] = [값],
       [칼럼명] = [값],
       [칼럼명] = [값]
---------------------
 where [조건];
  
 update student_ex
    set sgrade = 3;
