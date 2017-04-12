create table users
(
  user_id int not null auto_increment,
  user_name varchar(32) not null,
  user_gender varchar(6) not null,
  user_avatar varchar(32) not null
);

create table user_auths
(
  id int not null auto_increment,
  user_id int not null,
  identity_type varchar(32) not null,
  identifier varchar(32) not null,
  credential varchar(200) not null
);

alter table user_auths add constraint fk_user_id_user_auths_users foreign key(user_id) references users(user_id);

