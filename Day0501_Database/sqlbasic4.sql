서브쿼리: 쿼리문 안에 다른 쿼리문이 존재

 예: SMITH와 같은 부서에서 일하는 모든 직원을 조회
	1. 스미스가 어떤 부서에서 일하는지 알아야 함
SELECT deptno
  FROM emp
 WHERE ename = 'SMITH';
 
SELECT ename
  FROM emp
 WHERE deptno = 20;
 
이걸 서브 쿼리로 하나로 만들어보자

단일행 서브쿼리
SELECT ename
  FROM emp
 WHERE deptno = (SELECT deptno
 				   FROM emp
			 	  WHERE ename = 'SMITH');
복수행 서브쿼리
SELECT deptno
  FROM emp
 WHERE job = 'CLERK'
업무가 CLERK인 직원이 근무하는 근무지
SELECT dname,loc
  FROM dept
 WHERE deptno in (SELECT deptno
 					FROM emp
 				   WHERE job = 'CLERK')
 				   
SELECT dname,loc
  FROM dept
 WHERE deptno in (SELECT deptno
 					FROM emp
 				   WHERE job = 'CLERK');
select *
  from (select *
          from emp
         where deptno = 10);

SELECT dname,loc
  FROM dept
 WHERE deptno in (SELECT deptno
 					FROM emp
 				   WHERE job = 'CLERK');
select *
  from (select *
          from emp
         where deptno = 10);

select *
  from emp
 where deptno = 10;

select e.ename  as "이름",
       e.deptno as "부서번호",
       e.sal    as "급여",
       e.mgr    as "매니저번호",
       d.dname  as "부서이름",
       d.loc    as "근무지"
  from emp e, dept d
 where e.deptno = d.deptno;
 
select tmp.이름, tmp.근무지, tmp.부서이름
  from (select e.ename  as "이름",
               e.deptno as "부서번호",
               e.sal    as "급여",
               e.mgr    as "매니저번호",
               d.dname  as "부서이름",
               d.loc    as "근무지"
         from emp e, dept d
        where e.deptno = d.deptno) tmp
        where tmp.근무지 = 'CHICAGO';
        
        

-------------------------------------
select *
  from emp
 where deptno = 10;

select e.ename  as "이름",
       e.deptno as "부서번호",
       e.sal    as "급여",
       e.mgr    as "매니저번호",
       d.dname  as "부서이름",
       d.loc    as "근무지"
  from emp e, dept d
 where e.deptno = d.deptno;
 
select tmp.이름, tmp.근무지, tmp.부서이름
  from (select e.ename  as "이름",
               e.deptno as "부서번호",
               e.sal    as "급여",
               e.mgr    as "매니저번호",
               d.dname  as "부서이름",
               d.loc    as "근무지"
         from emp e, dept d
        where e.deptno = d.deptno) tmp
        where tmp.근무지 = 'CHICAGO';

-------------------------------------
select문에 들어가는 서브쿼리(스칼라 서브쿼리)
join 이용해서 사원정보+부서정보

select ename "사원이름",
	   (select d.dname
		  from dept d
		 where e.deptno = d.deptno
	   ) "부서"
  from emp e;
  
select ename "사원",
	   (select ename
	      from emp e2
	     where e1.mgr = e2.empno
	   ) "매니저"
  from emp e1;
  
  *시험 출제
1. emp 테이블을 조회해서 직원들 중, 급여가 직급의 평균 급여와 같거나 많은 직원의 이름, 업무, 급여 출력

SELECT e.ename, e.job, e.sal
  FROM emp e
 WHERE e.sal >= (SELECT AVG(sal)
 				   FROM emp e1
 				  WHERE e1.job = e.job
 			   GROUP BY job);
  
2. emp 테이블을 조회하여 부서별 최대 연봉을 가지는 직원의 이름과 연봉 출력
[where (컬럼1, 컬럼2) in (서브쿼리 컬럼1, 컬럼2)]

SELECT ename,
	   sal
  FROM emp
 WHERE sal IN (SELECT max(sal)
        		 FROM emp
       		 GROUP BY deptno);
       		 
SELECT e.ename,
	   e.sal
  FROM emp e
 WHERE (e.sal,e.deptno) IN (SELECT MAX(e1.sal),deptno
  							  FROM emp e1
						  GROUP BY e1.deptno);
 
3. emp 테이블을 조회하여 각 부서별 입사일이 가장 오래된 사원의
  이름, 입사일, 부서번호, 부서명을 출력 (단, 부서번호 오름차순)
  
SELECT e.ename,
	   e.hiredate,
	   e.deptno,
	   d.dname
  FROM emp e, dept d
 WHERE e.deptno = d.deptno
   AND hiredate IN (SELECT min(hiredate)
 					  FROM emp
 				  GROUP BY deptno)
 ORDER BY deptno;
 