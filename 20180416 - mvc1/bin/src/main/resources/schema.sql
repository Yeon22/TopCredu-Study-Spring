drop database if exists mvc1;
create database mvc1;
use mvc1;
create table emp(
	empno int(4) not null auto_increment,
	ename varchar(50),
	sal int(4),
	primary key(empno)
) ENGINE=InnoDB;
