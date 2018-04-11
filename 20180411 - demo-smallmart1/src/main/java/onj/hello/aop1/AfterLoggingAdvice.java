package onj.hello.aop1;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterLoggingAdvice implements AfterReturningAdvice {

	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println(arg1.getName() + ": 사후충고");
	}

}
