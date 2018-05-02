package com.example.websquare.service;

import java.util.List;

import com.example.websquare.model.Emp;

public interface EmpService {
	List<Emp> findAllEmps();
	Emp findByEmpno(int empno);
	boolean isEmpExist(Emp emp);
	void saveEmp(Emp emp);
	void updateEmp(Emp currentEmp);
	void deleteEmpByEmpno(int empno);
	void deleteAllEmps();
}
