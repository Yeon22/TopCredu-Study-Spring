package topcredu.task.java_configure;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoffeeMakerMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CoffeeManager ctx = context.getBean(CoffeeManager.class);
		ctx.order();
	}

}
