package onj.edu.mybatis.dao;

import onj.edu.mybatis.model.MyEmp;

public interface MyEmpDao {
	//empno를 key로 데이터 select
	public MyEmp getMyEmp(int empno);
	//insert
	public int setMyEmp(MyEmp myEmp);
	//update
	public int updateMyEmp(MyEmp myEmp);
}
