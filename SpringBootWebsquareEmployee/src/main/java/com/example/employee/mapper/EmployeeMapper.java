package com.example.employee.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.employee.model.Employee;

@Mapper
public interface EmployeeMapper {
	public int insert(Employee employee);
	public int update(Employee employee);
	public int deleteByEmpNo(int empno);
	
	@Select("SELECT * FROM employee")
	public List<Employee> findAllEmployees();
	
	public Employee selectByEmpNo(int empno);
}
