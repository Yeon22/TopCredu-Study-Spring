package aophello1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("메소드 실행 전 안녕...");
		Object ret = invocation.proceed(); //타겟 클래스의 sayHello()가 호출된다.
		System.out.println("메소드 실행 후 안녕...");
		
		return "It is Sample";
	}

}
