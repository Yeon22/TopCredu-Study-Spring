package edu.onj.function2;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import oracle.jdbc.OracleTypes;

public class EmpJDBCTemplate extends StoredProcedure implements EmpDao {
	private DataSource dataSource;
	private static final String SQL = "getEmp";
	
	public EmpJDBCTemplate(DataSource dataSource) {
		super(dataSource, SQL);
		setFunction(true);
		declareParameter(new SqlOutParameter("emp_cursor", OracleTypes.CURSOR, new EmpMapper()));
		declareParameter(new SqlParameter("v_deptno", Types.INTEGER));
	}


	public List<Emp> listEmp(Integer deptno) {
		Map<String, Object> resultSet = execute(deptno);
		ArrayList<Emp> list = (ArrayList)resultSet.get("emp_cursor");
		return list;
	}
	
}
