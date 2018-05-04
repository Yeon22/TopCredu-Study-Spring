use test;

create table village(
	id int(10) not null auto_increment,
	name varchar(50) null default null,
	district varchar(50) null default null,
	primary key(id)
);

select * from village;

drop table village;

commit;