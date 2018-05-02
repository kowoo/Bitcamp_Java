enum: 직원번호
ename: 직원이름
deptno: 부서번호
salary: 월급

create table employee(
	enum number,
	ename varchar2(30),
	deptno number,
	salary number
);

테이블만들고 해당 테이블에 데이터를 삽입, 삭제, 수정, 조회할 수 있음
EmployeeDao 클래스
	selectone: 직원 번호를 조건으로 직원의 모든 정보를 조회하여 직원 객체 반환
	selectAll: 모든 직원의 모든 정보를 조회하여 직원 리스트 반환
	deleteEmployee: 직원번호를 조건으로 직원 삭제
	updateEmployee: 직원번호를 조건으로 직원의 이름, 부서번호, 월급을 수정
	insertEmployee: 직원이 가져야할 모든 정보를 포함하여 직원정보 삽입

Employee 클래스
	직원번호(정수), 직원이름(문자열), 부서번호(정수), 월급(정수)

EmployeeDaoTest 클래스
	main method에서 EmployeeDao의 모든 기능 실행해보기(한 번씩)