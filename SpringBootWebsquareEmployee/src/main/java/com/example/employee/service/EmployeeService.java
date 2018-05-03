package com.example.employee.service;

import java.util.List;

import com.example.employee.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee selectByEmpNo(int empno);
	public int createEmployee(Employee employee);
	public int updateEmployee(Employee employee);
	public int deleteByEmpNo(int empno);
	boolean isEmployeeExist(Employee employee);
}
