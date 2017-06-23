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
  select name, phone, email, title, content, (select now()) from messageOld;

alter table guestbook
    add column hostId varchar(32);

alter table guestbook
    add column friendId varchar(32);

use course;
create table msg_record
(
  id int not null primary key,
  hostId varchar(32) not null,
  friendId varchar(32) not null
);

alter table msg_record
add constraint msg_record_host_id foreign key(hostId) references user_auths(userId);

alter table msg_record
add constraint msg_record_friend_id foreign key(friendId) references user_auths(userId);

create table msg
(
  id int not null primary key auto_increment,
  hostId varchar(32) not null,
  friendId varchar(32) not null,
  content varchar(2000)
);

alter table msg
    add column time varchar(40) not null;