package edu.biz.ioc;

public class HyundaiMaker implements CarMaker{
	public HyundaiMaker() {} //생성자
	
	public Car sell(Money money) {
		System.out.println("I sold a car.");
		Car car = new Car("Sonata");
		return car;
	}
}
