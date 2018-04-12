package jdbc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcClient {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("app-jdbc.xml");
		ctx.refresh();
		
		EmpDao e = (EmpDao)ctx.getBean("EmpDao");
		System.out.println(e.getNames());
		ctx.close();
	}
}
