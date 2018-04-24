-------------------------------------------------
-- 오라클 프로시져를 이용하여 테이블 삭제를 진행하기 위해서,
-- 먼저 procedure-to-drop.sql 파일에 있는 프로시져 생성쿼리를
-- SqlPlus 또는, SqlDeveloper에서 실행하여 만든다.
-------------------------------------------------

call p_drop_table('xuser');

CREATE TABLE XUSER (
	EMAIL VARCHAR2(100) NOT NULL PRIMARY KEY,
	PASSWORD VARCHAR2(100) DEFAULT '1234'
);

-------------------------------------------------

call p_drop_table('xboard');

CREATE TABLE XBOARD (
	ID NUMBER(10,0) NOT NULL PRIMARY KEY,
	WRITER VARCHAR2(100) DEFAULT NULL,
	TITLE VARCHAR2(255) DEFAULT NULL,
	CONTENT VARCHAR2(4000) DEFAULT NULL,
	REG_DATE DATE DEFAULT NULL,
	HIT_COUNT NUMBER(10,0) DEFAULT 0
);

-------------------------------------------------

call p_drop_seq('xboard_seq');

CREATE SEQUENCE XBOARD_SEQ
	START WITH 1
	INCREMENT BY 1
	NOMAXVALUE
	NOMINVALUE
	NOCYCLE
	NOCACHE;





