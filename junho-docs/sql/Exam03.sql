# DQL(Data Query Language) - 데이터 조회 문법
  - 데이터를 조회할때 사용하는 문법

## 테스트 용 테이블 및 데이터 준비

create table test1(
  no int not null,
  name varchar(20) not null,
  class varchar(10) not null,
  working char(1) not null,
  tel varchar(20)
);

alter table test1
 add constraint test1_pk primary key(no),
 add constraint test1_unique unique(name),
 modify column no int not null auto_increment;

insert into test1(name,class,working) values('aaa','java100','Y');
insert into test1(name,class,working) values('bbb','java100','N');
insert into test1(name,class,working) values('ccc','java100','Y');
insert into test1(name,class,working) values('ddd','java100','N');
insert into test1(name,class,working) values('eee','java100','Y');
insert into test1(name,class,working) values('kkk','java101','N');
insert into test1(name,class,working) values('lll','java101','Y');
insert into test1(name,class,working) values('mmm','java101','N');
insert into test1(name,class,working) values('nnn','java101','Y');
insert into test1(name,class,working) values('ooo','java101','N');

## select
- 테이블의 데이터를 조회할 때 사용하는 명령이다.

/* 모든 컬럼 값 조회하기. 컬럼 순서는 테이블을 생성할 때 선언한 순서이다.*/
select * from 테이블;
select * from test1;

/* 특정 컬럼의 값만 조회할 때 => "프로젝션(projection)"이라 부른다.*/
select 컬럼명,컬럼명 from 테이블;
select no, name, tel from test1;

/* 가상컬럽의 값 조회하기*/
select no, concat(name, '(', class, ')') from test1;

### 조회하는 컬럼에 별명 붙이기
- 별명을 붙이지 않으면 원래의 컬럼명이 조회 결과의 컬럼이름으로 사용된다.
- 위의 예제처럼 복잡한 식으로 표현한 컬럼인 경우 컬럼명도 그 식이 된다.
- 이런 경우 별명을 붙이면 조회 결과를 보기 쉽다.

select 컬럼명 as 별명 ...

select no as num, concat(name, '(' , class , ')') as title from test1;

/* as를 생략해도 된다.*/
select
    no num,
    concat(name,'(',class,')') title
from test1;

### 조회할 때 조건 지정하기
- where 절과 연산자를 이용하여 조회 조건을 지정할 수 있다.
- 이렇게 조건을 지정하여 결과를 선택하는 것을 "셀렉션(selection)" 이라 한다.

select * from test1 where no > 5;

## 연산자

### OR, AND, NOT
- OR : 두 조건 중에 참인 것이 있으면 조회 결과에 포함시킨다.
- AND : 두 조건 모두 참일 때만 조회 결과에 포함시킨다.
- NOT : 조건에 일치하지 않을 때만 결과에 포함시킨다.

select * from test1;

/* 재직자 또는 java100기 학생만 조회하라!*/
select no, name, class, working
from test1
where working='Y' or class='java100';

/* java100기 학생 중에 재직자만 조회하라!*/
select no, name, class, working
from test1
where working='Y' and class='java100';

/* 주의!
 * where 절을 통해 결과 데이터를 먼저 선택(selection)한 다음
 * 결과 데이터에서 가져올 컬럼을 선택(projection)한다.
 * 따라서 실행 순서는:
 * from ==> where ==> select
 */
select no, name
from test1
where working='Y' and class='java100';

/* 재직자가 아닌 사람만 조회하라!*/
select no, name, class, working
from test1
where not working = 'Y';

select no, name, class, working
from test1
where working != 'Y';

select no, name, class, working
from test1
where working <> 'Y';

