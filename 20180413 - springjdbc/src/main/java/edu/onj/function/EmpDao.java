package edu.onj.function;

import java.util.List;

import javax.sql.DataSource;

public interface EmpDao {
	public void setDataSource(DataSource ds);
	public int[] createEmpList(final List<Emp> emps);
	public List<Emp> listEmp(Integer deptno);
}
