package edu.ojc2;

public class Designer extends Emp {

	@Override
	public Emp getEmp() {
		return this;
	}
	
	public void work() {
		System.out.println("디자이너가 디자인을 합니다.");
	}

}
