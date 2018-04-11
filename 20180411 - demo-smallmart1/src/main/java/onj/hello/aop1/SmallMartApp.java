package onj.hello.aop1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SmallMartApp {

	public static void main(String[] args) throws Exception{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("smallmart1.xml");
		ctx.refresh();
		
		SmallMartInterface smallMart = (SmallMartInterface)ctx.getBean("smallMartProxy");
		smallMart.getProducts("과자");
		smallMart.getProducts2("과일");
		ctx.close();
	}

}
