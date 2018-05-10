Join
두 개 이상의 테이블에서 데이터를 조회할 때 사용

select *
  from emp, dept; //이렇게 하면 48줄이 나와버림. 12줄 * 4줄이라서
 
INNER JOIN(동등조인): 가장 많이 사용하는 조인 방법
양쪽 테이블 모두에 데이터가 존재하는 경우만 조회된다.
 select *
   from emp e, dept d
  where e.deptno = d.deptno
  order by ename; //쓸데없는 데이터의 사용을 방지. 두 조건이 맞는 경우만 출력하게 만들었음. 
  
 emp 테이블과 dept 테이블에서 모든 직원의 이름과 부서번호, 부서이름, 근무지를 조회
 칼럼이름이 중복되는 경우에는 테이블 이름을 명시해주자. (Alias 사용 권장)
 select e.ename, d.dname, e.deptno, d.loc
   from emp e, dept d
  where e.deptno = d.deptno;
  
 select ename,dname,loc,emp.deptno
   from emp,dept;
  where emp.deptno=dept.deptno
  중복 안되는 부분은 이렇게 해도 되긴함
  
 동등조인의 다른 문법1
 select *
   from emp e join dept d
     on e.deptno = d.deptno;
     
 동등조인의 다른 문법2 //얘보다 1이 많이 쓰이니까 1만 알아도 됨. 기능은 같다
 select *
   from emp e join dept d
  using (deptno)
   
 셀프조인(self join)
  select *
    from emp e1,emp e2;
   where
 
 모든 사원의 이름, 업무, 매니저의 번호, 매니저의 이름을 조회
 select e1.ename as "이름", e1.job as "업무", e1.mgr as "매니저 번호", e2.ename as "매니저 이름"
   from emp e1,emp e2
  where e2.ename=e1.mgr;
  

OUTER JOIN: 조인하려는 테이블의 한쪽 이상에 데이터가 존재하지 않아도 출력하고자 할 때
  
  select e1.ename, e1.job, e1.mgr, e2.ename
    from emp e1 left outer join emp e2
      on e1.mgr = e2.empno
      
      
---------------------------------------------------------------
OUTER JOIN ver. Oracle

데이터가 없어도 출력하고 하는 조건문 뒤에 (+)를 붙임
select e1.ename, e1.job, e1.mgr, e2.ename
  from emp e1, emp e2
 where e1.mgr = e2.empno(+); <<left outer join
 
 
---------------------------------------------------------------
 3개 이상의 테이블 조인
select e1.ename,
	   e1.job,
	   e1.mgr,
	   e2.ename,
	   e1.deptno,
	   d.dname,
	   d.loc
  from emp e1,emp e2,dept d
 where e1.mgr=e2.empno
   and e1.deptno = d.deptno;
 
   두 방법 중 위의 방법을 주로 사용함.
   
select e1.ename,
       e1.job,
 	   e1.mgr,
	   e2.ename,
	   d.dname,
	   d.loc
  from emp e1 join emp e2
    on e1.mgr = e2.empno
  join dept d
    on e1.deptno = d.deptno;
    
---------------------------------------------------------------
조인의 조건이 항상 '='만 있는 것은 아님
조인의 조건은 범위로도 지정할 수 있다.
ex)직원의 급여에 따른 급여 등급 조회하기 (이름, 급여, 급여 등급 조회)
select e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

---------------------------------------------------------------
1. emp,salgrade,dept 테이블에서
직원의 급여에 따른 급여 등급 조회하기 (이름, 급여, 급여 등급, 부서번호, 부서이름)
select 	e.ename,
		e.sal,
		s.grade,
		d.deptno,
		d.dname
  from  emp e,salgrade s,dept d
 where  (e.sal between s.losal and s.hisal)
   and  (e.deptno=d.deptno);
   
2. emp,dept 테이블에서 사원 이름과 그 사원이 소속된 부서 이름과 지역명 조회하기
select  e.ename,
		d.dname,
		d.loc
  from  emp e,dept d
 where  e.deptno = d.deptno;

3. emp,dept 테이블에서 10번 부서에서 담당하는 모든 업무와 지역명 조회하기
select  e.job,
		d.loc
  from  emp e,dept d
 where  e.deptno=10
   and  e.deptno=d.deptno;

4. 사원의 이름, 업무지역, 매니저 이름, 매니저 업무지역 조회하기
select  e1.ename,
		d1.loc,
		e2.ename,
		d2.loc
  from  emp e1, emp e2, dept d1, dept d2
 where  e1.deptno = d1.deptno
   and  e1.mgr = e2.empno
   and  e2.deptno = d2.deptno;

5. 'SMITH' 와 동일한 부서에서 근무하는 사원의 이름 조회  
select  e2.ename
  from  emp e1, emp e2
 where  e1.ename = 'SMITH'
   and  e1.deptno = e2.deptno;

6. 'KING' 보다 늦게 입사한 사원의 이름과 입사일 조회
select  e2.ename,
		e1.hiredate
  from  emp e1, emp e2
 where  e1.ename = 'KING'
   and  e1.hiredate < e2.hiredate;
 
7. 자신의 관리자보다 먼저 입사한 모든 사원의 이름, 입사일, 부서이름, 관리자이름, 관리자 입사일
select  distinct e1.ename,
		e1.hiredate,
		e1.deptno,
		e2.ename as "관리자 이름",
		e2.hiredate as "관리자 입사일"
  from  emp e1, emp e2
 where  e1.mgr = e2.empno
   and  e1.hiredate < e2.hiredate;
   
   
