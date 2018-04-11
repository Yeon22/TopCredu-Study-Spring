package topcredu.task.annotation_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoffeeMakerMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		CoffeeManager coffeeManager = (CoffeeManager)ctx.getBean("coffeeManager");
		coffeeManager.order();
	}

}
