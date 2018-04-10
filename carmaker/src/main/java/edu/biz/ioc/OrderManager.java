package edu.biz.ioc;

public class OrderManager {
	private CarMaker maker;
	
	public OrderManager() {
		this.maker = new HyundaiMaker();
	}
	
	public void order() {
		Car car = this.maker.sell(new Money(1000));
	}
}
