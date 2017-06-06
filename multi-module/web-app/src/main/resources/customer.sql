use course;

create table customer
(
  id int not null primary key auto_increment,
  ip varchar(20) not null,
  times int not null,
  created datetime,
  updated datetime
);
