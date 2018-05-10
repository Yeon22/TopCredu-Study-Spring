use testdb;

create table employee(
	empno int(255) primary key auto_increment,
	ename varchar(20),
	gender varchar(2),
	job varchar(20),
	position varchar(20),
	email varchar(30),
	salary int(255),
	hiredate date,
	createdDate datetime default localtimestamp,
	lastUpdateDate datetime default localtimestamp
);

insert into employee values(default,'김길동','남','개발자','사원','csc1234@gmail.com',3000,'20170502',default,default);
insert into employee values(default,'홍길동','남','퍼블리셔','대리','HKD1313@gamil.com',4500,'20160402',default,default);
insert into employee values(default,'임꺾정','남','영업사원','사원','LMK@naver.com',2500,'20170202',default,default);
insert into employee values(default,'장길산','남','영업사원','사원','JKS@naver.com',2500,'20170102',default,default);
insert into employee values(default,'장그래','남','영업사원','대리','misang@naver.com',3000,'20160202',default,default);
insert into employee values(default,'한석율','남','영업사원','과장','hsus@naver.com',3200,'20160202',default,default);
insert into employee values(default,'손민정','여','개발자','사원','SMJ@naver.com',3000,'20170502',default,default);
insert into employee values(default,'송윤선','여','PL','과장','SUS@gamil.com',3500,'20120502',default,default);
insert into employee values(default,'전희영','여','개발자','대리','JHY1314@gamil.com',3300,'20140502',default,default);
insert into employee values(default,'이민교','남','개발자','대리','LMK1313@gamil.com',3100,'20170502',default,default);
insert into employee values(default,'송석원','남','PM','차장','SSW414@gamil.com',4000,'20070502',default,default);
insert into employee values(default,'김동현','남','개발자','사원','KDH@gamil.com',3000,'20170502',default,default);
insert into employee values(default,'이경민','남','개발자','사원','LGM@gamil.com',3000,'20170502',default,default);
insert into employee values(default,'박수연','여','개발자','사원','PSW@gamil.com',3000,'20170502',default,default);
insert into employee values(default,'이종철','남','아키텍트','부장','topcre@topcre.com',5000,'19970502',default,default);
insert into employee values(default,'선지영','여','영업사원','차장','SJoo@naver.com',4000,'20000502',default,default);

select * from employee;

commit;