package edu.ojc2;

public abstract class Emp {
	public Emp() {}
	
	public void work() {
		getEmp().work(); //주입받은 객체의 getEmp() 메소드를 사용
	}
	
	//getEmp를 주입, Emp가 주입된다.
	//Run-Time중에 xml 파일로 부터 빈을 주입받는다.
	public abstract Emp getEmp();
}
