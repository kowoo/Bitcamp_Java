단일행 함수, 복수행 함수
조회한 데이터에 대해서 값을 변경하거나,
원하는 값을 얻어내기 위해서 사용하는 함수 - 오라클 내장함수 기준
(다른 dbms에서는 될 수도 있지만 안 될 수도 있으니 유의)

문자관련 함수 (보통은 대문자로 씀. SELECT INITCAP 이렇게)
INITCAP: 문자열 첫글자를 대문자로 변경
    모양: INITCAP('문자열')
    예: SELECT INITCAP('abcd') from dual;
    결과: Abcd
LOWER: 문자열을 소문자로 변경
    모양: LOWER('문자열')
    예: SELECT LOWER('ABCD') from dual;
    결과: abcd
UPPER: 문자열을 대문자로 변경
    모양: UPPER('문자열')
    예: SELECT UPPER('abcd') from dual;
    결과: ABCD
LENGTH: 문자열 길이 반환
    모양: LENGTH('문자열')
    예1: SELECT LENGTH('abcdef') from dual;
    결과: 6
    예2: emp테이블에서 이름 길이가 5이상인 직원의 모든 정보 조회
        SELECT ename from emp where LENGTH(ename)>=5;
CONCAT: 두 문자열 결합
    모양: CONCAT('문자열','문자열')
    예: SELECT concat(ename, '입니다') from emp;
        SELECT ename||' '||'입니다' from emp; (||와 concat은 같은 기능)
        SELECT ename||' 입니다' from emp;
    결과: ename입니다
         ename 입니다
         ename 입니다
SUBSTR: 문자열에서 일부 문자열 추출
    모양: SUBSTR(문자열, 인덱스, 개수) *인덱스는 1부터 시작
    예1: emp 테이블에서 모든 직원 이름의 첫글자를 조회
        SELECT SUBSTR(ename,1,1) from emp;
    예2: emp 테이블에서 모든 직원 이름의 첫글자를 조회.(단, 소문자로 조회함)
        SELECT LOWER(SUBSTR(ename,1,1)) from emp;
INSTR: 문자열에서 특정 문자열 위치 반환
    모양: INSTR(문자열, 찾을 문자열)
    예: SELECT INSTR('abcdefg', 'cd') from dual;
    결과: 3
LPAD: 문자열 왼쪽에 특정문자 채움
    모양: LPAD(문자열, 길이, 채울문자)
    예: SELECT LPAD('abcdef',10,'*') from dual;
    결과: ****abcdef (길이가 10개가 될때까지 채우므로 abcdef 6개 + 별 4개로 10개)
RPAD: 문자열 오른쪽에 특정문자 채움
    예: SELECT RPAD('abcdef',10,'*') from dual;
    결과: abcdef****
LTRIM: 문자열 왼쪽의 특정문자 지움
    모양: LTRIM(문자열, 지울문자), 지울문자가 없으면 공백삭제
    예1: SELECT LTRIM('*******/*****ABC*****/*******','*') from dual;
    결과1: '*****ABC*****/*******'                                     // */가 주석처리라서 따옴표 붙인거
    예2: SELECT LTRIM('    abc          ') from dual;
    결과2: abc          ~
RTRIM: 문자열 오른쪽의 특정문자 지움
    예: SELECT RTRIM('*******/*****ABC*****/*******','*') from dual;
    결과: '************ABC*****/'                                     // */가 주석처리라서 따옴표 붙인거
TRIM: 문자열 양쪽의 특정문자 지움
    예1: SELECT TRIM('    abc          ') from dual;
    결과1: abc
REPLACE: 문자열에서 특정 문자열 교체
    모양: REPLACE(문자열, 교체대상 문자열, 교체 문자열)
    예: SELECT REPLACE('abcdefg', 'cd', '*') from dual;
    결과: ab*efg
    
----------------------------------------------------------------------------------
숫자 관련 함수
ROUND: 반올림
    모양: ROUND(숫자, 표시자리수)
    예: SELECT ROUND(12.36, 1) from dual;
    결과: 12.4
TRUNC 버림
    모양: TRUNC(숫자, 표시자리수)
    예: SELECT TRUNC(12.36, 1) from dual;
    결과: 12.3
MOD: 나머지
    모양: MOD(A,B): A를 B로 나눈 나머지
    예: SELECT MOD(5,3) from dual;
    결과: 2
FLOOR: 내림
    모양: FLOOR(A): 가장 가까운 작은 정수 출력
    예: SELECT FLOOR(12.34) from dual;
    결과: 12
CEIL: 올림
    모양: CEIL(A): 가장 가까운 큰 정수 출력
    예: SELECT CEIL(12.34) from dual;
    결과: 13
POWER: 제곱수
    모양: POWER(숫자,제곱)
    예: SELECT POWER(4,3) from dual;
    결과: 64
        
    
----------------------------------------------------------------------------------
날짜 관련 함수

SYSDATE: 시스템의 현재 날짜 반환
    예: SELECT SYSDATE from dual;
    결과: 현재 날짜 (18/05/09)
TO_DATE: 특정 포맷의 문자열을 날짜 데이터로 변환
    예: SELECT TO_DATE('2018-05-09','RRRR-MM-DD') from dual;
    결과:
TO_CHAR: 날짜를 특정 포맷의 문자열로 반환
    예: SELECT TO_CHAR(SYSDATE,'RRRR:MM:DD') from dual;
    결과: 2018:05:09 (기존 18/05/09)
MONTHS_BETWEEN: 두 날짜간 개월 수 반환
    예: SELECT MONTHS_BETWEEN(SYSDATE,TO_DATE('2017-05-09','RRRR-MM-DD')) from dual;
    결과: 12
ADD_MONTHS: 특정 날짜에 개월 수 더하기
    예: SELECT ADD_MONTHS(SYSDATE,3) from dual;
    결과: 18/08/09
NEXT_DAY: 날짜 기준으로 지정한 요일의 돌아오는 날짜 반환
    예: SELECT NEXT_DAY (SYSDATE,'월') from dual; //한글로 설치해서 월, 월요일이 됨. 영어면 MON, MONDAY
    결과: 18/05/14
LAST_DAT: 날짜가 속한 달의 마지막 날
    예: SELECT LAST_DAY(SYSDATE) from dual;
    결과: 18/05/31
ROUND: 낮 12시 기준으로 시간이 지났으면 다음날, 아니면 오늘 반환
    예: SELECT ROUND(SYSDATE) from dual;
    결과: 18/05/09
TRUNC: 해당 날짜 반환(00시 기준)
    예: SELECT TO_CHAR((TRUNC(SYSDATE),'RRRR-MM-DD hh:mi:ss') from dual; ????
    결과: 
        
    
----------------------------------------------------------------------------------
NVL(칼럼, 값): 조회한 칼럼이 null이면 값을 넣어줌 (문자열도 가능한듯?)
    예: SELECT ename,job,sal,comm,sal+comm from emp;
    결과: SMITH sal+comm null
    예2: SELECT ename,job,sal,NVL(comm,0),sal+NVL(comm,0) from emp;
    결과: SMITH sal+comm 800
DECODE: 프로그래밍 언어에서 if(A==B){값} 과 같음
    모양: DECODE(A,B,값)
    예: SELECT deptno,DECODE(deptno,10,'ACCOUNTING') from emp;
    결과: deptno가 10이면 ACCOUNTING
    예2: SELECT deptno,DECODE(deptno,10,'A',20,'B') from emp;
    결과: deptno가 10이면 A, 20이면 B

----------------------------------------------------------------------------------
그룹함수 (복수행 함수)
각 행마다 함수를 처리하는 것이 아니라
조회 결과 중 여러 행을 묶어서 통계내는 함수
COUNT: 조회한 행의 개수
    예1: SELECT COUNT(*) as "직원수" from emp where deptno=10;
    결과1: 부서번호가 10인 직원 수(3)
    예2: SELECT COUNT(*) as "직원수", deptno as "부서"
        from emp
        group by deptno;
    결과2: 각 부서번호 별 직원 수(30=6, 20=3, 10=3)
SUM: 조회한 행의 합
    예1: SELECT SUM(sal) from emp;
    예2: SELECT SUM(sal),deptno
        from emp
        group by deptno;
    예3: SELECT SUM(sal),job
        from emp
        group by job;
    예4: SELECT SUM(sal),deptno,job
        from emp
        group by deptno,job
        order by deptno,job; //오ㄹ더바이는 언제나 맨 마지막
AVG: 조회한 행의 평균
     예1: SELECT FLOOR(AVG(sal)) from emp;
    예2: SELECT AVG(sal),deptno
        from emp
        group by deptno;
    예3: SELECT AVG(sal),job
        from emp
        group by job;
MAX: 조회한 행의 최대값
    예: SELECT MAX(SAL) from emp group by deptno;
MIN: 조회한 행의 최소값
    예: SELECT MIN(SAL) from emp group by deptno;
    예2: SELECT MIN(SAL), job
        from emp
        group by job;
        
통계함수에서 조건: where이 아니라 having
    예: 업무별 급여의 총합 중에서 4000이상인 값을 조회
        SELECT SUM(sal),job
        from emp
        group by job
        having SUM(sal)>=4000;
    예: 업무별 급여의 총합 중 부서번호 10에서 2000이상인 값을 조회   
        SELECT SUM(sal),job
        from emp
        where deptno = 10
        group by job
        having SUM(sal)>=2000;
