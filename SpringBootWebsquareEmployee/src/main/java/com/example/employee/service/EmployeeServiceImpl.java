package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.mapper.EmployeeMapper;
import com.example.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeMapper.findAllEmployees();
	}

	@Override
	public Employee selectByEmpNo(int empno) {
		return employeeMapper.selectByEmpNo(empno);
	}

	@Override
	public int createEmployee(Employee employee) {
		return employeeMapper.insert(employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeMapper.update(employee);
	}

	@Override
	public int deleteByEmpNo(int empno) {
		return employeeMapper.deleteByEmpNo(empno);
	}

	@Override
	public boolean isEmployeeExist(Employee employee) {
		if(employeeMapper.selectByEmpNo(employee.getEmpno()) == null) {
			return false;
		} else {
			return true;
		}
	}

}
