package edu.biz.ioc;

public class OrderManager {
	private CarMaker maker; //멤버, 인스턴스변수, 속성, 프로퍼티라고도 한다.
	
	public OrderManager(CarMaker maker) {
		this.maker = maker;
	}
	
	public void order() {
		Car car = this.maker.sell(new Money(1000));
		System.out.println(car);
	}
}
