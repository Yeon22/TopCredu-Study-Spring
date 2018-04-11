package onj.hello.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundLoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String findName = (String)invocation.getArguments()[0];
		String methodName = (String)invocation.getMethod().getName();
		System.out.println("[주변충고]" + methodName + "(" + findName + ") 메소드 실행 전");
		Object obj = invocation.proceed(); //타겟 클래스의 메소드 호출
		System.out.println("[주변충고]" + methodName + "(" + findName + ") 메소드 실행 후");
		return obj;
	}

}
