-- 오라클은 IF EXISTS 구문을 지원하지 않는다.
-- 따라서, 대상 테이블이 존재할 때 삭제하는 조건 쿼리를 사용할 수 없다.
-- 삭제 대상이 없을 때, 지우려고 하면 에러가 발생한다.
-- 이렇게 발생하는 에러를 흡수하여 무시하기 위해서 프로시져를 사용한다.
-- 안타깝게도 이클립스에서 프로시져를 실행할 수 없다.
-- 다음 쿼리를 오라클 전용 툴을 사용하여 선 실행하여 디비에 미리 프로시져를
-- 만들어 놓고 schema.sql에서 사용한다.

-------------------------------------------------
-- schema.sql에서 사용 : call p_drop_table('테이블명');
-------------------------------------------------
create or replace PROCEDURE P_DROP_TABLE(i_table IN VARCHAR2) AS 
BEGIN
	BEGIN
		EXECUTE IMMEDIATE 'DROP TABLE ' || upper(i_table);
	EXCEPTION
		WHEN OTHERS THEN
			IF SQLCODE != -942 THEN
				RAISE;
			END IF;
	END;
	DBMS_OUTPUT.PUT_LINE('TABLE ' || upper(i_table) || ' DROPPED OR NONE.');
END P_DROP_TABLE;

-------------------------------------------------
-- schema.sql에서 사용 : call p_drop_seq('시퀀스명');
-------------------------------------------------
create or replace PROCEDURE P_DROP_SEQ(i_seq IN VARCHAR2) AS 
BEGIN
	BEGIN
		EXECUTE IMMEDIATE 'DROP SEQUENCE ' || upper(i_seq);
	EXCEPTION
		WHEN OTHERS THEN
			IF SQLCODE != -2289 THEN
				RAISE;
			END IF;
	END;
	DBMS_OUTPUT.PUT_LINE('SEQUENCE ' || upper(i_seq) || ' DROPPED OR NONE.');
END P_DROP_SEQ;