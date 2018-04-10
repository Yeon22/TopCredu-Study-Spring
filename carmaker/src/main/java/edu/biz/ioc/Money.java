package edu.biz.ioc;

public class Money {
	private int amount;
	
	public Money() {}
	
	public Money(int amt) {
		this.amount = amt;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amt) {
		this.amount = amt;
	}
}
