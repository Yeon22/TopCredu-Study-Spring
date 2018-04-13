package edu.onj.function2;

public class Emp {
	private String empno;
	private String ename;
	private String sal;
	
	public Emp() {};
	
	public Emp(String empno, String ename, String sal) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}
}
