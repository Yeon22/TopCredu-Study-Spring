use myuser;

create table employee(
	empno int(255) auto_increment,
	ename varchar(20),
	job varchar(20),
	salary int(255),
	hiredate date,
	primary key(empno)
);

insert into employee values(default, '김기남', '개발팀', 1600000, '20170304');
insert into employee values(default, '박이나', '디자인팀', 1800000, '20180501');
insert into employee values(default, '하리수', '개발팀', 2000000, '20160101');
insert into employee values(default, '유재석', '영업팀', 2200000, '20140820');
insert into employee values(default, '김종국', '개발팀', 3000000, '20171217');

select * from employee;

commit;