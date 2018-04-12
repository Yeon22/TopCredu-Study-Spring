package jdbc.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jdbc.domain.Emp;

@Repository
@Transactional(readOnly=true)
public class EmpRepositorylmpl implements EmpRepository {
	private SimpleJdbcInsert jdbcInsert;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	RowMapper<Emp> empRowMapper;
	
	@Autowired //스프링부트에서 DataSource를 자동 주입해준다.
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> emps = jdbcTemplate.query("select empno, ename from emp", empRowMapper);
		return emps;
	}

	@Override
	public Emp findOne(Long empno) {
		return (Emp)jdbcTemplate.queryForObject("select empno, ename from emp where empno=?", empRowMapper, empno);
	}

	@Override
	@Transactional(readOnly=false)
	public Emp save(Emp emp) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(emp);
		
		if(emp.getEmpno() == null) {
			Number key = jdbcInsert.executeAndReturnKey(param);
			emp.setEmpno(key.longValue());
		} else {
			this.jdbcTemplate.update("insert into emp(empno, ename) values(?, ?)", emp.getEmpno(), emp.getEname());
		}
		
		return emp;
	}

	@Override
	@Transactional(readOnly=false)
	public void delete(Long empno) {
		this.jdbcTemplate.update("delete from emp where empno=?", empno);
	}
	
	//생성자가 실행된 후에 실행된다.
	@PostConstruct
	public void init() {
		//INSERT SQL Auto Create
		jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("emp").usingGeneratedKeyColumns("empno");
	}

}
