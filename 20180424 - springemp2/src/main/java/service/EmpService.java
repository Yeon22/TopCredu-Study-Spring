package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpDao;
import model.Emp;

@Service
public class EmpService {
	@Autowired
	private EmpDao dao;
	
	public List<Emp> getEmpAll() {
		return dao.getEmpAll();
	}
}
