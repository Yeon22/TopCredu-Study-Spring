package edu.onj.function;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import oracle.jdbc.OracleTypes;

public class EmpDaoImpl implements EmpDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	//여러건의 Emp 데이터를 BatchPreparedStatementSetter를 이용하여 일괄 INSERT
	public int[] createEmpList(final List<Emp> emps) {
		String SQL = "insert into emp(empno, ename, sal) values(?, ?, ?)";
		BatchPreparedStatementSetter setter = new BatchPreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				Emp emp = emps.get(index);
				int parameterIndex = 1;
				ps.setString(parameterIndex++, emp.getEmpno());
				ps.setString(parameterIndex++, emp.getEname());
				ps.setString(parameterIndex++, emp.getSal());
			}
			
			public int getBatchSize() {
				return emps.size();
			}
		};
		
		return jdbcTemplate.batchUpdate(SQL, setter);
	}

	//오라클 Stored Function을 호출하여 10번부서 사원리스트 출력(REF CURSOR)
	public List<Emp> listEmp(Integer deptno) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.dataSource)
				.withSchemaName("scott")
				.withFunctionName("getEmp")
				.declareParameters(
						new SqlOutParameter("emp_cursor", OracleTypes.CURSOR, new EmpMapper()),
						new SqlParameter("v_deptno", Types.INTEGER)).withoutProcedureColumnMetaDataAccess();
		SqlParameterSource params = new MapSqlParameterSource("v_deptno", deptno);
		
		//execute 메소드는 Map 형태로 리턴한다.
		Map<String, Object> resultSet = simpleJdbcCall.execute(params);
		return (List<Emp>)resultSet.get("emp_cursor");
	}

}
