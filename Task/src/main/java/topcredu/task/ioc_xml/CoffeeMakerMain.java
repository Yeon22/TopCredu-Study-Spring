package topcredu.task.ioc_xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class CoffeeMakerMain {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		BeanFactory ctx = new XmlBeanFactory(new FileSystemResource("src/main/resources/coffee.xml"));
		CoffeeManager coffeeManager = (CoffeeManager)ctx.getBean("coffeeManager");
		coffeeManager.order();
	}

}
