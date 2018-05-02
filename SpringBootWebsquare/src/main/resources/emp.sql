use myuser;

create table emp(
	empno int not null Auto_increment primary key,
	name varchar(50),
	job varchar(100),
	salary int,
	hiredate datetime default current_timestamp
);

drop table emp;

select * from emp;

insert into emp (name, job, salary) values('홍길동', '개발팀', 1700000);

commit;