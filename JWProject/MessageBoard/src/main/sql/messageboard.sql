use course;

-- 建表
create table guestbook
(
  id int not null primary key auto_increment,
  name varchar(20) not null,
  phone varchar(20),
  email varchar(40),
  title varchar(80) not null,
  content varchar(2000),
  time varchar(20) not null
);

-- 将message表中数据导入guestbook
insert into guestbook(name, phone, email, title, content, time)
  select name, phone, email, title, content, (select now()) from message;