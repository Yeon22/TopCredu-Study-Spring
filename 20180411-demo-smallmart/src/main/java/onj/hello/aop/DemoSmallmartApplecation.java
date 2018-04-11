package onj.hello.aop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSmallmartApplecation {

	public static void main(String[] args) {
		SpringApplication.run(DemoSmallmartApplecation.class, args);
		SmallMartInterface target = new SmallMart();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BeforeLoggingAdvice());
		pf.addAdvice(new AfterLoggingAdvice());
		pf.addAdvice(new AroundLoggingAdvice());
		pf.addAdvice(new ThrowsLoggingAdvice());
		
		pf.setTarget(target);
		
		try {
			SmallMartInterface proxy = (SmallMartInterface)pf.getProxy();
			proxy.getProducts("생필품");
		}catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
