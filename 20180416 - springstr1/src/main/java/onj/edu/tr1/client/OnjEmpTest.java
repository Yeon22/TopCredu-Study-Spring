package onj.edu.tr1.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import onj.edu.tr1.model.Emp;
import onj.edu.tr1.service.OnjService;

public class OnjEmpTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("onjoraclejava.xml");
		
		OnjService onjService = (OnjService)ctx.getBean("onjService");
		
		List<Emp> list = onjService.getEmpByDeptno(10);
		display(list);
		
		onjService.insertEmps();
		
		list = onjService.getEmpByDeptno(10);
		display(list);
	}
	
	public static void display(List<Emp> list) {
		for(Object e : list) {
			System.out.println(((Emp)e).getEmpno());
			System.out.println(((Emp)e).getEname());
			System.out.println(((Emp)e).getDeptno());
		}
	}

}
