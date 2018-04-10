package edu.biz.ioc5;

import org.springframework.stereotype.Component;

@Component("money") //DTO같은 컴포넌트 클래스임을 의미, @Named와 동일
public class Money {
	private int amount;
	
	public Money() {}
	
	public Money(int amt) {
		this.amount = amt;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
