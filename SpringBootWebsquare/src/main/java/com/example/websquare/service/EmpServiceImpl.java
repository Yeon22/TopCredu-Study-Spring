package com.example.websquare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websquare.model.Emp;
import com.example.websquare.repository.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<Emp> findAllEmps() {
		return empMapper.findAllEmps();
	}

	@Override
	public Emp findByEmpno(int empno) {
		return empMapper.findByEmpno(empno);
	}

	@Override
	public boolean isEmpExist(Emp emp) {
		if(empMapper.findByEmpno(emp.getEmpno()) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void saveEmp(Emp emp) {
		empMapper.saveEmp(emp);
	}

	@Override
	public void updateEmp(Emp currentEmp) {
		empMapper.updateEmp(currentEmp);
	}

	@Override
	public void deleteEmpByEmpno(int empno) {
		empMapper.deleteEmpByEmpno(empno);
	}

	@Override
	public void deleteAllEmps() {
		empMapper.deleteAllEmps();
	}

}
