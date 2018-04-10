package edu.biz.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("daewoo")
public class DaewooMaker implements CarMaker {
	@Autowired
	private Car car;
	
	public Car sell(Money money) {
		System.out.println("I sold a Tosca.");
		car.setName("Tosca");
		return car;
	}

}
