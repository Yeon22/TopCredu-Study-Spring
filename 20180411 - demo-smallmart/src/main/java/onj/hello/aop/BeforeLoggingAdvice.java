package onj.hello.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLoggingAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String findName = (String)args[0];
		System.out.println(method.getName() + "(" + findName + "):: 사전충고");
	}

}
