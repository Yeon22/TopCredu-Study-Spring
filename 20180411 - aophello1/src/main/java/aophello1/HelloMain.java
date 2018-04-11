package aophello1;

import org.springframework.aop.framework.ProxyFactory;

public class HelloMain {

	public static void main(String[] args) {
		IprintMsg target = new PrintMsg();
		
		//Proxy 빈껍데기 생성
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MyAroundAdvice()); //충고 add
		pf.setTarget(target); //Target add
		
		PrintMsg proxy = (PrintMsg)pf.getProxy(); //getProxy() -> 위빙
		System.out.println(proxy.sayHello());
	}

}
