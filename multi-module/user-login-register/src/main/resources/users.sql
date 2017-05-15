use course;

create table users
(
  id int not null,
  user_id varchar(32) not null,
  user_name varchar(32) not null,
  user_gender varchar(6),
  user_avatar varchar(32)
);
alter table users add constraint pk_users primary key(id, user_id);
alter table users modify column id int not null auto_increment;
alter table users add index index_name(user_id);

create table user_auths
(
  id int not null,
  user_id varchar(32) not null,
  identity_type varchar(32) not null,
  identifier varchar(32) not null,
  credential varchar(200) not null
);
alter table user_auths add constraint pk_user_auths primary key(id);
alter table user_auths modify column id int not null auto_increment;
alter table user_auths  add constraint uk_user_auths unique key(identity_type, identifier);
alter table user_auths add index index_name(user_id);
alter table user_auths add constraint fk_user_id_user_auths foreign key(user_id) references users(user_id);

alter table user_auths change credential credential_digest varchar(200) not null;

alter table user_auths add column remember_me_digest varchar(200) null;

update user_auths set remember_me_digest = 'deme' where user_id = '999AE93AA4A74DFA9ADDC1809AF901FE';

alter table user_auths
change column user_id userId varchar(32) not null;

alter table user_auths
change column identity_type identityType varchar(32) not null;

alter table user_auths
    change column credential_digest credentialDigest varchar(200) not null;

alter table user_auths
    change column remember_me_digest rememberMeDigest varchar(200) null;

