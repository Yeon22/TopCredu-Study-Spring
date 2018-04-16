package jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jdbc.model.Emp;

@Repository
public class EmpDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//EMP 테이블 전체 데이터 SELECT
	public List<Emp> getEmpAll() throws DataAccessException{
		List<Emp> empList = null;
		String sql = "select empno, ename, sal from emp";
		empList = this.jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp emp = new Emp();
				emp.setEmpno(rs.getLong("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getLong("sal"));
				
				return emp;
			}
			
		});
		
		return empList;
	}
}
