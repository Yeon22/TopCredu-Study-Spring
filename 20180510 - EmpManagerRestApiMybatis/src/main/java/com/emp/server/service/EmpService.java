package com.emp.server.service;

import java.util.List;
import java.util.Map;

import com.emp.server.model.Emp;

public interface EmpService {
	int createEmp(Emp emp);
	int updateEmp(Emp emp);
	int deleteEmpByEmpNo(int empno);
	List<Emp> getAllEmps();
	Map searchMember(Emp emp);
}
