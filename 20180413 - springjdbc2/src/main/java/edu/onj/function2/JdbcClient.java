package edu.onj.function2;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc2.xml");
		EmpJDBCTemplate empJDBCTemplate = (EmpJDBCTemplate)ctx.getBean("empJDBCTemplate");
		ArrayList<Emp> list = new ArrayList<Emp>();
		list = (ArrayList<Emp>)empJDBCTemplate.listEmp(20);
		for(Emp emp : list) {
			System.out.println("empno --> " + emp.getEmpno() + "ename --> " + emp.getEname() + "sal --> " + emp.getSal());
		}
	}
}
