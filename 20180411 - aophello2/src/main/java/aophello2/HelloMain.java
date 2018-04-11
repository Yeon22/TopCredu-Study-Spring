package aophello2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aophello1.xml");
		
		IprintMsg pringMsg = (IprintMsg)ctx.getBean("printMsg");
		
		//sayHello1만 충고가 내려가도록 되어있다.
		pringMsg.sayHello1();
		pringMsg.sayHello2();
	}

}
