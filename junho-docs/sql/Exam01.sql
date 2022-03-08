# DDL(Data Definition Language)
DB 객체(테이블, 뷰, 함수, 트리거 등)을 생성, 변경, 삭제하는 SQL 명령이다.
> create ...
> alter ...
> drop ...

- 데이터베이스(database) = 스키마(schema)
- 테이블(table)
- 뷰(view)
- 트리거(trigger = listener)
  - 특정 조건에서 자동으로 호출되는 함수
  - 특정 조건? SQL 실행 전/후 등
- 함수(function)
- 프로시져(procedure)
- 인덱스(index)

## 데이터베이스
  - 데이터베이스 생성
  > create database 데이터베이스명 옵션들...;
  예)
  > create database testdb character set utf8 collate utf8_general_ci;

  - 데이터베이스 삭제
  > drop database 데이터베이스명;
  예)
  > drop database testdb;

  - 데이터베이스 변경
  > alter database 데이터베이스명 옵션들...;
  > alter database testdb...;


## 테이블
  - 테이블 생성exit
  > create table 테이블명 (
    컬러명 데이터타입 NULL여부 옵션,
    컬러명 데이터타입 NULL여부 옵션,
    컬러명 데이터타입 NULL여부 옵션,
    컬러명 데이터타입 NULL여부 옵션,
  )

  예)
  create table test01 (
    name varchar(20) not null,
    kor int not null,
    eng int not null,
    math int not null,
    sum int not null,
    aver float not null
  );

  - 테이블 정보 보기
  > describe 테이블명;
  예) 
  > describe test01;

  > desc 테이블명;
  예)
  > desc test01;

  테이블 삭제하기
  > drop table 테이블명;
  예)
  > drop table test01;

  ### 테이블 컬럼 옵션

  ####  null 허용
  데이터를 입력하지 않아도 된다.
  > create table test1(
    no int, -- 현재 not null로 설정되어 잇지 않기 때문에 데이터를 입력하지 않아도 된다.
    name varchar(20)
  );

  데이터 입력 테스트:
  > insert into test1(no, name) values(1, 'aaaa');
  > insert into test1(no, name) values(null, 'bbbb');
  > insert into test1(no, name) values(3, null);
  > insert into test1(no, name) values(null, null);
  > select * from test1;

  #### not null
  데이터를 입력하지 않으면 입력/변경 거절!!
  > create table test1(
    no int not null, -- no값은 null이 되면 절대 안되고 데이터를 꼭 입력해줘야한다.
    name varchar(20)
  );

  데이터 입력 테스트:
  > insert into test1(no, name) values(1, 'aaaa');
  > insert into test1(no, name) values(null, 'bbb');
  > insert into test1(no, name) values(3, null);
  > insert into test1(no, name) values(null, null);

  #### 기본값 지정하기
  데이터를 입력할 때 컬럼을 생략하면 지정된 기본값이 대신 입력된다.
  > create table test1(
    no int not null,
    name varchar(20) default 'noname',
    age int default 20
  );

  > insert into test1(no, name, age) values(1, 'aaa', 30); -- 1 aaa 30

  값을 입력하지 않는 컬럼은 이름과 값 지정을 생략한다.
  > insert into test1(name, age) values('aaaa', 30); -- 오류 발생 이유는 no이 not null이기 때문에 데이터를 무조건 입력해줘야한다.

  컬럼에 default 값이 설정된 경우, 컬럼 값의 입력을 생략하면 기본값이 사용된다.
  > insert into test1(no, age) values(3, 30); -- 3 noname 30
  > insert into test1(no, name) values (4, 'ddd'); -- 4 ddd 20
  > insert into test1(no) values(5); -- 5 noname 20

  컬럼에 default 옵션이 있는 경우,
  - 컬럼 값을 생략하면 default 옵션으로 지정한 값이 사용된다.
  - 컬럼 값을 null로 지정하면 기본 값이 사용되지 않는다.
  > insert into test1(no, age, name) values(6, null, null);

  ### 컬럼 타입

  #### int
  - 4바이트 크기의 정수 값 저장
  - 기타 tinyint(1바이트), smallint(2바이트), mediumint(3바이트), bigint(8바이트)

  #### float
  - 부동소수점 저장

  #### numeric = decimal
  - 전체 자릿수와 소수점 이하의 자릿수를 정밀하게 지정할 수 있다.
  - numeric(n, e) : 전체 n자릿수 중에서 소수점은 e 자릿수이다.
    - 예) numeric(10,2) : 12345678.12 -- 전체 10자리수이고 소수점 아래 2자리를 뜻한다.
  - numeric : numeric(10,0) 과 같다.

  입력 테스트:
  > create table test1(
  c1 int,
  c2 float,
  c3 numeric(6,2), /* 소수점 자릿수를 지정하면 부동소수점으로 사용 */
  c4 numeric -- decimal 과 같다 numeric 과 int 차이는 numeric 은 숫자의 크기가 아니고 숫자의 자릿수이다
  );

  > insert into test1(c1) values(100); -- 100
  > insert into test1(c1) values(3.14); /* 소수점 이하 반올림하고 짜름 */ -- 3
  > insert into test1(c1) values(100.98); /* 소수점 이하 반올림하고 짜름 */ -- 101

  > insert into test1(c2) values(100); -- 100
  > insert into test1(c2) values(3.14); -- 3.14
  > insert into test1(c2) values(3.14159); -- 3.14159

  > insert into test1(c3) values(100); -- 100.00
  > insert into test1(c3) values(123456789); /* 입력 오류. 5자리 초과 */
  > insert into test1(c3) values(12345); /* 입력 오류. 1자리 초과 */
  > insert into test1(c3) values(1234); -- 1234.00
  > insert into test1(c3) values(3.14); -- 3.14
  > insert into test1(c3) values(3.14159); /* 2자리를 초과한 값은 반올림. */ -- 3.14
  > insert into test1(c3) values(3.14551); /* 2자리를 초과한 값은 반올림. */ -- 3.15

  > insert into test1(c4) values(1234567890); -- 1234567890
  > insert into test1(c4) values(12.34567890); /* 소수점은 반올림 처리됨 */ -- 12
  > insert into test1(c4) values(12345678.90); /* 소수점은 반올림 처리됨 */ -- 12345679

  #### char(n)
  - 최대 n개의 문자를 저장.
  - 0 <= n <= 255
  - 고정 크기를 갖는다.
  - 한 문자를 저장하더라도 n자를 저장할 크기를 사용한다.
  - 메모리 크기가 고정되어서 검색할 때 빠르다.

  #### varchar(n)
  - 최대 n개의 문자를 저장.
  - 0 ~ 65535 바이트 크기를 갖는다.
  - n 값은 문자집합규칙에 따라 최대 값이 다른다.
  - 한 문자에 1바이트를 사용하는 ISO-8859-n 문자집합인 경우 최대 65535 이다.
  - 그러나 UTF-8로 지정된 경우는, n은 최대 21844 까지 지정할 수 있다.
  - 가변 크기를 갖는다.
  - 한 문자를 저장하면 한 문자 만큼 크기의 메로리를 차지한다.
  - 메모리 크기가 가변적이라서 데이터 위치를 찾을 때 시간이 오래걸린다.
    그래서 검색할 때 위치를 계산해야 하기 때문에 검색 시 느리다.

  > create table test1 (
    c1 char(5),
    c2 varchar(5),
    c3 varchar(21000)
  );

  입력 테스트:
  > insert into test1(c1) values('');
  > insert into test1(c1) values('abcde');
  > insert into test1(c1) values('가나다라마'); /* 한글 영어 상관없이 5자 */
  > insert into test1(c1) values('abcdefghi'); /* 입력 크기 초과 오류! */
  > insert into test1(c1) values('가나다라마바'); /* 입력 크기 초과 오류! */

  > insert into test1(c2) values('');
  > insert into test1(c2) values('abcde');
  > insert into test1(c2) values('abcdefghi'); /* 입력 크기 초과 오류! */

  고정 크기와 가변 크기 비교:
  > insert into test1(c1) values('abc');
  > insert into test1(c2) values('abc');
  > select * from test1 where c1 = 'abc';
  DBMS 중에는 고정 크기인 컬럼의 값을 비교할 때 빈자리까지 검사하는 경우도 있다.
  즉 c1='abc' 에서는 데이터를 찾지 못하고, c1='abc  ' 여야만 데이터를 찾는 경우가 있다.
  그러나 mariadb는 고정크기 컬럼이더라도 빈자를 무시하고 데이터를 찾는다.

  #### text(65535), mediumtext(약 1.6mb), longtext(약 2GB)
  - 긴 텍스트를 저장할 때 사용하는 컬럼 타입이다.
  - 오라클의 경우 long타입과 CLOB(character large object) 타입이 있다.

  #### date
  - 날짜 정보를 저장할 때 사용한다.
  - 년,월,일 정보를 저장한다.
  - 오라클의 경우 날짜 뿐만 아니라 시간 정보도 저장한다.

  #### time
  - 시간 정보를 저장할 때 사용한다.
  - 시, 분, 초 정보를 저장한다.

  #### datetime
  - 날짜와 시간 정보를 함께 저장할 때 사용한다.

  > create table test1(
  c1 date,
  c2 time,
  c3 datetime
  );

  입력 테스터:
  > insert into test1(c1) values('2017-11-21'); -- 2017-11-21
  > insert into test1(c2) values('16:12:35'); -- 16:12:35
  > insert into test1(c3) values('2017-9-7 16:5:3'); -- 2017-09-07 16:5:3
  > insert into test1(c1) values('2017-11-21 16:13:33'); /* 날짜 정보만 저장*/ -- 2017-11-21
  > insert into test1(c2) values('2017-11-21 16:13:33'); /* 시간 정보만 저장*/ -- 16:13:33

  #### boolean
  - 보통 true, false를 의미하는 값을 저장할 때는 정수 1 또는 0 으로 표현한다.
  - 또는 문자로 Y 또는 N으로 표현하기도 한다.
  - 실제 컬럼을 생성할 때 tinyint(1)로 설정한다.

  > create table test1(
  c1 char(1),
  c2 int,
  c3 boolean
  );

  > insert into test1(c1) values('Y'); /* yes */
  > insert into test1(c1) values('N'); /* no */
  > insert into test1(c1) values('T'); /* true */
  > insert into test1(c1) values('F'); /* false */
  > insert into test1(c1) values('1'); /* true */
  > insert into test1(c1) values('0'); /* false */

  > insert into test1(c2) values(1); /* true */
  > insert into test1(c2) values(0); /* false */

  > insert into test1(c3) values('Y'); /* error */
  > insert into test1(c3) values('N'); /* error */
  > insert into test1(c3) values('T'); /* error */
  > insert into test1(c3) values('F'); /* error */

  > insert into test1(c3) values(true); /* 저장할 때 1 */
  > insert into test1(c3) values(false); /* 저장할 때 0 */
  > insert into test1(c3) values('1'); /* true -> 1 */
  > insert into test1(c3) values('0'); /* false -> 0 */
  > insert into test1(c3) values(1); /* true -> 1 */
  > insert into test1(c3) values(0); /* false -> 0 */

  - 숫자 컬럼인 경우 값을 설정할 때 문자로 표현할 수 있다.
  - 즉 문자열을 숫자로 바꿀 수 있으면 된다.


  ### 키 컬럼 지정

  테이블 :
  - no, name, email, id, pwd, jumin, tel, postno, basic_addr, gender

  #### key vs candidate key

  - key
   - 데이터를 구분할 때 사용하는 컬럼들의 집합
   - 예)
    - {email}, {jumin}, {id}, {name, tel}, {tel, basic, gender, name}
    - {name, jumin}, {email, id}, {id, name, email} ...
  - candidate key(후보키 = 최소키)
   - key 들 중에서 최소 항목으로 줄인 키
   - {jumin}, {email}, {id}, {name, tel}












