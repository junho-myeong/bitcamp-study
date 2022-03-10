-- 자바 필드명과 DBMS에 컬럼 명이 같을 필요없다 각자 규칙에 맞게 설정한다
create table ml_board(
  board_no int not null,
  title varchar(255) not null,
  content text not null,
  created_date datetime default now(),
  view_count int default 0 
);

alter table ml_board
  add constraint ml_board_pk primary key(board_no);

alter table ml_board
 modify column board_no int not null auto_increment;





