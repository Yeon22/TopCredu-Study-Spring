package edu.ojc.setter2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Develope {
	Emp emp;
	
	@Autowired
	@Qualifier("programmer")
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	void coding() {
		emp.gotoOffice();
		System.out.println("개발합니다....");
		emp.getoffWork();
	}
}
