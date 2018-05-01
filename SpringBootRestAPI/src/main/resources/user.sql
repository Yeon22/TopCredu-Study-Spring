use myuser;

create table user(
	id int not null Auto_increment primary key,
	name varchar(50),
	age int(10),
	salary int(50)
);

drop table user;

select * from user;

insert into user(name,age,salary) values("test1",20,15000000);
insert into user(name,age,salary) values("test2",20,15000000);
insert into user(name,age,salary) values("test3",20,15000000);

commit;