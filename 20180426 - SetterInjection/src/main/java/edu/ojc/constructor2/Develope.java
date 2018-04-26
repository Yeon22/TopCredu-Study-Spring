package edu.ojc.constructor2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Develope {
	Emp emp;
	
	@Autowired
	public void setEmp(@Qualifier("programmer")Emp emp) {
		this.emp = emp;
	}
	
	void coding() {
		emp.gotoOffice();
		System.out.println("개발합니다....");
		emp.getoffWork();
	}
}
