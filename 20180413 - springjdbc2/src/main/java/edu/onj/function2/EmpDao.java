package edu.onj.function2;

import java.util.List;

import javax.sql.DataSource;

public interface EmpDao {
	public List<Emp> listEmp(Integer deptno);
}
