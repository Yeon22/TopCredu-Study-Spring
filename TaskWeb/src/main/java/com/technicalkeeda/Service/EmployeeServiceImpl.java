package com.technicalkeeda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technicalkeeda.bean.Employee;
import com.technicalkeeda.dao.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeDao.getEmployees();
		return employees;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		Employee employee = employeeDao.getEmployee(employeeId);
		return employee;
	}

	@Override
	public int deleteEmployee(Long employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public int createEmployee(Employee employee) {
		return employeeDao.createEmployee(employee);
	}

}
