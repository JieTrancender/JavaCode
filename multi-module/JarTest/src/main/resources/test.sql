user course;

alter table user_auths_test
  change column user_id userId varchar(32) not null;

alter table user_auths_test
  change column identity_type identityType varchar(32) not null;

alter table user_auths_test
  change column credential_digest credentialDigest varchar(200) not null;

alter table user_auths_test
  change column remember_me_digest rememberMeDigest varchar(200) null;

alter table users_test
  change column user_id userId varchar(32) not null;

alter table users_test
  change column user_name name varchar(32) not null;

alter table users_test
  change column user_gender gender varchar(6) null;

alter table users_test
  change column user_avatar avatar varchar(32) null;

select u.userId, name, gender, avatar, identityType, identifier, credentialDigest, rememberMeDigest
from users_test u inner join user_auths_test a on u.userId = a.userId where identityType = 'email' and identifier = '582865471@qq.com';
