package onj.edu.tr2.model;

public class Emp {
	int empno;
	String ename;
	int deptno;
	
	public Emp(int empno, String ename, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}
