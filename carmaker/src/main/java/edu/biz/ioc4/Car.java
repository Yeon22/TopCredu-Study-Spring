package edu.biz.ioc4;

import org.springframework.stereotype.Component;

@Component("car")
public class Car {
	private String name;
	
	public Car() {}
	
	public Car(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
