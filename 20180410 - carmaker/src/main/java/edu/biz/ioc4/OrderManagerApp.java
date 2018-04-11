package edu.biz.ioc4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:ioc4.xml");
		OrderManager manager = (OrderManager)factory.getBean("orderManager");
		manager.order();
	}

}
