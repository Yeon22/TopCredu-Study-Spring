package aophello1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
//		IprintMsg target = new PrintMsg();
//		
//		//Proxy 빈껍데기 생성
//		ProxyFactory pf = new ProxyFactory();
//		pf.addAdvice(new MyAroundAdvice()); //충고 add
//		pf.setTarget(target); //Target add
//		
//		PrintMsg proxy = (PrintMsg)pf.getProxy(); //getProxy() -> 위빙
//		System.out.println(proxy.sayHello());
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aophello1.xml");
		IprintMsg pringMsg = (IprintMsg)ctx.getBean("printMsg");
		
		//sayHello1만 충고가 내려가도록 되어있다.
		pringMsg.sayHello1();
		pringMsg.sayHello2();
	}

}
