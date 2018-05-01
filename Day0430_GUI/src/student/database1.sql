SQL(Structed Query Language)
:DBMS를 통해서 데이터 베이스에 데이터를 조회, 수정, 삭제, 변경을 하기위한 언어

일단 cmd창을 통해 ㄱㄱ

sqlplus / as sysdba: 관리자 권한 접속

유저 생성
			아이디			  비번
CREATE USER kwh IDENTIFIED BY "1";

유저권한주기
모든권한주기
GRANT connect, dba, resource to kwh;

connect id/pw = 커넥트! (==conn id/pw)

혹시라도 아디 비번해서 접속안되면 이런 방식으로 ㄱ
ALTER user kwh identified "1";
conn id/pw;

접속하기(cmd 초기화면에서)
sqlplus 아이디/비번

테이블: 실제 데이터가 저장되는 공간
테이블 생성하기

CREATE TABLE [테이블명]()
	[컬럼명] [자료형] [옵션..], //옵션은 0개 이상 여러개가 들어갈 수 있음.
	[컬럼명] [자료형] [옵션..],
	[컬럼명] [자료형] [옵션..] //컬럼을 여러개 추가하고싶으면 쉼표로 추가. 마지막은 없음.
);

오라클 데이터 자료형(타입): 문자, 숫자, 날짜, 이진
문자: varchar2
숫자: number
날짜: date
이진데이터: blob

학생 정보를 저장하는 테이블을 만들어보자!
(학생번호-숫자, 이름-문자열, 학년-숫자)

CREATE TABLE student_ex(
	snum number(7),
	sname varchar2(20),
	sgrade number
);

만들어진 테이블 정보 확인
desc student_ex;

테이블 삭제
DROP TABLE [테이블명];
drop table student_ex;

테이블에 데이터를 활용해서 할 수 있는 일: 조회, 삭제, 수정, 추가
CRUD
Create, Read, Update, Delete

학생
[번호] [이름] [학년]
snum  sname sgrade


삽입(insert)
(테이블에 데이터 넣어주기)
insert into [테이블명]
			([칼럼명],[칼럼명2],...)
	values	([value1], [value2],...);

ex)insert into student_ex
				(snum, sname, sgrade)
		values	(1,'홍길동',3);
snum, sname를 적었으면 values (숫자, 문자열);
sname, snum을 적었으면 values (문자열, 숫자);
이렇게 칼럼 순서는 바꿔도 문제없다! 값은 기입한 칼럼순서와 같아야한다.

모든 칼럼에 데이터를 집어넣고자 할 때는 칼럼명을 생략해도 된다.
insert into student_ex values(6,'이이',3); 이렇게!


조회(select)
테이블에 저장되어 있는 데이터를 조회
select	[칼럼명], [칼럼명], [칼럼명]
from	[테이블명];
---------------------
where[조건] 특정 Row를 조회하고자 할 때 사용

ex) select snum, sname, sgrade
	from   student_ex;
모든 데이터를 조회할 때는
select * from [테이블명];


삭제(delete)
(데이터베이스 오브젝트(유저,테이블,뷰,프로시저 등) 삭제는 drop, 데이터 삭제는 delete)
삭제는 row 단위로 삭제해야한다. (특정한 칼럼을 지정할 필요가 없음)
delete
from [테이블명]
where [조건];
	
delete
from student_ex
------------------where가 없으면 모든 row를 삭제하니 주의해야함!!!
where snum = 1; //특정한 row 삭제용


수정(update)
존재하는 로우의 데이터를 변경하기 위해 사용.

update [테이블명]
   set [칼럼명] = [값],
   	   [칼럼명] = [값],
   	   [칼럼명] = [값]
---------------------
 where [조건]
 
update student_ex set sgrade=3; == 스튜던트_ex테이블의 sgrade값을 3으로 고침.
update student_ex set sgrade=1 where sname='강감찬'; 스튜던트_ex테이블에 sname 강감찬이 있다면 그 녀석의 sgrade를 1로 설정


select * from tab; //만들어진 테이블 검색