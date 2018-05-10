시퀀스(순차적으로 증가하는 값을 가지는 데이터베이스 오브젝트)
사용 예) 회원가입
회원을 구분하기 위해서 구분 키, 게시글 번호: 자동적으로 증가해야 하는 수

시퀀스 만들기														여기에는 속성값이 들어감 ex)최대값 순환
create sequence [시퀀스이름] start with [시작값] increment by [증가값] maxvalue 값 cycle

create sequence test_seq start with 1 increment by 1 maxvalue 9999999 cycle;

시퀀스의 다음 값 가져오기
select test_seq.nextval from dual;
시퀀스의 현재 값 가져오기
select test_seq.currval from dual;

사용자가 생성한 시퀀스 확인하기
select * from user_sequences;


ex) 학생정보(번호, 이름, 학년)를 저장하는 테이블 student_ex에 자동으로 번호를 증가시키면서 입력하기
insert into student_ex values (student_seq.nextval,'홍길동',3);

시퀀스 초기화
 현재 시퀀스값 만큼 빼고 1부터 시작하게 만들면 된다.
//증가값을 현재 값으로 변경
alter sequence student_seq increment by -8;
//초기화
select student_seq.nextval from dual;
//다시 증가값 1로 변경
alter sequence student_seq increment by 1;
//시퀀스 증가 시키기
select student_seq.nextval from dual;

한방에 삭제시키는게 아니라 그냥 현재값만큼 되돌려서 덮어버리는 느낌?

MySql는 auto_increment를 이용해서 key값을 1씩 증가시킬 수 있다.

----------------------------------------------------------
제약사항
테이블에 데이터를 입력할 때 특정한 값만 들어갈 수 있도록 설정
ex)중복되지 않는 값만 넣을 수 있도록 한다, null은 못넣게한다 등
primary key 기본키 지정 (중복안됨, not null), 테이블당 하나
not null: 널 ㅗ
unique: 중복 ㅗ
check: 특정 범위 지정
foreign key: 다른 테이블의 기본키(primary)인 값만 쓸 수 있게 지정.

제약사항 지정 방법
1. 테이블 생성시
ex) student 테이블 작성
번호: 기본키
이름: not null
학년: not null
점수: 100이하

create table student(
	num number(3) primary key,
	name varchar2(20) not null,
	grade number(2) not null,
	score number(5) check(score<=100)
)

constraint [제약사항이름] [제약사항]
create table student(
	num number(3) constraint student_pk primary key,
	name varchar2(20) not null,
	grade number(2) not null,
    email varchar2(50) not null,
	score number(5),
    constraint student_email_uq unique(email),
    constraint student_score_ck check(score<=100),
    constraint student_emial_fk reference 테이블명(칼럼명);
);
foreign키 추가						이름은 자유
alter table student add constraint student_fk reference;

제약사항 확인
user_constraints : 이 테이블에 적용된 제약사항이 저장되어 있다.
테이블에서 테이블 이름, 제약사항 이름, 제약사항 타입

select table_name,constraint_name,constraint_type
  from user_constraints
 where table_name = 'STUDENT';

2. 테이블 생성후 (테이블 수정)
			테이블명
alter table student add constraint primary key(name);
alter table student modify name varchar2(20) not null;
alter table student add not null(email);


alter table student add constraint 

----------------------------------------------------------------

create table student(
 num number(5),
 name varchar2(20),
 email varchar2(50)
 );

create table email_infe(
 email varchar2(50) primary key,
 info varchar2(100)
 );
 
insert into email_info values('emial1','info1');
insert into email_info values('emial2','info2');

alter table student
add constraint email_fk foreign key(email)
references email_info(email);
이걸 입력하면 student에는 email_info에 입력했던 email의 기본값만 들어갈 수 있음.

즉
insert into student values (1,'hong','email1');
insert into student values (1,'hong','email2');
은 가능하지만
insert into student values (1,'hong','email');
insert into student values (1,'hong','email3');
은 불가능하게 된다는것.
----------------------------------------------------------------------
테이블 생성시 칼럼 기본값 설정하기
create table student(
	num number(3) primary key,
	name varchar2(20) not null,
	birth_day date default sysdate
);

insert into student (num,name) values(1,'hong gil-dong');

디폴트 데이터를 넣어두면 아무것도 입력하지 않았을때 지정해둔 값이 들어간다. sysdate니까 오늘이 들어감
그러므로 select * from student;를 하면 1, 홍길동, 18/05/10이 됨.

----------------------------------------------------------------------
Member table 작성하기
create table Member(
num number(10) primary key,
id varchar2(30) not null + unique,
pw varchar2(50) not null,
name varchar2(20) not null,
email varchar2(30) not null + unique,
regDate date default sysdate
);


create table Member(
num number(10) primary key,
id varchar2(30) not null,
pw varchar2(50) not null,
name varchar2(20) not null,
email varchar2(30) not null,
regDate date default sysdate
);

alter table Member add unique(id);
alter table Member add unique(email);