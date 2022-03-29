create table ml_book(
  book_no int not null,
  title varchar(255) not null,
  author varchar(100) not null,
  press varchar(100) not null,
  feed text not null,
  read_date date,
  page int,
  price int
);


alter table ml_book 
  add column photo varchar(255)





#
