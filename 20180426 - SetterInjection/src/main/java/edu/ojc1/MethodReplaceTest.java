package edu.ojc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodReplaceTest {
	Emp programmer;
	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("lookup.xml");
		MethodReplaceTest test = (MethodReplaceTest)context.getBean("methodReplaceTest");
		//Programmer의 work()가 아닌 대체자인 Designer의 work()가 실행됨
		System.out.println(test.programmer.work());
	}

}
