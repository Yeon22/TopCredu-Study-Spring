package topcredu.task.DI;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:product.xml");
		MyController controller = (MyController)ctx.getBean("myController");
		List<Product> products = controller.getProducts();
		
		for(Product product : products) {
			System.out.println(product.getDescription());
		}
	}

}
