package edu.onj.function2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Emp> {

	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Emp emp = new Emp();
		emp.setEmpno(rs.getString("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setSal(rs.getString("sal"));
		return emp;
	}

}
