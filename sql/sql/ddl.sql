drop table if exists user CASCADE;

create table user1
(
 id number generated by default as identity,
 name varchar(255),
 primary key (idx)
);