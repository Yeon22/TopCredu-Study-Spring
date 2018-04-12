package onj.hello.aop2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@SpringBootApplication
public class DemoSmallmart2Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoSmallmart2Application.class, args);
		ApplicationContext ctx = new GenericXmlApplicationContext();
		((GenericXmlApplicationContext) ctx).load("smallmart2.xml");
		((AbstractApplicationContext) ctx).refresh();
		SmallMartInterface smallMart = (SmallMartInterface)ctx.getBean("smallMart");
		smallMart.getProducts("과자");
		((AbstractApplicationContext) ctx).close();
	}
}
