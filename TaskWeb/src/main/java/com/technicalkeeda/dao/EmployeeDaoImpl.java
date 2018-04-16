package com.technicalkeeda.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.technicalkeeda.bean.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = null;
		
		try {
			employees = jdbcTemplate.query("SELECT * FROM trn_employee", new BeanPropertyRowMapper<Employee>(Employee.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return employees;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		Employee employee = null;
		
		try {
			employee = jdbcTemplate.queryForObject("SELECT * FROM trn_employee WHERE employee_id = ?", 
					new Object[] {employeeId}, new BeanPropertyRowMapper<Employee>(Employee.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return employee;
	}

	@Override
	public int deleteEmployee(Long employeeId) {
		int count = jdbcTemplate.update("DELETE from trn_employee WHERE employee_id = ?", new Object[] {employeeId});
		return count;
	}

	@Override
	public int updateEmployee(Employee employee) {
		int count = jdbcTemplate.update(
				"UPDATE trn_employee set first_name = ?, last_name = ?, age = ?, where employee_id = ?", new Object[] {
						employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getEmployeeId() });
		return count;
	}

	@Override
	public int createEmployee(Employee employee) {
		int count = jdbcTemplate.update(
				"INSERT INTO trn_employee(employee_id, first_name, last_name, age) VALUES(?, ?, ?, ?)", new Object[] {
						employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getAge() });
		return count;
	}

}
