package com.mkyong1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong1.service.CustomerService;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("configure1.xml");
		CustomerService cService = (CustomerService) ctx.getBean("customerService");
		System.out.println(cService);
	}

}
