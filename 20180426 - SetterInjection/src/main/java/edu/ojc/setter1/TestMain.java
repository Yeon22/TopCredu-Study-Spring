package edu.ojc.setter1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ojc1.xml");
		
		Develope dev = (Develope)context.getBean("develope");
		dev.coding();
	}
}
