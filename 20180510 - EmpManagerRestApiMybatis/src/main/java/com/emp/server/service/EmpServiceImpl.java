package com.emp.server.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.server.mapper.EmpMapper;
import com.emp.server.model.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public int createEmp(Emp emp) {
		return empMapper.insert(emp);
	}

	@Override
	public int updateEmp(Emp emp) {
		return empMapper.update(emp);
	}

	@Override
	public int deleteEmpByEmpNo(int empno) {
		return empMapper.deleteByEmpNo(empno);
	}

	@Override
	public List<Emp> getAllEmps() {
		return empMapper.findAllEmps();
	}

	@Override
	public Map searchMember(Emp emp) {
		return empMapper.selectByEmp(emp);
	}

}
