package edu.biz.ioc5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderManagerApp {

	public static void main(String[] args) {
		//@Configuration 어노테이션이 적용된 클래스를 설정 정보로 이용하기 위해
		//AnnotationConfigApplicationContext를 이용하면 된다.
		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		OrderManager manager = context.getBean(OrderManager.class);
		manager.order();
	}

}
