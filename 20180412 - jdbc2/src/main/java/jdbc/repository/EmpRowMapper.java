package jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jdbc.domain.Emp;

@Repository
public class EmpRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long empno = rs.getLong("empno");
		String ename = rs.getString("ename");
		
		return new Emp(empno, ename);
	}
	
}
