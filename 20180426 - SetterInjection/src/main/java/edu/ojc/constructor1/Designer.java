package edu.ojc.constructor1;

public class Designer implements Emp {

	@Override
	public void gotoOffice() {
		System.out.println("디자이너 출근 합니다.");
	}

	@Override
	public void getoffWork() {
		System.out.println("디자이너 퇴근 합니다.");
	}

}
