package edu.ojc.constructor2;

import org.springframework.stereotype.Service;

@Service
public class Programmer implements Emp {

	@Override
	public void gotoOffice() {
		System.out.println("프로그래머 출근 합니다.");
	}

	@Override
	public void getoffWork() {
		System.out.println("프로그래머 퇴근 합니다.");
	}

}
