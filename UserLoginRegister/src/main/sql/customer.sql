create database if not exists customers;
use customers;

create table t_customer
(
  id char(32) primary key,
  name varchar(40) not null,
  gender varchar(6) not null,
  birthday char(10),
  cellphone varchar(15) not null,
  email varchar(40),
  description varchar(500)
);

select * from t_customer;