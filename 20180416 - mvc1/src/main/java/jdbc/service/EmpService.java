package jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbc.model.Emp;
import jdbc.repository.EmpDAO;

@Service
public class EmpService {
	@Autowired
	private EmpDAO dao;
	
	public List<Emp> getEmpAll(){
		return dao.getEmpAll();
	}
}
