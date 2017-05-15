use course;

create table image
(
  id int not null primary key auto_increment,
  name varchar(16) default null,
  url varchar(255) default null,
  date datetime default null,
  user_id int default null
);

create table user
(
  id int not null auto_increment primary key,
  userName varchar(16) default null,
  password varchar(16) default null
);