package edu.ojc.setter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ojc2.xml");
		
		Develope dev = (Develope)context.getBean("develope");
		dev.coding();
	}

}
