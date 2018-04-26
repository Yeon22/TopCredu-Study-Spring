package edu.ojc.setter1;

public class Develope {
	Emp emp;
	
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	void coding() {
		emp.gotoOffice();
		System.out.println("개발합니다...");
		emp.getoffWork();
	}
}
