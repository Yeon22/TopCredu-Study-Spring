package edu.ojc2;

public class Programmer extends Emp {

	@Override
	public Emp getEmp() {
		return this;
	}
	
	public void work() {
		System.out.println("프로그래머가 개발을 합니다.");
	}

}
