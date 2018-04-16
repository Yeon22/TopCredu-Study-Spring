package onj.edu.tr1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import onj.edu.tr1.model.Emp;

@Repository
public class OnjDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Emp> getEmpByDeptno(int deptno){
		String sql = "select empno, ename, deptno from emp where deptno = ?";
		List<Emp> list = jdbcTemplate.query(
				sql, 
				new Object[] { deptno },
				new RowMapper() {
					public Object mapRow(ResultSet rs, int index) throws SQLException {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int deptno = rs.getInt("deptno");
						
						return new Emp(empno, ename, deptno);
					}
				}
		);
		
		return list;
	}
	
	public void insertEmps() throws Exception {
		String sql = "insert into emp(empno, ename, deptno) values(?, ?, ?)";
		
		jdbcTemplate.update(sql, new Object[] { 111, "Onj1", 10 });
		
		jdbcTemplate.update(sql, new Object[] { 222, "Onj2", 20 });
		
		jdbcTemplate.update(sql, new Object[] { 333, "Onj3", 30 });
		
		//같은 데이터를 넣으면 키값이 중복되어 DataAccessException 발생(런타임예외)
		jdbcTemplate.update(sql, new Object[] { 333, "Onj3", 30 });
		
//		throw new Exception();
	}
}
