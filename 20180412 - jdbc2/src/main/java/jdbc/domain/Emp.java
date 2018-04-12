package jdbc.domain;

public class Emp {
	private Long empno;
	private String ename;
	
	public Emp() {};
	
	public Emp(String ename) {
		this.ename = ename;
	}
	
	public Emp(Long empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}
	
	public Long getEmpno() {
		return empno;
	}
	
	public void setEmpno(Long empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String toString() {
		return "[empno=" + empno + ",ename=" + ename + "]";
	}
}
