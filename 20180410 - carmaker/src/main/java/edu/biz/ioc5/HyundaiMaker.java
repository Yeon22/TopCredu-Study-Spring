package edu.biz.ioc5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hyundai") //@Named와 동일, 서비스계층의 클래스입을 의미
public class HyundaiMaker implements CarMaker{
	@Autowired
	private Car car;
	
	public Car sell(Money money) {
		System.out.println("I sold a Sonata.");
		car.setName("Sonata");
		return car;
	}
}
