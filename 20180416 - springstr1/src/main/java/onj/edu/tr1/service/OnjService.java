package onj.edu.tr1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onj.edu.tr1.dao.OnjDao;
import onj.edu.tr1.model.Emp;

@Service
public class OnjService {
	@Autowired
	private OnjDao dao;
	
	public OnjService() {};
	public OnjService(OnjDao onjDao) {
		this.dao = onjDao;
	}
	
	public List<Emp> getEmpByDeptno(int deptno){
		return dao.getEmpByDeptno(deptno);
	}
	
	public void insertEmps() throws Exception{
		dao.insertEmps();
	}
}
