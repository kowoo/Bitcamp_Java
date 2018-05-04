JDBC

자바에서 oracle을 사용할 수 있게 하는 라이브러리 가져오기

C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 폴더에서

ojdbc6.jar을 복사

프로젝트 우클릭, 새로 만들기, 폴더 lib를 만든 뒤 복사했던 jar를 붙여넣기

외부라이브러리를 사용하기 위해서는 java Build Path를 설정해 주어야 한다. 
(컴파일 할때 추가 해놓은 build path가서 클래스를 찾아봐라...)

프로젝트 우클릭> properties > java build path
> Libraries 탭 >  add jar > 복사한  jar 파일 선택


DDL (Data Definition Language)
데이터베이스에서 관리할 데이터 오브젝트를 생성하거나 삭제하는 sql
create, drop 등

DML (Data Manipulation Language)
테이블에 조회, 삭제, 수정, 삽입을 위한 sql
	select, delete, update, insert 등?
	
DCL (Data Control Language)
데이터베이스에 대한 권한을 부여하는 명령어
grant, revoke 등 

