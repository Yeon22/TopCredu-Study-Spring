package com.mkyong.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.service.UserService;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("configure.xml");
		UserService userService = (UserService) ctx.getBean("userService");
		System.out.println(userService.toString());
	}

}
