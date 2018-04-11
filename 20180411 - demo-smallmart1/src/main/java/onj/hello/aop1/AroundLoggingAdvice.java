package onj.hello.aop1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation arg0) throws Throwable {
		String findName = (String)arg0.getArguments()[0];
		if(findName == null) {
			throw new Throwable("예외");
		}
		
		System.out.println("메소드 실행 전");
		Object returnedObj = arg0.proceed();
		System.out.println("메소드 실행 후");
		
		return returnedObj;
	}

}
