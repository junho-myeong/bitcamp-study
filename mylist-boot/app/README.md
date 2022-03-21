# 13.1 서비스 객체 도입 : Mybatis의 트랜잭션 제어

- mybatis 에서 트랜잭션 제어하는 방법

## 백엔드 개발 실습

### 1단계 - 연락처에 여러 개의 전화번호를 입력할 수 있도록 자식 테이블을 추가한다.

```
drop table ml_contact;
drop table ml_tel_type;

-- 연락처
create table ml_contact(
  contact_no int not null,
  name varchar(50) not null,
  email varchar(20) not null,
  company varchar(50)
);

alter table ml_contact
  add constraint primary key (contact_no),
  modify column contact_no int not null auto_increment;

-- 전화번호 유형
create table ml_tel_type(
  tt_no int not null,
  title varchar(20) not null
);

alter table ml_tel_type
  add constraint primary key (tt_no),
  modify column tt_no int not null auto_increment;

-- 연락처 전화번호
create table ml_cont_tel(
  ct_no int not null, -- 전화번호 PK
  contact_no int not null, -- 연락처 PK
  tt_no int not null, -- 전화번호 유형 PK
  tel varchar(20) not null -- 전화번호
);

alter table ml_cont_tel
  add constraint primary key (ct_no),
  modify column ct_no int not null auto_increment;

alter table ml_cont_tel
  add constraint ml_cont_tel_fk1
      foreign key (contact_no) references ml_contact(contact_no),
  add constraint ml_cont_tel_fk2
      foreign key (tt_no) references ml_tel_type(tt_no);   

```

### 2단계 - 연락처 테이블에 예제 데이터를 넣는다.
```
-- 전화번호 유형 입력
insert into ml_tel_type(tt_no, title) values(1, '전화');
insert into ml_tel_type(tt_no, title) values(2, '팩스');
insert into ml_tel_type(tt_no, title) values(3, '휴대전화');
insert into ml_tel_type(tt_no, title) values(4, '직장전화');
insert into ml_tel_type(tt_no, title) values(5, '직장팩스');

-- 연락처 기본 정보 입력
insert into ml_contact(contact_no,name,email,company)
  values(1, '사람1', 'user1@test.com', '비트캠프');
insert into ml_contact(contact_no,name,email,company)
  values(2, '사람2', 'user2@test.com', '비트캠프');
insert into ml_contact(contact_no,name,email,company)
  values(3, '사람3', 'user3@test.com', '비트캠프');

-- 연락처에 전화번호 추가
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(1, 1, 1, '02-1111-1111');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(2, 1, 2, '02-1111-1112');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(3, 1, 3, '010-1111-1111');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(4, 2, 3, '010-1111-2222');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(5, 3, 3, '010-1111-3333');    
```
  
### 3단계 - 연락처 데이터를 다룰 DAO를 준비한다.

- com.eomcs.mylist.dao.ContactDao 인터페이스를 변경한다.
  - 연락처의 전화번호를 다루는 메서드 추가

## 프론트엔드 개발 실습

### 1단계 - 미니 jQuery 라이브러리를 만든다.

- /src/main/resources/static/myQuery.js 생성
  - jQuery를 모방하여 일부 함수를 만든다.
- /src/main/resources/static/todo/index.html 변경
  - myQuery 라이브러리를 HTML 에 적용한다.

### 2단계 - 미니 jQuery 라이브러리를 압축한다.

- /src/main/resource/static/myQuery.min.js 생성
  - javascript 또는 CSS 파일을 압축하는 사이트의 도움을 받는다.
- /src/main/resources/static/todo/index.html 변경
  - myQuery 라이브러리를 HTML 에 적용한다.

### 3단계 - 진짜 jQuery 라이브러리를 적용한다.

- /src/main/resources/static/todo/index.html 변경
  - myQuery 라이브러리 대신 CDN 방식으로 진짜 jQuery 라이브러리를 적용한다.

### 4단계 - NPM을 이용하여 라이브러리를 자동으로 다운받는다.

- /src/main/resources/static/ 폴더에 jQuery 라이브러리를 다운로드 한다.
  - `npm init` 실행하여 package.json 설정 파일을 준비한다.
  - `npm install jquery` 실행하여 jQuery 라이브러리를 설치한다.
  - `npm install sweetalert2` 실행하여 SweetAlert2 라이브러리를 설치한다.
- /src/main/resources/static/todo/index.html 변경
  - CDN 라이브러리 대신 npm으로 다운로드 받은 라이브러리를 사용한다.






#
