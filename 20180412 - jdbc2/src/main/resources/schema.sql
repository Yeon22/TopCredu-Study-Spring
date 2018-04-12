drop database if exists jdbc2;
create database jdbc2;
use jdbc2;
create table emp
(
	empno int(4) not null auto_increment,
	ename varchar(50),
	primary key (empno)
) ENGINE=InnoDB;
