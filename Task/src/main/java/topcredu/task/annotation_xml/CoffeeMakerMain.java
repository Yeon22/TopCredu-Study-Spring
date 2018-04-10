package topcredu.task.annotation_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeMakerMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:coffee2.xml");
		CoffeeManager coffeeManager = (CoffeeManager)ctx.getBean("coffeeManager");
		coffeeManager.order();
	}

}
