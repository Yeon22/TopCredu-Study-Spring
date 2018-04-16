package onj.edu.tr2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import onj.edu.tr2.model.Emp;

@Repository("onjDao")
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
	
	@Transactional
	public void insertEmps() throws Exception {
		String sql = "insert into emp(empno, ename, deptno) values(?, ?, ?)";
		
		jdbcTemplate.update(sql, new Object[] { 1771, "오자바1", 10 });
		jdbcTemplate.update(sql, new Object[] { 1772, "오자바2", 20 });
		jdbcTemplate.update(sql, new Object[] { 1773, "오자바3", 30 });
		
		//같은 데이터를 넣으면 키값이 중복되어 DataAceessException 발생(런타임예외)
		jdbcTemplate.update(sql, new Object[] { 1773, "오자바3", 30 });
		
		//아래 주석을 풀면 Exception이 발생하므로 트랜잭션은 롤백
		//onjoracle.javaxml에서 rollback-for="Exception"으로 정의했기 때문
		//만약 정의하지 않았다면 주석을 풀더라도 트랜잭션은 롤백안됨
		throw new Exception();
	}
}
